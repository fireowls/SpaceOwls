package fr.fireowls.spaceowls.system.corp;

import fr.fireowls.spaceowls.utils.Location;


public class EllipseCorp extends Corp {

	private Corp c1;
	private Corp c2;
	private int periode;
	
	public EllipseCorp(Location location,Corp c1, Corp c2, int periode) {
		super(CorpType.ELLIPSE, location);
		this.c1 = c1;
		this.c2 = c2;
		this.periode = periode;		
	}

	@Override
	public String toString() {
		return this.type.getName()+"["+location.toString()+",c1="+c1.getName()+",c2="+c2.getName()+",periode="+periode+"]";
	}
}
