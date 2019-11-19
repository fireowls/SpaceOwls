package fr.fireowls.spaceowls.engine;

import fr.fireowls.spaceowls.SpaceOwls;
import javafx.animation.AnimationTimer;

public class EngineLoop extends AnimationTimer {

    protected Engine engine;

    protected long startNanoTime;
    protected long lastNanoTime;

    protected double clock;
    protected double deltaTime;

    protected double timerPerTicks;

    public static final double SECOND = 1_000_000_000.00;

    public EngineLoop(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void start() {
        startNanoTime = System.nanoTime();
        engine.create();
        timerPerTicks = SECOND / SpaceOwls.TARGET_FPS;
        super.start();
    }

    private int next = 0;
    private int count = 0;
    private boolean pause = false;

    public void pause() {
        pause = true;
    }

    public void resume() {
        pause = false;
    }

    @Override
    public void handle(long now) {
        if (!pause) {
            clock = (now - startNanoTime) / SECOND;
            deltaTime = (now - lastNanoTime) / SECOND;

            engine.update(deltaTime);
            engine.render(engine.getPainter());
            if (clock >= next) {
                engine.setFPS(count);
                next++;
                count = 0;
            }
            count++;
            lastNanoTime = System.nanoTime();
        }
    }

    @Override
    public void stop() {
        super.stop();
    }

    public double getDeltaTime() {
        return deltaTime;
    }

    public double getClock() {
        return clock;
    }

    public Engine getEngine() {
        return engine;
    }
}
