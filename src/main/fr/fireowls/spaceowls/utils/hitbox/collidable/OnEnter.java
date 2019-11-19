package fr.fireowls.spaceowls.utils.hitbox.collidable;

@FunctionalInterface
public interface OnEnter {

    void handle(Collidable collidable);

}
