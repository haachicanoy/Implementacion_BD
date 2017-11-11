
public class DataBase {
	
	String database;

	//adicionar variables con los esquema y indices
	
	public DataBase(String database) {
		super();
		this.database = database;	
		loadSchema(database);
		loadIndex(database);
	}
	
	private void loadIndex(String database2) {
		//Implementar la carga de los indices 
	}

	private void loadSchema(String database2) {
		//Implementar la carga de los esquemas
	}

	public String query(String queryStr){
		Object executionTree = parserSQL(queryStr);//llamado al parseador
		return executeSQL(executionTree); //llamado a ejecutar la consula con el arbol generado por el parseador
		
	}

	private Object parserSQL(String sql){
		//implementaci�n del parser
		return null;
	}
	
	private String executeSQL(Object executionTree){
		//implementar un motor de ejecuci�n de consultas
		return null;
	}
}
