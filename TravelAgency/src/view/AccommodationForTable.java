package view;

import model.Accommodation;
import model.Destination;

public class AccommodationForTable {
	private long businessId;

	private String displayName;

    
	private int numberOfRooms;

    /**
     * The amount of people that can fit into a single room.
     */
	private int numberOfPeoplePerRoom;

    /**
     * The price per a single person.
     */
	private double pricePerPerson;

   

    /**
     * The place in which this accommodation is located.
     */
	private Destination location;
	/**
	 * Hotel/Hostel/Motel
	 */
	private String type;
	
	 /**
     * The current number of rooms being occupied in׳�׳� this accommodation.
     */
    private int currentNumberOfOccupiedRooms = 0;
	
	
	
	public AccommodationForTable(Accommodation a) {
		super();
		this.businessId = a.getBusinessId();
		this.displayName = a.getDisplayName();
		this.numberOfRooms = a.getNumberOfRooms();
		this.numberOfPeoplePerRoom = a.getNumberOfPeoplePerRoom();
		this.pricePerPerson = a.getPricePerPerson();
		this.location = a.getLocation();
		this.currentNumberOfOccupiedRooms=a.getCurrentNumberOfOccupiedRooms();
		String tmp= a.getClass().getName().substring(6);
		
		
		this.type =tmp;
	}
	
	
	public int getCurrentNumberOfOccupiedRooms() {
		return currentNumberOfOccupiedRooms;
	}


	public void setCurrentNumberOfOccupiedRooms(int currentNumberOfOccupiedRooms) {
		this.currentNumberOfOccupiedRooms = currentNumberOfOccupiedRooms;
	}


	public long getBusinessId() {
		return businessId;
	}
	public void setBusinessId(long businessId) {
		this.businessId = businessId;
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
	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}
	public int getNumberOfPeoplePerRoom() {
		return numberOfPeoplePerRoom;
	}
	public void setNumberOfPeoplePerRoom(int numberOfPeoplePerRoom) {
		this.numberOfPeoplePerRoom = numberOfPeoplePerRoom;
	}
	public double getPricePerPerson() {
		return pricePerPerson;
	}
	public void setPricePerPerson(double pricePerPerson) {
		this.pricePerPerson = pricePerPerson;
	}
	public Destination getLocation() {
		return location;
	}
	public void setLocation(Destination location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
	
	
}
