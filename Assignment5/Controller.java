//Name: Robert Johnson
//Assignment: Assignment 4
//Due Date: 10/11/2019

import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.SwingUtilities;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Controller implements MouseListener,KeyListener
{
    Model model;
    View view;

    Controller() throws IOException, Exception {
        model = new Model();
        view = new View(this);
       
    }

    public void update(Graphics g) {
        model.update(g);
    }
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    
    public void keyTyped (KeyEvent e)
    { 
    	if (e.getKeyChar() == 'h')
    	{
    		System.out.println("hello world");
    	}
    	if (e.getKeyChar() == 'n')
    	{
    		System.out.println("Robbers captured : " + RobberAuto.numCaptured + " Robbers escaped : " + RobberAuto.numEscaped);
    	}
    	if (e.getKeyChar() == 'r')
    	{
    		model.initialize();
    		view.repaint();
    	}
    	
    	if (e.getKeyChar() == 's')
    	{
    		Thread t = new Thread (new SpriteMover (model, view));
    		t.start();
    	}
    	
    }

    public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			this.model.addSprite(e.getX(), e.getY());
			view.repaint();
		} else if (SwingUtilities.isRightMouseButton(e))  {
			 this.model.updateScene(view.getHeight(), view.getWidth());
			 view.repaint();
		}
    }

    public void mouseReleased(MouseEvent e) {    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }

    public static void main(String[] args) throws Exception {
        //  Use the following line to determine which directory your program
        //  is being executed from, since that is where the image files will
        //  need to be.
        //System.out.println("cwd=" + System.getProperty("user.dir"));
        new Controller();
    }
}

