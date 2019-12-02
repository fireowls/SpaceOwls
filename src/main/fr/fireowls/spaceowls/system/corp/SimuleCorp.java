package fr.fireowls.spaceowls.system.corp;

import fr.fireowls.spaceowls.screen.scene.MainScreen;
import fr.fireowls.spaceowls.system.trajectory.SimulateTrajectory;
import fr.fireowls.spaceowls.utils.Location;

public class SimuleCorp extends Corp{

	public SimuleCorp(Location location, double vitx,double vity) {
		super(CorpType.SIMULE, location);
		this.setTrajectory(new SimulateTrajectory(MainScreen.ss ,this,vitx,vity));
	}
	
	public SimuleCorp(Object[] ds) {
		this(new Location((double)ds[0],(double)ds[1]),(int)ds[2],(int)ds[3]);
	}
	
	 public String toString() {
		return this.type.getName()+"["+this.mass+","+this.location.toString()+"]";
	}
}
