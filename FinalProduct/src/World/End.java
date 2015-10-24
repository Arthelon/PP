package World;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class End extends BasicGameState {
	
	private int screenX;
	private int screenY;
	
	private int score = 0;
	
	public End(int screenX, int screenY) {
		this.screenX = screenX;
		this.screenY = screenY;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		this.score = score;
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}
}
