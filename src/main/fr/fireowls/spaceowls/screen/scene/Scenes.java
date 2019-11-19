package fr.fireowls.spaceowls.screen.scene;

import fr.fireowls.spaceowls.screen.Screen;

public enum Scenes {

    MAIN(MainScreen.class);

    private Class<? extends Screen> c;

    private Scenes(Class<? extends Screen> c) {
        this.c = c;
    }

    public Class<? extends Screen> getScreenClass() {
        return c;
    }

    public Screen createScreen() {
        try {
            return (Screen) c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
