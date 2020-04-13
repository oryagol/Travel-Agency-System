package model;

import java.io.Serializable;

/**
 * Class Trophy ~ represent a single Trophy, a trophy may belong to a stadium, team, coach or player.
 * 
 * @author Java Course Team 2018 - Heyam Abdalhade
 * @author University Of Haifa - Israel
 * @param <T>
 */
public class TicketCheckIn<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// -------------------------------Class Members------------------------------
	private final String codeTichet;
	/**
	* The customer for this ticket
	*/
	private Customer customer;
	/**
	* The order for this ticket
	*/
	private Order order;
	/**
	* The check-In for this ticket(flight or Accommodation or group trip)
	*/
	private T checkIn;
	
	// -------------------------------Constructors------------------------------
	
	public TicketCheckIn(String code, Customer customer, Order order, T checkIn) {
		super();
		this.codeTichet = code;
		this.customer = customer;
		this.order = order;
		this.checkIn = checkIn;
	}

	// -------------------------------Getters And Setters------------------------------
	
	
	public Customer getCustomer() {
		return customer;
	}

	public String getCodeTichet() {
		return codeTichet;
	}

	public Order getOrder() {
		return order;
	}

	public T getCheckIn() {
		 return checkIn;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setCheckIn(T checkIn) {
		this.checkIn = checkIn;
	}

	// -------------------------------hashCode equals & toString------------------------------	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeTichet == null) ? 0 : codeTichet.hashCode());
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
		TicketCheckIn<?> other = (TicketCheckIn<?>) obj;
		if (codeTichet == null) {
			if (other.codeTichet != null)
				return false;
		} else if (!codeTichet.equals(other.codeTichet))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TicketCheckIn [codeTichet=" + codeTichet + ", customer=" + customer + ", order=" + order + ", checkIn="
				+ checkIn + "]";
	}

}
