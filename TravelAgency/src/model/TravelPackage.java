package model;

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Antonio Zaitoun on 13/07/2018.
 * Update by Heyam Abdalhade on 04/08/2018.
 */
public class TravelPackage extends Order {

	// -------------------------------Class Members------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private double price;


	public TravelPackage(String name,double price,int numberOfTickets) {
		super();
		this.name = name;
		this.price = price;
		super.maxquantity = numberOfTickets;
	

	}


	public TravelPackage(int id,Person owner,
			String name,
			int numberOfTickets,
			double price,
			Set<TicketCheckIn<Flight>> flights,
			Set<TicketCheckIn<Accommodation>> accommodations,
			Set<TicketCheckIn<GroupTrip>> groupTrips) {
		super(id, owner, numberOfTickets);
		this.name = name;
		this.price = price;

		//copy 
		this.flights.addAll(flights);
		this.accommodations.addAll(accommodations);
		this.groupTrips.addAll(groupTrips);
	}
	@Override
	public double getTotalCost() {
		return price;
	}

	/**
	 * Purchase the travel package
	 *
	 * 1) Check if package can be ordered.
	 * 2) Create a copy of travel using the current instance parameters.
	 * 3) iterate over each array (flights,accommodations,group trips) in the copy and make reservations.
	 *
	 * @param person The person who is making the purchase.
	 * @return An order with an instance of Travel Package.
	 */
	public Order purchase(int orderPackage, Customer person){
		//TODO: Complete this method

        
		//make sure that this package can be purchased.
		if(!isAvailable())
			return null;
		//make reservations
				for (TicketCheckIn<Flight> tFlight : flights)
				{
					tFlight.setCustomer(person);
					tFlight.getCheckIn().reserveSeats(1);
				}

				for (TicketCheckIn<Accommodation> tAccommodation : accommodations)
				{
					tAccommodation.setCustomer(person);
					tAccommodation.getCheckIn().reserveRooms(1);
				}

				for (TicketCheckIn<GroupTrip> tGroupTrip : groupTrips)
				{
					tGroupTrip.setCustomer(person);
					tGroupTrip.getCheckIn().reserveSpots(1);		
				}
		TravelPackage copy = new TravelPackage(orderPackage,person,name,maxquantity,price,flights,accommodations,groupTrips);
		//copy.setOwner(person);

		return copy;
	}

	/**
	 * @return true if all flights, accommodations and group trips are available. else false.
	 */
	public boolean isAvailable(){
		//TODO: Complete this method

		for (TicketCheckIn<Flight> flight : flights)
			if(!flight.getCheckIn().isAvailable(1))
				return false;

		for (TicketCheckIn<Accommodation> accommodation : accommodations)
			if(!accommodation.getCheckIn().isAvailable(1))
				return false;

		for (TicketCheckIn<GroupTrip> groupTrip : groupTrips)
			if(!groupTrip.getCheckIn().isAvailable(1))
				return false;

		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TravelPackage that = (TravelPackage) o;
		return Objects.equals(name, that.name);
	}

	@Override
	public String toString() {
		 DecimalFormat df = new DecimalFormat("0.00");
		return "TravelPackage{" +
			//	"id='" + getOrderId() + '\'' +
				"name='" + name + '\'' +
				"maxquantity="+maxquantity+
				", price=" + df.format(price )+
				'}';
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public boolean addTichetsFlightForPackage(Set<TicketCheckIn<Flight>> tFlight) { 
		if(tFlight.size() > maxquantity) return false;
		this.flights = tFlight; 
		return true;
	}

	public boolean addTicketsAccommodationForPackage(Set<TicketCheckIn<Accommodation>> tAccommodation) {
		if(tAccommodation.size() > maxquantity) return false;
		this.accommodations = tAccommodation; 
		return true;	}

	public boolean addTicketsGroupTripForPackage(Set<TicketCheckIn<GroupTrip>> tGroupTrip) { 
		if(tGroupTrip.size() > maxquantity) return false;
		this.groupTrips = tGroupTrip; 
		return true;	}

	@Override
	public boolean addTicketFlight(TicketCheckIn<Flight> flight) { return false; }

	@Override
	public boolean addTicketAccommodation(TicketCheckIn<Accommodation> accommodation) { return false; }

	@Override
	public boolean addTicketGroupTrip(TicketCheckIn<GroupTrip> groupTrip) { return false;
	}
}
