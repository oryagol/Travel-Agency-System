package controller;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


import model.*;

/**
 * Created by Antonio Zaitoun on 14/07/2018.
 * Update by Heyam Abdalhade on 04/08/2018.
 */
public class QueriesController {

//**********************************HW1********************************//

    /**
     * Get all travel packages that are in a certain price range.
     *
     * 1) create a temp array
     * 2) iterate over the packages array, and for each element, if the conditions are met, append it in the temp array.
     * 3) create a results array and copy the non-null values from the temp array.
     * 4) return the results.
     *
     * @param startRange The start range price.
     * @param endRange The end range price.
     * @return Travel Packages within a given price range.
     */
    public Set<TravelPackage> getAllPackagesInRange(double startRange, double endRange){
        //TODO: Complete this method


        final Set<TravelPackage> tempArr = new HashSet<TravelPackage>();

        for (TravelPackage travelPackage : Shared.getInstance().getPackages().values())
            if(travelPackage.getTotalCost() <= endRange &&
                    travelPackage.getTotalCost() >= startRange)
            	tempArr.add(travelPackage);

        return tempArr;
    }



//**********************************HW2********************************//
	
	/**
	 * A Method to return in a list all customers who have Order a motel with a WiFi service,
	 * and sort the list before returning it in ascending order, sorted by customer age.
	 * @return the sorted list.
	 */
	public Set<Person> getAllCustomersWhoOrdered_A_MotelWithWiFiService(){
		//TODO:
		Set<Person> toRet=new TreeSet<>();
		for (Order o : Shared.getInstance().getOrders().values()) {
			for (TicketCheckIn<Accommodation> tci : o.getAccommodations()) {
				if(tci.getCheckIn() instanceof Motel) {
					Motel m=(Motel)tci.getCheckIn();
					if(m.isHasWifi()) {
						toRet.add(o.getOwner());
					}
				}
			}
		}
		return toRet;
	}


	/**
	 * A method that receives a collection of accommodation and type of sort and sorts the accommodation according to its location, 
	 * the main sort by accommodation's country and secondary sort according to the accommodation's city, 
	 * according to the type of sort (ascending or descending order).
	 * The method returns MAP when its key is the accommodation's Location and the value is accommodation .
	 * Hint Use TreeMap.
	 * Note: Assume that all the given Accommodations are not in the same location.
	 * Note: String sorted by default in a lexicographical order, use this option. 
	 * @param Accommodations List of Accommodation to sort.
	 * @param sortedType The Sort type, if true Sort in ascending order, else sort In descending order.
	 * @return return a Map of Accommodations sorted by key.
	 */
	public  Map<Destination, TreeSet<Accommodation>> getAllAccommodationSortedByDestination(Collection<Accommodation> Accommodations
			,boolean sortedType){
		// TODO Auto-generated method stub
		Map<Destination, TreeSet<Accommodation>> toRet=new TreeMap<>(new Comparator<Destination>() {
			@Override
			public int compare(Destination d1, Destination d2) {
				// TODO Auto-generated method stub
				// if sortedType=true sort in ascending sort else sort in descending sort.
				if(sortedType) {
					int mainSort=d1.getCountry().compareTo(d2.getCountry());
					if(mainSort==0) {
						return d1.getCity().compareTo(d2.getCity());
					}else {
						return mainSort;
					}
				}else {
					int mainSort=d2.getCountry().compareTo(d1.getCountry());
					if(mainSort==0) {
						return d2.getCity().compareTo(d1.getCity());
					}else {
						return mainSort;
					}
				}
			}
		});

		for (Accommodation accommodation : Accommodations) {
			TreeSet<Accommodation> acc =new TreeSet<>();
			if(!toRet.containsKey(accommodation.getLocation()))
			{				
				acc.add(accommodation);
				toRet.put(accommodation.getLocation(), acc);
			}
			else 
			{
				acc = toRet.get(accommodation.getLocation());
				acc.add(accommodation);
				toRet.put(accommodation.getLocation(), acc);
			}
		}
		return toRet;

	}

