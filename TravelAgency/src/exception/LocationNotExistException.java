package exception;

public class LocationNotExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LocationNotExistException() {
		super("The location dont exist in the system");
	}
	@Override
	public String toString() {
		return "The location dont exist in the system";
	}
	
}
