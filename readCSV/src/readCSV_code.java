import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * readCSV.java
 * @author HAACHICANOY
 */

public class readCSV_code {
	
	public static void main(String[] args) {
		
		// .csv comma separated values
		// Test commit Diego :D
		String fileName = "data.csv";
		File file = new File(fileName); // TODO: read about File
		try {
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()) {
				String data = inputStream.next();
				System.out.println(data);
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
