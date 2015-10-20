package Entity;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Fence extends GameObject {
	private static Random randomGen = new Random();
	private static int delay = 0;
	private static final float SPEED = 0.05f;
	
	public Fence(int x, int y) throws SlickException {
		super();
		setPos(x, y);
		setImage(new Image("res/images/fence.png"));
	}
	
	public static void spawn(int delta) throws SlickException {
		if (delay > 0) {
			delay -= delta;
		} else {
			int random = randomGen.nextInt(60);
			if (random <= 11) {
				getWorld().addObject(new Fence(random * 48, -8));
			}
			delay = 1000;
		}
	}
	
	public void update(GameContainer gc, int delta) {
		setV(0, SPEED * delta);
		changeY(getV().y);
		
		if (getPos().y > 700 + getHeight()/2) {
			getWorld().removeObject(this);
		}
	}
}
