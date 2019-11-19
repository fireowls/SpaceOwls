package fr.fireowls.spaceowls.utils.hitbox.shape;

public class SquaredHitBoxShape extends HitBoxShape {

    public SquaredHitBoxShape(double width, double height) {
        setHeight(width);
        setWidth(height);
    }

    @Override
    public boolean conflict(HitBoxShape other) {
        return !(
                (other.getLocation().getX() >= location.getX() + width)
                || (other.getLocation().getX() + other.getWidth() <= location.getX())
                || (other.getLocation().getY() >= location.getY() + height)
                || (other.getLocation().getY() + other.getHeight() <= location.getY())
        );
    }
}
