package fr.fireowls.spaceowls.system.trajectory;

/**
 * Class qui décrit les méthodes utiles pour une trajectoire static
 * @author defossea
 *
 */
public class StaticTrajectory extends Trajectory {
	
	/**
	 * constructeur
	 */
    public StaticTrajectory() {
        super(TrajectoryType.STATIC);
    }

    @Override
    public void update(double dt) {}
}
