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
		long currentYear = java.time.Year.now().getValue();	
		return distance * this.mass * (currentYear - this.modelYear) * this.cylinders * 0.002;
	}

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice)
	{
		if (distance == 0) {
			return 0;		
		}
		return (this.cylinders * this.gasTankCapacity * this.fuelPrice) / (distance * 0.1);
	}

	@Override
	public void startEngine()
	{
		System.out.println("Engine starts with KEYSTART.")
	}
}
