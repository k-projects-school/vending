package test.java.vending.johan.vdv;

public class App {

	public static void main(String[] args) {
		// Create a new vending machine with stock and register
		VendingMachine vendingMachine = new VendingMachine(new Stock(10), new Register());

		// Ask for 5 cans
		for (int i = 0; i < 5; i++) {
			// Print the menu
			vendingMachine.printMenu();
			// Get the input from the user
			vendingMachine.getUserInput();
		}		
		Utility.printDivider();
		Utility.printNewLine();
		
		// Print all the tickets of the vending machine
		System.out.println("All tickets: ");
		vendingMachine.getRegister().printTickets();
		Utility.printDivider();
		Utility.printNewLine();
		// Print the amount of each can type sold for the current day
		vendingMachine.getRegister().printDailyOverview();
		Utility.printDivider();
	}

}
