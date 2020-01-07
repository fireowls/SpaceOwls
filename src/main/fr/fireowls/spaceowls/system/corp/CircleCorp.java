package fr.fireowls.spaceowls.system.corp;

import fr.fireowls.spaceowls.system.trajectory.ElipseTrajectory;
import fr.fireowls.spaceowls.utils.Location;


public class CircleCorp extends Corp {

	private Corp c1;
	private int periode;
	
	public CircleCorp(Location location, Corp c1, int periode) {
		super(CorpType.CERCLE, location);
		this.c1 = c1;
		this.periode = periode;
		setTrajectory(new ElipseTrajectory(c1.location, Math.sqrt(Math.pow(c1.location.getX()-location.getX(),2) +
														Math.pow(c1.location.getY()-location.getY(),2)), periode));
	}

	@Override
	public String toString() {
		return this.type.getName()+"["+location.toString()+",c1="+c1.getName()+", periode="+periode+"]";
	}
}
