import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;


public class Bucky extends Sprite {
	Image WorldMap;
	Animation bucky, left, right, up, down;
	private final float speed = 0.2f;
	private Vector2f pos;
	int[] duration = {200,200};
	
	public Bucky() throws SlickException {
		Image[] walkUp = {new Image("src/buckysBack.png"), new Image("src/buckysBack.png")};
		Image[] walkDown = {new Image("src/buckysFront.png"), new Image("src/buckysFront.png")};
		Image[] walkRight = {new Image("src/buckysRight.png"), new Image("src/buckysRight.png")};
		Image[] walkLeft = {new Image("src/buckysLeft.png"), new Image("src/buckysLeft.png")};
		WorldMap = new Image("world.png");
		
		pos = new Vector2f(0,0);
		
		up = new Animation(walkUp, duration, false); //Animation(imageArray, duration, auto-updating);
		down = new Animation(walkDown, duration, false);
		left = new Animation(walkLeft, duration, false);
		right = new Animation(walkRight, duration, false);
		
		bucky = right;
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		Input input = gc.getInput();
		if (input.isKeyDown(Input.KEY_UP)) {
			bucky = up;
			pos.y += delta * speed;
			if (pos.y > 305) {
				pos.y -= delta*speed;
			}
		} if (input.isKeyDown(Input.KEY_DOWN)) {
			bucky = down;
			pos.y -= delta * speed;
			if (pos.y < -460) {
				pos.y += delta*speed;
			}
		} if (input.isKeyDown(Input.KEY_LEFT)) {
			bucky = left;
			pos.x += delta * speed;
			if (pos.x > 400) {
				pos.x -= delta * speed;
			}
		} if (input.isKeyDown(Input.KEY_RIGHT)) {
			bucky = right;
			pos.x -= delta * speed;
			if (pos.x < -760) {
				pos.x += delta * speed;
			}
		}
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		
		WorldMap.draw(pos.x, pos.y);
		bucky.draw(400, 300); 
	}
	public Vector2f getPos() {
		return pos;
	}

}
