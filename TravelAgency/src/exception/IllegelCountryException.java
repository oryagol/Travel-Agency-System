package exception;

public class IllegelCountryException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IllegelCountryException() {
		super("The country dont exist in the database");
	}
	@Override
	public String toString() {
		return "The country dont exist in the database";
	}
	
	
}
