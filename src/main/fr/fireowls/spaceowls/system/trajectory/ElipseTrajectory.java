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
    protected double radiusX;
    
    /**
     * le demi grand axe
     */
    protected double radiusY;

    /**
     * constructeur
     * @param center centre de l'élipse
     * @param radiusX le demi petit axe
     * @param radiusY le demi grand axe
     */
    public ElipseTrajectory(Location center, double radiusX, double radiusY) {
        super(TrajectoryType.ELLIPSE);

        this.center = center;
        this.location = center;
        this.radiusX = radiusX;
        this.radiusY = radiusY;

        xCalculator = dt -> location.getX() + radiusX * Math.cos(dt);
        yCalculator = dt -> location.getY() + radiusY * Math.sin(dt);

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
