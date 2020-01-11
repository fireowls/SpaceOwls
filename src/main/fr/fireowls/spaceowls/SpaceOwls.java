package fr.fireowls.spaceowls;

import fr.fireowls.spaceowls.screen.Camera;
import fr.fireowls.spaceowls.system.SpaceSystem;
import fr.fireowls.spaceowls.system.corp.ShipCorp;
import fr.fireowls.spaceowls.system.corp.SimuleCorp;
import fr.fireowls.spaceowls.system.corp.StaticCorp;
import fr.fireowls.spaceowls.utils.FileInterpretor;
import fr.fireowls.spaceowls.utils.Location;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SpaceOwls extends Application {

    boolean running = true;
    public static final String APP_NAME = "SpaceOwls";
    public static final int TARGET_FPS = 60;

    private SpaceSystem ss;
    private Canvas canvas;
    private Camera camera;

    ShipCorp c;

    public static void main(String...args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        // FileInterpretor fi = new FileInterpretor("D:\\programmation\\java\\other\\SpaceOwls\\res\\system\\02_PlanèteTourne.astro");
        // ss = fi.createSystem();
        ss = new SpaceSystem(0.01, 4, 500, 500);

        StaticCorp c1 = new StaticCorp(new Location(200, 200));
        ss = new SpaceSystem(0.01, 4, 500, 500);
        //ss = fi.createSystem();
        c = new ShipCorp(new Location(-300, -300), 0, 0, ss, 0.1, 0.1);
        c.setMass(10);
        StaticCorp c2 = new StaticCorp(new Location(1000, 500));
        c2.setMass(400);
        SimuleCorp c3 = new SimuleCorp(new Location(0,100), 0.025, 0, ss);
        c3.setMass(10);
        ss.addCorp(c, c1, c2, c3);

        ss.create();

        canvas = new Canvas(ss.getRayon()*2,ss.getRayon()*2-300);
        camera = new Camera();

        camera.setFocus(c3);

        VBox vBox = new VBox(canvas);
        vBox.addEventHandler(KeyEvent.KEY_PRESSED, e -> ss.getShip().keyPressed(e.getCode()));
        stage.setScene(new Scene(vBox));
        stage.setTitle(APP_NAME);
        stage.show();
        AnimationTimer timer = new AnimationTimer() {
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
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.save();
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, 1500, 1000);
        context.translate(-(camera.getLocation().getX()), -(camera.getLocation().getY()));
        context.scale(camera.getScale(), camera.getScale());
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, 1500, 1000);
        ss.render(canvas);
        context.restore();
    }

    private void update(double delta) {
        camera.update();
        ss.update(delta);
    }
}