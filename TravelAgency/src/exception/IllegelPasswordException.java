package exception;

public class IllegelPasswordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IllegelPasswordException() {
		super("Password is incorrect!");
	}
	@Override
	public String toString() {
		return "Password is incorrect!";
	}

}
