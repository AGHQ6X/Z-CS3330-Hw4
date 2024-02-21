package edu.missouri.vehicleproject.main;

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
		
		// Display all motorbike information.
		vehicleManager.displayAllMotorBikeInformation();
		
		// Display all SUV information.
		vehicleManager.displayAllSUVInformation();
		
		// Display all truck information.
		vehicleManager.displayAllTruckInformation();
		
		// Save list to check file write ability
		vehicleManager.saveVehicleList();
	}
}
