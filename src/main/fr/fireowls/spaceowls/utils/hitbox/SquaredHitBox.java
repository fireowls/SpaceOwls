package fr.fireowls.spaceowls.utils.hitbox;

import fr.fireowls.spaceowls.utils.hitbox.shape.SquaredHitBoxShape;
import javafx.scene.canvas.GraphicsContext;

public class SquaredHitBox extends HitBox {

    protected double height;
    protected double width;

    public SquaredHitBox(double width, double height) {
        setShape(new SquaredHitBoxShape(width, height));
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(GraphicsContext painter) {
        painter.strokeRect(location.getX(), location.getY(), width, height);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
