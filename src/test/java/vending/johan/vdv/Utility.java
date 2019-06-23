package test.java.vending.johan.vdv;

import java.text.*;
import java.util.*;

public class Utility {
	/*
	 * Well need the scanner to get some responses of the player, because we don't
	 * want to create a new scanner in every class, we'll put it here and set some
	 * shorthand methods for it
	 */
	private static Scanner kbd = new Scanner(System.in);

	/**
	 * Get the next input
	 * 
	 * @return
	 */
	public static String next() {
		return kbd.next();
	}
	/*
	 * End shorthands -----------------------------------------------
	 */

	// Date formatter
	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	// Number formatter
	private static NumberFormat numberFormatter = new DecimalFormat("#0.00");

	/**
	 * Format a date
	 * 
	 * @param calendar
	 * @return
	 */
	public static String formatDate(GregorianCalendar calendar) {
		dateFormatter.setCalendar(calendar);
		return dateFormatter.format(calendar.getTime());
	}

	/**
	 * Format a number
	 * 
	 * @param number
	 * @return
	 */
	public static String formatNumber(double number) {
		return numberFormatter.format(number);
	}

	/**
	 * Print a empty line
	 */
	public static void printNewLine() {
		System.out.println();
	}

	/**
	 * Print a line
	 */
	public static void printDivider() {
		System.out.println("----------------------------------------");
	}
}
