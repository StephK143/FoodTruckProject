package com.skill.distillery.foodtruck.app;

import java.util.*;

public class FoodTruckApp {
	Scanner kb = new Scanner(System.in);
	FoodTruck[] fleetOfFoodTrucks = new FoodTruck[5];

	int i = 0;
	int choice = 1;
	boolean keepGoing = true;

	public static void main(String[] args) {

		FoodTruckApp app = new FoodTruckApp();

		app.runApp();
	}

	public void runApp() {
		System.out.println("***Welcome to Food Truck Heaven!***\n");

		userEntries();

		while (keepGoing) {
			printMenu();
			userChoice(choice);
		}

		kb.close();
	}

	public FoodTruck[] userEntries() {
		boolean endOrNot = true;
		int rating = 0;
		for (i = 0; i < fleetOfFoodTrucks.length; i++) {

			System.out.println("what is the name of the food truck?\nor type quit to go on\n");
			String quit = kb.nextLine();

			if (quit.equalsIgnoreCase("quit")) {
				break;
			} else {
				FoodTruck makeTruck;
				String name = quit;
				System.out.println("what is the type of food?");
				String type = kb.nextLine();

				do {
					System.out.println("On a scale of 1-5 how would you rate this food truck?");

					rating = kb.nextInt();
					kb.nextLine();
					if (rating >= 1 && rating <= 5) {
						endOrNot = false;
					} else {
						System.out.println("Not a valid entry");
					}
				} while (endOrNot);

				makeTruck = new FoodTruck(name, type, rating);

				fleetOfFoodTrucks[i] = makeTruck;
			}
		}
		return fleetOfFoodTrucks;
	}

	public int printMenu() {

		System.out.println("========================================");
		System.out.println("========================================");
		System.out.println("|              Main Menu               |");
		System.out.println("| 1. List all existing food trucks     |");
		System.out.println("| 2. See average rating of food trucks |");
		System.out.println("| 3. Display highest-rated food truck  |");
		System.out.println("| 4. Quit                              |");
		System.out.println("======================================= ");
		System.out.println("========================================");

		return choice;
	}

	public boolean userChoice(int choice) {

		do {

			choice = kb.nextInt();
			kb.nextLine();

			switch (choice) {

			case 1:
				listTrucks();
				keepGoing = true;
				break;

			case 2:
				avgRating();
				keepGoing = true;
				break;
			case 3:
				highestRatedTruck();
				keepGoing = true;
				break;
			case 4:
				keepGoing = false;
				System.out.println("You have choosen to exit. Thank you and have a great day!");
				break;
			default:
				System.out.println("Entry not valid.");
			}
		} while (choice <= 4 && choice > 0);

		return keepGoing;
	}

	public void listTrucks() {
		System.out.println("Here is a list of food trucks in your area:");

		for (i = 0; i < fleetOfFoodTrucks.length; i++) {
			if (fleetOfFoodTrucks[i] != (null)) {
				System.out.println(fleetOfFoodTrucks[i].toString());
			}
		}
	}

	public void avgRating() {
		int totalRating = 0;
		int count = 0;

		for (i = 0; i < fleetOfFoodTrucks.length; i++) {
			FoodTruck calcAvg = fleetOfFoodTrucks[i];
			if (fleetOfFoodTrucks[i] != (null)) {
				totalRating += calcAvg.getRating();
				count++;
			}
		}
		double avg = totalRating / count;
		System.out.println("The average rating for all the food trucks is: " + avg);

	}

	public void highestRatedTruck() {
		int highestRating = 0;
		String highestRate = "none";
		int count = 0;

		for (i = 0; i <= fleetOfFoodTrucks.length; i++) {

			if (fleetOfFoodTrucks[i] == null) {
				break;
			}

			if (highestRating < fleetOfFoodTrucks[i].getRating()) {

				highestRating = fleetOfFoodTrucks[i].getRating();
				highestRate = fleetOfFoodTrucks[i].getName();
				count = i;
			}

		}
		System.out.println("The food truck in your area with the highest rating is:");
		System.out.println(fleetOfFoodTrucks[count].toString());
	}
}
