import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * GraphicsPrac5 Program uses Applet to create a Square that moves,
 * and it includes gravity and speed.
 * 
 * @author  KennethSalanga
 * @version 1.0
 * @since   08-22-2019
 */
public class GraphicsPrac5 extends Applet implements KeyListener
{
	private double x, y, xVelocity, yVelocity;
	final double speed = .3;
	final double gravity = .96;
	private boolean upAccel, downAccel, rightAccel, leftAccel;
	Thread thread;
	
	/**
	 * Initializes the Applet's size,
	 * adds a Keyboard listener, and 
	 * initializes variables to 0.
	 */
	public void init() 
	{
		upAccel = false;
		downAccel = false;
		rightAccel = false;
		leftAccel = false;
		xVelocity = 0;
		yVelocity = 0;
		x = 0;
		y = 0;
		this.resize(100, 100);
		addKeyListener(this);
		
		thread = new Thread();
		thread.start();
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
		g.drawRect((int) x, (int) y, 50, 50);
		
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
		switch (key) 
		{
		    case KeyEvent.VK_UP:
			    if (y == 0) 
			    {
				    y = getHeight();
			    } 
			    else 
			    {
				    y -= (speed - gravity);
			    }
			    break;
		    case KeyEvent.VK_DOWN:
		    	if (y > getHeight()) 
		    	{
		    		y = 0;
		    	} 
		    	else 
		    	{
		    		y += (speed - gravity);
		    	}
		    	break;
		    case KeyEvent.VK_RIGHT:
		    	if (x > getWidth())
		    	{
		    		x = 0;
		    	} 
		    	else 
		    	{
		    		x += (speed - gravity);
		    	}
		    	break;
		    case KeyEvent.VK_LEFT:
		    	if (x == 0) 
		    	{
		    		x = getWidth();
		    	} 
		    	else 
		    	{ 
		    		x -= (speed - gravity);
		    	}
		    	break;
		    default:
		    	x = 0;
		    	y = 0;
		}
		
		repaint();
		System.out.printf("(%d, %d)", x, y);
		System.out.println();
	} 

	public void keyTyped(KeyEvent e) {}
	
	public void keyReleased(KeyEvent e) {}
}