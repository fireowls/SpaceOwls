package fr.fireowls.spaceowls.hud;

import fr.fireowls.spaceowls.system.SpaceSystem;
import fr.fireowls.spaceowls.system.corp.Corp;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BPCore {
	
	private static VBox detail = new VBox();

	public static VBox getCoreVBox(SpaceSystem ss) {
		VBox res = new VBox();
		for (Corp c : ss.getCorps()) {
			Label lblCorp = new Label(c.getName());
			lblCorp.setOnMouseClicked(e -> {
				detail.getChildren().clear();
				detail.getChildren().add(new Label("Type : " + c.getType()));
				detail.getChildren().add(new Label("Pos X : " + c.getLocation().getX()));
				detail.getChildren().add(new Label("Pos Y : " + c.getLocation().getY()));
				detail.getChildren().add(new Label("Trajectory type : " + c.getTrajectory().getType()));
			});
			res.getChildren().add(lblCorp);
		}
		return res;
	}
	
	public static VBox getDetail() {
		return detail;
	}
	
}
