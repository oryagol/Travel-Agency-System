package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Antonio Zaitoun on 13/07/2018.
 * Update by Heyam Abdalhade on 04/08/2018.
 */
public class Flight implements Serializable{
	// -------------------------------Class Members------------------------------

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * The flight number (identifier)
     */
    private String flightNumber;

    /**
     * The max seats count on this flight.
     */
    private int numberOfSeats;

    /**
     * From (take off) source.
     */
    private Destination from;

    /**
     * To (landing) destination.
     */
    private Destination to;

    /**
     * Flight ticket price.
     */
    private double price;

    /**
     * The date of the flight.
     */
    private Date dateTakeoff;

    /**
     * The date of the flight.
     */
    private Date dateLanding;
    /**
     * The current number of passengers.
     */
    private int currentNumberOfPassengers = 0;

    /**
     * array tickets
     */

    private ArrayList<TicketCheckIn<Flight>> tickets;
    
    /**
     * public constructor
     *
     * @param flightNumber The flight number.
     * @param numberOfSeats The number of seats in this flight.
     * @param from the departure location.
     * @param to the destination.
     * @param price The price per seat.
     * @param date The date of the flight.
     */
    
	// -------------------------------Constructors------------------------------

    public Flight(String flightNumber, int numberOfSeats, Destination from, Destination to, double price, Date date) {
        this.flightNumber = flightNumber;
        this.numberOfSeats = numberOfSeats;
        this.from = from;
        this.to = to;
        this.price = price;
        this.dateTakeoff=date;
        tickets = new ArrayList<>();
    }
	// -------------------------------Getters And Setters------------------------------
    public String getFlightNumber() {
        return flightNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public Destination getFrom() {
        return from;
    }

    public Destination getTo() {
        return to;
    }

    public double getPrice() {
        return price;
    }

    public Date getDateTakeoff() {
        return dateTakeoff;
    }
    
    public Date getDateLanding() {
        return dateLanding;
    }
    
    public ArrayList<TicketCheckIn<Flight>> getTickets() {
		return tickets;
	}
	// -------------------------------More Methods------------------------------

    public boolean reserveSeats(int seats){

        if(currentNumberOfPassengers + seats > numberOfSeats)
            return false;

        currentNumberOfPassengers += seats;
        return true;
    }

    public boolean cancelReservedSeats(int seats) {

        if(currentNumberOfPassengers - seats < 0)
            return false;

        currentNumberOfPassengers += seats;
        return true;
    }

    public boolean isAvailable(int people){
        return !(currentNumberOfPassengers + people > numberOfSeats);
    }
    
    /**
     * Add Ticket.
     * @param numberOfPeople
     * @return
     */
    public boolean AddTicket(TicketCheckIn<Flight> ticket){
        //TODO: Complete this method
    	if(tickets.contains(ticket))
    		return false;
       else {
    	   tickets.add(ticket);
    	   return true;
       }
    }
    /**
     * Remove Ticket.
     * @param numberOfPeople
     * @return
     */
    public boolean removeTicket(TicketCheckIn<Flight> ticket){
        //TODO: Complete this method
    	if(!tickets.contains(ticket))
    		return false;
       else {
    	   tickets.remove(ticket);
    	   return true;
       }
      
    }
    
    public void removeTicketByOrder(Order o) {
    	//TODO
    	ArrayList<TicketCheckIn<Flight>> temp =new ArrayList<>();
		temp.addAll(tickets);
		for(TicketCheckIn<Flight> t: temp)
			if(t.getOrder().equals(o))
				tickets.remove(t);
	}

	// -------------------------------hashCode equals & toString------------------------------	

    @Override
    public String toString() {
        return "GroupTrip{" +
                "flightNumber='" + flightNumber + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", from=" + from +
                ", to=" + to +
                ", price=" + price +
                ", date=" + dateTakeoff +
                '}';
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flightNumber == null) ? 0 : flightNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(flightNumber, flight.flightNumber);
	}
}