	/**
	 * A method sorted the orders in the system according to its total cost 
	 * and return the sorted orders in a Set.
	 * @param sortedType The Sort type, if true Sort in ascending order, else sort In descending order.
	 * @return return a Set of Orders sorted by Total Cost.
	 */
	public Set<Order> getAllOrdersSortededByTotalCost(){
		//TODO
		TreeSet<Order> toRet=new TreeSet<>(new Comparator<Order>() {
			@Override
			public int compare(Order o1, Order o2) {
				// TODO Auto-generated method stub
				int res=new Double(o2.getTotalCost()/o2.getQuantity()).compareTo(new Double(o1.getTotalCost()/o1.getQuantity()));
				return res;
			}
		});
		toRet.addAll(Shared.getInstance().getOrders().values());
		return toRet;
	}


	/**
	 * This query returns all the customers that have a ticket from 
	 * flight1 or flight2 but not to both 
	 * @return array of customers if customers were found, empty list otherwise  
	 */
	public ArrayList<Customer> getCustomersFlight1XORFlight2(String flight1, String flight2) {
		//TODO
		ArrayList<Customer> flight1Customers = new ArrayList<>();
		ArrayList<Customer> flight2Customers = new ArrayList<>();
		Set<Customer> flight1UnionFlight2 = new TreeSet<>();
		if (Shared.getInstance().getFlights().containsKey(flight1) && 
				Shared.getInstance().getFlights().containsKey(flight2)) {
			Flight f1 = Shared.getInstance().getFlights().get(flight1);
			Flight f2 = Shared.getInstance().getFlights().get(flight2);
			for (Customer c : Shared.getInstance().getCustomers().values()) {

				for (TicketCheckIn<Flight> tick : c.getTicketsFlight()) {
					if (tick.getCheckIn().equals(f1)) 
						flight1Customers.add(c);
					if (tick.getCheckIn().equals(f2)) 
						flight2Customers.add(c);
				}
			}
			flight1UnionFlight2.addAll(flight1Customers);
			flight1UnionFlight2.addAll(flight2Customers);
			flight1UnionFlight2.removeIf(c -> { return flight1Customers.contains(c) && flight2Customers.contains(c); });

		}
		return new ArrayList<>(flight1UnionFlight2);
	}

	/**
	 * 1) create a copy of destinations array
	 * 2) create an array of ints at the length of the copied array
	 * 3) for each order, for each flight,accommodation,trip increment the counter array.
	 * 4) sort the arrays based on the counter array
	 * 5) copy the result into a new array
	 * 6) return the new array
	 *
	 * @return The 5 most popular destinations based on the orders.
	 */
	public List<Destination> getMostPopularDestinations(){
		//TODO: Complete this method

		Map<Destination, Integer> allDestationAndCount = new HashMap<Destination, Integer>();

		for ( Order order : Shared.getInstance().getOrders().values()) {

			for (TicketCheckIn<Accommodation> element : order.getAccommodations()) {
				Destination temp = element.getCheckIn().getLocation();
				if(allDestationAndCount.containsKey(temp))
					allDestationAndCount.put(temp, allDestationAndCount.get(temp)+1);
				else
					allDestationAndCount.put(temp, 1);					
			}
			for (TicketCheckIn<Flight> element : order.getFlights()) {
				Destination temp = element.getCheckIn().getTo();
				if(allDestationAndCount.containsKey(temp))
					allDestationAndCount.put(temp, allDestationAndCount.get(temp)+1);
				else
					allDestationAndCount.put(temp, 1);	
			}
			for (TicketCheckIn<GroupTrip> element : order.getGroupTrips()) {
				Destination temp = element.getCheckIn().getLocation();
				if(allDestationAndCount.containsKey(temp))
					allDestationAndCount.put(temp, allDestationAndCount.get(temp)+1);
				else
					allDestationAndCount.put(temp, 1);	
			}
		}

		ArrayList<Map.Entry<Destination, Integer>> list = 
				new ArrayList<Map.Entry<Destination, Integer>>(allDestationAndCount.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Destination, Integer>>() {
			public int compare(Map.Entry<Destination, Integer> o1,Map.Entry<Destination, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		ArrayList<Destination> relevant = new ArrayList<>(5);
		for(int i=0; i<5 ;i++) {
			if(i<list.size())
			relevant.add(list.get(i).getKey());
		}

		return relevant;
	}


}
