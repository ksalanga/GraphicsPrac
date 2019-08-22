import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GraphicsPrac3 extends Applet implements KeyListener{
	private int x, y;
	
	
	public void init() {
		
		this.resize(100, 100);
		addKeyListener(this);
		x = 0;
		y = 0;
	}
	
	public void paint(Graphics g) {
		setBackground(Color.black);
		g.setColor(Color.BLUE);
		g.drawRect(x, y, 50, 50);
		
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_UP:
			if(y > 0) y -= 10;
			break;
		case KeyEvent.VK_DOWN:
			if(y < getHeight() - 10) y += 10;
			break;
		case KeyEvent.VK_RIGHT:
			if(x < getWidth() - 10) x += 10;
			break;
		case KeyEvent.VK_LEFT:
			if(x > 0) x -= 10;
			break;
		}
		repaint();
		System.out.printf("(%d, %d)", x, y);
	} 

	public void keyTyped(KeyEvent e) {
	}
	
	public void keyReleased(KeyEvent e) {
	}

}