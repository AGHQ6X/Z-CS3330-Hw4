package edu.missouri.vehicleproject.main;

import edu.missouri.vehicleproject.vehiclemanager.VehicleManager;

public class Main
{
	public static void main(String[] args)
	{
		// Instantiate vehicleManager, perform operations based on the requirements.
		@SuppressWarnings("unused")
		VehicleManager vehicleManager = new VehicleManager();
		
		// Read vehicle data from the vehcileList.csv file and initialize objects.
		
		// Display all vehicle information.
        System.out.println("Displaying all vehicle information: ");
        vehicleManager.displayAllVehicleInformation();
		
		
		// Display all car information.
        System.out.println("Displaying all car information:");
        vehicleManager.displayAllCarInformation();
		
		// Display all motorbike information.
        System.out.println("Displaying all motorbike information:");
        vehicleManager.displayAllMotorBikeInformation();
	}
}
