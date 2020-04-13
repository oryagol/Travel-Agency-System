package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import model.*;

/**
 * Created by Antonio Zaitoun on 17/07/2018.
 * Update by Heyam Abdalhade on 04/08/2018.
 */
public final class Shared implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// -------------------------------Class Members------------------------------
	private static Shared instance;

	/**
	 * The orders made by customers.
	 */
	private final HashMap<Integer, Order> orders;

	/**
	 * The packages that were pre-defined by the travel agency.
	 */
	private final HashMap<String,TravelPackage> packages;

	/**
	 * The flights that are taking place.
	 */
	private final HashMap<String, Flight> flights;

	/**
	 * All the registered accommodations.
	 */
	private final HashMap<Long,Accommodation> accommodations;

	/**
	 * All the destinations registered by the agency.
	 */
	private final HashMap<String, ArrayList<Destination>> destinations;

	/**
	 * All the people in the database, includes guides and customers.
	 */
	private final HashMap<Long,Customer> customers;

	private final HashMap<Long,Guide> guides;

	/**
	 * All the trips that are registered by the travel agency.
	 */
	private final HashMap<Integer,GroupTrip> trips;
	
	private final HashMap<Long, Person> userConfirmation;
	
	private Integer count=1;
	private Integer orderRunningNumber=1;
	
	
	HashMap<Destination, ArrayList<Flight>> flightsFromDestination;
	HashMap <Destination, ArrayList<Flight>> flightsToDestination;
	private HashMap <Order, HashMap<Customer, Integer>> table;

	// -------------------------------Constructors------------------------------
	private Shared() {
		count = 0;
		orders = new HashMap<>();
		packages = new HashMap<>();
		flights = new HashMap<>();
		accommodations = new HashMap<>();
		destinations = new HashMap<>();
		customers = new HashMap<>();
		guides = new HashMap<>();
		trips = new HashMap<>();
		userConfirmation = new HashMap<>();
		flightsFromDestination= new HashMap<>();
		flightsToDestination = new HashMap<>();
		table = new HashMap<>();
	}

	// -----------------------------------------Getters--------------------------------------

	

	public static Shared getInstance() {
		if (instance == null) 
			instance = new Shared();
		return instance;

	} 


	public Integer getOrderRunningNumber() {
		return orderRunningNumber;
	}

	public void setOrderRunningNumber(Integer orderRunningNumber) {
		this.orderRunningNumber = orderRunningNumber;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void boostCount() {
		count++;
	}
	public Integer orderNextNumber() {
		return orderRunningNumber++;
	}

	public HashMap<Integer, Order> getOrders() {
		return orders;
	}

	public HashMap<String, TravelPackage> getPackages() {
		return packages;
	}

	public HashMap<String, Flight> getFlights() {
		return flights;
	}

	public HashMap<Long, Accommodation> getAccommodations() {
		return accommodations;
	}

	public HashMap<String, ArrayList<Destination>> getDestinations() {
		return destinations;
	}

	public HashMap<Long, Customer> getCustomers() {
		return customers;
	}

	public HashMap<Long, Guide> getGuides() {
		return guides;
	}

	public HashMap<Integer, GroupTrip> getTrips() {
		return trips;
	}
	


	public HashMap<Destination, ArrayList<Flight>> getFlightsFromDestination() {
		return flightsFromDestination;
	}

	public HashMap<Destination, ArrayList<Flight>> getFlightsToDestination() {
		return flightsToDestination;
	}

	public HashMap<Order, HashMap<Customer, Integer>> getTable() {
		return table;
	}
	
	public HashMap<Long, Person> getUserConfirmation() {
		return userConfirmation;
	}
	
	public static boolean save(String fileName) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(instance);
			objectOut.close();
			fileOut.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return false;
		} catch (IOException e1) {
			e1.printStackTrace();
			return false;
		}
		return true;
	}

	public static void load(String fileName) {
		instance = null;
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream obIn = new ObjectInputStream(fileIn);
			instance = (Shared)obIn.readObject();
			obIn.close();
			fileIn.close();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			try {
				instance = getInstance();
				FileOutputStream fileOut = new FileOutputStream(fileName);
				ObjectOutputStream obOut = new ObjectOutputStream(fileOut);
				obOut.writeObject(instance);
				obOut.close();
				fileOut.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



}
