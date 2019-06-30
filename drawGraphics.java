import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class drawGraphics extends JPanel {

	public void reDrawWindow(Graphics g, String shape, int X1, int Y1, int X2, int Y2) {
		this.setBackground(Color.WHITE);
		g.setColor(Color.BLACK);
		if (shape.equals("Rectangle")) {
			g.fillRect(X1,Y1, X2, Y2);
		}
	
		
	}
}
