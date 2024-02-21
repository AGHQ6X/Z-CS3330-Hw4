package edu.missouri.vehicleproject.vehiclemanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import edu.missouri.vehicleproject.vehicle.Car;
import edu.missouri.vehicleproject.vehicle.FuelType;
import edu.missouri.vehicleproject.vehicle.MotorBike;
import edu.missouri.vehicleproject.vehicle.StartMechanism;
import edu.missouri.vehicleproject.vehicle.Vehicle;
import edu.missouri.vehicleproject.vehicle.VehicleColor;

public class VehicleManager
{
	// Fields
	private String fileName;
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
		this.fileName = "vehicleList.csv";
		this.vehicles = new ArrayList<Vehicle>();
		
		// Read from file
		readFromFile(this.fileName);
	}
	
	// File IO methods
	public boolean readFromFile(String fileName)
	{
		// Create a reader object
		BufferedReader reader;
		
		// File opening
		try
		{
			reader = new BufferedReader(new FileReader(fileName));
			
			//Check if empty
			if (reader.readLine() == null)
			{
				//Print error
				System.out.println("File empty.");
				
				//Close the reader
				reader.close();
				
				//File was empty
				return false;
			}
			
			//Read first CSV line
			String line = reader.readLine();
			
			// Loop through lines
			while (line != null)
			{
				//Separate values by commas
				String[] values = line.split(",", 12);
				
				if (values.length == 12)
				{
					// Parse values
					String brand = values[1];
					String make = values[2];
					long modelYear = Long.parseLong(values[3]);
					double price = Double.parseDouble(values[4]);
					VehicleColor color = VehicleColor.valueOf(values[5]);
					FuelType fuelType = FuelType.valueOf(values[6]);
					double mileage = Double.parseDouble(values[7]);
					double mass = Double.parseDouble(values[8]);
					int cylinders = Integer.parseInt(values[9]);
					double gasTankCapacity = Double.parseDouble(values[10]);
					StartMechanism startType = StartMechanism.valueOf(values[11]);
					
					// Check which vehicle we have
					if (values[0].equals("Car"))
					{
						vehicles.add(new Car(brand, make, modelYear, price, color, mileage, mass, cylinders, gasTankCapacity, fuelType, startType));
					}
					else if (values[0].equals("MotorBike"))
					{
						vehicles.add(new MotorBike(brand, make, modelYear, price, color, mileage, mass, cylinders, gasTankCapacity, fuelType, startType));
					}
					else if (values[0].equals("SUV"))
					{
						vehicles.add(new MotorBike(brand, make, modelYear, price, color, mileage, mass, cylinders, gasTankCapacity, fuelType, startType));
					}
					else if (values[0].equals("MotorBike"))
					{
						vehicles.add(new MotorBike(brand, make, modelYear, price, color, mileage, mass, cylinders, gasTankCapacity, fuelType, startType));
					}
				}
				
				// Read next CSV line
				line = reader.readLine();
			}
			
			// Close reader
			reader.close();
		}
		catch (IOException e)
		{
			// Print error
			System.out.println("File read error: " + e.toString());
			
			// File read failed
			return false;
		}
		
		// If it got here, the file read was successful
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
		// Print heading
		System.out.println("Vehicles:");
		
		// Loop through all vehicles
		for (Vehicle vehicle : vehicles)
		{
			// Print vehicle with a small indent
			System.out.println(" " + vehicle.toString());
		}
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
