package fr.fireowls.spaceowls.utils.hitbox;

import fr.fireowls.spaceowls.utils.hitbox.shape.HitBoxShape;
import fr.fireowls.spaceowls.utils.hitbox.shape.SquaredHitBoxShape;

public enum HitBoxType {

    SQUARED(SquaredHitBoxShape.class);

    Class<? extends HitBoxShape> c;

    private HitBoxType(Class<? extends HitBoxShape> c) {
        this.c = c;
    }


    public Class<? extends HitBoxShape> getHitBoxShapeClass() {
        return c;
    }

}
