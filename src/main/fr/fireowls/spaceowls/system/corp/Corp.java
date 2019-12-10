package fr.fireowls.spaceowls.system.corp;

import fr.fireowls.spaceowls.screen.OwlPainter;
import fr.fireowls.spaceowls.system.trajectory.Trajectory;
import fr.fireowls.spaceowls.utils.Location;
import fr.fireowls.spaceowls.utils.Updatable;
import fr.fireowls.spaceowls.utils.hitbox.HitBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Corp implements Updatable {

	protected final CorpType type;

	protected HitBox hitBox;
	protected Trajectory trajectory;

	protected Location location;
	
	protected double mass;
	protected String name;

	public Corp(CorpType type, Location location) {
		this(type, location, null, null);
	}

	public Corp(CorpType type, Location location, HitBox hitBox) {
		this(type, location, hitBox, null);
	}

	public Corp(CorpType type, Location location, Trajectory trajectory) {
		this(type, location, null, trajectory);
	}

	public Corp(CorpType type, Location location, HitBox hitBox, Trajectory trajectory) {
		this.type = type;
		this.location = location;
		setHitBox(hitBox);
		setTrajectory(trajectory);
	}

	@Override
	public void create() {
		if (hitBox != null) hitBox.create();
		if (trajectory != null) trajectory.create();
	}

	@Override
	public void update(double delta) {
		//if (hitBox != null) hitBox.update(delta);
		if (trajectory != null) trajectory.update(delta);
	}

	@Override
	public void render(Canvas canvas) {
		//if (hitBox != null) hitBox.render(painter);
		//if (trajectory != null) trajectory.render(painter);
		trajectory.render(canvas);
		canvas.getGraphicsContext2D().setFill(Color.YELLOW);
		canvas.getGraphicsContext2D().fillOval(location.getX()+200, location.getY()+200, 50, 50);
	}

	@Override
	public void dispose() {
		if (hitBox != null) hitBox.dispose();
		if (trajectory != null) trajectory.dispose();
	}

	public void setHitBox(HitBox hitBox) {
		this.hitBox = hitBox;
		if (hitBox != null)
			location.link(hitBox.getLocation());
	}

	public HitBox getHitBox() {
		return hitBox;
	}

	public void setTrajectory(Trajectory trajectory) {
		this.trajectory = trajectory;
		if (trajectory != null)
			trajectory.bindCorp(this);
	}

	public Trajectory getTrajectory() {
		return trajectory;
	}

	public Location getLocation() {
		return location;
	}

	public CorpType getType() {
		return type;
	}
	
	public double getMass() {
		return this.mass;
	}
	
	public void setMass(double mass) {
		this.mass = mass;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Corp [type=" + type + ", hitBox=" + hitBox + ", trajectory=" + trajectory + ", location=" + location
				+ ", mass=" + mass + "]";
	}	
	
	
}
