package edu.missouri.vehicleproject.vehicle;

public class Truck extends Vehicle
{
	// Constructor
	public Truck(String brand, String make, long modelYear, double price, 
			VehicleColor color, double mileage, double mass, int cylinders, 
			double gasTankCapacity, FuelType fuelType, StartMechanism startType)
	{
		super(brand, make, modelYear, price, color, mileage, mass, cylinders, 
				gasTankCapacity, fuelType, startType);
	}

	// Vehicle abstract methods
	@Override
	public double calculateMaintenaceCost(double distance)
	{
		// TODO 
		
		return 0;
	}

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice)
	{
		// TODO 
		
		return 0.0;
	}

	@Override
	public void startEngine()
	{
		// TODO
	}
}