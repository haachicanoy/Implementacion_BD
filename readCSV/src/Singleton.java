
public class Singleton { 

	
	private static Singleton instance = null;
	
	protected Singleton() {
		//Constructor
		}
		 
	public static Singleton getInstance() {
	      if(instance == null) {
	         instance = new Singleton();
	      }
	      return instance;
	}
	
}
