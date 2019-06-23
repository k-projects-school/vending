package test.java.vending.johan.vdv;

public enum Can {
	COLA(2.2), FANTA(2.2), ICETEA(2) {
		@Override
		public String getName() {
			return "Ice-Tea";
		}
	},
	SPA(1.5);

	// The price of the can
	private double price;

	/**
	 * Constructor
	 * 
	 * @param price
	 */
	Can(double price) {
		this.price = price;
	}

	/**
	 * Get the price
	 * 
	 * @return
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Get the name
	 * 
	 * @return
	 */
	public String getName() {
		// Get the first character as a upper case and the rest as lower case
		return this.name().charAt(0) + this.name().toLowerCase().substring(1);
	}
}
