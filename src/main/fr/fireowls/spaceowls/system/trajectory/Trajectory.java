package fr.fireowls.spaceowls.system.trajectory;

import java.util.ArrayList;
import java.util.List;

import fr.fireowls.spaceowls.SpaceOwls;
import fr.fireowls.spaceowls.engine.Engine;
import fr.fireowls.spaceowls.screen.OwlPainter;
import fr.fireowls.spaceowls.system.corp.Corp;
import fr.fireowls.spaceowls.utils.Location;
import fr.fireowls.spaceowls.utils.Updatable;
import fr.fireowls.spaceowls.utils.Vector;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

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
	
	protected List<Location> previousLocation;
	
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
		
		previousLocation = new ArrayList<>();

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
		location.move(
				xCalculator.handle(dt),
				yCalculator.handle(dt)
		);
		if(previousLocation.size() < 2000) {
			previousLocation.add(new Location(location.getX()+20, location.getY()+20));
		} else {
			previousLocation.remove(0);
			previousLocation.add(new Location(location.getX()+20, location.getY()+20));
		}
		
	}

	@Override
	public void render(Canvas canvas) {
		canvas.getGraphicsContext2D().setFill(Color.WHITE);
		canvas.getGraphicsContext2D().setGlobalAlpha((float)(0.2));
		for(int i = 0; i < previousLocation.size(); i++) {
			Location l = previousLocation.get(i);
			canvas.getGraphicsContext2D().fillRect(l.getX()+200, l.getY()+200, 1, 1);
		}
		canvas.getGraphicsContext2D().setGlobalAlpha(1);
	}

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
