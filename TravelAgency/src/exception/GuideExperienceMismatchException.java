package exception;

public class GuideExperienceMismatchException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GuideExperienceMismatchException() {
		super("The guide dont have experience in all of the relevent locations");
	}
	@Override
	public String toString() {
		return "The guide dont have experience in all of the relevent locations";
	}
	
}
