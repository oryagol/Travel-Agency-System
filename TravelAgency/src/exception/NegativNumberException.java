package exception;

public class NegativNumberException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NegativNumberException() {
		super("Prices need to be positive!");
	}
	@Override
	public String toString() {
		return "Prices need to be positive!";
	}
	
	
}
