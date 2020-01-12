package fr.fireowls.spaceowls.utils;

import javafx.scene.canvas.Canvas;

public interface Updatable {

    public void create();
    public void update(double delta);
    public void render(Canvas canvas);
    public void dispose();

}
