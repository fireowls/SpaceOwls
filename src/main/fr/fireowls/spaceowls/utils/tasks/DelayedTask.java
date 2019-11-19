package fr.fireowls.spaceowls.utils.tasks;

public class DelayedTask extends Task {

    private int ticks;

    public DelayedTask(TaskHandler handler, int ticks) {
        super(handler);
        this.ticks = ticks;
    }

    public DelayedTask(TaskHandler handler, String name, int ticks) {
        super(handler, name);
        this.ticks = ticks;
    }

    @Override
    public void onStart() {
        try {
            thread.sleep(ticks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRun() {
        handler.handle();
    }

    @Override
    public void onStop() {

    }

    public int getTicks() {
        return ticks;
    }
}
