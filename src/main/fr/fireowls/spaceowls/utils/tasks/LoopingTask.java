package fr.fireowls.spaceowls.utils.tasks;

public class LoopingTask extends Task {

    protected int ticks;
    protected int ticksBeforeStart;
    protected boolean run;

    public LoopingTask(TaskHandler handler, int ticks) {
        this(handler, 0, ticks > 0 ? ticks : 0);
    }

    public LoopingTask(TaskHandler handler, int ticksBeforeStart, int ticks) {
        super(handler);
        this.ticks = ticks;
        this.ticksBeforeStart = ticksBeforeStart;
    }

    public LoopingTask(TaskHandler handler, String name, int ticksBeforeStart, int ticks) {
        super(handler, name);
        this.ticks = ticks > 0 ? ticks : 0;
        this.ticksBeforeStart = ticksBeforeStart;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRun() {
        if (ticksBeforeStart > 0)
            pause(ticksBeforeStart);
        while (run) {
            handler.handle();
            if (ticks > 0)
                pause(ticks);
        }
    }

    @Override
    public void onStop() {

    }

    @Override
    public void start() {
        run = true;
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
        run = false;
    }

    public boolean isRunning() {
        return run;
    }

    public void setTicks(int ticks) {
        this.ticks = ticks;
    }

    public int getTicks() {
        return ticks;
    }
}
