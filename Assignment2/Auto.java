//Name: Robert Johnson
//Assignment: Assignment 2
//Due Date: 9/16/2019

import java.lang.Math;

public class Auto {
	private String description;
	private int xValue = 0;
	private int yValue = 0;
	private GasTank gasTank;
	private Engine engine;
	
	public Auto(String description, int capacity, Engine engine1) {
		if(description.length() == 0) {
			this.description = "Generic auto";
		} else {
			this.description = description;
		}
		if(engine1 == null) {
			this.engine = new Engine();
		} else {
			this.engine = engine1;
		}
		gasTank = new GasTank(capacity);
	}
	
	public String getDescription() {
		return description + " (engine: " + engine.getDescription() + "), fuel: " 
				+ String.format("%.2f", gasTank.getLevel()) + "/" + gasTank.getCapacity() + ", location: (" 
				+ xValue + "," + yValue + ")";
	}
	
	public int getX() {
		return xValue;
	}
	
	public int getY() {
		return yValue;
	}
	
	public double getFuelLevel() {
		return gasTank.getLevel();
	}
	
	public int getMPG() {
		return engine.getMPG();
	}
	
	public void fillUp() {
		gasTank.setLevel(gasTank.getCapacity());
	}
	
	public int getMaxSpeed() {
		return engine.getMaxSpeed();
	}
	
	public double drive(int distance, double xRatio, double yRatio) {
		double fuelUsed = (double) distance / engine.getMPG();
		if(fuelUsed > gasTank.getLevel()) {
			fuelUsed =  gasTank.getLevel();
			distance = (int) (engine.getMPG() * fuelUsed);
			System.out.println("Ran out of gas after driving " + String.format("%.2f", (double) distance) + " miles.");
		}
		gasTank.setLevel(gasTank.getLevel() - fuelUsed);
		
		// calculating slope (rise/run)
		double m = Math.abs(yRatio / xRatio);
		
		// slope is 0 
		if (m == 0) { 
			if(xRatio < 0) {
				 xValue = xValue - distance; 
			} else {
				 xValue = xValue + distance; 
			}
	       
	    } 
	  
	    else { 
	        double dx = (distance / Math.sqrt(1 + (m * m))); 
	        double dy = m * dx;
	        if (xRatio < 0) {
	        	xValue = (int) (xValue - dx); 
	        } else {
	        	xValue = (int) (xValue + dx); 
	        }
	        if (yRatio < 0) {
	        	yValue = (int) (yValue - dy); 
	        } else {
	        	yValue = (int) (yValue + dy); 
	        }
	    } 
		return distance;
	}

}
