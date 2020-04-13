package exception;

public class FlightToSameLocationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FlightToSameLocationException() {
		super("The flights are from and to the same location!");
	}
	@Override
	public String toString() {
		return "The flights are from and to the same location!";
	}

}
