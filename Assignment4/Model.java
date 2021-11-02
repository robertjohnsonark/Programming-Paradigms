//Name: Robert Johnson
//Assignment: Assignment 4
//Due Date: 10/11/2019

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;


class Model
{
	private ArrayList<Sprite> sprites = new ArrayList();
	int type = 0;

    Model() {
    	CopAuto copAuto = new CopAuto();
    	this.sprites.add(copAuto);
    }

    public void update(Graphics g) {
    	for (Sprite s : this.sprites) {
    	      s.update(g);
    	    }
    }
    public void addSprite(int xValue, int yValue) {
        Sprite spriteType;
        if (this.type == 0) {
          spriteType = new RobberAuto();
        } else {
          spriteType = new CopAuto();
        } 
        this.type = (this.type + 1) % 2;
        spriteType.setX(xValue);
        spriteType.setY(yValue);
        this.sprites.add(spriteType);
      }
    public void fillUps()  {
        for (Sprite s : this.sprites)
          ((Auto)s).fillUp(); 
      }
}
