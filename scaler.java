import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class scaler extends JPanel {
	JFrame referenceWindow;
	ArrayList<body> bodiesToScale;
	terrain currentTerrain;
	private int xSize, ySize , xPos, yPos;
	
	private int xLengthInMeters,yLengthInMeters;
	
	private int xScaling,yScaling;
	
	private int width,height;
	
	private drawGraphics allGraphics = new drawGraphics();
	
	
	

	public scaler(JFrame ref,ArrayList<body> allBodies, terrain thisTerrain) {
		referenceWindow = ref;
		bodiesToScale = allBodies;
		currentTerrain = thisTerrain;
		
		xSize = referenceWindow.getWidth();
		ySize = referenceWindow.getHeight();
		
		xLengthInMeters = 50;
		yLengthInMeters = 50;
		
		xScaling =  xSize / xLengthInMeters;
		yScaling = ySize / yLengthInMeters;
		
		width = 10;
		height = 10;
		
	}
	
	public void reDraw() {

		for (body bodyToScale : bodiesToScale) {
			int xtemp = (int) (xSize / 2 + bodyToScale.getXandY()[0] * xScaling);
			int ytemp = (int) (ySize / 2 - bodyToScale.getXandY()[1] * yScaling);
			bodyToScale.updateGraphics(xtemp, ytemp);
		}
		
		repaint();
	}
	
	int X1,Y1,X2,Y2;
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (body bodyToScale : bodiesToScale) {
			
			allGraphics.reDrawWindow(g, "Rectangle",bodyToScale.getGraphicsX(),bodyToScale.getGraphicsY(), width, height);
		}
		for (double [] positions : currentTerrain.getTerrain()) {
			X1 = (int) (xSize / 2 + positions[0] * xScaling);
			Y1 = (int) (ySize / 2 - positions[1] * yScaling);
			X2 = (int) (xSize / 2 + positions[2] * xScaling);
			Y2 = (int) (ySize / 2 - positions[3] * yScaling);
			g.drawLine(X1,Y1,X2,Y2);
		}
		
	}	
}
