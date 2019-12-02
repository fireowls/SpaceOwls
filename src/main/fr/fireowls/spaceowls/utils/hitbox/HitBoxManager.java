package fr.fireowls.spaceowls.utils.hitbox;

import fr.fireowls.spaceowls.screen.OwlPainter;
import fr.fireowls.spaceowls.utils.Updatable;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.List;

public class HitBoxManager implements Updatable {

    private List<HitBox> hitBoxes;
    private boolean isCreate;
    private boolean show;

    public HitBoxManager() {
        this.hitBoxes = new ArrayList<>();
        isCreate = false;
        show = false;
    }

    public void add(HitBox...hitBoxes) {
        for (HitBox hitbox : hitBoxes) {
            this.hitBoxes.add(hitbox);
            if (isCreate)
                hitbox.create();
        }
    }

    public void remove(HitBox...hitBoxes) {
        for (HitBox hitbox : hitBoxes) {
            this.hitBoxes.remove(hitbox);
            hitbox.dispose();
        }
    }

    public void show() {
        hitBoxes.stream().forEach(HitBox::show);
        show = true;
    }

    public void hide() {
        hitBoxes.stream().forEach(HitBox::hide);
        show = false;
    }

    public void toggleShow() {
        if (show)
            hide();
        else
            show();
    }

    @Override
    public void create() {
        hitBoxes.stream().forEach(HitBox::create);
        isCreate = true;
    }

    @Override
    public void update(double delta) {

        for (int i = 0 ; i < hitBoxes.size() - 1 ; i++) {

            HitBox current = hitBoxes.get(i);

            for (int y = i+1 ; y < hitBoxes.size() ; y++) {

                HitBox compare = hitBoxes.get(y);

                if (current.conflict(compare)) {
                    if (current.isInContact(compare)) {
                        current.onContact(compare);
                        compare.onContact(current);
                    } else {
                        current.onEnter(compare);
                        compare.onEnter(current);
                    }
                } else if (current.isInContact(compare)) {
                    current.onExit(compare);
                    compare.onExit(current);
                }

            }

            current.update(delta);

        }

    }

    @Override
    public void render(Canvas canvas) {
        if (show)
            for (HitBox hitbox : hitBoxes)
                hitbox.render(canvas);
    }

    @Override
    public void dispose() {
        hitBoxes.stream().forEach(HitBox::dispose);
        isCreate = false;
    }
}
