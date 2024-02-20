package edu.missouri.vehicleproject.vehiclemanager;

import java.util.ArrayList;

import edu.missouri.vehicleproject.vehicle.Vehicle;

public class VehicleManager
{
	// Fields
	private final String fileName;
	@SuppressWarnings("unused")
	private ArrayList<Vehicle> vehicles;
	
	// Constructors
	public VehicleManager()
	{
		// Initialize variables
		this.fileName = "vehicleList.csv";
		this.vehicles = new ArrayList<Vehicle>();
		
		// Read from file
		readFromFile(this.fileName);
	}
	
	public VehicleManager(String fileName)
	{
		// Initialize variables
		this.fileName = fileName;
		this.vehicles = new ArrayList<Vehicle>();
		
		// Read from file
		readFromFile(this.fileName);
	}
	
	// File IO methods
	public boolean readFromFile(String fileName)
	{
		// TODO
		
		return true;
	}
	
	public boolean saveVehicleList()
	{
		// TODO
		
		return true;
	}
	
	// List editor methods
	public boolean addVehicle(Vehicle vehicle)
	{
		// TODO
		
		return true;
	}
	
	public boolean removeVehicle(Vehicle vehicle)
	{
		// TODO
		
		return true;
	}
	
	// Display information methods
	public void displayVehicleInformation(Vehicle v)
	{
		// TODO
	}
	
	public void displayAllCarInformation()
	{
		// TODO
	}
	
	public void displayAllTruckInformation()
	{
		// TODO
	}
	
	public void displayAllSUVInformation()
	{
		// TODO
	}
	
	public void displayAllMotorBikeInformation()
	{
		// TODO
	}
	
	public void displayAllVehicleInformation()
	{
		// TODO
	}
	
	// Check vehicle methods
	@SuppressWarnings("unused")
	private boolean isVehicleType(Vehicle v, @SuppressWarnings("rawtypes") Class clazz)
	{
		// TODO
		
		return true;
	}
	
	public int getNumberOfVehichlesByType(@SuppressWarnings("rawtypes") Class clazz)
	{
		// TODO
		
		return 0;
	}
	
	public Vehicle getVehicleWithHighestMaintenanceCost(double distance)
	{
		// TODO
		
		return null;
	}
	
	public Vehicle getVehicleWithLowestMaintenanceCost(double distance)
	{
		// TODO
		
		return null;
	}
	
	public ArrayList<Vehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice)
	{
		// TODO
		
		return null;
	}
	
	public ArrayList<Vehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice)
	{
		// TODO
		
		return null;
	}
	
	public double getAverageFuelEfficiencyOfSUVs(double distance, double fuelPrice)
	{
		// TODO
		
		return 0.0;
	}
}
