package fr.fireowls.spaceowls.hud;

import fr.fireowls.spaceowls.system.corp.Corp;
import fr.fireowls.spaceowls.utils.Location;

public class Camera {

    private double scale;
    private Location location;
    private Corp corp;

    public Camera() {
        scale = 1;
        location = new Location(0, 0);
        corp = null;
    }

    public void update() {
        if (corp != null)
            this.location.move(corp.getLocation());
    }

    public void setFocus(Corp corp) {
        this.corp = corp;
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

    public Corp getFocusCorp() {
        return corp;
    }
}
