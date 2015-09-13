package Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Player extends Sprite {
	private final float MOVESPEED = 0.3f;
	
	public Player() throws SlickException {
		Image defaultPos = new Image("res/images/player/player1.png");
		setImage(defaultPos);
		setPos(300, 600);
		
		Image[] walk = {defaultPos, new Image("res/images/player/player2.png"), defaultPos, new Image("res/images/player/player3.png")};
		addAnimation(walk, 200, "walk");
		Image[] death = {new Image("res/images/player/death1.png"), new Image("res/images/player/death2.png")};
		
		setAnimation("walk");
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		playerMove(gc, delta);
	}
	
	public void playerMove(GameContainer gc, int delta) {
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_UP)) {
			changeY(-MOVESPEED * delta);
		}
		if (input.isKeyDown(Input.KEY_DOWN)) {
			changeY(MOVESPEED * delta);
		}
		if (input.isKeyDown(Input.KEY_LEFT)) {
			changeX(-MOVESPEED * delta);
		}
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			changeX(MOVESPEED * delta);
		}
	}
	

}
