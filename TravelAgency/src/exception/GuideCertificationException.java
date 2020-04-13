package exception;

public class GuideCertificationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GuideCertificationException() {
		super("Guide relevent Certificate hasnt uploaded");
	}
	@Override
	public String toString() {
		return "Guide relevent Certificate hasnt uploaded";
	}
	
	

}
