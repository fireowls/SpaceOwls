package fr.fireowls.spaceowls.hud;

import fr.fireowls.spaceowls.system.SpaceSystem;
import javafx.scene.layout.HBox;

public class BoardPanel {
	
	private SpaceSystem ss;
	private HBox hboxMain;
	
	public BoardPanel(SpaceSystem ss) {
		this.ss = ss;
		this.hboxMain = createBoardPanelWithShip();
	}
	
	public HBox getHboxMain() {
		return hboxMain;
	}

	private HBox createBoardPanelWithShip() {
		return new HBox(BPShip.getShipView(), BPShip.getShipInfo(ss), BPCore.getCoreVBox(ss), BPCore.getDetail());
	}

}
