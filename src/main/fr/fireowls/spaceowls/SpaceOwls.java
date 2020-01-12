package fr.fireowls.spaceowls;

import fr.fireowls.spaceowls.engine.Engine;
import fr.fireowls.spaceowls.engine.EngineController;
import fr.fireowls.spaceowls.engine.EngineVue;
import fr.fireowls.spaceowls.system.SpaceSystem;
import fr.fireowls.spaceowls.system.corp.Corp;
import fr.fireowls.spaceowls.utils.FileInterpretor;
import fr.fireowls.spaceowls.utils.VerifyArgs;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class SpaceOwls extends Application {

    public static final String APP_NAME = "SpaceOwls";
    public static final int FRAME_WIDTH = 1000, FRAME_HEIGHT = 1000;

    private static String system;

    @Override
    public void start(Stage stage) {
        if (system.equals(VerifyArgs.DEFAULT_SYS)) {
            Label label = new Label("Selectionnez un systeme.");
            FileChooser fileChooser = new FileChooser();
            TextField field = new TextField();
            Button openDialogue = new Button("Ouvrire boite de dialogue");

            openDialogue.setOnAction(e -> {
                File selected = fileChooser.showOpenDialog(stage);
                if (selected != null)
                    field.setText(selected.getAbsolutePath());
            });

            HBox hobx = new HBox(field, openDialogue);
            Button button = new Button("Demarrer");
            button.setOnAction(e -> {
                stage.close();
                system = field.getText();
                run();
            });
            VBox box = new VBox(label, hobx, button);

            stage.setTitle(APP_NAME);
            stage.setWidth(250);
            stage.setHeight(100);
            stage.setScene(new Scene(box));
            stage.show();
        } else {
            run();
        }

    }

    public void run() {
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