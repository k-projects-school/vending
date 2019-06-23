package test.java.vending.johan.vdv;

import java.util.InputMismatchException;
import java.util.UUID;

public class VendingMachine {
	// Unique Id for the vending machine
	private UUID id;
	// The stock of the vending machine
	private Stock stock;
	// The register of the vending machine
	private Register register;

	/**
	 * Constructor
	 * 
	 * @param stock    - The stock
	 * @param register - The register
	 */
	public VendingMachine(Stock stock, Register register) {
		this.id = UUID.randomUUID();
		this.stock = stock;
		this.register = register;
	}

	/**
	 * Get the register
	 * 
	 * @return
	 */
	public Register getRegister() {
		return this.register;
	}

	/**
	 * Get the id
	 * 
	 * @return
	 */
	public UUID getId() {
		return this.id;
	}

	/**
	 * Get the stock
	 * 
	 * @return
	 */
	public Stock getStock() {
		return this.stock;
	}

	/**
	 * Get the choice of the user
	 * 
	 * @param input
	 * @return
	 */
	public Can getChoice(int input) {
		return Can.values()[input - 1];
	}

	/**
	 * Print the menu
	 */
	public void printMenu() {
		System.out.println("Make your choice: ");
		// Loop through the can types
		for (Can can : Can.values()) {
			// String suffix to show if the current can is sold out or not
			String soldOut = "";
			// If the stock is depleted of a type of can
			if (!this.stock.checkStock(can)) {
				soldOut = " / Sold out!";
			}
			System.out.println("[" + (can.ordinal() + 1) + "] " + can.getName() + ": "
					+ Utility.formatNumber(can.getPrice()) + "€" + soldOut);
		}
	}

	/**
	 * Get the input of the user
	 */
	public void getUserInput() {
		try {
			// Get the first input
			String response = Utility.next();
			// Parse the response to an Integer
			int input = Integer.parseInt(response);

			// If the input is higher or lower then the options
			if (input > Can.values().length || input < 0) {
				throw new InputMismatchException();
			}

			// Get the chosen can
			Can can = this.getChoice(input);
			
			if (this.stock.checkStock(can)) {
				// If the can is in stock, remove it from the stock
				this.stock.removeCan(can);
				// Add a new ticket to the register
				this.register.addTicket(new Ticket(can));
			} else {
				// If the chosen can is not in stock
				System.out.println(
						"The article You choose is not available at this moment. Please choose another article.");
				this.getUserInput();
			}
		} catch (InputMismatchException | NumberFormatException e) {
			/*
			 * If a user enters a wrong input (a number to high or to low, or a non numeric input),
			 * show a message and let the user choose a new can.
			 */
			System.out.println("You have to enter a number between 1 and " + Can.values().length);
			this.getUserInput();
		}
	}
}
