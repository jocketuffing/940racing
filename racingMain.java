import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class racingMain {
	
	static Double elapsedTime = 0.0;
	static int elapsedSeconds = 0;
	static drawGraphics allGraphics = new drawGraphics();
	
	
	public static void main(String[] args) { 
		
		terrain thisTerrain = new terrain();
		thisTerrain.setXPositions(-500.0, 500.0, 1);
		
		ArrayList<body> allBodies = new ArrayList<body>();

		body testBody = new body();
		body testBody2 = new body();
		
		testBody.setStartValues(2.5, 10.0, 100.0);
		testBody2.setStartValues(20.0, 15.0, 100.0);
		
		
		allBodies.add(testBody);
		allBodies.add(testBody2);
		
		forceUpdater forceToUpdate = new forceUpdater(allBodies,thisTerrain);
		
		
		JFrame frame = new JFrame("940 Racing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		
		scaler testBodyScaling = new scaler(frame,allBodies,thisTerrain);
		frame.add(testBodyScaling);
		frame.setVisible(true);
		frame.add(thisTerrain);
		frame.setVisible(true);
		
		double divider = 1000000000.0;
		double startTime = (double) System.nanoTime() / divider;
		double timeDiff = 0.0;
		
		while(true) {
			
			timeDiff = (double) System.nanoTime() / divider - startTime;

			if (timeDiff > 0.01) {
				
				forceToUpdate.calculateForces();
				for (body bodyToUpdate : allBodies) {
					bodyToUpdate.updatePosition(timeDiff);
				}
	
				testBodyScaling.reDraw();
				startTime = System.nanoTime() / divider;

			}
		}
	}
}