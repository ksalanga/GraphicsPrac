import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;

public class GraphicsPrac2 extends Applet {
	public void init() {
		this.resize(500, 500);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.yellow);
		int[] xPoints = {200, 250, 350, 275, 320, 200, 80, 125, 50, 150};
		int[] yPoints = {100, 250, 250, 350, 500, 400, 500, 350, 250, 250};
		g.fillPolygon(xPoints, yPoints, 10);
		g.setColor(Color.black);
		int[] xPts = {180, 210, 150, 220, 250, 280, 350, 290, 320, 250};
		int[] yPts = {300, 200, 160, 160, 70, 160, 160, 200, 300, 250};
		g.fillPolygon(xPts, yPts, 10);
		showStatus("Hey"); //just puts a message in the bottom corner of the applet
	}
}