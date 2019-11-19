package fr.fireowls.spaceowls.screen;

import fr.fireowls.spaceowls.SpaceOwls;
import fr.fireowls.spaceowls.engine.Engine;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ScreenContext {

    public static final String DEFAULT_TITLE = SpaceOwls.APP_NAME;
    public static final int DEFAULT_WITH_SIZE = 1080;
    public static final int DEFAULT_HEIGHT_SIZE = 720;

    public static final boolean DEFAULT_RESIZABLE = false;

    private Stage stage;
    private GraphicsContext graphicsContext;
    private OwlPainter painter;
    private Camera camera;

    public ScreenContext(Stage stage) {
        this.stage = stage;
        stage.setTitle(DEFAULT_TITLE);
        stage.setWidth(DEFAULT_WITH_SIZE);
        stage.setHeight(DEFAULT_HEIGHT_SIZE);
        stage.setResizable(DEFAULT_RESIZABLE);
        graphicsContext = null;
        painter = null;
        camera = new Camera();
    }

    public void initStage(Engine engine) {

        Canvas canvas = new Canvas();
        canvas.setHeight(getHeight());
        canvas.setWidth(getWith());

        this.graphicsContext = canvas.getGraphicsContext2D();
        this.painter = new OwlPainter(graphicsContext, camera);
        engine.setPainter(painter);

        BorderPane box = new BorderPane(canvas);
        Scene scene = new Scene(box);

        stage.setScene(scene);

        stage.show();
        stage.setOnCloseRequest(event -> engine.dispose());
        stage.setOnHidden(event -> engine.pause());
        stage.setOnShown(event -> engine.resume());
    }

    public String getTitle() {
        return stage.getTitle();
    }

    public void setTitle(String title) {
        this.stage.setTitle(title);
    }

    public void setWith(int with) {
        this.stage.setWidth(with);
    }

    public void setHeight(int height) {
        this.stage.setHeight(height);
    }

    public double getWith() {
        return this.stage.getWidth();
    }

    public double getHeight() {
        return this.stage.getHeight();
    }

    public void setSize(int height, int with) {
        setHeight(height);
        setWith(with);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    public boolean isResizable() {
        return stage.isResizable();
    }

    public void setResizable(boolean resizable) {
        stage.setResizable(resizable);
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public OwlPainter getPainter() {
        return painter;
    }

    public Camera getCamera() {
        return camera;
    }
}
