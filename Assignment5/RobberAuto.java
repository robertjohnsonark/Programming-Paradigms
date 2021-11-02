//Name: Robert Johnson
//Assignment: Assignment 4
//Due Date: 10/11/2019

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

public class RobberAuto
  extends Auto
{
  private int xRatio;
  private int yRatio;
  private boolean isCaptured = false;
  static int numCaptured = 0;
  private boolean isEscaped = false;
  static int numEscaped = 0;
  
  public RobberAuto() {
    super("RobberCar", 5000, new Engine("V5", 20, 200), "red-auto.jpg");
    fillUp();
    Random random = new Random();
    this.xRatio = 0;
    this.yRatio = 0;
    while (this.xRatio == 0 && this.yRatio == 0) {
      this.xRatio = random.nextInt(11) - 5;
      this.yRatio = random.nextInt(11) - 5;
    } 
    
  }

  public void updateState(int height, int width) {
	  if (!isCaptured)
		{
		
			drive(4,xRatio ,yRatio);
		}
	  
		if (((super.getX() > width || super.getY() > height) || (super.getX() <= -1 || super.getY() <=-1)) && (!isEscaped))
		{	
			numEscaped++;
			isEscaped = true;
		}
		}
  
  public void updateImage(Graphics g) {
	  super.updateImage(g);
  }
  public void captured()
	{
		isCaptured = true;
		numCaptured++;
		setImage("jail.jpg");
	}
	
	public boolean isCaptured()
	{
		return isCaptured;
	}
	
	public boolean hasEscaped()
	{
		return isEscaped;
	}
  
	
}
