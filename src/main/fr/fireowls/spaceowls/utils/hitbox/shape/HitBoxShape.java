package fr.fireowls.spaceowls.utils.hitbox.shape;

import fr.fireowls.spaceowls.utils.Location;

import java.util.Observable;
import java.util.Observer;

public abstract class HitBoxShape implements Observer {

    protected Location location;

    protected double width;
    protected double height;

    public HitBoxShape() {
        location = new Location(0, 0);
    }

    public abstract boolean conflict(HitBoxShape other);

    private void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public void update(Observable o, Object arg) {
        setLocation((Location) arg);
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
