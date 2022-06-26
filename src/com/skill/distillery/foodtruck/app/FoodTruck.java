package com.skill.distillery.foodtruck.app;

public class FoodTruck {

	private String name;
	private String type;
	private int rating;
	private int truckId;
	private static int nextTruckId = 42;

	public FoodTruck() {
	}

	public FoodTruck(String name, String type, int rating) {
		this.name = name;
		this.type = type;
		this.rating = rating;
		this.truckId = nextTruckId;
		nextTruckId++;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getTruckId() {
		return truckId;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Food Truck Name: ").append(name).append(" Type of food served: ").append(type).append(" Rating: ")
				.append(rating).append(" Truck ID: ").append(truckId).append(".");

		return builder.toString();
	}
//	public String toString2() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("The food truck with the highest rating is:\n").append("Food Truck Name: ").append(name).append(" Type of food served: ").append(type).append(" Rating: ")
//		.append(rating).append(" Truck ID: ").append(truckId).append(".");
//		
//		return builder.toString();
//	}
	


}
