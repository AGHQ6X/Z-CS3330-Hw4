package edu.missouri.vehicleproject.main;

import edu.missouri.vehicleproject.vehicle.Car;
import edu.missouri.vehicleproject.vehicle.MotorBike;
import edu.missouri.vehicleproject.vehicle.SUV;
import edu.missouri.vehicleproject.vehicle.Truck;
import edu.missouri.vehicleproject.vehiclemanager.VehicleManager;

public class Main
{
	public static void main(String[] args)
	{
		// Instantiate vehicleManager, perform operations based on the requirements.
		VehicleManager vehicleManager = new VehicleManager();
		
		// Read vehicle data from the vehcileList.csv file and initialize objects.
		vehicleManager.readFromFile("vehicleListCopy.csv");
		
		// Display all vehicle information.
		vehicleManager.displayAllVehicleInformation();
		
		// Display all car information.
		vehicleManager.displayAllCarInformation();
		
		// Display Car count
		System.out.println("There are " + vehicleManager.getNumberOfVehichlesByType(Car.class) + " Cars.");
		
		// Display all motorbike information.
		vehicleManager.displayAllMotorBikeInformation();
		
		// Display MotorBike count
		System.out.println("There are " + vehicleManager.getNumberOfVehichlesByType(MotorBike.class) + " MotorBikes.");
		
		// Display all SUV information.
		vehicleManager.displayAllSUVInformation();
		
		// Display SUV count
		System.out.println("There are " + vehicleManager.getNumberOfVehichlesByType(SUV.class) + " SUVs.");
		
		// Display all truck information.
		vehicleManager.displayAllTruckInformation();
		
		// Display Truck count
		System.out.println("There are " + vehicleManager.getNumberOfVehichlesByType(Truck.class) + " Trucks.");
		
		// Save list to check file write ability
		vehicleManager.saveVehicleList();
	}
}
