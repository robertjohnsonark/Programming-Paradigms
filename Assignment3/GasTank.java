//Name: Robert Johnson
//Assignment: Assignment 3
//Due Date: 9/30/2019

public class GasTank {
	private int maxCapacity;
	private double currentLevel;

	public GasTank() {
		this.maxCapacity = 0;
	}

	public GasTank(int capacity) {
		if (capacity >= 0) {
			this.maxCapacity = capacity;
		} else {
			this.maxCapacity = 0;
		}
		this.currentLevel = 0.0;
	}

	public int getCapacity() {
		return maxCapacity;
	}

	public double getLevel() {
		return currentLevel;
	}

	public void setLevel(double levelIn) {
		if (levelIn < 0) {
			this.currentLevel = 0;
		} else if (levelIn > maxCapacity) {
			this.currentLevel = maxCapacity;
		} else {
			this.currentLevel = levelIn;
		}
	}
}