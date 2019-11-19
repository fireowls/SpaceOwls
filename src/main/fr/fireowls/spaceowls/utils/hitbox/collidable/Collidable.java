package fr.fireowls.spaceowls.utils.hitbox.collidable;

/**
 * Interface qui répertories les règles de base
 * pour gérer les contact entre objets
 */
public interface Collidable {

	/**
	 * Calcule si il y a un contact entre deux object Collidable.
	 * @param other l'objet potentiellement en conflit
	 * @return true si ils sont en conflit
	 */
	public boolean conflict(Collidable other);

	/**
	 * Est appelé Temps qu'un autre objet Collidable est en contact avec l'objet courrant.
	 * @param other l'autre objet Collidable
	 */
	public void onContact(Collidable other);

	/**
	 * Est appelé quand un autre objet Collidable entre en contact avec l'objet courrant.
	 * @param other l'autre objet Collidable
	 */
	public void onEnter(Collidable other);

	/**
	 * Est appelé quand un autre objet Collidable n'est plus en contact avec l'objet courrant.
	 * @param other l'autre objet Collidable
	 */
	public void onExit(Collidable other);

	/**
	 * Vérifie si l'objet courrant est en contact avec au moins un autre objet Collidable.
	 * @return true si il est en contact avec un autre objet Collidable
	 */
	public boolean isInContact();

	/**
	 * Vérifie si il y a un contact entre deux object Collidable.
	 * @param other l'objet potentiellement en conflit
	 * @return true si ils sont en conflit et que la methode onEnter() a était invoqué pour les deux objets en conflits
	 */
	public boolean isInContact(Collidable other);
}
