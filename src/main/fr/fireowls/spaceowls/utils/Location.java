package fr.fireowls.spaceowls.utils;

import java.util.Observer;
import java.util.Observable;

public class Location extends Observable implements Observer {
	
	private double x;
	private double y;

	public Location(double x, double y) {
		move(x, y);
	}

	public void move(Location location) {
		move(location.getX(), location.getY());
	}

	public void move(double x, double y) {
		this.x = x;
		this.y = y;
		setChanged();
		notifyObservers();
	}

	public void setX(double x) {
		move(x, y);
	}

	public void setY(double y) {
		move(x, y);
	}
		
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}


	public void link(Location location) {
		location.move(this);
		this.addObserver(location);
	}

	public void unLink(Location location) {
		this.deleteObserver(location);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Location
				&& ((Location) obj).getX() == x
				&& ((Location) obj).getY() == y;
	}

	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + "]";
	}


	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Location) {
			this.move((Location) o);
		}
	}
}
