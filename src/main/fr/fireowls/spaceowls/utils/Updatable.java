package fr.fireowls.spaceowls.utils;

import fr.fireowls.spaceowls.screen.OwlPainter;
import javafx.scene.canvas.Canvas;

public interface Updatable {

    public void create();
    public void update(double delta);
    public void render(Canvas canvas);
    public void dispose();

}
