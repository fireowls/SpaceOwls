package fr.fireowls.spaceowls.utils;

public class Vector {

	private Location point;
	
	public Vector(Location point) {
		this.point = point;
	}
	
	public Vector(double x, double y) {
		this(new Location(x, y));
	}

	public void add(Vector vector) {
		add(vector.getX(), vector.getY());
	}

	public void add(double x, double y) {
		point.setX(point.getX() + x);
		point.setY(point.getY() + y);
	}

	public void multiplie(double factor) {
		setX(getX() * factor);
		setY(getY() * factor);
	}

	public double getNorme() {
		return Math.sqrt(Math.pow(point.getX(), 2)+Math.pow(point.getY(), 2));
	}
	
	public void setLocation(Location point) {
		this.point = point;
	}
	
	public void setX(double x) {
		point.setX(x);
	}
	
	public void setY(double y) {
		point.setY(y);
	}

	public double getX() {
		return point.getX();
	}

	public double getY() {
		return point.getY();
	}
	
}
