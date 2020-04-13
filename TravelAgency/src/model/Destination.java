package model;

import java.io.Serializable;

/**
 * Created by Antonio Zaitoun on 13/07/2018.
 * Update by Heyam Abdalhade on 04/08/2018.
 */
public class Destination implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// -------------------------------Class Members------------------------------
	final private String country;
    final private String city;
    
	// -------------------------------Constructors------------------------------

    /**
     *
     * @param country 
     * @param city
     */
    public Destination(String country, String city) {
        this.country = country.toLowerCase();
        this.city = city.toLowerCase();
    }

    public Destination(String s) {
        String[] vals = s.split("_");
        country = vals[0].toLowerCase();
        city =  vals[1].toLowerCase();
    }

    // -------------------------------Getters------------------------------

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }
    
	// -------------------------------hashCode equals & toString------------------------------	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Destination other = (Destination) obj;
		if(other.city.equals(this.city) && other.country.equals(this.country))
			return true;
		else
			return false;
	}


    @Override
    public String toString() {
        return country+", "+city;
    }
    

}
