package fr.fireowls.spaceowls.engine;

import fr.fireowls.spaceowls.screen.OwlPainter;
import fr.fireowls.spaceowls.screen.ScreenManager;
import fr.fireowls.spaceowls.utils.Updatable;
import fr.fireowls.spaceowls.utils.tasks.TaskManager;

public class Engine implements Updatable {

    private int fps;

    private TaskManager taskManager;
    private ScreenManager screenManager;
    private EngineLoop engineLoop;
    
    private OwlPainter painter;

    public Engine() {
        this.taskManager = new TaskManager("engine-tasks");
        this.screenManager = new ScreenManager();
        engineLoop = new EngineLoop(this);
        fps = 0;
    }

    public void start() {
        engineLoop.start();
    }

    @Override
    public void create() {
        screenManager.create();
    }

    @Override
    public void update(double delta) {
        screenManager.update(delta);
    }

    @Override
    public void render(OwlPainter painter) {
        screenManager.render(painter);
    }

    @Override
    public void dispose() {
        engineLoop.stop();
        taskManager.dispose();
        screenManager.dispose();
    }

    public TaskManager getTaskManager() {
        return taskManager;
    }

    public ScreenManager getScreenManager() {
        return screenManager;
    }

    public void setFPS(int fps) {
        this.fps = fps;
    }

    public int getFPS() {
        return fps;
    }

    public void setPainter(OwlPainter painter) {
        this.painter = painter;
    }

    public OwlPainter getPainter() {
        return painter;
    }

    public double getTimer() {
        return engineLoop.getClock();
    }

}
