package view;

import java.util.Set;

import model.Accommodation;
import model.Flight;
import model.GroupTrip;
import model.Order;
import model.TicketCheckIn;
import model.TravelPackage;


public class OrdersForTable {
	
	private int id;

	/**
	 * The Person who made this order.
	 */
	private String owner;

	/**
	 * The number of max TicketCheckIn for each type for which this order was made.
	 */
	protected int quantity;
	
	private double Price;
	/**
	 * The flights that were ordered.
	 */
	protected String flights;
	
	/**
	 * The accommodations that were ordered.
	 */
	protected  String accommodations;

	/**
	 * The group trips that were ordered.
	 */
	protected  String groupTrips;
	
	
	public OrdersForTable(Order o) {
		
		super();
		
		this.id = o.getOrderId();
		if(o.getOwner()!=null)
		{
		this.owner = o.getOwner().getFirstName()+" "+o.getOwner().getSurname()+" ,"+"id:"+o.getOwner().getId();
		}
		this.quantity = o.getQuantity();
		this.Price = o.getTotalCost();
		String tmp="";
		for(TicketCheckIn<Flight> f:o.getFlights())
		{
			tmp+=f.getCheckIn().getFlightNumber()+"\n";
		
		}
		this.flights=tmp;
		
		
		tmp="";
		for(TicketCheckIn<Accommodation> f:o.getAccommodations())
		{
			tmp+="Name: "+f.getCheckIn().getDisplayName()+", id: "+f.getCheckIn().getBusinessId() + "\n";
		}
		this.accommodations=tmp;
		tmp="";
		for(TicketCheckIn<GroupTrip> f:o.getGroupTrips())
		{
			tmp+=f.getCheckIn().getTripId()+"\n";
		}
		this.groupTrips=tmp;
		}
	

	

	public String getFlights() {
		return flights;
	}



	public void setFlights(String flights) {
		this.flights = flights;
	}



	public String getAccommodations() {
		return accommodations;
	}



	public void setAccommodations(String accommodations) {
		this.accommodations = accommodations;
	}



	public String getGroupTrips() {
		return groupTrips;
	}



	public void setGroupTrips(String groupTrips) {
		this.groupTrips = groupTrips;
	}



	public int getId() {
		return id;
	}

	public void setId(int orderId) {
		this.id = orderId;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int maxquantity) {
		this.quantity = maxquantity;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		this.Price = price;
	}
	
	
	

}
