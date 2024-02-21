package edu.missouri.vehicleproject.vehicle;

public abstract class Vehicle
{
	//Constant
	protected static final long currentYear = 2024;
	
	// Protected fields
	protected String brand;
	protected String make;
	protected long modelYear;
	protected double price;
	protected VehicleColor color;
	protected double mileage;
	protected double mass;
	protected int cylinders;
	protected double gasTankCapacity;
	protected FuelType fuelType;
	protected StartMechanism startType;
	
	// Constructors
	public Vehicle(String brand, String make, long modelYear, double price, 
			VehicleColor color, double mileage, double mass, int cylinders,
			double gasTankCapacity, FuelType fuelType, StartMechanism startType)
	{
		this.brand = brand;
		this.make = make;
		this.modelYear = modelYear;
		this.price = price;
		this.color = color;
		this.mileage = mileage;
		this.mass = mass;
		this.cylinders = cylinders;
		this.gasTankCapacity = gasTankCapacity;
		this.fuelType = fuelType;
		this.startType = startType;
	}
	
	public Vehicle(Vehicle v)
	{
		this.brand = v.brand;
		this.make = v.make;
		this.modelYear = v.modelYear;
		this.price = v.price;
		this.color = v.color;
		this.mileage = v.mileage;
		this.mass = v.mass;
		this.cylinders = v.cylinders;
		this.gasTankCapacity = v.gasTankCapacity;
		this.fuelType = v.fuelType;
		this.startType = v.startType;
	}
	
	// Abstract methods
	public abstract double calculateMaintenaceCost(double distance);
	public abstract double calculateFuelEfficiency(double distance, double fuelPrice); 
	public abstract void startEngine(); 
	
	// String conversions
	@Override
	public String toString()
	{
		return "$" + this.price + " " + this.modelYear + " " + this.brand 
				+ " " + this.make + " (" + this.color + "), " + this.mileage 
				+ " Miles driven, " + this.mass + " Tons, " + this.cylinders
				+ " cylinder " + this.fuelType + " engine with " 
				+ this.gasTankCapacity + " Gallon tank and " + this.startType;
	}
	
	public String toCSV()
	{
		return this.getClass().getSimpleName() + "," + this.brand + "," + 
				this.make + "," + this.modelYear + "," + this.price + "," 
				+ this.color + "," + this.fuelType + "," + this.mileage 
				+ "," + this.mass + "," + this.cylinders + "," 
				+ this.gasTankCapacity + "," + this.startType;
	}

	//Getters and setters 
	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public String getMake()
	{
		return make;
	}

	public void setMake(String make)
	{
		this.make = make;
	}

	public long getModelYear()
	{
		return modelYear;
	}

	public void setModelYear(long modelYear)
	{
		this.modelYear = modelYear;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public VehicleColor getColor()
	{
		return color;
	}

	public void setColor(VehicleColor color)
	{
		this.color = color;
	}

	public double getMileage()
	{
		return mileage;
	}

	public void setMileage(double mileage)
	{
		this.mileage = mileage;
	}

	public double getMass()
	{
		return mass;
	}

	public void setMass(double mass)
	{
		this.mass = mass;
	}

	public int getCylinders()
	{
		return cylinders;
	}

	public void setCylinders(int cylinders)
	{
		this.cylinders = cylinders;
	}

	public double getGasTankCapacity()
	{
		return gasTankCapacity;
	}

	public void setGasTankCapacity(double gasTankCapacity)
	{
		this.gasTankCapacity = gasTankCapacity;
	}

	public FuelType getFuelType()
	{
		return fuelType;
	}

	public void setFuelType(FuelType fuelType)
	{
		this.fuelType = fuelType;
	}

	public StartMechanism getStartType()
	{
		return startType;
	}

	public void setStartType(StartMechanism startType)
	{
		this.startType = startType;
	}
}
