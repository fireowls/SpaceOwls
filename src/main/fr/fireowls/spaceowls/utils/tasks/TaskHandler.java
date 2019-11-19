package fr.fireowls.spaceowls.utils.tasks;

@FunctionalInterface
public interface TaskHandler {

    public void handle(Object...obj);

}
