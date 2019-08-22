import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/* 
<applet code="HelloWorld" width=200 height=60> 
</applet> 
*/

public class Painting extends Applet{ //this needs to be public because a network is accessing applet
	
	public void paint(Graphics g) { //paint just runs over and over again, constantly updates applet everytime screen is minimized or maximized
		g.setColor(Color.BLUE);
		g.drawOval(100, 50, 300, 400);
		g.fillOval(175, 150, 30, 30);
		g.fillOval(295, 150, 30, 30);
		g.setColor(Color.green);
		g.fillRect(230, 220, 40, 40);
		g.setColor(Color.red);
		g.fillArc(150, 300, 200, 70, 180, 180);
	}
	
}