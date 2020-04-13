package exception;

public class RemoveOrderException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RemoveOrderException() {
		super("Failed to remove order");
	}

	@Override
	public String toString() {
		return "Failed to remove order";
	}

}
