package exception;

public class GuideNotExist extends Exception{

	@Override
	public String toString() {
		return "The guide dont exist in the database";
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GuideNotExist() {
		super("The guide dont exist in the database");
	}
	
}
