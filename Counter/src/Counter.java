import java.applet.Applet; //Applet Class
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; //KeyListener Interface

public class Counter extends Applet implements KeyListener 
{
	private int counter = 0;
	
	public void init()
	{
		this.resize(100,100);
		addKeyListener(this);
	}
	
	public void paint(Graphics g)
	{
		setBackground(Color.pink);
		String output = Integer.toString(counter);
		g.setColor(Color.YELLOW);
		g.drawString(output, 50, 50);
		
		if (counter % 10 == 0 && counter != 0) 
		{
			g.setColor(Color.RED);
			g.drawString("YOU FINISHED!!!!!!", 70, 50);
		}
	}
	
	public void keyPressed(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			counter++;
		}
		
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
}