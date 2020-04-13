package exception;

public class ObjectExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ObjectExistException() {
		super(" already exist!");
	}
	@Override
	public String toString() {
		return " already exist!";
	}
	
}
