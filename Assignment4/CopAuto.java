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
  
  public CopAuto() {
    super("CopCar", 30, new Engine("V3", 30, 100), "cop-auto.jpg");
    
    Random random = new Random();
    xRatio = 0;
    yRatio = 0;
    while (xRatio == 0 && yRatio == 0) {
      xRatio = random.nextInt(11) - 5;
      yRatio = random.nextInt(11) - 5;
    } 
    fillUp();
  }



  
  public void update(Graphics g) {
    drive(20, xRatio, yRatio);
    super.update(g);
  }
}
