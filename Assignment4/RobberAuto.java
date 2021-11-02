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
  
  public RobberAuto() {
    super("RobberCar", 20, new Engine("V5", 20, 200), "red-auto.jpg");
    
    Random random = new Random();
    this.xRatio = 0;
    this.yRatio = 0;
    while (this.xRatio == 0 && this.yRatio == 0) {
      this.xRatio = random.nextInt(11) - 5;
      this.yRatio = random.nextInt(11) - 5;
    } 
    fillUp();
  }



  
  public void update(Graphics g) {
    drive(40, this.xRatio, this.yRatio);
    super.update(g);
  }
}
