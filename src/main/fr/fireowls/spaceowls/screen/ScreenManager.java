package fr.fireowls.spaceowls.screen;

import fr.fireowls.spaceowls.screen.scene.Scenes;
import fr.fireowls.spaceowls.utils.Updatable;
import javafx.scene.canvas.Canvas;

import java.util.Stack;

public class ScreenManager implements Updatable {

    private Stack<Screen> screens;

    public ScreenManager() {
        screens = new Stack<>();
    }

    public void loadScreen(Scenes screen) {
        Screen s = screen.createScreen();
        s.setScreenManager(this);
        s.create();
        screens.push(s);
    }

    @Override
    public void create() {
        for (Screen screen : screens) {
            screen.create();
        }
    }

    @Override
    public void update(double delta) {
        if (screens.size() > 0)
            screens.peek().update(delta);
    }

    @Override
    public void render(Canvas canvas) {
        if (screens.size() > 0)
            screens.peek().render(canvas);
    }

    @Override
    public void dispose() {
        for (Screen screen : screens) {
            screen.dispose();
        }
    }

    public Stack<Screen> getScreens() {
        return screens;
    }
}
