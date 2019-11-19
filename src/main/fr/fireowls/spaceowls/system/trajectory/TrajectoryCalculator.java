package fr.fireowls.spaceowls.system.trajectory;

@FunctionalInterface
public interface TrajectoryCalculator {
    double handle(double dt);
}
