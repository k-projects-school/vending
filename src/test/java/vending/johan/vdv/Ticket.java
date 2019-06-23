package test.java.vending.johan.vdv;

import java.util.GregorianCalendar;

public class Ticket {
	// The can associated with the ticket
	private Can can;
	// The price of the can
	private double amount = 0;
	// The date the can was bought
	private GregorianCalendar date = new GregorianCalendar();

	/**
	 * Constructor
	 * 
	 * @param can
	 */
	Ticket(Can can) {
		this.can = can;
		this.setAmount();
	}

	/**
	 * Set the price of the can on the ticket
	 */
	private void setAmount() {
		this.amount = this.can.getPrice();
	}

	/**
	 * Get the price amount of the ticket
	 * 
	 * @return
	 */
	public double getAmount() {
		return this.amount;
	}

	/**
	 * Get the date
	 * 
	 * @return
	 */
	public GregorianCalendar getDate() {
		return this.date;
	}

	/**
	 * Get the can
	 * 
	 * @return
	 */
	public Can getCan() {
		return this.can;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return can.getName() + " " + Utility.formatNumber(amount) + "€ \nVerkooptijd: " + date.getTime();
	}
}
