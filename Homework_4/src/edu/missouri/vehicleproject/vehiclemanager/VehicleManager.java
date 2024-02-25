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
		this.vehicles = new ArrayList<Vehicle>();n
		// Read from file
		readFromFile(this.fileName);
	}
	
	// File IO methods
	public boolean readFromFile(String fileName)
	{
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length != 12) {
					System.out.println("Invalid data format in CSV file: " + line);
					continue;
				}
				
				//Extract vehicle information
				String type = parts[0];
				String brand = parts[1];
				String make = parts[2];
				long modelYear = Long.parseLong(parts[3]);
				double price = Double.parseDouble(parts[4]);
				VehicleColor color = VehicleColor.valueOf(parts[5]);
				FuelType fuelType = FuelType.valueOf(parts[6]);
				double milage = Double.parseDouble(parts[7]);
				double mass = Double.parseDouble(parts[8]);
				int cylinders = Integer.parseInteger(parts[9]);
				double gasTankCapacity = Double.parseDouble(parts[10]);
				StartMechanism startType = StartMechanism.valueOf(parts[11]);
				
				//Create vehicle object
				switch(type) {
				case "Car":
					vehicles.add(new Car(brand, make, modelYear, price, color, milage, mass, cylinders, gasTankCapacity, fuelType, startType));
					break;
				case "Truck":
					vehicles.add(new Car(brand, make, modelYear, price, color, milage, mass, cylinders, gasTankCapacity, fuelType, startType));
					break;
				case "SUV":
					vehicles.add(new Car(brand, make, modelYear, price, color, milage, mass, cylinders, gasTankCapacity, fuelType, startType));
					break;
				case "MotorBike":
					vehicles.add(new Car(brand, make, modelYear, price, color, milage, mass, cylinders, gasTankCapacity, fuelType, startType));
					break;
				default:
					System.out.println("Unknown vehicle type: " + type);
					break;
				}
			}
			return true;
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return false;
		}
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
