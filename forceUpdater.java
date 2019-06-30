import java.util.ArrayList;

public class forceUpdater {
	ArrayList<body> bodiesToUpdate;
	terrain terrainToCompare;
	double k = 1000000;
public forceUpdater(ArrayList<body> allBodies,terrain terreinToCheck) {
	bodiesToUpdate = allBodies;
	terrainToCompare = terreinToCheck;
}

public void calculateForces() {
	for (body bodyToUpdate : bodiesToUpdate) {
		if (bodyToUpdate.getXandY()[1] < terrainToCompare.getY(bodyToUpdate.getXandY()[0])) {
			getTerrainForces(bodyToUpdate);
			//bodyToUpdate.setForces(-100.0, 10000.0);
			
		}
		else {
			bodyToUpdate.setForces(0.0, 0.0);
		}	

	}
}

public void getTerrainForces(body bodyWithImpact) {
	double window = 1.0;
	double Xterrain = 0.0;
	double Yterrain = 0.0;
	double opp = 0.0;
	double adj = 0.0;
	double hyp = 0.0;
	double F = 0.0;
	

	F = k * (terrainToCompare.getY(bodyWithImpact.getXandY()[0]) - bodyWithImpact.getXandY()[1]);
	opp = Math.abs(terrainToCompare.getY(bodyWithImpact.getXandY()[0] - window)) - Math.abs(terrainToCompare.getY(bodyWithImpact.getXandY()[0] + window));
	adj = 2 * window;
	hyp = Math.sqrt(Math.pow(opp, 2) + Math.pow(adj, 2));
	
	double cosAlfa;
	double sinAlfa;
	cosAlfa = adj / hyp;
	sinAlfa = opp / hyp;
	
	//bodyWithImpact.setForces(- 0.1 * F * sinAlfa, F * cosAlfa);
	bodyWithImpact.setForces( F * sinAlfa, F * cosAlfa);
	
	/*
	if (bodyWithImpact.getVxandVy()[0] < 0.0) {
		bodyWithImpact.setForces(F * sinAlfa, F * cosAlfa);
	}
	else {
		bodyWithImpact.setForces(- F * sinAlfa, F * cosAlfa);
	}
	*/
	
}

}
