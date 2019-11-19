package fr.fireowls.spaceowls.system.corp;

import fr.fireowls.spaceowls.screen.scene.MainScreen;
import fr.fireowls.spaceowls.system.trajectory.SimulateTrajectory;
import fr.fireowls.spaceowls.utils.Location;

public class SimuleCorp extends Corp{

	public SimuleCorp(Location location) {
		super(CorpType.SIMULE, location);
		this.setTrajectory(new SimulateTrajectory(MainScreen.ss ,this));
	}
	
	 public String toString() {
		return this.type.getName()+"["+this.mass+","+this.location.toString()+"]";
	}
}
