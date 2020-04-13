package exception;

public class PasswordMismatchException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PasswordMismatchException() {
		super("The password in the relevent fields dont match");
	}
	@Override
	public String toString() {
		return "The password length need to be at least 8, and need to match verification";
	}
	
}
