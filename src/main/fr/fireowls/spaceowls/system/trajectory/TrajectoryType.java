package fr.fireowls.spaceowls.system.trajectory;

/**
 * Types de trajectoire possible
 * @author defossea
 *
 */
public enum TrajectoryType {

	STATIC(StaticTrajectory.class),
	SIMULATE(SimulateTrajectory.class),
	ELLIPSE(ElipseTrajectory.class),
	CIRCLE(CercleTrajectory.class),
	SHIP(ShipTrajectory.class);

	/**
	 * class de la trajectoire
	 */
	private Class<? extends Trajectory> c;

	/**
	 * constructeur
	 * @param c class de la trajectoire
	 */
	private TrajectoryType(Class<? extends Trajectory> c) {
		this.c = c;
	}

	/**
	 * récupérer la class de la trajectoire
	 * @return la class de la trajectoire
	 */
	public Class<? extends Trajectory> getTrajectoryClass() {
		return c;
	}
}
