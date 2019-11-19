package fr.fireowls.spaceowls.utils.hitbox;

import fr.fireowls.spaceowls.screen.OwlPainter;
import fr.fireowls.spaceowls.utils.Location;
import fr.fireowls.spaceowls.utils.Updatable;
import fr.fireowls.spaceowls.utils.hitbox.collidable.Collidable;
import fr.fireowls.spaceowls.utils.hitbox.collidable.OnContact;
import fr.fireowls.spaceowls.utils.hitbox.collidable.OnEnter;
import fr.fireowls.spaceowls.utils.hitbox.collidable.OnExit;
import fr.fireowls.spaceowls.utils.hitbox.shape.HitBoxShape;

import java.util.ArrayList;
import java.util.List;

/**
 * Reprente la boite de contact d'un objet
 * Permet de détecter quand deux objets sont en contact
 */
public abstract class HitBox implements Collidable, Updatable {

	protected List<Collidable> contacts;

	protected HitBoxShape shape;

	protected OnContact onContact;
	protected OnEnter onEnter;
	protected OnExit onExit;

	protected Location location;
	protected boolean show;

	public HitBox() {

		location = new Location(0, 0);

		onContact = null;
		onEnter = null;
		onExit = null;

		show = false;

	}

	public void show() {
		show = true;
	}

	public void hide() {
		show = false;
	}

    @Override
    public void create() {
		contacts = new ArrayList<>();
    }

    @Override
    public void update(double delta) {}

    @Override
    public void render(OwlPainter painter) {
        if (show) {
            draw(painter);
        }
    }

    @Override
    public void dispose() {
        contacts.stream().forEach(this::onExit);
    }

	@Override
	public boolean conflict(Collidable other) {
		if (other instanceof HitBox) {
			HitBox otherBox = (HitBox) other;
			HitBoxShape otherBoxShape = otherBox.getShape();
			return shape.conflict(otherBoxShape);
		}
		return false;
	}

	@Override
	public void onContact(Collidable other) {
		if (onContact != null)
			onContact.handle(other);
	}

	@Override
	public void onEnter(Collidable other) {
		contacts.add(other);
		if (onEnter != null)
			onEnter.handle(other);
	}

	@Override
	public void onExit(Collidable other) {
		contacts.remove(other);
		if (onExit != null) {
			onExit.handle(other);
		}
	}

	@Override
	public boolean isInContact() {
		return contacts.size() > 0;
	}

	@Override
	public boolean isInContact(Collidable other) {
		return contacts.contains(other);
	}

    public abstract void draw(OwlPainter painter);

	public void setOnContact(OnContact onContact) {
		this.onContact = onContact;
	}

	public void setOnEnter(OnEnter onEnter) {
		this.onEnter = onEnter;
	}

	public void setOnExit(OnExit onExit) {
		this.onExit = onExit;
	}

	public void setShape(HitBoxShape shape) {
		this.shape = shape;
		location.link(shape.getLocation());
	}

	public HitBoxShape getShape() {
		return shape;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof HitBox
				&& ((HitBox) obj).getShape().equals(shape);
	}
}
