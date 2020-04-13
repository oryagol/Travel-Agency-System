package exception;

public class CustomerNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CustomerNotExistException() {
		super("The customer dont exist in the databse");
	}

	@Override
	public String toString() {
		return "The customer dont exist in the databse";
	}

}
