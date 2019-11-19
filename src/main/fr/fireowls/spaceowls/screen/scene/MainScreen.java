package fr.fireowls.spaceowls.screen.scene;

import fr.fireowls.spaceowls.SpaceOwls;
import fr.fireowls.spaceowls.screen.OwlPainter;
import fr.fireowls.spaceowls.screen.Screen;
import fr.fireowls.spaceowls.system.SpaceSystem;
import fr.fireowls.spaceowls.system.corp.Corp;
import fr.fireowls.spaceowls.system.trajectory.ElipseTrajectory;
import fr.fireowls.spaceowls.system.trajectory.Trajectory;
import fr.fireowls.spaceowls.utils.Location;
import fr.fireowls.spaceowls.utils.hitbox.CircleHitBox;
import fr.fireowls.spaceowls.utils.hitbox.HitBox;

public class MainScreen extends Screen {

    double x = 10;
    double y = 10;
    public static SpaceSystem ss;
    Corp c1;
    Corp c2;

    Trajectory trajectory1;
    Trajectory trajectory2;
    Trajectory trajectory3;

    @Override
    public void create() {

        ss = new SpaceSystem(6.67430, 1, 6, 5000);

        c1 = new Corp(null, new Location(100, 10));

        HitBox box = new CircleHitBox(50, 50);
        c1.setHitBox(box);

        trajectory1 = new ElipseTrajectory(c1.getLocation(), 1, 1);
        c1.setTrajectory(trajectory1);

        ss.addCorp(c1);
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
