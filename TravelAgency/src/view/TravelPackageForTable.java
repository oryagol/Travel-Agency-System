package view;

import model.TravelPackage;

public class TravelPackageForTable extends OrdersForTable {
	
	private String Name;

	
	
	
	
	public TravelPackageForTable(TravelPackage tp) {
		super(tp);
		Name = tp.getName();
		
	
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
	

}
