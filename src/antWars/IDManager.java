package antWars;


/**
 * Singleton class to give new id for cards and base globally
 * 
 */
 public class IDManager {
	private int id;
	private int baseID;
	
	private static IDManager single_instance = null;
	
	private IDManager() {
		id = 0;
		baseID = 0;
	}
	
	public static IDManager getInstance() {
		if (single_instance == null) {
			single_instance = new IDManager();
		}
		return single_instance;
	}
	
	public int getNewID() {
		return ++id;
	}
	
	public int getNewBaseID() {
		return ++baseID;
	}

}
