package fr.fireowls.spaceowls;

import fr.fireowls.spaceowls.engine.Engine;
import fr.fireowls.spaceowls.screen.ScreenContext;
import fr.fireowls.spaceowls.screen.ScreenManager;
import fr.fireowls.spaceowls.screen.scene.Scenes;
import fr.fireowls.spaceowls.system.SpaceSystem;
import fr.fireowls.spaceowls.system.corp.*;
import fr.fireowls.spaceowls.system.trajectory.ElipseTrajectory;
import fr.fireowls.spaceowls.utils.FileInterpretor;
import fr.fireowls.spaceowls.utils.Location;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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

        //FileInterpretor fi = new FileInterpretor("03_DeuxPlanetes.astro");
        ss = new SpaceSystem(0.01, 4, 500, 500);
        //ss = fi.createSystem();
        ss.create();
        
        ShipCorp c = new ShipCorp(new Location(10, 10), 0, 0, ss, 0.1, 0.1);
        c.setMass(10);
        ss.addCorp(c);
        StaticCorp c1 = new StaticCorp(new Location(200, 200));
        c1.setMass(40);

        StaticCorp c2 = new StaticCorp(new Location(1000, 500));
        c2.setMass(400);

        SimuleCorp c3 = new SimuleCorp(new Location(0,100), 0.025, 0, ss);
        c3.setMass(10);
        ss.addCorp(c, c1, c2, c3);


        canvas = new Canvas(ss.getRayon()*2,ss.getRayon()*2);

        VBox vBox = new VBox(canvas);
        vBox.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
        	((ShipCorp)(ss.getCorps().get(0))).keyPressed(e.getCode());
        });
        stage.setScene(new Scene(vBox));
        stage.setTitle(APP_NAME);
        stage.show();
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	vBox.requestFocus();
                update(ss.getDt());
                render(stage);
            }
        };
        timer.start();
    }


    private void render(Stage stage) {
    	canvas.getGraphicsContext2D().setFill(Color.BLACK);
    	canvas.getGraphicsContext2D().fillRect(0, 0, 1500, 1000);
        ss.render(canvas);
    }

    private void update(double delta) {
        ss.update(delta);
    }
}