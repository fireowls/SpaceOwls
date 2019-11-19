package fr.fireowls.spaceowls.system.trajectory;

import fr.fireowls.spaceowls.system.SpaceSystem;
import fr.fireowls.spaceowls.system.corp.Corp;
import fr.fireowls.spaceowls.system.corp.ShipCorp;
import fr.fireowls.spaceowls.system.corp.SimuleCorp;
import fr.fireowls.spaceowls.utils.Location;

public class ShipTrajectory extends Trajectory{

	private ShipCorp corp;
	
	public ShipTrajectory(ShipCorp c) {
		super(TrajectoryType.SHIP);
		this.corp = c;
	}
	
	public void applicateStrength(SimuleCorp autre) {
		double distance = Math.sqrt(Math.pow((corp.getLocation().getX() - autre.getLocation().getX()), 2) + Math.pow((corp.getLocation().getY() - autre.getLocation().getY()), 2));
		double f = SpaceSystem.g * (corp.getMass()) * autre.getMass() / (Math.pow(distance, 2));
		double a = (f / corp.getMass()) * SpaceSystem.fa;
		
		double dirX = (autre.getLocation().getX() - corp.getLocation().getX()) / distance;
		double dirY = (autre.getLocation().getY() - corp.getLocation().getY()) / distance;
		
		corp.setVitX((float) (corp.getVitX() + dirX * a));
		corp.setVitY((float) (corp.getVitY() + dirY * a));
	}
	
	public Location getNextLocation(Corp c, double dt) {
		applicateStrength((SimuleCorp) c);
		return new Location(corp.getLocation().getX() + corp.getVitX(), corp.getLocation().getY() + corp.getVitY());
	}	
}
