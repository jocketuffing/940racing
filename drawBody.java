
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class drawBody extends JPanel {
	
	private int x,y,width,height;	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
		g.setColor(Color.BLACK);
		
		g.fillRect(x, y, width, height);
		
		
	}
	
	public void setDimensions(double X, double Y, int W, int H){
		x = (int) X;
		y = (int) Y;
		width = W;
		height = H;
		repaint();
	}
	
	
}