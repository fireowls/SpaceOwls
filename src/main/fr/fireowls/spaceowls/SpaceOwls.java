package fr.fireowls.spaceowls;

import fr.fireowls.spaceowls.engine.Engine;
import fr.fireowls.spaceowls.hud.BoardPanel;
import fr.fireowls.spaceowls.screen.ScreenContext;
import fr.fireowls.spaceowls.screen.ScreenManager;
import fr.fireowls.spaceowls.screen.scene.Scenes;

import fr.fireowls.spaceowls.math.CorpSize;
import fr.fireowls.spaceowls.system.SpaceSystem;
import fr.fireowls.spaceowls.system.corp.Corp;
import fr.fireowls.spaceowls.system.corp.ShipCorp;
import fr.fireowls.spaceowls.system.corp.SimuleCorp;
import fr.fireowls.spaceowls.system.corp.StaticCorp;
import fr.fireowls.spaceowls.utils.FileInterpretor;
import fr.fireowls.spaceowls.utils.Location;
import fr.fireowls.spaceowls.utils.VerifyArgs;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
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
    public static String sys;

    public static void main(String...args) {
        sys = VerifyArgs.verifyArgument(args);
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        SpaceOwls.stage = stage;


        FileInterpretor fi = new FileInterpretor(sys);
        //ss = new SpaceSystem(0.01, 4, 500, 500);
        ss = fi.createSystem();


        CorpSize corpSize = new CorpSize(ss.getCorps());

        for(Corp c:ss.getCorps()){
            c.setHeight(corpSize.getCorpSize(c));
            c.setWidth(corpSize.getCorpSize(c));
        }
        ss.create();

        canvas = new Canvas(ss.getRayon()*2,ss.getRayon()*2-300);

        for(Corp c:ss.getCorps()){
            c.setHeight(corpSize.getCorpSize(c));
            c.setWidth(corpSize.getCorpSize(c));
        }

        ss.create();

        canvas = new Canvas(ss.getRayon()*2,ss.getRayon()*2);


        VBox vBox = new VBox(canvas);
        //BoardPanel bp = new BoardPanel(ss);
        //vBox.getChildren().add(bp.getHboxMain());

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