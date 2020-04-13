package exception;

public class FailToAddException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FailToAddException() {
		super("Some of the tickets are not available");
	}

	@Override
	public String toString() {
		return "Some of the tickets are not available";
	}


}
