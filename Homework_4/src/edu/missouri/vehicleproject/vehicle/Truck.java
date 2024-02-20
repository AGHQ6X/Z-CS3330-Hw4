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
		return distance * this.mass * (Vehicle.currentYear - this.modelYear) 
				* this.cylinders * 0.002;
	}

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice)
	{
		return this.cylinders * this.gasTankCapacity * fuelPrice / distance 
				* 0.1;
	}

	@Override
	public void startEngine()
	{
		System.out.println("Vehicle is a " + StartMechanism.KEYSTART);
	}
}
