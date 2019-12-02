package fr.fireowls.spaceowls;

import fr.fireowls.spaceowls.engine.Engine;
import fr.fireowls.spaceowls.screen.ScreenContext;
import fr.fireowls.spaceowls.screen.ScreenManager;
import fr.fireowls.spaceowls.screen.scene.Scenes;
import fr.fireowls.spaceowls.system.SpaceSystem;
import fr.fireowls.spaceowls.system.corp.*;
import fr.fireowls.spaceowls.system.trajectory.ElipseTrajectory;
import fr.fireowls.spaceowls.utils.Location;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SpaceOwls extends Application{

    boolean running = true;
    public static final String APP_NAME = "SpaceOwls";
    public static final int TARGET_FPS = 60;

    public static Stage stage;
    private AnimationTimer timer;

    private SpaceSystem ss;
    private Canvas canvas;
    private Corp corp;

    public static void main(String...args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        SpaceOwls.stage = stage;
        long lastTime = System.nanoTime();
        ss = new SpaceSystem(0, 0.1, 0, 1000);
        canvas = new Canvas(1500,1000);
        Location l = new Location(10,10);
        corp = new SimuleCorp(l, ss);


        ss.addCorp(corp);


        VBox vBox = new VBox(canvas);
        stage.setScene(new Scene(vBox));
        stage.setTitle(APP_NAME);
        stage.show();
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update(ss.getDt());
                render(stage);
            }
        };
        timer.start();
    }


    private void render(Stage stage) {
        canvas.getGraphicsContext2D().clearRect(0,0,1500,1000);
        ss.render(canvas);
    }

    private void update(double delta) {
        ss.update(delta);
        System.out.println(corp.getLocation().getX() + " "+ corp.getLocation().getY());
    }

    /*public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }*/

   /* public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

}