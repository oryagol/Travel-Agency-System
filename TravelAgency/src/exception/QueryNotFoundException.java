package exception;

public class QueryNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public QueryNotFoundException() {
		super("Query not found");
	}

	@Override
	public String toString() {
		return "Query not found";
	}
	

}
