package fr.fireowls.spaceowls.utils;

import fr.fireowls.spaceowls.screen.OwlPainter;

public interface Updatable {

    public void create();
    public void update(double delta);
    public void render(OwlPainter painter);
    public void dispose();

}
