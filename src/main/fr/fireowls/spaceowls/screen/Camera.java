package fr.fireowls.spaceowls.screen;

import fr.fireowls.spaceowls.utils.Location;

public class Camera {

    private double scale;
    private Location location;

    public Camera() {
        scale = 1;
        location = new Location(0, 0);
    }

    public void zoom(double value) {
        scale += value;
    }

    public double getScale() {
        return scale;
    }

    public Location getLocation() {
        return location;
    }

}
