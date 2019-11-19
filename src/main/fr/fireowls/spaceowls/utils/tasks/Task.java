package fr.fireowls.spaceowls.utils.tasks;

public abstract class Task implements Runnable {

    protected TaskHandler handler;
    protected String name;
    protected Thread thread;

    private TaskManager taskManager;

    public Task(TaskHandler handler) {
        this(handler,System.nanoTime()+"");
    }

    public Task(TaskHandler handler, String name) {
        this.handler = handler;
        this.name = name;
        taskManager = null;
    }

    public abstract void onStart();
    public abstract void onRun();
    public abstract void onStop();

    @Override
    public void run() {
        onStart();
        onRun();
        onStop();
    }

    public void init(TaskManager manager) {
        thread = new Thread(manager.getThreadGroup(), this, name);
        taskManager = manager;
    }

    public void start() {
        System.out.println("start task: "+getName());
        thread.start();
    }

    public void stop() {
        taskManager.stop(this);
    }

    public void pause(int ticks) {
        try {
            thread.sleep(ticks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Thread getThread() {
        return thread;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Task &&
                ((Task) obj).getName().equals(name);
    }
}
