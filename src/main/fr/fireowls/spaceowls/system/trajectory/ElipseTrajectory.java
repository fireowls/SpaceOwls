package fr.fireowls.spaceowls.system.trajectory;

import fr.fireowls.spaceowls.utils.Location;

/**
 * Class qui décrit les méthodes utiles pour une trajectoire éliptique
 * @author defossea
 *
 */
public class ElipseTrajectory extends Trajectory {

	/**
	 * centre de l'élipse
	 */
    protected Location center;
    
    /**
     * le demi petit axe
     */
    protected double r;
    private double perimeter;
    private double vitX;
    private double periode;

    /**
     * constructeur
     * @param center centre de l'élipse
     * @param r le rayon
     */
    public ElipseTrajectory(Location center, double r, double periode) {
        super(TrajectoryType.ELLIPSE);

        this.center = center;
        this.location = center;
        this.r = r;
        this.periode = periode;
    }

    @Override
    public void update(double dt) {
        perimeter = 2 * Math.PI * r;
        vitX =  2 * r / (periode/2);
        location.move(location.getX()+vitX * dt, location.getY());

        if(previousLocation.size() < 2000) {
            previousLocation.add(new Location(location.getX(), location.getY()));
        } else {
            previousLocation.remove(0);
            previousLocation.add(new Location(location.getX(), location.getY()));
        }
    }

    /**
     * changer le centre de l'élipse
     * @param center le nouveau centre
     */
    public void setCenter(Location center) {
        this.center = center;
    }

    /**
     * récupérer le centre de l'élipse
     * @return
     */
    public Location getCenter() {
        return center;
    }
}
