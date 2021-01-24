package com.availablefoodtrucks.services;

import java.util.Iterator;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

/***
 * 
 * This class is meant for printed the list of available trucks based on the
 * page limit
 * 
 * @param trucks JSONArray for trucks
 * @param limt   number of trucks to be listed per page
 * 
 * @author Harsh
 *
 */

public class Loggers {

	public static void printAvailableTrucks(JSONArray trucks, int limit) {

		// Returning if no truck available at any particular time
		if (trucks.length() == 0) {
			System.out.println("No Trucks Available at this time");
			return;
		}

		// Throwing error if limit is less than 1
		if (limit <= 0) {
			throw new IllegalArgumentException("Limit must be atleast 1");
		}

		Iterator<Object> truck = trucks.iterator();
		Scanner sc = new Scanner(System.in);

		while (true) {
			// indentation to print to the output cleanly
			System.out.printf("%75s %20s\n", "NAME", "ADDRESS");

			for (int i = 1; i <= limit && truck.hasNext(); i++) {
				JSONObject t = (JSONObject) truck.next();
				System.out.printf("%75s %20s\n", t.get("applicant"), t.get("location"));
			}

			if (truck.hasNext()) {
				// Waiting for user input to display next set of trucks
				System.out.println("Press ENTER to view more..");
				sc.nextLine();
			} else {
				sc.close();
				break;
			}

		}
	}
}
