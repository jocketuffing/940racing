import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

public class terrain extends JPanel {
double x,y;
double X1,Y1,X2,Y2;
ArrayList<Double> xPositions;
ArrayList<Double> yPositions;
private drawGraphics allGraphics = new drawGraphics();

public terrain() {
	y = 0.0;
	x = 0.0;
	xPositions = new ArrayList<Double>();
}

public double getY(double Xin) {
	y = 0; 
	
	if(Xin > Math.PI) {
		 //y = 0.5 * Xin;
		 y = 2 * Math.sin(Xin / Math.PI) + 0.5 * Xin - Math.PI;
	}
	else if(Xin < - 2 * Math.PI) {
		 //y = 0.5 * Xin;
		 y = Math.cos(Xin / Math.PI) - Xin - 2 * Math.PI;
	}
	
	return y;
}

public void setXPositions(double start,double stop,double stamp) {
	double i = start;
	while(i < stop) {
		xPositions.add(i);
		i = i + stamp;
	}
}

public ArrayList<Double> getXpositions(){
	return xPositions;
}


public ArrayList<double []> getTerrain() {
		ArrayList<double []> positionsGraphics = new ArrayList<double []>();
		int i = 0;
		boolean firstSaved = false;
		while(i < xPositions.size() - 1) {
			X1 = xPositions.get(i);
			Y1 = getY(xPositions.get(i));
			X2 = xPositions.get(i + 1);
			Y2 = getY(xPositions.get(i + 1));
			positionsGraphics.add(new double[] { X1,Y1,X2,Y2});
			i += 1;
		}
		
		return positionsGraphics;
}

}
