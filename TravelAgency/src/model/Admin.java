package model;


public class Admin extends Person{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Admin admin;
	private Admin(long id, String password)
	{
		super(id, password); 
	} 
	
	public static Admin getInstance() {
		if(admin == null)
			admin = new Admin(0, "admin");
		return admin;
	}
}

