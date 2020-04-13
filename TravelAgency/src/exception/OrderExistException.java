package exception;

public class OrderExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public OrderExistException() {
		super("The order already exist");
	}
	@Override
	public String toString() {
		return "The order already exist";
	}

}
