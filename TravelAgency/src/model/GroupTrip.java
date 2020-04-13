package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Antonio Zaitoun on 13/07/2018.
 * Update by Heyam Abdalhade on 04/08/2018.
 */
public class GroupTrip implements Serializable{

	// -------------------------------Class Members------------------------------

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final int tripId;

    /**
     * A simple description of the tour.
     */
    private String description;

    /**
     * The time of the trip.
     */
    private Date date;

    /**
     * The location in which this trip takes place.
     */
    private Destination location;

    /**
     * The tour guide.
     */
    private Guide guide;

    /**
     * The price per person of this trip.
     */
    private double price;

    /**
     * The maximum number of tourists this group trip allows.
     */
    private int maxCapacity;

    /**
     * The current number of tourists in this group trip.
     */
    private int currentNumberOfTourists = 0;
    
    /**
     * array tickets
     */

    private ArrayList<TicketCheckIn<GroupTrip>> tickets;

	// -------------------------------Constructors------------------------------

    /**
     *
     * @param description A simple description of the tour.
     * @param date The time of the trip.
     * @param location The location in which this trip takes place.
     * @param guide The tour guide.
     * @param price The price per person of this trip.
     * @param maxCapacity The maximum number of tourists this group trip allows.
     */
    public GroupTrip(int id, String description, Date date, Destination location, Guide guide, double price, int maxCapacity) {
        this.tripId = id;
    	this.description = description;
        this.date = date;
        this.location = location;
        this.guide = guide;
        this.price = price;
        this.maxCapacity = maxCapacity;
        tickets = new ArrayList<>();
    }
	// -------------------------------Getters And Setters------------------------------


    public String getDescription() {
        return description;
    }

    public int getMaxCapacity() {
		return maxCapacity;
	}


	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}


	public int getCurrentNumberOfTourists() {
		return currentNumberOfTourists;
	}


	public void setCurrentNumberOfTourists(int currentNumberOfTourists) {
		this.currentNumberOfTourists = currentNumberOfTourists;
	}


	public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Destination getLocation() {
        return location;
    }

    public void setLocation(Destination location) {
        this.location = location;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getTripId() {
        return tripId;
    }
   
    public ArrayList<TicketCheckIn<GroupTrip>> getTickets() {
		return tickets;
	}
    
	// -------------------------------More Methods------------------------------

    /**
     * Check if trip is available for additional x people.
     * @param people The number of people to check for.
     * @return true if the trip is available for additional x people.
     */
    public boolean isAvailable(int people){
    	//TODO: Complete this method
        return !(currentNumberOfTourists + people > maxCapacity);
    }

    

    public boolean reserveSpots(int spots){
    	//TODO: Complete this method
    	if(currentNumberOfTourists + spots > maxCapacity)
            return false;

        currentNumberOfTourists += spots;

        return true;
    }

    public boolean cancelReservedSpots(int spots) {
    	//TODO: Complete this method
    	if(currentNumberOfTourists - spots < 0)
            return false;

        currentNumberOfTourists += spots;

        return true;
    }

    /**
     * Add Ticket.
     * @param numberOfPeople
     * @return
     */
    public boolean AddTicket(TicketCheckIn<GroupTrip> ticket){
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
    public boolean removeTicket(TicketCheckIn<GroupTrip> ticket){
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
    	ArrayList<TicketCheckIn<GroupTrip>> temp =new ArrayList<>();
		temp.addAll(tickets);
		for(TicketCheckIn<GroupTrip> t: temp)
			if(t.getOrder().equals(o))
				tickets.remove(t);
	}
	
	// -------------------------------hashCode equals & toString------------------------------	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tripId;
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
		GroupTrip other = (GroupTrip) obj;
		if (tripId != other.tripId)
			return false;
		return true;
	}
	
	@Override
    public String toString() {
        return "GroupTrip ID:"+tripId;

	}
}
