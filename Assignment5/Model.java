//Name: Robert Johnson
//Assignment: Assignment 4
//Due Date: 10/11/2019

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


class Model
{
	private ArrayList<Sprite> sprites = new ArrayList();
	int type = 0;

    Model() throws IOException {
    	synchronized(sprites)
    	{
    	Bank bigBank = new Bank();
    	this.sprites.add(bigBank);
    	}
    }

    public void update(Graphics g) {
    	synchronized(sprites)
    	{
    	for (Sprite s : this.sprites) {
    	      s.updateImage(g);
    	    }
    	}
    }
    public void addSprite(int xValue, int yValue) {
    	synchronized(sprites)
    	{
        Sprite spriteType;
        if (this.type == 0) {
          spriteType = new RobberAuto();
          spriteType.setX(300);
          spriteType.setY(300);
          this.sprites.add(spriteType);
        } else {
          spriteType = new CopAuto();
          spriteType.setX(xValue);
          spriteType.setY(yValue);
          this.sprites.add(spriteType);
        } 
        this.type = (this.type + 1) % 2;
    	}
      }
    public void updateScene(int height, int width)   {
    	synchronized(sprites)
    	{
			Iterator<Sprite> iter = sprites.iterator();
			while(iter.hasNext())
			{
				Sprite s = iter.next();
				s.updateState(height, width);
	    		
	    		
		    		for ( Sprite sprite : sprites )
		    		{
		    			
		    			if( (s instanceof CopAuto) && (sprite instanceof RobberAuto) 
		    					&& s.overlaps(sprite) )
		    			{
		    				
		    				if( !((RobberAuto)sprite).isCaptured() )
		    				{
		    					((RobberAuto)sprite).captured();
		    				}
		    			}
		    		}
	    		
				
	    		
				if( s instanceof RobberAuto )
				{
					if( ((RobberAuto)s).hasEscaped() )
					{
						System.out.println("I'm free!");
						iter.remove();
					}
				}
			}
    	}
    }
    public void initialize()
    {
    	synchronized(sprites)
    	{
    	sprites.clear();
    	sprites.add(new Bank());
    	RobberAuto.numCaptured = 0;
    	RobberAuto.numEscaped = 0;
    	}
    }
}
