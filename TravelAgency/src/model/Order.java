package model;


import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Antonio Zaitoun on 14/07/2018.
 * Update by Heyam Abdalhade on 04/08/2018.
 */
public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// -------------------------------Class Members------------------------------   
	private int orderId;

	/**
	 * The Person who made this order.
	 */
	private Person owner;

	/**
	 * The flights that were ordered.
	 */
	protected Set<TicketCheckIn<Flight>> flights;
	
	/**
	 * The accommodations that were ordered.
	 */
	protected  Set<TicketCheckIn<Accommodation>> accommodations;

	/**
	 * The group trips that were ordered.
	 */
	protected  Set<TicketCheckIn<GroupTrip>> groupTrips;

	/**
	 * The number of max TicketCheckIn for each type for which this order was made.
	 */
	protected int maxquantity;

	// -------------------------------Constructors------------------------------

	/**
	 * Create order for person.
	 * @param owner The owner of this order.
	 */
	public Order(int id, Person owner, int maxQ) {
		orderId = id;
		this.owner = owner;
		this.maxquantity = maxQ;
		flights = new HashSet<>();
		accommodations = new HashSet<>() ;
		groupTrips = new HashSet<>() ;
	}

	/**
	 * Partial constructor for comparison.
	 * @param id The id of the order.
	 */
	public Order(int id){
		this.orderId = id;
	}
	
	public Order() {
		flights = new HashSet<>();
		accommodations = new HashSet<>() ;
		groupTrips = new HashSet<>() ;
	}
	// -------------------------------Getters And Setters------------------------------

	public int getOrderId() {
		return orderId;
	}

	public Person getOwner() {
		return owner;
	}

	public Set<TicketCheckIn<Flight>> getFlights() {
		return flights;
	}

	public Set<TicketCheckIn<Accommodation>> getAccommodations() {
		return accommodations;
	}

	public Set<TicketCheckIn<GroupTrip>> getGroupTrips() {
		return groupTrips;
	}

	public int getQuantity() {
		return maxquantity;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public void setQuantity(int quantity) {
		this.maxquantity = quantity;
	}

	// -------------------------------More Methods------------------------------

	/**
	 * Calculates the total order cost.
	 * @return the sum of flights, accommodations and group trips multiplied by the quantity.
	 */
	public double getTotalCost(){
		//TODO: Complete this method

		double cost = 0.0;

		for (TicketCheckIn<Flight> tFlight : flights)
			cost += tFlight == null ? 0.0 : tFlight.getCheckIn().getPrice();

		for (TicketCheckIn<Accommodation> tAccommodation : accommodations)
			cost += tAccommodation == null ? 0.0 : tAccommodation.getCheckIn().getPricePerPerson();

		for (TicketCheckIn<GroupTrip> tGroupTrip : groupTrips)
			cost += tGroupTrip == null ? 0.0 : tGroupTrip.getCheckIn().getPrice();

		return cost;
	}

	/**
	 * Add a flight to the order.
	 * @param flight the flight to add.
	 * @return true if added successfully, false otherwise.
	 */
	public boolean addTicketFlight(TicketCheckIn<Flight> tFlight){
		//TODO: Complete this method
		if(flights.contains(tFlight) || flights.size()>= maxquantity) return false;
		else {
			if(tFlight.getCheckIn().reserveSeats(1))
			{
				flights.add(tFlight);
				return true;
			}

		}  
		return false;
	}

	/**
	 * Add accommodation to the order.
	 * @param accommodation the accommodation to add.
	 * @return true if added successfully.
	 */
	public boolean addTicketAccommodation(TicketCheckIn<Accommodation> tAccommodation){
		//TODO: Complete this method
		if(accommodations.contains(tAccommodation)|| accommodations.size()>= maxquantity) return false;
		else {
			if(tAccommodation.getCheckIn().reserveRooms(1))
			{
				accommodations.add(tAccommodation);
				return true;
			}

		} 
		return false;
	}

	/**
	 * Add a group trip to the order.
	 *
	 * @param groupTrip the group trip to add.
	 * @return true if added successfully.
	 */
	public boolean addTicketGroupTrip(TicketCheckIn<GroupTrip> tGroupTrip){
		//TODO: Complete this method
		if(groupTrips.contains(tGroupTrip) || groupTrips.size()>= maxquantity) return false;
		else {
			if(tGroupTrip.getCheckIn().reserveSpots(1))
			{
				groupTrips.add(tGroupTrip);
				return true;
			}
		} 
		return false;
	}

	/**
	 * 
	 */
	public void cancel() {
		//TODO: Complete this method

		for (TicketCheckIn<Flight> flight : flights)
			flight.getCheckIn().cancelReservedSeats(1);

		for (TicketCheckIn<Accommodation> accommodation : accommodations)   
			accommodation.getCheckIn().clearReservations(1);

		for (TicketCheckIn<GroupTrip> groupTrip : groupTrips)
			groupTrip.getCheckIn().cancelReservedSpots(1);
	}

	@Override
	public String toString() {
		 DecimalFormat df = new DecimalFormat("0.00");
		return "Order [orderId=" + orderId + ", owner=" + 
					owner.id + ", maxquantity=" + maxquantity + ", price="+df.format(getTotalCost())+"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (orderId != other.orderId)
			return false;
		return true;
	}

}
