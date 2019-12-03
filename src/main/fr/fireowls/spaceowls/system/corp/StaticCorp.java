package fr.fireowls.spaceowls.system.corp;

import fr.fireowls.spaceowls.system.trajectory.StaticTrajectory;
import fr.fireowls.spaceowls.utils.Location;

public class StaticCorp extends Corp {

    public StaticCorp(Location location) {
        super(CorpType.STATIC, location);
        this.setTrajectory(new StaticTrajectory());
    }
    
    public StaticCorp(Object[] ds) {
    	this(new Location((double)ds[0],(double)ds[1]));
    }
    
    public String toString() {
		return this.type.getName()+"["+this.mass+","+this.location.toString()+"]";
	}
}
