package Entity;

import java.util.HashMap;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Sprite extends gameObject {
	private HashMap<String, Animation> animation = new HashMap<String, Animation>();
	private Animation currentAnimation;
	
	public Sprite() throws SlickException {
		currentAnimation = null;
	}
	
	public void addAnimation(Image[] img, int duration, String key) {
		animation.put(key, new Animation(img, duration, true));
	}
	
	public void setAnimation(String key) {
		currentAnimation = animation.get(key);
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		currentAnimation.draw(getPos().x-(getWidth()/2), getPos().y-(getHeight()/2));
	}

}
