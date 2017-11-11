import java.util.Scanner;


public class Main {

	private static Scanner scanner;

	public static void main(String[] args) {
		System.out.println ("Consola SQL");
		System.out.println ("Por favor introduzca una consulta:");
		String input = "";

		DataBase dataBase = new DataBase("A");
		
		boolean status = true;
		while (status) {
			scanner = new Scanner (System.in);
			input = scanner.nextLine ();				//Recibe el texto ingresado por consola
			if(input.equals("0")||input.equals("Exit")){//Dos opciones para salir digitando 0 o Exit
				status = false;
			}else{
				dataBase.query(input);
			}
			
			System.out.println ("Consulta: \"" + input +"\"");
		}
		System.out.println("Saliendo...");
	} //Cierre del main
	
	
}
