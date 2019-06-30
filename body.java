import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class body {
	private double x,y,mass,Fx,Fy,Ax,Ay,Vx,Vy,E,deltaTime;
	private int xPos, yPos;
	
	public body() {
		Fx = 0.0;
		Fy = 0.0;
		mass = 100.0;
		E = - 9.807;
		deltaTime = 0.0;
		Vx = 0.0;
		Vy = 0.0;
	}
	
	public void setStartValues(double X, double Y,double M) {
		x = X;
		y = Y;
		mass = M;
	}
	
	public void updatePosition(double timeStamp) {
		
		deltaTime = timeStamp;
			
		Ax = Fx / mass;
		Vx = Vx + Ax * deltaTime;
		x = x + Vx * deltaTime;
		
		Ay = E + Fy / mass;
		Vy = Vy + Ay * deltaTime;
		y = y + Vy * deltaTime;
		

	}
	
	public double[] getXandY() {
		double[] toReturn = new double[] {x,y};
		return toReturn;
	}
	
	public void setForces(double newX,double newY) {
		Fx = newX;
		Fy = newY;
	}
	
	public double[] getFxandFy() {
		return new double[] {Fx,Fy};
	}
	
	public double[] getVxandVy() {
		return new double[] {Vx,Vy};
	}
	
	public void updateGraphics(int x,int y) {
		xPos = x;
		yPos = y;
	}
	
	public int getGraphicsX() {
		return xPos;
	}
	public int getGraphicsY() {
		return yPos;
	}
	
}





