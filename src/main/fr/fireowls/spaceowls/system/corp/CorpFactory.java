package fr.fireowls.spaceowls.system.corp;

import fr.fireowls.spaceowls.system.trajectory.ShipTrajectory;
import fr.fireowls.spaceowls.system.trajectory.SimulateTrajectory;
import fr.fireowls.spaceowls.system.trajectory.StaticTrajectory;
import fr.fireowls.spaceowls.utils.Location;

public class CorpFactory {

	public static Corp createCorp(String name,double...doubles) {
		
		if(doubles.length == 2) {
			StaticCorp c = new StaticCorp(new Location(doubles[0],doubles[1]));
			c.setTrajectory(new StaticTrajectory());
			return c;
		}else if(doubles.length == 4) {
			//SimuleCorp c = new SimuleCorp(new Location(doubles[0],doubles[1]), doubles[2], doubles[3]);
			//c.setTrajectory(new SimulateTrajectory((SimuleCorp) c));
			//return c;
		}else if(doubles.length == 6) {
			ShipCorp c = new ShipCorp(new Location(doubles[0],doubles[1]), doubles[2], doubles[3], doubles[4], doubles[5]);
			c.setTrajectory(new ShipTrajectory((ShipCorp) c));
			return c;
		}
		return null;
	}
}
