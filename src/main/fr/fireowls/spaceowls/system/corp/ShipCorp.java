package fr.fireowls.spaceowls.system.corp;

import fr.fireowls.spaceowls.system.SpaceSystem;
import fr.fireowls.spaceowls.system.trajectory.ShipTrajectory;
import fr.fireowls.spaceowls.utils.Location;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class ShipCorp extends Corp{

	protected final double pprincipal;
	protected final double pretro;

	protected double vitX;
	protected double vitY;

	public ShipCorp(Location location, double vitX, double vitY, SpaceSystem ss, double pprincipal, double pretro) {
		super(CorpType.VAISSEAU, location);
		this.pprincipal = pprincipal;
		this.pretro = pretro;
		this.trajectory = new ShipTrajectory(ss, this, vitX, vitY);
		this.vitX = vitX;
		this.vitY = vitY;
	}
	
	public void keyPressed(KeyCode e) {
		if (e == KeyCode.LEFT) {
	    	((ShipTrajectory) trajectory).vitX -= pretro;
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
		trajectory.render(canvas);
		canvas.getGraphicsContext2D().setFill(Color.BLUE);
		canvas.getGraphicsContext2D().fillRect(location.getX()+canvas.getWidth()/2, location.getY()+canvas.getHeight()/2, 50, 50);
	}

	public double getPprincipal() {
		return pprincipal;
	}

	public double getPretro() {
		return pretro;
	}

	public double getVitX() {
		return vitX;
	}

	public double getVitY() {
		return vitY;
	}
}
