package exception;

public class OrderNotExistException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OrderNotExistException() {
		super("The order dont exist in the databse");
	}

	@Override
	public String toString() {
		return "The order dont exist in the databse";
	}
}
