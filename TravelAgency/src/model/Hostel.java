package model;

import utils.HostelAccommodationType;

/**
 * Created by Antonio Zaitoun on 13/07/2018.
 */
public class Hostel extends Accommodation {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HostelAccommodationType accommodationType;

    /**
     *
     * @param displayName
     * @param numberOfRooms
     * @param numberOfPeoplePerRoom
     * @param pricePerPerson
     * @param location
     * @param accommodationType
     */
    public Hostel(long id,String displayName,
                  int numberOfRooms,
                  int numberOfPeoplePerRoom, 
                  double pricePerPerson,
                  Destination location,
                  HostelAccommodationType accommodationType) {
        super(id,displayName, numberOfRooms, numberOfPeoplePerRoom, pricePerPerson, location);
        this.accommodationType = accommodationType;
    }

    public HostelAccommodationType getAccommodationType() {
        return accommodationType;
    }

    public void setAccommodationType(HostelAccommodationType accommodationType) {
        this.accommodationType = accommodationType;
    }
    
    @Override
    public String toString() {
        return "Hostel{" +
                "accommodationType=" + accommodationType +
                ", businessId=" + businessId +
                ", displayName='" + displayName + '\'' +
                ", numberOfRooms=" + numberOfRooms +
                ", numberOfPeoplePerRoom=" + numberOfPeoplePerRoom +
                ", pricePerPerson=" + pricePerPerson +
                '}';
    }
}
