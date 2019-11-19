package fr.fireowls.spaceowls.utils.tasks;

public class RepeatingTask extends Task {

    private int ticks;
    private boolean run;

    public RepeatingTask(TaskHandler handler, int ticks) {
        super(handler);
        this.ticks = ticks;
    }

    public RepeatingTask(TaskHandler handler, String name, int ticks) {
        super(handler, name);
        this.ticks = ticks;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRun() {
        while (run) {
            handler.handle();
            try {
                thread.sleep(ticks);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
