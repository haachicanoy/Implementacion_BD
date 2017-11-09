package Main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * readCSV.java
 * @author HAACHICANOY
 */

public class readCSV_code {
	
    static BufferedWriter output = null;
	static Set<String> items ;// Variable que almacena los registros unicos
	File fileResult;//Fichero resultado
	
	public static void main(String[] args) throws IOException {

        File file = new File("C_1.csv");
        output = new BufferedWriter(new FileWriter(file));
		List<String> paths = getFiles("A");
		items = new HashSet<>();
		
		for (String path : paths) {
			System.out.println("Loading: "+path);
			seqScan(path);
			System.out.println("Loaded: "+path);
		}
		if ( output != null ) {
            output.close();
          }
		
		System.out.println("Reg:"+ items.size());
	}
	
	
	public static boolean seqScan(String path) throws IOException{
		//1048576
		//400 repetidos
		//commit test Diego
		// .csv comma separated values
		boolean status = false;
		String fileName = path;//"data.csv";
		File file = new File(fileName); 
		try {
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()) {
				String data = inputStream.next();
				if(!items.contains(data)){//Si no se ha leido el registro se adiciona
					System.out.println(data);
					items.add(data);
					output.write(data+"\n");//imprimir en el fichero de salida
				}
			}
			inputStream.close();
			status = true;
		} catch (FileNotFoundException e) {
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
	
/*	public static void bufferOutput() throws IOException {
		String text = "Hello world";
		BufferedWriter output = null;
		try {
			File file = new File("example.txt");
			output = new BufferedWriter(new FileWriter(file));
			output.write(text);
			} catch ( IOException e ) {
				e.printStackTrace();
				} finally {
					if ( output != null ) {
						output.close();
						}
					}
		}*/
	
}

//Node implementation
//Taken from: https://www.discoduroderoer.es/listas-enlazadas-en-java/

public class Nodo<T> {
    
    private T dato;
    private Nodo<T> siguiente;
 
    /**
     * Constructor por defecto
     */
    public Nodo(){
        siguiente=null;
     }
 
    /**
     * Le pasamos un dato al nodo
     * @param p 
     */
    public Nodo(T p){
        siguiente=null;
        dato = p;
    }
    /**
     * Le pasamos un dato y su siguiente nodo al nodo
     * @param t Dato a insertar
     * @param siguiente Su sisguiente nodo
     */
    public Nodo(T t, Nodo<T> siguiente){
        this.siguiente=siguiente;
        dato = t;
    }
     
    public T getDato() {
        return dato;
    }
 
    public void setDato(T dato) {
        this.dato = dato;
    }
 
    public Nodo<T> getSiguiente() {
        return siguiente;
    }
 
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
     
}

