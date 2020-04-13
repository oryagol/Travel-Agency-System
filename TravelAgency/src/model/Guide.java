package model;


import java.util.Date;
import java.util.HashSet;

/**
 * Created by Antonio Zaitoun on 13/07/2018.
 * Update by Heyam Abdalhade on 04/08/2018.
 */
public class Guide extends Person {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// -------------------------------Class Members------------------------------
	/**
	 * The date of which this person has became a guide.
	 */
	private Date startDate;

	/**
	 * A list of destinations in which this guide is experienced.
	 */
	private HashSet<Destination> experiencedDestinations;
	/**
	 * A list of groups Trips in which this guide is guided them.
	 */
	private HashSet<GroupTrip> groupsTrip;

	// -------------------------------Constructors------------------------------

	/**
	 *
	 * @param id The ID of the person.
	 * @param firstName First name of the person.
	 * @param surname Last name of the person.
	 * @param birthDate The birth date of the person.
	 * @param email The person's email.
	 * @param address The person's address.
	 * @param startDate The date of which this person became a guide.
	 * @param experiencedDestinations A list of destinations in which this guide is experienced.
	 */
	public Guide(long id, String password,
			String firstName,
			String surname,
			Date birthDate,
			String email,
			Address address,
			Date startDate,
			HashSet<Destination> experiencedDestinations, String answer) {
		super(id, password, firstName, surname, birthDate, email, address, answer);
		this.startDate = startDate;
		this.experiencedDestinations = experiencedDestinations;
		groupsTrip = new HashSet<>();
	}
	// -------------------------------More Methods------------------------------
	/**
	 * This method calculate this Guide seniority (in years). 
	 * if the Guide started to work in this year, than its seniority is 0 years.
	 * 
	 * @return seniority
	 */
	@SuppressWarnings("deprecation")
	public int getGuideSeniority() {
		//TODO
		Date temp = new Date();
		temp = new Date(temp.getTime() - startDate.getTime());
		return temp.getYear();
	}
	
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public HashSet<GroupTrip> getGroupsTrip() {
		return groupsTrip;
	}
	public void setGroupsTrip(HashSet<GroupTrip> groupsTrip) {
		this.groupsTrip = groupsTrip;
	}
	public HashSet<Destination> getExperiencedDestinations() {
		return experiencedDestinations;
	}
	public void setExperiencedDestinations(HashSet<Destination> experiencedDestinations) {
		this.experiencedDestinations = experiencedDestinations;
	}
	/**
	 * 
	 * @param gTrip
	 * @return
	 */
	public boolean addGroupTrip(GroupTrip gTrip) {
		//TODO
		if(groupsTrip.contains(gTrip)) return false;
		else {
			if(experiencedDestinations.contains(gTrip.getLocation()))
			{
				groupsTrip.add(gTrip);
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param des
	 * @return
	 */
	public boolean addExpDestination(Destination des) {
		//TODO
		if(!experiencedDestinations.contains(des))
		{
			experiencedDestinations.add(des);
			return true;
		}

		return false;
	}
}
