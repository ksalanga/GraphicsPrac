import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GraphicsPracStar extends Applet implements KeyListener{
	private int x, y;
	private int[] xPts, yPts;
	
	public void init() {
		
		this.resize(1000, 1000);
		addKeyListener(this);
		x = 0;
		y = 0;
		xPts = new int [] {200, 250, 350, 275, 320, 200, 80, 125, 50, 150};
		yPts = new int[] {100, 250, 250, 350, 500, 400, 500, 350, 250, 250};
	}
	
	public void paint(Graphics g) {
		setBackground(Color.black);
		g.setColor(Color.BLUE);
		//g.drawRect(x, y, 10, 10);
		g.fillPolygon(xPts, yPts, 10);
		
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_UP:
			if(min(yPts) > 0) advance(-20, yPts);
			break;
		case KeyEvent.VK_DOWN:
			if(max(yPts) < getHeight() - 10) advance(20, yPts);
			break;
		case KeyEvent.VK_RIGHT:
			if(max(xPts) < getWidth() - 10) advance(20, xPts);
			break;
		case KeyEvent.VK_LEFT:
			if(min(yPts) > 0) advance(-20, xPts);
			break;
		}
		repaint();
		System.out.printf("(%d, %d)", (min(xPts) + max(xPts)) / 2, (min(yPts) + max(yPts)) / 2);
		System.out.println();
	} 
	
	private int min(int[] pts) {
		int min = pts[0];
		for(int i = 1; i < pts.length; i++) {
			if(pts[i] < min) min = pts[i];
		}
		return min;
	}
	
	private int max(int[] pts) {
		int max = pts[0];
		for(int i = 1; i < pts.length; i++) {
			if(pts[i] > max) max = pts[i];
		}
		return max;
	}
	
	private void advance(int pt, int[] pts) {
		for(int i = 0; i < pts.length; i++) {
			pts[i] += pt;
		}
	}
	
	
	
	public void keyTyped(KeyEvent e) {
	}
	
	public void keyReleased(KeyEvent e) {
	}

}