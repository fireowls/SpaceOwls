package fr.fireowls.spaceowls.screen.scene;

import fr.fireowls.spaceowls.SpaceOwls;
import fr.fireowls.spaceowls.screen.OwlPainter;
import fr.fireowls.spaceowls.screen.Screen;
import fr.fireowls.spaceowls.system.SpaceSystem;
import fr.fireowls.spaceowls.utils.FileInterpretor;

public class TestScreen extends Screen{

	SpaceSystem ss;
	
	@Override
	public void create() {
		FileInterpretor fi = new FileInterpretor("01_CorpsTombeSurSoleil.astro");
    	ss = fi.createSystem();
    	ss.getHitBoxManager().show();
    	ss.create();
	}

	@Override
	public void update(double delta) {
	    ss.update(delta);
	}
	
	@Override
	public void render(OwlPainter painter) {
	    painter.clear();
	    painter.fillText(SpaceOwls.engine.getFPS()+"", 10, 10);
	    ss.render(painter);
	}
	
	@Override
	public void dispose() {
	    ss.dispose();
	}

}
