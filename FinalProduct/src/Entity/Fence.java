package Entity;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Fence extends Sprite {
	private static Random randomGen = new Random();
	private static int delay = 0;
	
	public Fence(int x, int y) throws SlickException {
		super();
		setPos(x, y);
		Image[] defaultAnimation = {new Image("res/images/fence.png")};
		addAnimation(defaultAnimation, 10000, "default");
		
		setAnimation("default");
		
	}
	
	public static void spawn(int delta) throws SlickException {
		if (delay > 0) {
			delay -= delta;
		} else if (!isMapStopped()){
			int random = randomGen.nextInt(60);
			if (random <= 15) {
				getWorld().addObject(new Fence(random * 48, -8));
			}
			delay = 1000;
		}
	}
	
	public void update(GameContainer gc, int delta) {
		setV(0, 0);
		if (!isMapStopped()) {
			setV(0, MAPSPEED * delta);
			changeY(getV().y);
		} 
		
		if (getPos().y > 700 + getHeight()/2) {
			getWorld().removeObject(this);
		}
	}
	
	@Override
	public void collideMove(Vector2f collideV) {
		
	}
}
