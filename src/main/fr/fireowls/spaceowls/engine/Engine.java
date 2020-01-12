package fr.fireowls.spaceowls.engine;

import fr.fireowls.spaceowls.system.SpaceSystem;
import fr.fireowls.spaceowls.utils.Updatable;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.List;

public class Engine implements Updatable {

    private List<EngineVue> vues;
    private SpaceSystem ss;

    @Override
    public void create() {
        ss.create();
        vues = new ArrayList<>();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update(ss.getDt());
                render(null);
            }
        };
        timer.start();
    }

    @Override
    public void update(double delta) {
        ss.update(delta);
        for (EngineVue vue : vues) {
            vue.update(delta);
        }
    }

    @Override
    public void render(Canvas canvas) {
        for (EngineVue vue : vues) {
            vue.render(canvas);
        }
    }

    @Override
    public void dispose() {
        ss.dispose();
        vues.forEach(EngineVue::dispose);
    }

    public void addView(EngineVue vue) {
        vue.setSpaceSystem(ss);
        vue.create();
        this.vues.add(vue);
    }

    public void setSpaceSystem(SpaceSystem ss) {
        this.ss = ss;
    }
}
