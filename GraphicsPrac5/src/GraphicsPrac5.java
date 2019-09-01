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
		g.setColor(Color.red);
		g.fillOval((int) x, (int) y, 50, 50);
		g.setColor(Color.white);
		g.drawOval((int) x, (int) y, 50, 50);
		
	}
	
	/**
	 * Runs the thread of execution for
	 * the Applet to use acceleration velocity and
	 * distance. Also moved repaint method 
	 * (which updates) here.
	 */
	public void run()
	{
		if (!upAccel || !downAccel || !rightAccel || !leftAccel)
		{
			
		}
		
		if (x < 0)
		{
			x = getWidth(); //applet function
		}
		if (y < 0)
		{
			y = getHeight(); //applet function
		}
		if (x > getWidth())
		{
			x = 0;
		}
		if (y > getHeight())
		{
			y = 0;
		}
		
		x += xVelocity;
		y += yVelocity;
		
		repaint();
		
		try
		{
			Thread.sleep(5); //pauses the execution for 5 ms to let things rest. refreshes the thread sort of
		}
		catch(InterruptedException e)
		{
			
		}
	}
	
	/**
	 * Takes keyboard presses and outputs
	 * movement based on arrow keys.
	 * This time, the keys will accelerate
	 * the block.
	 * @param e any key stroke pressed.
	 */
	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode(); //gets the KeyEvent value which is a constant.
		switch (key) 
		{
		    case KeyEvent.VK_UP:
			    upAccel = true;
			    break;
		    case KeyEvent.VK_DOWN:
		    	downAccel = true;
		    	break;
		    case KeyEvent.VK_RIGHT:
		    	rightAccel = true;
		    	break;
		    case KeyEvent.VK_LEFT:
		    	leftAccel = true;
		    	break;
		}
		
	} 
	
	/**
	 * Takes keyboard releases and outputs
	 * movement based on arrow keys.
	 * @param e any key stroke released.
	 */
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode(); //gets the KeyEvent value which is a constant.
		switch (key) 
		{
		    case KeyEvent.VK_UP:
			    upAccel = false;
			    break;
		    case KeyEvent.VK_DOWN:
		    	downAccel = false;
		    	break;
		    case KeyEvent.VK_RIGHT:
		    	rightAccel = false;
		    	break;
		    case KeyEvent.VK_LEFT:
		    	leftAccel = false;
		    	break;
		}	
	}
	
	public void keyTyped(KeyEvent e) {}
}