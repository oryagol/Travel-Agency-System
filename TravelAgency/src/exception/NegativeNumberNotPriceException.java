package exception;

public class NegativeNumberNotPriceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Please enter positive value in relevent fields";
	}
	
	

}
