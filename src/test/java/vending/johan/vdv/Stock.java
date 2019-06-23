package test.java.vending.johan.vdv;

import java.util.Arrays;

public class Stock {
	// Array that holds all the cans
	private Can[] cans = new Can[0];

	/**
	 * Constructor
	 * 
	 * @param amount
	 */
	Stock(int amount) {
		this.initStock(amount);
	}

	/**
	 * Check if a can is in stock
	 * 
	 * @param can
	 * @return
	 */
	public boolean checkStock(Can can) {
		// Loop through the cans in stock
		for (int i = 0; i < this.cans.length; i++) {
			// If the can is found in the array, the can is in stock
			if (this.cans[i].equals(can)) {
				return true;
			}
		}

		// If the can is not found in the array, it's not in stock
		return false;
	}

	/**
	 * Initialize the stock
	 * 
	 * @param amount
	 */
	public void initStock(int amount) {
		// Loop through all the can types
		for (Can can : Can.values()) {
			// Add cans for the given amount
			for (int i = 0; i < amount; i++) {
				this.addCan(can);
			}
		}
	}

	/**
	 * Add a can to the cans array
	 * 
	 * @param can
	 */
	private void addCan(Can can) {
		// Copy the cans array and ad & entry to the array
		this.cans = Arrays.copyOf(this.cans, this.cans.length + 1);
		// Add the given can to the cans array in the last (new) position
		this.cans[this.cans.length - 1] = can;
	}

	/**
	 * Remove a can from the stock
	 * 
	 * @param can
	 */
	public void removeCan(Can can) {
		// Create a temporary array to store the cans
		Can[] temp = Arrays.copyOf(this.cans, this.cans.length - 1);
		// The position where the can will be stored in the temporary array
		int pos = 0;
		// Flag to check if the can is already removed
		boolean isRemoved = false;
		// Loop through the cans
		for (int i = 0; i < this.cans.length; i++) {
			// If the given can is the same as the current can of the iteration
			if (this.cans[i].equals(can) && !isRemoved) {
				/*
				 * If the current can is not removed, set the flag to true. This will prevent that there
				 * will be more of the same can type be removed
				 */
				isRemoved = true;
				continue;
			} else {
				// Add the can, that doesn't needs to be removed, to the temporary array
				temp[pos] = this.cans[i];
				// Increment the position
				pos++;
			}
		}

		// Set the temporary array as the cans array
		this.cans = temp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Stock [cans=" + Arrays.toString(cans) + "]";
	}
}
