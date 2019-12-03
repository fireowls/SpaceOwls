package fr.fireowls.spaceowls.system.corp;

import fr.fireowls.spaceowls.system.SpaceSystem;
import fr.fireowls.spaceowls.utils.Location;

import java.lang.reflect.InvocationTargetException;

public class CorpFactory {

	/**
	 * Créer un corp static
	 * @param location est la position du corp
	 * @return le corp
	 */
	public static Corp createStaticCorp(Location location){
		return new StaticCorp(location);
	}

	/**
	 * Créer un corp simulé
	 * @param location est la position du corp
	 * @param vitX est la vitesse en X du corp
	 * @param vitY est la vitesse en Y du corp
	 * @return le corp
	 */
	public static Corp createSimuleCorp(Location location,double vitX,double vitY, SpaceSystem ss){
		return new SimuleCorp(location,vitX,vitY, ss);
	}

	/**
	 * Créer un vaisseau
	 * @param location est la position du vaisseau
	 * @param vitX est la vitesse en X
	 * @param vitY est la vitesse en Y
	 * @param pprincipal est la force de propulsion principale
	 * @param pretro est la force de propulsion retro
	 * @return le corp
	 */
	public static Corp createShipCorp(Location location,double vitX,double vitY, SpaceSystem ss, double pprincipal,double pretro){
		return new ShipCorp(location,vitX,vitY, ss, pprincipal,pretro);
	}

	/**
	 * Créer un corp ellipse
	 * @param location est la location du corp
	 * @param c1 est un corp
	 * @param c2 est un corp
	 * @param periode est la periode
	 * @return le corp
	 */
	public static Corp createEllipseCorp(Location location,Corp c1,Corp c2,int periode){
		return new EllipseCorp(location,c1,c2,periode);
	}

}
