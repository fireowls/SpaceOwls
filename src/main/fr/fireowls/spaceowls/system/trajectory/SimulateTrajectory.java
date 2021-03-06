package fr.fireowls.spaceowls.system.trajectory;


import fr.fireowls.spaceowls.system.SpaceSystem;
import fr.fireowls.spaceowls.system.corp.Corp;
import fr.fireowls.spaceowls.system.corp.SimuleCorp;
import fr.fireowls.spaceowls.utils.Location;

/**
 * Class qui décrit les méthodes utiles pour une trajectoire simulée
 * @author defossea
 *
 */
public class SimulateTrajectory extends Trajectory {

	/**
	 * l'objet qui parcours la trajectoire simulée
	 */
	private SpaceSystem ss;
	private SimuleCorp corp;
	public double vitX = 1;
	public double vitY = 1;
	
	/**
	 * constructeur
	 * @param corp l'objet qui parcours la trajectoire simulée
	 */
	public SimulateTrajectory(SpaceSystem ss, SimuleCorp corp, double vitX, double vitY) {
		super(TrajectoryType.SIMULATE);
		this.ss = ss;
		this.corp = corp;
		this.vitX = vitX;
		this.vitY = vitY;
	}
	
	@Override
	public void update(double delta) {
		//timer = engine.getTimer() - startTrajectory;
		for(Corp c : ss.getCorps()) {
			if(!c.equals(corp)) {
				applicateStrength(c);
			}
		}
		corp.getLocation().move(
				corp.getLocation().getX() + (delta * vitX),
				corp.getLocation().getY() + (delta * vitY)
		);
		if(previousLocation.size() < 2000) {
			previousLocation.add(new Location(location.getX()+20, location.getY()+20));
		}else {
			previousLocation.remove(0);
			previousLocation.add(new Location(location.getX()+20, location.getY()+20));
		}
	}
	
	/**
	 * appliquer une force qui déplace l'objet en fonction d'un autre objet
	 * @param autre l'autre objet
	 */
	public void applicateStrength(Corp autre) {
		double distance = Math.sqrt(Math.pow((corp.getLocation().getX() - autre.getLocation().getX()), 2) + Math.pow((corp.getLocation().getY() - autre.getLocation().getY()), 2));
		double f = SpaceSystem.g * (corp.getMass()) * autre.getMass() / (Math.pow(distance, 2));
		double a = (f / corp.getMass()) * SpaceSystem.dt;
		
		double dirX = (autre.getLocation().getX() - corp.getLocation().getX()) / distance;
		double dirY = (autre.getLocation().getY() - corp.getLocation().getY()) / distance;
		
		vitX = ((float) (vitX + dirX * a));
		vitY = ((float) (vitY + dirY * a));
	}
}
.
