package Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Shooter extends Sprite {
//	private static final float FIRESPEED = 0.2f;
	private static final float MOVESPEED = 0.1f;
	private static final int SCORE = 20;
	private static final int SPAWNCHANCE = 77;
	private static final int SPAWNGAP = 37;
	private static final int SHOOTERLIMIT = 7; //Limit to the number of shooter's on the screen at one time
	
	private static int random = 0;
	private static int shooterCount = 0; 
	private static int spawnDelay = 0;
	
	private int dir;
	private int moveTime;
	private int moveRandom;
	private int delta;
	private int spawnImmunity;
//	private Image left, right, down, back;
	
	public Shooter(float x, float y) throws SlickException {
		super();
		shooterCount++;
		spawnImmunity = 500;
		moveTime = 0;
		delta = 0; 
		moveRandom = 0;
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
		this.delta = delta;
		if (spawnImmunity > 0) {
			spawnImmunity -= delta;
		}
		if (getAlive()) {
			movePattern();
		} 
	}
	
	public static void spawn(int delta) throws SlickException {
		random = (int)(Math.random()*(16 * SPAWNCHANCE));
		if (spawnDelay > 0) {
			spawnDelay -= delta;
		} else if (Shooter.getCount() < SHOOTERLIMIT && random % SPAWNCHANCE == 0) {
			getWorld().addObject(new Shooter(((int)random/SPAWNCHANCE) * SPAWNGAP, 0));
			spawnDelay = 1000; //This ensures that there is at least a 1 second time-gap between each Shooter spawned.
		}
	}
	
	public void movePattern() {
		setV(0, 0);
		if (moveTime <= 0) {
			moveRandom = (int)(Math.random() * 15) + 1;
			switch (moveRandom) {
				case 1 : case 15 :
					dir = 1;
					break;
				case 2: case 3: case 4: case 5: 
					dir = 3;
					break;
				case 6: case 7: case 8: 
					dir = 2;
					break;
				case 9: case 10: case 11:
					dir = 4;
					break;
				case 12: case 13: case 14: 
					dir = 0;
			}
			moveTime = 1000;
		} else {
			moveTime-= delta;
		}
		
		
		if (dir == 1) {
			setV(getV().x, -MOVESPEED * delta);
		}
		if (dir == 3 || getPos().y < getHeight() / 2) {
			setV(getV().x, MOVESPEED * delta);
		}
		if (dir == 4 || getPos().x > 592 - getWidth() / 2) {
			setV(-MOVESPEED * delta, getV().y);
		}
		if (dir == 2 || getPos().x < getWidth() / 2) {
			setV(MOVESPEED * delta, getV().y);
		}
		
		if (getPos().y > 700 - getHeight() / 2) {
			getWorld().removeObject(this);
		}
		
		changeX(getV().x);
		changeY(getV().y);
	}
	
	public void collideMove(Vector2f collideV, boolean alive) {
		getV().sub(collideV);
		getV().set(getV().x*-1, getV().y*-1);
		
		changeX(getV().x);
		changeY(getV().y);
	}
	
	
	public void death() throws SlickException {
		if (spawnImmunity <= 0) {
			deathAnimation();
			setAlive(false);
			random = (int)(Math.random() * 20) + 1;
			if (random == 9) {
				getWorld().addObject(new PowerHealth(getPos()));
			} else if (random / 5 == 0) {
				getWorld().addObject(new PowerMoney(getPos()));
			}
			
			
			shooterCount--;
			getWorld().getScoreBoard().addScore(SCORE);
		}
	}
	
	public static int getCount() {
		return shooterCount;
	}
	
}
