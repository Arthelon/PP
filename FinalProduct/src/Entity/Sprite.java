package Entity;

import java.util.ArrayList;
import java.util.HashMap;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Sprite extends GameObject {
	private HashMap<String, Animation> animation = new HashMap<String, Animation>();
	private Animation currentAnimation;
	
	public Sprite() throws SlickException {
		currentAnimation = null;
	}

	
	@Override
	public void render(GameContainer gc, Graphics g) {
		currentAnimation.draw(getPos().x-(getWidth()/2), getPos().y-(getHeight()/2));
		if (currentAnimation.isStopped()) {
			getWorld().removeObject(this);
		}
	}
	
	public boolean collide(Vector2f pos) {
		return ((pos.x >= getPos().x - getWidth()/2 && pos.x <= getPos().x + getWidth()/2) && 
				(pos.y >= getPos().y - getHeight()/2 && pos.y <= getPos().y + getHeight()/2));
	}
	
	public void addAnimation(Image[] img, int duration, String key) {
		animation.put(key, new Animation(img, duration, true));
	}
	
	
	public void setAnimation(String key) {
		currentAnimation = animation.get(key);
	}
	
	public void death() {
		
	}
	
	public void deathAnimation() {
		currentAnimation = animation.get("death");
		currentAnimation.setLooping(false);
	}
	
	public void collideMove(int collideList) {

	}
	
	public Animation getAnimation() {
		return currentAnimation;
	}
}
