package fr.fireowls.spaceowls.system.corp;

import fr.fireowls.spaceowls.system.trajectory.ElipseTrajectory;
import fr.fireowls.spaceowls.utils.Location;

public class EllipseCorp extends Corp{
    public EllipseCorp(Location location, double radiusX, double radiusY) {
        super(CorpType.ELLIPSE, location);
        this.setTrajectory(new ElipseTrajectory(location, radiusX, radiusY));
    }

    @Override
    public String toString() {
        return "EllipseCorp{" +
                "type=" + type +
                ", hitBox=" + hitBox +
                ", trajectory=" + trajectory +
                ", location=" + location +
                ", mass=" + mass +
                '}';
    }
}
