package fr.fireowls.spaceowls;

import fr.fireowls.spaceowls.engine.Engine;
import fr.fireowls.spaceowls.screen.ScreenContext;
import fr.fireowls.spaceowls.screen.ScreenManager;
import fr.fireowls.spaceowls.screen.scene.Scenes;
import javafx.application.Application;
import javafx.stage.Stage;

public class SpaceOwls extends Application {

    public static final String APP_NAME = "SpaceOwls";
    public static final int TARGET_FPS = 60;

    public static Engine engine;
    public static ScreenContext context;

    public static void main(String...args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        engine = new Engine();
        context = new ScreenContext(primaryStage);
        context.initStage(engine);

        ScreenManager screenManager = engine.getScreenManager();
        screenManager.loadScreen(Scenes.MAIN);
        
        engine.start();
    }
}