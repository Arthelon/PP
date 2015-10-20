package Entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Vector2f;

public class PowerMoney extends PowerUp {
	
	private Sound powerSound = new Sound("res/sound/powerUp.wav");
	
	public PowerMoney(Vector2f pos) throws SlickException {
		super();
		setPos(pos.x, pos.y);
		setImage(new Image("res/images/powerMoney.png"));
	}
	public void activate() {
		if (!getActive()) {
			powerSound.play();
			getWorld().getScoreBoard().addScore(50);
			setActive(true);
		}
	}
	
}
