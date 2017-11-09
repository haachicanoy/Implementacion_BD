package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SeqScan implements Iterator<List<Object>>{

	private String tableName;
	private int limit = 10;
	private int countBlocks = 1;
	private int countRows = 1;
	private String dataSchema; 
	private Scanner inputStream;
	
	
	public SeqScan(String tableName) {
		open(tableName);
	}
	
	public void open(String tableName){
		this.tableName = tableName;
		File file = new File(tableName+"/schema.csv"); 
		try {
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()) {
				dataSchema = inputStream.next(); 
			}
			inputStream.close(); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();			
		}
        nextBlock();
	}

	@Override
	public boolean hasNext() {

		if(countRows > limit){
			this.close();
			inputStream = nextBlock();
			if(inputStream == null){
				return false;
			}
			countRows = 1;
		}
		return inputStream != null && inputStream.hasNext();
	}

	@Override
	public List<Object> next() {
		if(hasNext()){
			return parseRow(inputStream.next(), dataSchema);	
		}
		return null;
	}
	
	public void close(){
		if ( inputStream != null ) {
			inputStream.close();
			}
	}
	
	public List<Object> parseRow(String row , String schema){
		String[] tempRow = row.split(";");
		String[] tempSchema = schema.split(";");
		List<Object> list = null;
		if(tempRow.length > 0){
			list = new ArrayList<>();
			for (int i = 0; i < tempRow.length; i++) {
				String[] schemaCol = tempSchema[i].split("-");
				String data = tempRow[i];
				if(schemaCol[1].equals("integer")){
					list.add(Integer.parseInt(data));
				}else if (schemaCol[1].equals("double")){
					list.add(Double.parseDouble(data));
				}else if (schemaCol[1].equals("boolean")){
					list.add(Boolean.parseBoolean(data));
				}else {//String
					list.add(String.valueOf(data));
				}			
			}
		}
		countRows++;
		return list;
	}
	
	public Scanner nextBlock(){
		File file = new File(tableName+"/"+tableName+"_"+countBlocks+".csv"); 
		try {
			inputStream = new Scanner(file);
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			//No se encuentran mas bloques
			return null;
		}
		countBlocks++;
		return inputStream;
    }

}

