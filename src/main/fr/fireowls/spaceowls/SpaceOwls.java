package fr.fireowls.spaceowls;

import fr.fireowls.spaceowls.engine.Engine;
import fr.fireowls.spaceowls.engine.EngineController;
import fr.fireowls.spaceowls.engine.EngineVue;
import fr.fireowls.spaceowls.system.SpaceSystem;
import fr.fireowls.spaceowls.system.corp.Corp;
import fr.fireowls.spaceowls.utils.FileInterpretor;
import fr.fireowls.spaceowls.utils.VerifyArgs;
import javafx.application.Application;
import javafx.stage.Stage;

public class SpaceOwls extends Application {

    public static final String APP_NAME = "SpaceOwls";
    public static final int FRAME_WIDTH = 1500, FRAME_HEIGHT = 1000;

    private static String system;

    @Override
    public void start(Stage stage) {
        Engine engine = new Engine();
        EngineController engineController = new EngineController();

        FileInterpretor interpretor = new FileInterpretor(system);
        SpaceSystem spaceSystem = interpretor.createSystem();

        engine.setSpaceSystem(spaceSystem);
        engine.create();

        for (Corp corp : spaceSystem.getCorps()) {
            EngineVue engineVue = new EngineVue();
            engine.addView(engineVue);
            engineVue.getCamera().setFocus(corp);
        }
    }

    public static void main(String...args) {
        system = VerifyArgs.verifyArgument(args);
        launch(args);
    }
}