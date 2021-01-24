package com.availablefoodtrucks.services;

import org.json.JSONArray;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/***
 * 
 * This class is meant for getting a sorted JSONArray of food trucks that are
 * open at mentioned time and day
 * 
 * @param url    The url of food truck Socrata API
 * @param day    number corresponding to day of the week
 * @param time24 time in 24 hr format (11:20)
 * @return JSONArray list of available food trucks
 * @throws UnirestException
 * 
 * @author Harsh
 *
 */

public class AvailableTrucks {

	public static JSONArray getCurrentlyAvailableFoodTruckLists(String url, String day, String time24)
			throws UnirestException {

		// Filter list based on time24 and dayorder and sort based on applicant
		HttpResponse<JsonNode> asJson = Unirest.get(url).queryString("$select", "applicant, location")
				.queryString("$where",
						String.format("start24<='%1$s' AND end24>'%1$s' AND dayorder='%2$s'", time24, day))
				.queryString("$order", "applicant ASC").asJson();

		return asJson.getBody().getArray();

	}

}