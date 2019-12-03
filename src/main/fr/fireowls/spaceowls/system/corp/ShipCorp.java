package fr.fireowls.spaceowls.system.corp;

import fr.fireowls.spaceowls.system.SpaceSystem;
import fr.fireowls.spaceowls.system.trajectory.ShipTrajectory;
import fr.fireowls.spaceowls.utils.Location;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;

public class ShipCorp extends Corp{

	protected final double pprincipal;
	protected final double pretro;

	public ShipCorp(Location location, double vitX, double vitY, SpaceSystem ss, double pprincipal, double pretro) {
		super(CorpType.VAISSEAU, location);
		this.pprincipal = pprincipal;
		this.pretro = pretro;
		this.trajectory = new ShipTrajectory(this);
	}
	
	@Override
	public void render(Canvas canvas) {
		canvas.getGraphicsContext2D().fillRect(location.getX(), location.getY(), 50, 50);
		canvas.setOnKeyPressed(e -> {
		    if (e.getCode() == KeyCode.LEFT) {
		    	
		    }
		    if (e.getCode() == KeyCode.RIGHT) {
		    	
		    }
		    if (e.getCode() == KeyCode.UP) {
		    	
		    }
		    if (e.getCode() == KeyCode.DOWN) {
		    	
		    }
		});
	}
	
	
	
	
		
}
