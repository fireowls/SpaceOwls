package fr.fireowls.spaceowls.system.corp;

import fr.fireowls.spaceowls.screen.scene.MainScreen;
import fr.fireowls.spaceowls.system.SpaceSystem;
import fr.fireowls.spaceowls.system.trajectory.SimulateTrajectory;
import fr.fireowls.spaceowls.utils.Location;

public class SimuleCorp extends Corp{

	public SimuleCorp(Location location, SpaceSystem ss) {
		super(CorpType.SIMULE, location);
		this.setTrajectory(new SimulateTrajectory(ss ,this));
	}
	
	 public String toString() {
		return this.type.getName()+"["+this.mass+","+this.location.toString()+"]";
	}
}
