import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * GraphicsPrac4 Program uses Applet to create a Square that moves
 * 
 * @author  KennethSalanga
 * @version 1.0
 * @since   08-22-2019
 */
public class GraphicsPrac4 extends Applet implements KeyListener
{
	private int x, y;
	final int speed = 100;
	
	/**
	 * Initializes the Applet's size,
	 * adds a Keyboard listener, and 
	 * initializes variables to 0.
	 */
	public void init() 
	{
		this.resize(100, 100);
		addKeyListener(this);
		x = 0;
		y = 0;
	}
	
	/**
	 * Paints the Applet by adding background
	 * color and shape.
	 * @param g Takes in graphics of panel
	 */
	public void paint(Graphics g) 
	{
		setBackground(Color.black);
		g.setColor(Color.BLUE);
		g.drawRect(x, y, 50, 50);
		
	}
	
	/**
	 * Takes keyboard presses and outputs
	 * movement based on arrow keys.
	 * Also repaints the canvas once 
	 * keys are pressed.
	 * @param e any key stroke pressed.
	 */
	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode(); //gets the KeyEvent value which is a constant.
		switch(key) 
		{
		    case KeyEvent.VK_UP:
			    if (y == 0) 
			    {
				    y = getHeight();
			    } 
			    else 
			    {
				    y -= speed;
			    }
			    break;
		    case KeyEvent.VK_DOWN:
		    	if (y > getHeight()) 
		    	{
		    		y = 0;
		    	} 
		    	else 
		    	{
		    		y += speed;
		    	}
		    	break;
		    case KeyEvent.VK_RIGHT:
		    	if (x > getWidth())
		    	{
		    		x = 0;
		    	} 
		    	else 
		    	{
		    		x += speed;
		    	}
		    	break;
		    case KeyEvent.VK_LEFT:
		    	if (x == 0) 
		    	{
		    		x = getWidth();
		    	} 
		    	else 
		    	{ 
		    		x -= speed;
		    	}
		    	break;
		}
		repaint();
		System.out.printf("(%d, %d)", x, y);
		System.out.println();
	} 

	public void keyTyped(KeyEvent e) {}
	
	public void keyReleased(KeyEvent e) {}

}