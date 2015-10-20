package Entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Vector2f;
 
public class PowerHealth extends PowerUp {
	
	private Sound powerSound = new Sound("res/sound/powerUp.wav");
	
	public PowerHealth(Vector2f pos) throws SlickException {
		super();
		setPos(pos.x, pos.y);
		setImage(new Image("res/images/powerHeart.png"));
	}
	
	public void activate() {
		if (!getActive()) {
			powerSound.play();
			getWorld().getHealthBar().changeHealth(1);
			setActive(true);
		}
	}

}
