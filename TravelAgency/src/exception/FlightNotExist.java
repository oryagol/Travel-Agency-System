package exception;

public class FlightNotExist extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FlightNotExist() {
		super("Not all the flights exist in the database");
	}
	@Override
	public String toString() {
		return "Not all the flights exist in the database";
	}
	
}
