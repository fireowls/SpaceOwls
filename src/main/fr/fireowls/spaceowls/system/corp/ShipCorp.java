package fr.fireowls.spaceowls.system.corp;

import fr.fireowls.spaceowls.SpaceOwls;
import fr.fireowls.spaceowls.utils.Location;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ShipCorp extends Corp{

	protected final double pprincipal;
	protected final double pretro;
	protected double vitX;
	protected double vitY;
	
	public ShipCorp(Location location, double vitx, double vity, double pprincipal, double pretro) {
		super(CorpType.VAISSEAU,location);
		this.pprincipal = pprincipal;
		this.pretro = pretro;
		this.vitX = vitx;
		this.vitY = vity;
	}
	
	public String toString() {
		return this.type.getName()+"["+this.mass+","+this.location.toString()+","+vitX+","+vitY+","+pprincipal+","+pretro+"]";
	}
	
	@Override
	public void create() {
		super.create();
		SpaceOwls.stage.addEventHandler(KeyEvent.KEY_PRESSED, (key)->{
			if(key.getCode()==KeyCode.UP)
				this.vitX += pprincipal;
			if(key.getCode()==KeyCode.DOWN)
				this.vitX -= pretro;
		});
	}

	public double getVitX() {
		return vitX;
	}

	public void setVitX(double vitX) {
		this.vitX = vitX;
	}

	public double getVitY() {
		return vitY;
	}

	public void setVitY(double vitY) {
		this.vitY = vitY;
	}

	public double getPprincipal() {
		return pprincipal;
	}

	public double getPretro() {
		return pretro;
	}
	
		
}
