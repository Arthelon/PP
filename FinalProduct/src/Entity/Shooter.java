package Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Shooter extends Sprite {
	private static final float FIRESPEED = 0.2f;
	private static final float MOVESPEED = 0.2f;
	
	private Image left, right, down, back;
	private static int shooterCount = 0; 
	
	public Shooter(float x, float y) throws SlickException {
		super();
		shooterCount++;
//		Image left = new Image("res/images/shooter/shootLeft.png");
//		Image right = new Image("res/images/shooter/shootRight.png");
//		Image back = new Image("res/images/shooter/shooterBack.png");
		Image down = new Image("res/images/shooter/shooter.png");
		
		Image[] shootDown = {down, new Image("res/images/shooter/shooter1.png"), down, new Image("res/images/shooter/shooter2.png")};
		Image[] death = {new Image("res/images/shooter/shooterDeath.png")};
		
		addAnimation(death, 600, "death");
		addAnimation(shootDown, 200, "shootDown");
		
		setAnimation("shootDown");
		
		setImage(down);
		setPos(x + getWidth()/2, y + getHeight()/2);
	}
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		movePattern(delta);
	}
	
	public void movePattern(int delta) {
		
	}
	
	public void death() {
		deathAnimation();
		shooterCount--;
	}
	
	public static int getCount() {
		return shooterCount;
	}
	
}
