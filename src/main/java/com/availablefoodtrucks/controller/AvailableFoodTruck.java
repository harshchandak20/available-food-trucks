package com.availablefoodtrucks.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;

import com.availablefoodtrucks.services.AvailableTrucks;
import com.availablefoodtrucks.services.Loggers;
import com.mashape.unirest.http.exceptions.UnirestException;

/***
 * 
 * This class is the controller class with main method to call the
 * availabletrucks and loggers services page limit
 * 
 * @author Harsh
 *
 */

public class AvailableFoodTruck {

	public static void main(String[] args) {

		Date now = new Date();
		String time = new SimpleDateFormat("HH:mm").format(now);
		String day = new SimpleDateFormat("u").format(now);

		try {
			// URL of food truck Socrata API
			String url = "https://data.sfgov.org/resource/jjew-r69b.json";

			// Calling AvailableTrucks service to get list of available trucks as of now
			JSONArray trucks = AvailableTrucks.getCurrentlyAvailableFoodTruckLists(url, day, time);

			// Calling Loggers service to print the list of trucks
			Loggers.printAvailableTrucks(trucks, 10);

		} catch (UnirestException e) {
			System.out.println(e);
		}

	}

}