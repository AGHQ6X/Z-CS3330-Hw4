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
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
			for (Vehicle vehicle : vehicles) {
				bw.write(vehicleToCSVString(vehicle));
				bw.newLine();
			}
			return true;
		} catch (IOException e) {
			System.out.println("Error writing to file: " + e.getMessage());
			return false;
		}
	}
	
	//Convert vehicle object to CSV stirng
	private String vehicleToCSVString(Vehicle vehicle) {
		return String.join(",", vehicle.getClass().getSimpleName(), vehicle.getBrand(), vehicle.getMake(),
				String.valueOf(vehicle.getModelYear()), String.valueOf(vehicle.getPrice()), vehicle.getColor().toString(),
				String.valueOf(vehicle.getMilage()), String.valueOf(vehicle.getMass()), String.valueOf(vehicle.getCylinders()),
				String.valueOf(vehicle.getGasTankCapacity()), vehicle.getFuelType().toString(), vehicle.getStartType().toString());
	}
	
	// List editor methods
	public boolean addVehicle(Vehicle vehicle)
	{
		return vehicles.add(vehicle);
	}
	
	public boolean removeVehicle(Vehicle vehicle)
	{
		return vehicles.remove(vehicle);
	}
	
	// Display information methods
	public void displayVehicleInformation(Vehicle v)
	{
		if (vehicles.contains(v)) {
			System.out.println(v);
		} else {
			System.out.println("Vehicle not found.");
		}
	}
	
	public void displayAllCarInformation()
	{
		System.out.println("Cars information: ");
		for (Vehicle vehicle : vehicles) {
			if (vehicle instanceof Car) {
				System.out.println(vehicle);
			}
		}
	}
	
	public void displayAllTruckInformation()
	{
		System.out.println("Trucks information: ");
		for (Vehicle vehicle : vehicles) {
			if (vehicle instanceof Truck) {
				System.out.println(vehicle);
			}
		}
	}
	public void displayAllSUVInformation()
	{
		System.out.println("SUVs information: ");
		for (Vehicle vehicle : vehicles) {
			if (vehicle instanceof SUV) {
				System.out.println(vehicle);
			}
		}
	}
	
	public void displayAllMotorBikeInformation()
	{
		System.out.println("MotorBikes information: ");
		for (Vehicle vehicle : vehicles) {
			if (vehicle instanceof MotorBike) {
				System.out.println(vehicle);
			}
		}
	}
	
	public void displayAllVehicleInformation()
	{
		System.out.println("All vehicles information: ");
		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle);
		}
	}
	
	// Check vehicle methods
	@SuppressWarnings("unused")
	private boolean isVehicleType(Vehicle v, @SuppressWarnings("rawtypes") Class clazz)
	{
		int count = 0;
        for (Vehicle vehicle : vehicles) {
            if (clazz.isInstance(vehicle)) {
                count++;
        }
    }
	public int getNumberOfVehichlesByType(@SuppressWarnings("rawtypes") Class clazz)
	{
		// TODO
		
		return 0;
	}
	
	public Vehicle getVehicleWithHighestMaintenanceCost(double distance)
	{
		if (vehicles.isEmpty()) {	
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
