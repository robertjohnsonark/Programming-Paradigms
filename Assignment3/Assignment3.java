//Name: Robert Johnson
//Assignment: Assignment 3
//Due Date: 9/30/2019

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Assignment3 {
	public static void main(String[] args) {
		try {
		String autoDescription;
		int fuelTankCapacity = 0;
		String engineDescription;
		int mpg = 0;
		int maxSpeed = 0;

		autoDescription = JOptionPane.showInputDialog("Enter the description of the Auto");

		
			do {
				fuelTankCapacity = Integer.parseInt(JOptionPane.showInputDialog("Enter the fuel tank capacity"));
			} while (fuelTankCapacity <= 0);
		

		engineDescription = JOptionPane.showInputDialog("Enter the description of the Engine");

		
			do {
				mpg = Integer.parseInt(JOptionPane.showInputDialog("Enter the miles per gallon"));
			} while (mpg <= 0);
		

		
			do {
				maxSpeed = Integer.parseInt(JOptionPane.showInputDialog("Enter the max speed"));
			} while (maxSpeed <= 0);
		

		Engine engine1 = new Engine(engineDescription, mpg, maxSpeed);
		Auto auto1 = new Auto(autoDescription, fuelTankCapacity, engine1);
		JOptionPane.showMessageDialog(null, auto1.getDescription());

		int legs = 0;

			do {
				legs = Integer.parseInt(JOptionPane.showInputDialog("Enter how many legs in the trip"));
			} while (legs <= 0);
		

		int distance = 0;
		double xRatio = 0.0;
		double yRatio = 0.0;
		int[][] coordinates = new int[10][2];
		coordinates[0][0] = 0;
		coordinates[0][1] = 0;

		for (int x = 1; x <= legs; x++) {

			
				do {
					distance = Integer
							.parseInt(JOptionPane.showInputDialog("Enter distance of the leg (leg #" + x + ")"));
				} while (distance <= 0);
			
			
				xRatio = Double.parseDouble(JOptionPane.showInputDialog("Enter xRatio of the leg (leg #" + x + ")"));
			

			
				yRatio = Double.parseDouble(JOptionPane.showInputDialog("Enter yRatio of the leg (leg #" + x + ")"));
			
			if (x == 1) {
				auto1.fillUp();
			}
			auto1.drive(distance, xRatio, yRatio);
			coordinates[x][0] = auto1.getX();
			coordinates[x][1] = auto1.getY();
			// Test inputs in example: TestAuto, 50, V8, 50, 100, 3, 200, 2, 3, 300, -1, 4, 500, 2, -0.5
		 

		}
		DrivePanel drivePanel = new DrivePanel(coordinates, legs);

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(3);
		frame.add(drivePanel);
		frame.setSize(600, 600);
		frame.setVisible(true);
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting.");
			System.exit(0);
		}
	}
}
