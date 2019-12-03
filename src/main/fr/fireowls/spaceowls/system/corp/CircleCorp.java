package fr.fireowls.spaceowls.system.corp;

import fr.fireowls.spaceowls.utils.Location;

public class CircleCorp extends Corp {

    private Corp center;
    private int periode;

    public CircleCorp(Location location,Corp center,int periode) {
        super(CorpType.CERCLE, location);
        this.center = center;
        this.periode = periode;
    }

    @Override
    public String toString() {
        return this.type.getName()+"["+location.toString()+",centre="+center.getName()+",periode="+periode+"]";
    }
}
