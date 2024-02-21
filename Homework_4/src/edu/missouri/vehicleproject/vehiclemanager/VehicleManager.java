package edu.missouri.vehicleproject.vehiclemanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import edu.missouri.vehicleproject.vehicle.Car;
import edu.missouri.vehicleproject.vehicle.FuelType;
import edu.missouri.vehicleproject.vehicle.MotorBike;
import edu.missouri.vehicleproject.vehicle.SUV;
import edu.missouri.vehicleproject.vehicle.StartMechanism;
import edu.missouri.vehicleproject.vehicle.Truck;
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
						vehicles.add(new SUV(brand, make, modelYear, price, color, mileage, mass, cylinders, gasTankCapacity, fuelType, startType));
					}
					else if (values[0].equals("Truck"))
					{
						vehicles.add(new Truck(brand, make, modelYear, price, color, mileage, mass, cylinders, gasTankCapacity, fuelType, startType));
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
		// Create a writer object
		BufferedWriter writer;
		
		// File opening
		try
		{
			// Initialize writer
			writer = new BufferedWriter(new FileWriter(this.fileName, false));
			
			// Write opening line
			writer.write("Type,Model,Make,ModelYear,Price,Color,FuelType,Mileage,Mass,Cylinders,GasTankCapacity,StartType");
			writer.newLine();
			
			// Loop through vehicles
			for (Vehicle vehicle : this.vehicles)
			{
				// Write line to CSV
				writer.write(vehicle.toCSV());
				writer.newLine();
			}
			
			// Close writer 
			writer.close();
		}
		catch (IOException e)
		{
			// Print error
			System.out.println("File write error: " + e.toString());
				
			// File read failed
			return false;
		}
		
		// If it got here, the file read was successful
		return true;
	}
	
	// List editor methods
	public boolean addVehicle(Vehicle vehicle)
	{
		return this.vehicles.add(vehicle);
	}
	
	public boolean removeVehicle(Vehicle vehicle)
	{
		return this.vehicles.remove(vehicle);
	}
	
	// Display information methods
	public void displayVehicleInformation(Vehicle v)
	{
		// Print vehicle with an indent
		System.out.println("    " + v.toString());
	}
	
	public void displayAllCarInformation()
	{
		// Print heading
		System.out.println("Cars:");
				
		// Loop through all vehicles
		for (Vehicle vehicle : vehicles)
		{
			// Check if vehicle is a Car
			if (this.isVehicleType(vehicle, Car.class))
			{
				// If vehicle is a Car, print
				this.displayVehicleInformation(vehicle);
			}
		}
	}
	
	public void displayAllTruckInformation()
	{
		// Print heading
		System.out.println("Trucks:");
						
		// Loop through all vehicles
		for (Vehicle vehicle : vehicles)
		{
			// Check if vehicle is a Truck
			if (this.isVehicleType(vehicle, Truck.class))
			{
				// If vehicle is a Truck, print
				this.displayVehicleInformation(vehicle);
			}
		}
	}
	
	public void displayAllSUVInformation()
	{
		// Print heading
		System.out.println("SUVs:");

		// Loop through all vehicles
		for (Vehicle vehicle : vehicles)
		{
			// Check if vehicle is an SUV
			if (this.isVehicleType(vehicle, SUV.class))
			{
				// If vehicle is a SUV, print
				this.displayVehicleInformation(vehicle);
			}
		}
	}
	
	public void displayAllMotorBikeInformation()
	{
		// Print heading
		System.out.println("MotorBikes:");

		// Loop through all vehicles
		for (Vehicle vehicle : vehicles)
		{
			// Check if vehicle is a MotorBike
			if (this.isVehicleType(vehicle, MotorBike.class))
			{
				// If vehicle is a MotorBike, print
				this.displayVehicleInformation(vehicle);
			}
		}
	}
	
	public void displayAllVehicleInformation()
	{
		// Print heading
		System.out.println("Vehicles:");
		
		// Loop through all vehicles
		for (Vehicle vehicle : vehicles)
		{
			// Print vehicle
			this.displayVehicleInformation(vehicle);
		}
	}
	
	// Check vehicle methods
	private boolean isVehicleType(Vehicle v, @SuppressWarnings("rawtypes") Class clazz)
	{
		return v.getClass() == clazz;
	}
	
	public int getNumberOfVehichlesByType(@SuppressWarnings("rawtypes") Class clazz)
	{
		// Counter variable
		int count = 0;
		
		// Loop through vehicles
		for (Vehicle vehicle : this.vehicles)
		{
			// Check if the vehicle is of type clazz
			if (this.isVehicleType(vehicle, clazz))
			{
				// If the vehicle is of type clazz, increment counter
				count++;
			}
		}
		
		// Return the count
		return count;
	}
	
	public Vehicle getVehicleWithHighestMaintenanceCost(double distance)
	{
		// Check for empty vehicle list
		if (this.vehicles.isEmpty())
		{
			// If vehicles is empty, return null
			return null;
		}
		
		// Create an array to store the best vehicles and a double to store efficiency
		ArrayList<Vehicle> array = new ArrayList<Vehicle>();
		double best = Double.MIN_VALUE;

		// Loop through vehicles
		for (Vehicle vehicle : this.vehicles)
		{
			// Calculate the efficiency of vehicle
			double vMaint = vehicle.calculateMaintenaceCost(distance);

			// Check if the efficiency is better or equal
			if (vMaint > best)
			{
				// If the efficiency is better, replace elements with vehicle
				array.clear();
				array.add(vehicle);

				// Set the best variable to new target
				best = vMaint;
			}
			else if (vMaint == best)
			{
				// If the efficiency is a tie, just add it to the list
				array.add(vehicle);
			}
		}

		// Create a Random object
		Random rand = new Random();
		
		//Get random int within array index range
		int index = rand.nextInt(array.size());
		
		//Return the element at the random index
		return array.get(index);
	}
	
	public Vehicle getVehicleWithLowestMaintenanceCost(double distance)
	{
		// Check for empty vehicle list
		if (this.vehicles.isEmpty())
		{
			// If vehicles is empty, return null
			return null;
		}

		// Create an array to store the best vehicles and a double to store efficiency
		ArrayList<Vehicle> array = new ArrayList<Vehicle>();
		double best = Double.MAX_VALUE;

		// Loop through vehicles
		for (Vehicle vehicle : this.vehicles)
		{
			// Calculate the efficiency of vehicle
			double vMaint = vehicle.calculateMaintenaceCost(distance);

			// Check if the efficiency is better or equal
			if (vMaint < best)
			{
				// If the efficiency is better, replace elements with vehicle
				array.clear();
				array.add(vehicle);

				// Set the best variable to new target
				best = vMaint;
			}
			else if (vMaint == best)
			{
				// If the efficiency is a tie, just add it to the list
				array.add(vehicle);
			}
		}

		// Create a Random object
		Random rand = new Random();

		//Get random int within array index range
		int index = rand.nextInt(array.size());

		//Return the element at the random index
		return array.get(index);
	}
	
	public ArrayList<Vehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice)
	{
		// Create an array to store the best vehicles and a double to store efficiency
		ArrayList<Vehicle> array = new ArrayList<Vehicle>();
		double best = Double.MIN_VALUE;

		// Loop through vehicles
		for (Vehicle vehicle : this.vehicles)
		{
			// Calculate the efficiency of vehicle
			double vEff = vehicle.calculateFuelEfficiency(distance, fuelPrice);

			// Check if the efficiency is better or equal
			if (vEff > best)
			{
				// If the efficiency is better, replace elements with vehicle
				array.clear();
				array.add(vehicle);

				// Set the best variable to new target
				best = vEff;
			}
			else if (vEff == best)
			{
				// If the efficiency is a tie, just add it to the list
				array.add(vehicle);
			}
		}

		// Return the lowest
		return array;
	}
	
	public ArrayList<Vehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice)
	{
		// Create an array to store the best vehicles and a double to store efficiency
		ArrayList<Vehicle> array = new ArrayList<Vehicle>();
		double best = Double.MAX_VALUE;
		
		// Loop through vehicles
		for (Vehicle vehicle : this.vehicles)
		{
			// Calculate the efficiency of vehicle
			double vEff = vehicle.calculateFuelEfficiency(distance, fuelPrice);
			
			// Check if the efficiency is better or equal
			if (vEff < best)
			{
				// If the efficiency is better, replace elements with vehicle
				array.clear();
				array.add(vehicle);
				
				// Set the best variable to new target
				best = vEff;
			}
			else if (vEff == best)
			{
				// If the efficiency is a tie, just add it to the list
				array.add(vehicle);
			}
		}
		
		// Return the lowest
		return array;
	}
	
	public double getAverageFuelEfficiencyOfSUVs(double distance, double fuelPrice)
	{
		// TODO
		
		return 0.0;
	}
}
