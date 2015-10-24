package Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class PowerUp extends GameObject {
	private static final float MOVESPEED = 0.05f;
	
	public PowerUp() throws SlickException {
		super();
		// TODO Auto-generated constructor stub
	}

	private boolean activated = false;
	
	public void activate() {
		
	}
	
	public boolean getActive() {
		return activated;
	}
	
	public void setActive(boolean active) {
		activated = active;
	}
	
	public void update(GameContainer gc, int delta) {
		if (!isMapStopped()) {
			changeY(MOVESPEED * delta);
		}
	}
}
