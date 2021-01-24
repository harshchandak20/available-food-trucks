## Table of contents
* [Project Details](#available-food-trucks)
* [Requirements](#Requirements)
* [Setup](#Setup)
* [Implementation](#Implementation)

# available-food-trucks
A commant line program to fetch all the available food trucks at a current time using San Francisco government’s public data source 'https://data.sfgov.org/resource/jjew-r69b.json'

# Requirements
* Java 8
* Maven

# Setup
Import and cd into the repository
##### To trigger jar packing
```
$ mvn clean install 
```
##### To run the jar created
```
$ java -jar target/available-food-trucks-0.0.1-SNAPSHOT.jar
```

# Implementation
The application uses the end point 'https://data.sfgov.org/resource/jjew-r69b.json' to get the list of food trucks.

There are 2 services 
* Get the list of AvailableTrucks
* Parse the list and print the truck details

The end point provides an option to filter and sort.
Below is the sample request to find available trucks where start24<= && end24> the current timestamp and the day is [0-6] (0: Sunday, 1: Monday and so on) which is sorted based on applicant.
https://data.sfgov.org/resource/jjew-r69b.json?%24select=applicant%2C+location&%24where=start24%3C%3D%2723%3A35%27+AND+end24%3E%2723%3A35%27+AND+dayorder%3D%274%27&%24order=applicant+ASC

The response is parsed as JSON over loop wherein user response is required after every listing of 10 trucks.
