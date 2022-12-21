package com.basic.interfaces;

public class Vehicle {
	
	public static void main(String[] args) {
		
		Drivable d1=new Car();
		Drivable d2=new Bus();
		Drivable d3=new Bike();
		d1.driven();
		d2.driven();
		d3.driven();
	}
}

class Car implements Drivable{
	
	@Override
	public void driven() {
		System.out.println("Car can be driven.");

	}
}
class Bus implements Drivable{
	
	@Override
	public void driven() {
		System.out.println("Bus can be driven.");

	}
}
class Bike implements Drivable{
	
	@Override
	public void driven() {
		System.out.println("Bike can be driven.");

	}
}
