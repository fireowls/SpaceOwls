package fr.fireowls.spaceowls.engine;

import fr.fireowls.spaceowls.SpaceOwls;
import fr.fireowls.spaceowls.hud.Camera;
import fr.fireowls.spaceowls.system.SpaceSystem;
import fr.fireowls.spaceowls.utils.Updatable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class EngineVue implements Updatable {

    private Stage stage;
    private SpaceSystem ss;
    private Camera camera;

    private Canvas canvas;
    private VBox box;

    @Override
    public void create() {
        stage = new Stage();
        camera = new Camera();

        canvas = new Canvas(SpaceOwls.FRAME_WIDTH, SpaceOwls.FRAME_HEIGHT);
        box = new VBox(canvas);
        stage.setScene(new Scene(box));
        stage.setTitle(SpaceOwls.APP_NAME);
        stage.show();
    }

    @Override
    public void update(double delta) {
        box.requestFocus();
        camera.update();
    }

    @Override
    public void render(Canvas canvas) {
        GraphicsContext context = this.canvas.getGraphicsContext2D();
        context.save();
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, stage.getWidth(), stage.getHeight());
        context.translate(-(camera.getLocation().getX()), -(camera.getLocation().getY()));
        context.scale(camera.getScale(), camera.getScale());
        ss.render(this.canvas);
        context.restore();
    }

    @Override
    public void dispose() {
        stage.close();
    }

    public void setSpaceSystem(SpaceSystem ss) {
        this.ss = ss;
    }

    public Camera getCamera() {
        return camera;
    }
}
