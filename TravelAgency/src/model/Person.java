package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * Created by Antonio Zaitoun on 13/07/2018.
 * Update by Heyam Abdalhade on 04/08/2018.
 */
public abstract class Person implements Comparable<Person>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// -------------------------------Class Members------------------------------
    /**
     * The ID of the person.
     */
    final protected long id;
    
    /**
     * The password to enter the system
     */
    protected String password;

	/**
     * First name of the person.
     */
    private String firstName;

    /**
     * Last name of the person.
     */
    private String surname;

    /**
     * The birth date of the person.
     */
    private Date birthDate;

    /**
     * The person's email.
     */
    private String email;

    /**
     * The person's address.
     */
    private Address address;
    /**
     * The answer to the private question to reset password
     */
    private String answer;

	// -------------------------------Constructors------------------------------
    /**
     * Partial constructor using only id.
     * @param id The id of the person.
     */
    public Person(long id, String password) {
        this.id = id;
        this.password = password;
    }

    /**
     * Full constructor.
     *
     * @param id The ID of the person.
     * @param firstName First name of the person.
     * @param surname Last name of the person.
     * @param birthDate The birth date of the person.
     * @param email The person's email.
     * @param address The person's address.
     */
    public Person(long id, String password, String firstName, String surname, Date birthDate, String email, Address address, String answar) {
        this.id = id;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
        this.address = address;
        this.answer = answar;
    }

	// -------------------------------Getters And Setters------------------------------

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	

	// -------------------------------More Methods------------------------------
	/**
	 * This method calculate this person age (in years). 
	 * if the person age is 40.5, than its age is 40 years.
	 * 
	 * @return employee seniority
	 */
	@SuppressWarnings("deprecation")
	public int getPersonAge() {
		//TODO
		Date temp = new Date();
		temp = new Date(temp.getTime() - birthDate.getTime());
		return temp.getYear();
	}
	
	public int compareTo(Person o2) {
		Integer sen1 = this.getPersonAge();
		Integer sen2 = o2.getPersonAge();
		Integer ans = sen1.compareTo(sen2);
		if(ans != 0)
			return ans;
		else
			return 1;
	}

	// -------------------------------hashCode equals & toString------------------------------	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		return true;
		
    }

	@Override
	public String toString() {
		DateFormat dft = new SimpleDateFormat("dd/MM/yyyy;HH:mm");
		return "Person [id=" + id + ", firstName=" + firstName + ", surname=" + surname + ", birthDate=" + dft.format(birthDate)
				+ ", email=" + email + ", address=" + address + "]";
	}
    
    
}
