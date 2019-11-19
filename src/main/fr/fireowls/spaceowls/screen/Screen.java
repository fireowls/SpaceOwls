package fr.fireowls.spaceowls.screen;

import fr.fireowls.spaceowls.utils.Updatable;

public abstract class Screen implements Updatable {

    private ScreenManager screenManager;

    public void setScreenManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    public ScreenManager getScreenManager() {
        return screenManager;
    }

    public void stop() {

    }
}
