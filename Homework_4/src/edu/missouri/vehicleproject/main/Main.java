package edu.missouri.vehicleproject.main;

import java.util.ArrayList;

import edu.missouri.vehicleproject.vehicle.Car;
import edu.missouri.vehicleproject.vehicle.MotorBike;
import edu.missouri.vehicleproject.vehicle.SUV;
import edu.missouri.vehicleproject.vehicle.Truck;
import edu.missouri.vehicleproject.vehicle.Vehicle;
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
		
		// Check for highest fuel efficiency
		Vehicle highV = vehicleManager.getVehicleWithHighestMaintenanceCost(1.0);
		System.out.println("Vehicle with highest maintenance cost: ");
		vehicleManager.displayVehicleInformation(highV);
		
		// Check for highest fuel efficiency
		Vehicle lowV = vehicleManager.getVehicleWithLowestMaintenanceCost(1.0);
		System.out.println("Vehicle with lowest maintenance cost: ");
		vehicleManager.displayVehicleInformation(lowV);
		
		// Check for highest fuel efficiency
		ArrayList<Vehicle> highArr = vehicleManager.getVehicleWithHighestFuelEfficiency(1.0, 2.99);
		System.out.println("Vehicles with highest fuel efficiency:");
		highArr.forEach(v -> vehicleManager.displayVehicleInformation(v));
		
		// Check for lowest fuel efficiency
		ArrayList<Vehicle> lowArr = vehicleManager.getVehicleWithLowestFuelEfficiency(1.0, 2.99);
		System.out.println("Vehicles with lowest fuel efficiency:");
		lowArr.forEach(v -> vehicleManager.displayVehicleInformation(v));
		
		// Check the average fuel efficiency of SUVs
		double avgSUV = vehicleManager.getAverageFuelEfficiencyOfSUVs(1.0, 2.99);
		System.out.println("The average SUV fuel efficiency is: " + avgSUV);
		
		// Save list to check file write ability
		vehicleManager.saveVehicleList();
	}
}
