package fr.fireowls.spaceowls.hud;

import fr.fireowls.spaceowls.system.SpaceSystem;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class BPShip {
	
	public static ImageView getShipView() {
		Image spaceShipImage = new Image("res/board_panel/space_ship.jpg");
		ImageView spaceShipImageView = new ImageView();
		spaceShipImageView.setImage(spaceShipImage);
		return spaceShipImageView;
	}
	
	public static VBox getShipInfo(SpaceSystem ss) {
		Label lblPosX = new Label("Position X : " + ss.getShip().getLocation().getX());
		Label lblPosY = new Label("Position Y : " + ss.getShip().getLocation().getY());
		Label lblVitX = new Label("Vitesse X : " + ss.getShip().getVitX());
		Label lblVitY = new Label("Vitesse Y : " + ss.getShip().getVitY());
		Label lblPropPrin = new Label("Puissance propulseurs principals : " + ss.getShip().getPprincipal());
		Label lblPropFrei = new Label("Puissance propulseurs de freinage : " + ss.getShip().getPretro());
		return new VBox(lblPosX, lblPosY, lblPropPrin, lblPropFrei, lblVitX, lblVitY);
	}
}
