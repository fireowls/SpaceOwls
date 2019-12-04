package fr.fireowls.spaceowls.system.corp;

import fr.fireowls.spaceowls.system.SpaceSystem;
import fr.fireowls.spaceowls.system.trajectory.ShipTrajectory;
import fr.fireowls.spaceowls.utils.Location;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ShipCorp extends Corp{

	protected final double pprincipal;
	protected final double pretro;

	public ShipCorp(Location location, double vitX, double vitY, SpaceSystem ss, double pprincipal, double pretro) {
		super(CorpType.VAISSEAU, location);
		this.pprincipal = pprincipal;
		this.pretro = pretro;
		this.trajectory = new ShipTrajectory(ss, this, vitX, vitY);
	}
	
	public void keyPressed(KeyCode e) {
		System.out.println(e);
		if (e == KeyCode.LEFT) {
	    	((ShipTrajectory) trajectory).vitX -= pretro;
	    	System.out.println("truc");
	    }
	    if (e == KeyCode.RIGHT) {
	    	((ShipTrajectory) trajectory).vitX += pretro;
	    }
	    if (e == KeyCode.UP) {
	    	((ShipTrajectory) trajectory).vitY -= pprincipal;
	    }
	    if (e == KeyCode.DOWN) {
	    	((ShipTrajectory) trajectory).vitY += pretro;
	    }
	}
	
	@Override
	public void render(Canvas canvas) {
		canvas.getGraphicsContext2D().fillRect(location.getX(), location.getY(), 50, 50);
	}
}
