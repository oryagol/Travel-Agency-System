package model;



import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import controller.Shared;




/**
 * Created by Antonio Zaitoun on 13/07/2018.
 * Update by Heyam Abdalhade on 04/08/2018.
 */
public class Customer extends Person{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// -------------------------------Class Members------------------------------
	/**
	 * The orders which the person has made and participated.
	 */
	private HashSet<Order> orders; 
	/**
	 * all Tickets
	 */
	private Set<TicketCheckIn<Flight>> ticketsFlight;
	private Set<TicketCheckIn<Accommodation>> ticketsAccpommodation;
	private Set<TicketCheckIn<GroupTrip>> ticketsGroupTrips;


	// -------------------------------Constructors------------------------------

	public Customer(long id, String password) {
		super(id, password); 
	}

	public Customer(long id, String password, String firstName, String surname, Date birthDate, String email, Address address, String answer) {
		super(id, password, firstName, surname, birthDate, email, address, answer);
		orders = new HashSet<Order>();

		ticketsFlight = new HashSet<>();
		ticketsAccpommodation = new HashSet<>();
		ticketsGroupTrips = new HashSet<>();
	}

	// -------------------------------Getters And Setters------------------------------

	public HashSet<Order> getOrders() {
		return orders;
	}

	public Set<TicketCheckIn<Flight>> getTicketsFlight() {
		return ticketsFlight;
	}

	public Set<TicketCheckIn<Accommodation>> getTicketsAccpommodation() {
		return ticketsAccpommodation;
	}

	public Set<TicketCheckIn<GroupTrip>> getTicketsGroupTrips() {
		return ticketsGroupTrips;
	}
	// -------------------------------More Methods------------------------------


	/**
	 * Add a new order to the customer.
	 *
	 * This method adds a new order to the orders array 
	 * only if the given order doesn't already exists in the Customer's orders array.
	 *
	 * @param order The order to add.
	 * @return true if the order was successfully added.
	 */
	public boolean addOrder(Order order){
		//TODO: Complete this method
		if (order != null && !orders.contains(order)) 
		{
			return orders.add(order);
		}

		return false;
	}


	/**
	 * Remove an order from the orders array.
	 *
	 * @param orderId The order to remove.
	 * @return True if the order was removed.
	 */
	public boolean removeOrder(int orderId){
		//TODO: Complete this method
		if(orderId < 0) return false;
		Order newOrder = Shared.getInstance().getOrders().get(orderId);
		if (orders.contains(newOrder))
			return orders.remove(newOrder);
		return false;
	}

	/**
	 * 
	 * @param ticket
	 * @return
	 */
	public boolean addTicketFlight(TicketCheckIn<Flight> ticket){
		//TODO: Complete this method
		if (ticket != null  &&!ticketsFlight.contains(ticket)) 
		{
			return ticketsFlight.add(ticket);
		}

		return false;
	}

	/**
	 * 
	 * @param ticket
	 * @return
	 */
	public boolean addTicketsAccpommodation(TicketCheckIn<Accommodation> ticket){
		//TODO: Complete this method
		if (ticket != null && !ticketsAccpommodation.contains(ticket)) 
		{
			return ticketsAccpommodation.add(ticket);
		}

		return false;
	}
	/**
	 * 
	 * @param ticket
	 * @return
	 */
	public boolean addTicketsGroupTrips(TicketCheckIn<GroupTrip> ticket){
		//TODO: Complete this method
		if (ticket != null && !ticketsGroupTrips.contains(ticket)) 
		{
			return ticketsGroupTrips.add(ticket);
		}

		return false;
	}

	/**
	 * 
	 * @param o
	 */
	public void removeTicketByOrder(Order o) {

		Iterator<TicketCheckIn<Accommodation>> iterAcc = ticketsAccpommodation.iterator();

		while (iterAcc.hasNext()) {
			TicketCheckIn<Accommodation> it = iterAcc.next();

			if (it.getOrder().equals(o))
				iterAcc.remove();
		}

		Iterator<TicketCheckIn<Flight>> iterFlight = ticketsFlight.iterator();

		while (iterFlight.hasNext()) {
			TicketCheckIn<Flight> it = iterFlight.next();

			if (it.getOrder().equals(o))
				iterFlight.remove();
		}

		Iterator<TicketCheckIn<GroupTrip>> iterTrip = ticketsGroupTrips.iterator();

		while (iterTrip.hasNext()) {
			TicketCheckIn<GroupTrip> it = iterTrip.next();

			if (it.getOrder().equals(o))
				iterTrip.remove();
		}
	}

	// ------------------------------- toString------------------------------	

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", orders=" + orders +
				'}';
	}
}
