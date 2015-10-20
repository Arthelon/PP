package Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public class Bomb extends GameObject {
	
	private int time = 2000;
	public Bomb(float x, float y) throws SlickException {
		super();
		
		setPos(x, y + getHeight());
	}
	
	public void update(GameContainer gc, int delta) {
		time -= delta;
		if (time <= 0 && time > -1000) {
			//Flashy Image
			getWorld().bombActive(this);
		} 
		if (time <= 1000) {
			getWorld().removeObject(this);
		}
	}
}
