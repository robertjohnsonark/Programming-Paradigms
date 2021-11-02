//Name: Robert Johnson
//Assignment: Assignment 2
//Due Date: 9/16/2019

public class Engine {
	private String engineDescription;
	private int mpg;
	private int maxSpeed;

	public Engine() {
		this.mpg = 0;
		this.maxSpeed = 0;
		this.engineDescription = "";
	}

	public Engine(String engineDescription, int mpg, int maxSpeed) {
		if (mpg < 0) {
			this.mpg = 0;
		} else {
			this.mpg = mpg;
		}
		if (maxSpeed < 0) {
			this.maxSpeed = 0;
		} else {
			this.maxSpeed = maxSpeed;
		}
		if (engineDescription.length() == 0) {
			this.engineDescription = "Generic engine";
		} else {
			this.engineDescription = engineDescription;
		}
	}

	public String getDescription() {
		return engineDescription + "(MPG: " + mpg + ", Max speed: " + maxSpeed + ")";
	}

	public int getMPG() {
		return mpg;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}
}
