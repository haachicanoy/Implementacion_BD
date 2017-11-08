import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * readCSV.java
 * @author HAACHICANOY
 */

public class readCSV_code {
	
	public static void main(String[] args) {
		
		List<String> paths = getFiles("A");
		
		for (String path : paths) {
			System.out.println("Loading: "+path);
			seqScan(path);
			System.out.println("Loaded: "+path);
		}
 		
	}
	
	public static boolean seqScan(String path){
		//1048576
		//400000 repetidos
		// .csv comma separated values
		boolean status = false;
		String fileName = path;//"data.csv";
		File file = new File(fileName); // TODO: read about File
		try {
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()) {
				String data = inputStream.next();
				System.out.println(data);
			}
			inputStream.close();
			status = true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		return status;
	}
	
	public static List<String> getFiles(String root){
		String path = root; 

        String files;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles(); 

        List<String> paths = new ArrayList<>();
        System.out.println("Paths loading...");
        
        for (int i = 0; i < listOfFiles.length; i++) 
        {

            if (listOfFiles[i].isFile()) 
            {
                files = listOfFiles[i].getName();
                if (files.endsWith(".csv") || files.endsWith(".CSV"))
                {
                	if(files.contains(root)){
                		paths.add(listOfFiles[i].getPath());
                		System.out.println(files);
                	}
                }
            }
        }
        System.out.println("Paths loaded...");
        return paths;
        
    }
	
	

}
