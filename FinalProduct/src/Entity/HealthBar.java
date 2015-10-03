package Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class HealthBar extends GameObject {
	
	private int health;

	public HealthBar() throws SlickException {
		super();
		health = 2;
		setImage(new Image("res/images/health.png"));
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) {
		for (int i = 0; i < health; i++) {
			getImage().draw(20 + (40 * i), 650);
		}
	}
	
	public int getHealth() {
		return health;
	}
	
	public void changeHealth(int health) {
		this.health += health;
	}

}
