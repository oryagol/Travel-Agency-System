
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Antonio Zaitoun on 13/07/2018.
 * Update by Heyam Abdalhade on 04/08/2018.
 */
public abstract class Accommodation implements Comparable<Accommodation> ,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// -------------------------------Class Members------------------------------
    /**
     * The business id of this accommodation (unique).
     */
    protected final long businessId;

    protected String displayName;
    /**
     * The number of rooms this accommodation offers.
     * For simplicity assume that all rooms are the same size.
     */
    protected int numberOfRooms;

    /**
     * The amount of people that can fit into a single room.
     */
    protected int numberOfPeoplePerRoom;

    /**
     * The price per a single person.
     */
    protected double pricePerPerson;

    /**
     * The current number of people occupying this accommodation.
     */
    @SuppressWarnings("unused")
	private int currentNumberPeople = 0;

    /**
     * The current number of rooms being occupied in׳�׳� this accommodation.
     */
    private int currentNumberOfOccupiedRooms = 0;

    /**
     * The place in which this accommodation is located.
     */
    private Destination location;

    /**
     * array tickets
     */

    private ArrayList<TicketCheckIn<Accommodation>> tickets;
    
	// -------------------------------Constructors------------------------------

    /**
     * Public constructor
     *
     * @param displayName The display name of the accommodation.
     * @param numberOfRooms The number of rooms this accommodation can offer.
     * @param numberOfPeoplePerRoom The number of people in each room.
     * @param pricePerPerson The price per person.
     * @param location The location at which this accommodation is located.
     */
    public Accommodation(long id, String displayName,
                         int numberOfRooms,
                         int numberOfPeoplePerRoom,
                         double pricePerPerson,
                         Destination location) {
    	this.businessId = id;
        this.displayName = displayName;
        this.numberOfRooms = numberOfRooms;
        this.numberOfPeoplePerRoom = numberOfPeoplePerRoom;
        this.pricePerPerson = pricePerPerson;
        this.location = location;
        this.tickets = new ArrayList<>();
    }
	// -------------------------------Getters And Setters------------------------------
  

    public long getBusinessId() {
        return businessId;
    }

    public int getCurrentNumberOfOccupiedRooms() {
		return currentNumberOfOccupiedRooms;
	}


	public void setCurrentNumberOfOccupiedRooms(int currentNumberOfOccupiedRooms) {
		this.currentNumberOfOccupiedRooms = currentNumberOfOccupiedRooms;
	}


	public String getDisplayName() {
		return displayName;
	}


	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}


	public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getNumberOfPeoplePerRoom() {
        return numberOfPeoplePerRoom;
    }

    public double getPricePerPerson() {
        return pricePerPerson;
    }

    public Destination getLocation() {
        return location;
    }
   
    public ArrayList<TicketCheckIn<Accommodation>> getTickets() {
		return tickets;
	}

	// -------------------------------More Methods------------------------------

    /**
     * Make reservations for certain amount of people.
     * @param numberOfPeople
     * @return
     */
    public boolean reserveRooms(int numberOfPeople){
        //TODO: Complete this method

        int roomsNeeded = numberOfPeople / numberOfPeoplePerRoom + (numberOfPeople % numberOfPeoplePerRoom  == 0 ? 0 : 1);

        if(currentNumberOfOccupiedRooms + roomsNeeded > numberOfRooms)
            return false;


        currentNumberOfOccupiedRooms += roomsNeeded;
        currentNumberPeople += numberOfPeople;
        return true;
    }

    /**
     * Remove reservations for certain amount of people.
     * @param numberOfPeople
     * @return
     */
    public boolean clearReservations(int numberOfPeople){
        //TODO: Complete this method

        int roomsNeeded = numberOfPeople / numberOfPeoplePerRoom + (numberOfPeople % numberOfPeoplePerRoom  == 0 ? 0 : 1);

        if(currentNumberOfOccupiedRooms - roomsNeeded < 0)
            return false;

        currentNumberOfOccupiedRooms -= roomsNeeded;
        currentNumberPeople -= numberOfPeople;

        return true;
    }
    /**
     * Add Ticket.
     * @param numberOfPeople
     * @return
     */
    public boolean AddTicket(TicketCheckIn<Accommodation> ticket){
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
     * @param
     * @return
     */
    public boolean removeTicket(TicketCheckIn<Accommodation> ticket){
        //TODO: Complete this method
    	if(!tickets.contains(ticket))
    		return false;
       else {
    	   tickets.remove(ticket);
    	   return true;
       }
      
    }

    /**
     *
     * @param people
     * @return
     */
    public boolean isAvailable(int people){
        //TODO: Complete this method

        int roomsNeeded = people / numberOfPeoplePerRoom + (people % numberOfPeoplePerRoom  == 0 ? 0 : 1);
        //return  !(currentNumberOfOccupiedRooms - roomsNeeded < 0);
        return !(currentNumberOfOccupiedRooms + roomsNeeded > numberOfRooms);
    }


	public void removeTicketByOrder(Order o) {
		//TODO
		ArrayList<TicketCheckIn<Accommodation>> temp =new ArrayList<>();
		temp.addAll(tickets);
		for(TicketCheckIn<Accommodation> t: temp)
			if(t.getOrder().equals(o))
				tickets.remove(t);
	}
	
	
	@Override
	public int compareTo(Accommodation o) {
		//TODO
		Integer sen1 = this.getNumberOfRooms();
		Integer sen2 = o.getNumberOfRooms();
		return sen2.compareTo(sen1);
	}

	// -------------------------------hashCode equals & toString------------------------------	
  
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (businessId ^ (businessId >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object o) {
		 if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Accommodation that = (Accommodation) o;
	        return businessId == that.businessId;
	}

}
