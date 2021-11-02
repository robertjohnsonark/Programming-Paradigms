//Name: Robert Johnson
//Assignment: Assignment 4
//Due Date: 10/11/2019

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

public class CopAuto
  extends Auto
{
  private static int xRatio;
  private static int yRatio;
  
  private boolean positiveX = true;
  private boolean positiveY = true;
  
  public CopAuto() {
    super("CopCar", 5000, new Engine("V3", 30, 100), "cop-auto.jpg");
    fillUp();
    Random random = new Random();
    xRatio = 0;
    yRatio = 0;
    while (xRatio == 0 && yRatio == 0) {
      xRatio = random.nextInt(11) - 5;
      yRatio = random.nextInt(11) - 5;
    } 
   
  }

  public void updateState(int height, int width) {
	  		// car is 60x60 pixels
			if(getX() > width - 60 || getX() < 0)
			{
				positiveX = !positiveX;
			}
			if(getY() > height - 60 || getY() < 0) 
			{
				positiveY = !positiveY;
			}
			

			if(positiveX)
			{
				if(positiveY) {
					drive(2, xRatio, yRatio);
				}
				else {
					drive(2, xRatio, -yRatio);
				}
			}
			else
			{
				if(positiveY) {
					drive(2, -xRatio, yRatio);
				}
				else {
					drive(2, -xRatio, -yRatio);
				}
			}
  }
public void updateImage(Graphics g) {
	super.updateImage(g);
  }
}
