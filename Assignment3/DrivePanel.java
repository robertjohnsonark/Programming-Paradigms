//Name: Robert Johnson
//Assignment: Assignment 3
//Due Date: 9/30/2019

import java.awt.Graphics;
import javax.swing.JPanel;

public class DrivePanel extends JPanel {
	private int[][] coordinates = new int[10][2];
	private int legCount = 0;

	public DrivePanel(int[][] points, int legs) {
		this.coordinates = points;
		this.legCount = legs;

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int height = getHeight();
		for (int x = 0; x < this.legCount; x++) {
			g.drawLine(coordinates[x][0], (height - coordinates[x][1]), coordinates[x + 1][0],
					(height - coordinates[x + 1][1]));
			g.drawString(
					String.format("(%d,%d)",
							new Object[] { Integer.valueOf(coordinates[x + 1][0]),
									Integer.valueOf(coordinates[x + 1][1]) }),
					coordinates[x + 1][0] + 10, height - coordinates[x + 1][1]);
		}

	}
}
