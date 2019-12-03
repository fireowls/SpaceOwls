package fr.fireowls.spaceowls.system.corp;

import fr.fireowls.spaceowls.system.SpaceSystem;
import fr.fireowls.spaceowls.system.trajectory.SimulateTrajectory;
import fr.fireowls.spaceowls.utils.Location;

public class SimuleCorp extends Corp{

	public SimuleCorp(Location location, double vitX, double vitY, SpaceSystem ss) {
		super(CorpType.SIMULE, location);
		this.setTrajectory(new SimulateTrajectory(ss ,this, vitX, vitY));
	}
	
	 public String toString() {
		return this.type.getName()+"["+this.mass+","+this.location.toString()+"]";
	}
}
