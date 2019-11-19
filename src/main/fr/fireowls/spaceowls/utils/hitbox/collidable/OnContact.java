package fr.fireowls.spaceowls.utils.hitbox.collidable;

@FunctionalInterface
public interface OnContact {

    void handle(Collidable collidable);

}
