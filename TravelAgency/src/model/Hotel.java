package model;

/**
 * Created by Antonio Zaitoun on 13/07/2018.
 */
public class Hotel extends Accommodation {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Any number between 1.0 ~ 5.0
     */
    private double starRating;

    private boolean serversBreakfast;

    private boolean hasPool;

    public Hotel(long id, String displayName,
                 int numberOfRooms,
                 int numberOfPeoplePerRoom,
                 double pricePerPerson,
                 Destination location,
                 double starRating, 
                 boolean serversBreakfast,
                 boolean hasPool) {
        super(id,displayName, numberOfRooms, numberOfPeoplePerRoom, pricePerPerson, location);
        setStarRating(starRating);
        this.serversBreakfast = serversBreakfast;
        this.hasPool = hasPool;
    }

    public double getStarRating() {
        return starRating;
    }

    public void setStarRating(double starRating) {
        this.starRating = Math.min(Math.max(starRating,1.0),5.0);
    }

    public boolean isServersBreakfast() {
        return serversBreakfast;
    }

    public void setServersBreakfast(boolean serversBreakfast) {
        this.serversBreakfast = serversBreakfast;
    }

    public boolean isHasPool() {
        return hasPool;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "starRating=" + starRating +
                ", hasPool=" + hasPool +
                ", serversBreakfast=" + serversBreakfast +
                ", businessId=" + businessId +
                ", displayName='" + displayName + '\'' +
                ", numberOfRooms=" + numberOfRooms +
                ", numberOfPeoplePerRoom=" + numberOfPeoplePerRoom +
                ", pricePerPerson=" + pricePerPerson +
                '}';
    }
}
