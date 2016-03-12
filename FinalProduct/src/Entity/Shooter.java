package Entity;

import static java.lang.Math.atan2;
import static java.lang.Math.toDegrees;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Shooter extends Sprite implements Enemy {
	private static final float SHOOTSPEED = 0.2f;
	private static final int SCORE = 20;
	private static final int SPAWNCHANCE = 77;
	private static final int SPAWNGAP = 37;
	private static final int SHOOTERLIMIT = 6; //Limit to the number of shooter's on the screen at one time
	private static final float MOVESPEED = 0.08f;
	
	private static int shooterCount = 0; 
	private static int spawnDelay = 0;
	private static Random randomGen = new Random();
	
	private int dir = 0;
	private int shootAngle = 0;
	private int moveTime = 0;
	private int moveRandom = 0;
	private int delta = 0;
	private int spawnImmunity = 500;
	private int shootDelay = 0;
	private Image left, right, down, back;
	
	public Shooter(float x, float y) throws SlickException {
		super();
		shooterCount++;
		left = new Image("res/images/shooter/shooterLeft.png");
		right = new Image("res/images/shooter/shooterRight.png");
		back = new Image("res/images/shooter/shooterBack.png");
		down = new Image("res/images/shooter/shooter.png");
		
		Image[] shootDown = {down, new Image("res/images/shooter/shooter1.png"), down, new Image("res/images/shooter/shooter2.png")};
		Image[] shootUp = {back, new Image("res/images/shooter/shooterBack1.png"), back, new Image("res/images/shooter/shooterBack2.png")};
		Image[] shootLeft = {left, new Image("res/images/shooter/shooterLeft1.png"), left, new Image("res/images/shooter/shooterLeft2.png")};
		Image[] shootRight = {right, new Image("res/images/shooter/shooterRight1.png"), right, new Image("res/images/shooter/shooterRight2.png")};
		Image[] death = {new Image("res/images/shooter/shooterDeath.png")};
		Image[] still = {down};
		
		addAnimation(shootDown, 200, "shootDown");
		addAnimation(shootUp, 200, "shootUp");
		addAnimation(shootLeft, 200, "shootLeft");
		addAnimation(shootRight, 200, "shootRight");
		addAnimation(death, 600, "death");
		addAnimation(still, 10, "still");
		
		setAnimation("shootDown");
		
		setImage(down);
		setPos(x, y);
	}
	
	public static void spawn(int delta) throws SlickException {
		int random = randomGen.nextInt(16*SPAWNCHANCE);
		if (spawnDelay > 0) {
			spawnDelay -= delta;
		} else if (Shooter.getCount() < SHOOTERLIMIT && random % SPAWNCHANCE == 0 && !isMapStopped()) {
			getWorld().addObject(new Shooter(((int)random/SPAWNCHANCE) * SPAWNGAP, -25));
			spawnDelay = 1000; //This ensures that there is at least a 1 second time-gap between each Shooter spawned.
		}
	}
	
	public static int getCount() {
		return shooterCount;
	}
	
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		this.delta = delta;
		if (spawnImmunity > 0) {
			spawnImmunity -= delta;
		}
		if (getAlive()) {
			moveShooter();
			shootPlayer();
		} else if(!isMapStopped()) {
			setV(0, MAPSPEED * delta);
			changeY(getV().y);
		}
		if (!getAlive()) {
			moveTime += delta;
			if (moveTime <= 50) {
				setV(0, -0.7f*delta);
				changeY(getV().y);
			}
		}
	}
	
	public void shootPlayer() throws SlickException {
		int random = randomGen.nextInt(10);
		float dX = getWorld().getPlayerPos().x - getPos().x;
		float dY = getWorld().getPlayerPos().y - getPos().y;
		
		if (shootDelay <= 0) {
			shootAngle = (int) toDegrees(atan2(dY,dX)) + 90;
			if (random <= 3) {
				Bullet bullet = new Bullet(getPos().x, getPos().y, shootAngle, SHOOTSPEED, 1300);
				bullet.setEnemyFired(true);
				getWorld().addObject(bullet);
			}
			shootDelay = 750;
		} else {
			shootDelay -= delta;
		}
		
		if (shootAngle >= 45 && shootAngle < 135) {
			setAnimation("shootRight");
		} else if (shootAngle >= 135 && shootAngle < 225) {
			setAnimation("shootDown");
		} else if (shootAngle >= 225 && shootAngle < 315) {
			setAnimation("shootLeft");
		} else {
			setAnimation("shootUp");
		}
	}
	
	public void moveShooter() {
		if (moveTime <= 0) {
			moveRandom = randomGen.nextInt(15) + 1;
			if (spawnImmunity > 0) {
				moveRandom = 3;
			}
			if (getPos().y + getHeight()/2 < 0) {
				moveRandom = 6;
			}
			switch (moveRandom) {
				case 11 : case 15 :
					dir = 1;
					break;
				case 1: case 2: case 3: case 4: 
					dir = 3;
					break;
				case 5: case 7: case 9: 
					dir = 2;
					break;
				case 6: case 8: case 10:
					dir = 4;
					break;
				case 12: case 13: case 14: 
					dir = 0;
			}
			moveTime = 1000;
		} else {
			moveTime-= delta;
		}
		
		setV(0, 0);
		if (dir == 1) {
			setV(0, -MOVESPEED * delta);
		}
		if (dir == 3) {
			setV(0, MOVESPEED * delta);
		}
		if (dir == 4) {
			setV(-MOVESPEED * delta, 0);
		}
		if (dir == 2) {
			setV(MOVESPEED * delta, 0);
		}
		
		if (getPos().x < getWidth() / 2) {
			changeX(MOVESPEED * delta);
		}
		if (getPos().x > 592 - getWidth() / 2) {
			changeX(-MOVESPEED * delta);
		}
		if (getPos().y > 700 + getHeight() / 2) {
			getWorld().removeObject(this);
			shooterCount--;
		}
		
		changeX(getV().x);
		changeY(getV().y);
	}
	
	
	public void death() throws SlickException {
		if (spawnImmunity <= 0) {
			deathAnimation();
			moveTime = 0;
			setAlive(false);
			int random = randomGen.nextInt(30) + 1;
			if (random == 9) {
				getWorld().addObject(new PowerHealth(getPos()));
			} else if (random / 7 == 0) {
				getWorld().addObject(new PowerMoney(getPos()));
			}
			
			shooterCount--;
			getWorld().getScoreBoard().addScore(SCORE);
		}
	}
}
