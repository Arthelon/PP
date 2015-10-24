package Entity;


import java.util.HashMap;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Sprite extends GameObject {
	
	//HashMap data structure holding Sprite animations ; Stores String keys that corresponds to different Animation Objects
	private HashMap<String, Animation> animation = new HashMap<String, Animation>(); 
	private Animation currentAnimation;
	private boolean alive = true;
	
	public Sprite() throws SlickException {
		currentAnimation = null;
	}

	
	@Override
	public void render(GameContainer gc, Graphics g) {
		currentAnimation.draw(getPos().x-(getWidth()/2), getPos().y-(getHeight()/2)); 
		//Removes Sprite from Game if it's animation stops
		if (currentAnimation.isStopped()) {
			getWorld().removeObject(this);
		}
	}
	
	public void addAnimation(Image[] img, int duration, String key) {
		animation.put(key, new Animation(img, duration, true));
	}
	
	
	public Animation getAnimation() {
		return currentAnimation;
	}
	
	
	public void setAnimation(String key) {
		currentAnimation = animation.get(key);
		setImage(currentAnimation.getCurrentFrame());
	}
	
	public void death() throws SlickException {
		
	}
	
	public void deathAnimation() {
		currentAnimation = animation.get("death");
		currentAnimation.setLooping(false);
	}
	//Make Immune unique to Player
	//
	public void collideMove(Vector2f collideList) {

	}
	
	public boolean getAlive() {
		return alive;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}
