package fr.fireowls.spaceowls.system.trajectory;

import fr.fireowls.spaceowls.SpaceOwls;
import fr.fireowls.spaceowls.engine.Engine;
import fr.fireowls.spaceowls.screen.OwlPainter;
import fr.fireowls.spaceowls.system.corp.Corp;
import fr.fireowls.spaceowls.utils.Location;
import fr.fireowls.spaceowls.utils.Updatable;
import fr.fireowls.spaceowls.utils.Vector;
import javafx.scene.canvas.Canvas;

/**
 * Class mère de toutes les trajectoires
 * @author defossea
 *
 */
public class Trajectory implements Updatable {

	/**
	 * type de trajectoire
	 */
	protected TrajectoryType type;
	
	/**
	 * position du corp
	 */
	protected Location location;

	/**
	 * calcul de la trajectoire de x
	 */
	protected TrajectoryCalculator xCalculator;
	
	/**
	 * calcul de la trajectoire de y
	 */
	protected TrajectoryCalculator yCalculator;

	/**
	 * direction de la trajectoire
	 */
	protected Vector direction;

	/**
	 * lapse de temps depuis le précedent appel
	 */
	protected double timer;
	
	/**
	 * moment de la creation de la trajectoire
	 */
	protected double startTrajectory;

	/**
	 * gestion des thread
	 */
	//protected Engine engine;

	/**
	 * constructeur
	 * @param type type de la trajectoire
	 */
	public Trajectory(TrajectoryType type) {
		this.type = type;
		location = null;
		direction = null;

		xCalculator = null;
		yCalculator = null;
		timer = 0;
		startTrajectory = 0;

		//engine = SpaceOwls.engine;
	}

	@Override
	public void create() {
		location = location != null ? location : new Location(0, 0);
		direction = direction != null ? direction : new Vector(0, 0);

		xCalculator = xCalculator != null ? xCalculator : dt -> 0;
		yCalculator = yCalculator != null ? yCalculator : dt -> 0;
		//startTrajectory = engine.getTimer();
	}

	@Override
	public void update(double dt) {
		
		//timer = engine.getTimer() - startTrajectory;
		System.out.println(location + " " + xCalculator.handle(timer) + " " + yCalculator.handle(timer));
		location.move(
				xCalculator.handle(dt),
				yCalculator.handle(dt)
		);
	}

	@Override
	public void render(Canvas canvas) {}

	@Override
	public void dispose() {}

	public void bindCorp(Corp corp) {
		Location corpLocation = corp.getLocation();
		location = corpLocation;
		location.link(corpLocation);
	}

	/**
	 * récupérer la direction de la trajectoire
	 * @return le direction de la trajectoire
	 */
	public Vector getDirection() {
		return direction;
	}

	/**
	 * récupérer la position du corp
	 * @return la position du corp
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * récupérer le type de la trajectoire
	 * @return le type de la trajectoire
	 */
	public TrajectoryType getType() {
		return type;
	}

	/**
	 * récupérer le timer
	 * @return le timer
	 */
	public double getTimer() {
		return timer;
	}

}
