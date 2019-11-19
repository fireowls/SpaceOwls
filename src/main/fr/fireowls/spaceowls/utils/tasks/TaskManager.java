package fr.fireowls.spaceowls.utils.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {

    private List<Task> tasks;
    private String name;
    private ThreadGroup group;

    public TaskManager(String name) {
        this.name = name;
        this.group = new ThreadGroup(name);
        this.tasks = new ArrayList<>();
    }

    public void put(Task task) {
        tasks.add(task);
        task.init(this);
    }

    public void stop(String task) {
        for (Task t : getTasks(task)) {
            stop(t);
        }
    }

    public void stop(Task task) {
        for (int i = 0 ; i < tasks.size() ; i++) {
            if (tasks.get(i).equals(task)) {
                tasks.remove(i);
                task.getThread().stop();
                i--;
            }
        }
    }


    public void start(String name) {
        for (Task task : getTasks(name)) {
            start(task);
        }
    }

    public void start(Task task) {
        if (getTasks(task.getName()).size() == 0) {
            put(task);
        }
        task.start();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Task> getTasks(String name) {
        return tasks.stream().filter(x -> x.getName().equals(name)).collect(Collectors.toList());
    }

    public ThreadGroup getThreadGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public void dispose() {
        while (tasks.size() > 0) {
            stop(tasks.get(0));
        }
    }
}
