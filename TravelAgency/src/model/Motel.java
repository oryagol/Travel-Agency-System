package model;

/**
 * Created by Antonio Zaitoun on 13/07/2018.
 * Update by Heyam Abdalhade on 04/08/2018.
 */
public class Motel extends Accommodation {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean hasKitchen;

    private boolean hasWifi;

    public Motel(long id, String displayName,
                 int numberOfRooms,
                 int numberOfPeoplePerRoom,
                 double pricePerPerson, 
                 Destination location,
                 boolean hasKitchen,
                 boolean hasWifi) {
        super(id,displayName, numberOfRooms, numberOfPeoplePerRoom, pricePerPerson, location);
        this.hasKitchen = hasKitchen;
        this.hasWifi = hasWifi;
    }

	public boolean isHasKitchen() {
		return hasKitchen;
	}

	public void setHasKitchen(boolean hasKitchen) {
		this.hasKitchen = hasKitchen;
	}

	public boolean isHasWifi() {
		return hasWifi;
	}

	public void setHasWifi(boolean hasWifi) {
		this.hasWifi = hasWifi;
	}
	 @Override
	    public String toString() {
	        return "Motel{" +
	                "hasKitchen=" + hasKitchen +
	                ", hasWifi=" + hasWifi +
	                ", businessId=" + businessId +
	                ", displayName='" + displayName + '\'' +
	                ", numberOfRooms=" + numberOfRooms +
	                ", numberOfPeoplePerRoom=" + numberOfPeoplePerRoom +
	                ", pricePerPerson=" + pricePerPerson +
	                '}';
	    }
    
}
