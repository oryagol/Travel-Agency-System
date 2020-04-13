package model;

import java.io.Serializable;

/**
 * Created by Antonio Zaitoun on 13/07/2018.
 * Update by Heyam Abdalhade on 04/08/2018.
 */
public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		// -------------------------------Class Members------------------------------
		private String city;
		private String country;
		private int houseNumber;
		private String phoneNumber;
		private String street;

		// -------------------------------Constructors-----------------------------
		public Address(String city,String country,  String street, int houseNumber, String phoneNumber) {
			super();
			this.city = city;
			this.country = country;
			this.houseNumber = houseNumber;

			this.phoneNumber = phoneNumber;
			this.street = street;
		}

		// -------------------------------Getters And Setters------------------------------
		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public int getHouseNumber() {
			return houseNumber;
		}

		public void setHouseNumber(int houseNumber) {
			this.houseNumber = houseNumber;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}
		// -------------------------------More Methods------------------------------

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((city == null) ? 0 : city.hashCode());
			result = prime * result + ((country == null) ? 0 : country.hashCode());
			result = prime * result + houseNumber;
			result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
			result = prime * result + ((street == null) ? 0 : street.hashCode());
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
			Address other = (Address) obj;
			if (city == null) {
				if (other.city != null)
					return false;
			} else if (!city.equals(other.city))
				return false;
			if (country == null) {
				if (other.country != null)
					return false;
			} else if (!country.equals(other.country))
				return false;
			if (houseNumber != other.houseNumber)
				return false;
			if (phoneNumber == null) {
				if (other.phoneNumber != null)
					return false;
			} else if (!phoneNumber.equals(other.phoneNumber))
				return false;
			if (street == null) {
				if (other.street != null)
					return false;
			} else if (!street.equals(other.street))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return street + " " + houseNumber + ", " + city + ", " + country + ", phones: " + phoneNumber;
		}
}
