package fr.fireowls.spaceowls.system;

import java.util.ArrayList;
import java.util.List;

import fr.fireowls.spaceowls.system.corp.Corp;
import fr.fireowls.spaceowls.system.corp.CorpType;
import fr.fireowls.spaceowls.system.corp.ShipCorp;
import fr.fireowls.spaceowls.utils.Updatable;
import fr.fireowls.spaceowls.utils.hitbox.HitBoxManager;
import javafx.scene.canvas.Canvas;

/**
 * Classe qui gere le systeme planetaire
 * @author bankaerb
 *
 */
public class SpaceSystem implements Updatable{
	
	public static double g;
	public static double dt;
	public static double fa;
	public static double rayon;
	private List<Corp> corps;
	private HitBoxManager hitboxManager;

	/**
	 * Créer un systeme avec cles parametre preciser
	 * @param g est la constante de gravite du systeme
	 * @param dt est la variation de temps de la simulation
	 * @param fa est le facteur d'acceleration de la simulation
	 * @param rayon est le rayon du systeme
	 */
	public SpaceSystem(double gr,double dt, double Fa, double rayon,List<Corp> element) {
		g = gr;
		this.dt = dt;
		fa = Fa;
		this.rayon = rayon;
		this.corps = element;

		hitboxManager = new HitBoxManager();
	}

	public SpaceSystem(double g,double dt, double fa, double rayon) {
		this(g, dt, fa, rayon, new ArrayList<>());
	}
	
	
	/**
	 * 
	 * @return la valeur de G
	 */
	public double getG() {
		return g;
	}

	/**
	 * Change la valeur de g par la valeur passee en parametre
	 * @param g est la nouvelle valeur de G
	 */
	public void setG(double gr) {
		g = gr;
	}

	/**
	 * 
	 * @return la valeur du pas de temps
	 */
	public double getDt() {
		return dt;
	}

	/**
	 * Change la valeur de pas de temps par celle passee en parametre
	 * @param dt est le nouveau pas de temps
	 */
	public void setDt(double dt) {
		this.dt = dt;
	}

	/**
	 * 
	 * @return la valeur du facteur d'acceleration
	 */
	public double getFa() {
		return fa;
	}

	/**
	 * Change le facteur d'acceleration par celle passee en parametre
	 * @param fa est le nouveau facteur d'acceleration
	 */
	public void setFa(double Fa) {
		fa = Fa;
	}

	/**
	 * 
	 * @return la valeur du rayon du systeme
	 */
	public double getRayon() {
		return rayon;
	}

	/**
	 * Change la valeur du rayon par celle passee en parametre
	 * @param rayon est la nouvelle valeur du rayon
	 */
	public void setRayon(double rayon) {
		this.rayon = rayon;
	}


	public List<Corp> getCorps() {
		return corps;
	}


	public void setCorps(List<Corp> corps) {
		this.corps = corps;
	}
	
	public void addCorp(Corp...corp) {
		for (Corp c : corp) {
			this.corps.add(c);
			if (c.getHitBox() != null)
				hitboxManager.add(c.getHitBox());
		}
	}

	public void removeCorp(Corp...corp) {
		for (Corp c : corp) {
			this.corps.remove(c);
			hitboxManager.remove(c.getHitBox());
		}
	}

	@Override
	public void create() {
		for(Corp c : this.corps) {
			c.create();
		}
		hitboxManager.create();
	}


	@Override
	public void update(double delta) {
		for(Corp c : this.corps) {
			c.update(delta);
		}
		//hitboxManager.update(delta);
	}


	@Override
	public void render(Canvas canvas) {
		for(Corp c : this.corps) {
			c.render(canvas);
		}
		//hitboxManager.render(canvas);
	}


	@Override
	public void dispose() {
		for(Corp c : this.corps) {
			c.dispose();
		}
		hitboxManager.dispose();
	}

	public HitBoxManager getHitBoxManager() {
		return hitboxManager;
	}
	
	public ShipCorp getShip() {
		for (Corp c : corps) {
			if (c.getType() == CorpType.VAISSEAU) {
				return (ShipCorp) c;
			}
		}
		return null;
	}
}
