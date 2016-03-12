package Entity;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Bomber extends Sprite implements Enemy {
	private static final int BOMBERLIMIT = 2;
	private static final int SCORE = 40;
	private static final float MOVESPEED = 0.1f;
	
	private static int bomberCount = 0;
	private static int spawnDelay = 0;
	private static Random randomGen = new Random();
	
	private int spawnImmunity = 500;
	private int bombDelay = 0;
	private int moveTime = 0;
	private int moveRandom = 0;
	private int delta = 0;
	private int dir = 0;
	private boolean bombPlaced = false;
	
	public Bomber(float x, float y) throws SlickException {
		super();
		bomberCount++;
		
		Image death = new Image("res/images/bomber/BomberDeath.png");
		Image walk = new Image("res/images/bomber/Bomber.png");
		Image active = new Image("res/images/bomber/BomberActive.png");
		
		Image[] bomberWalk = {walk, new Image("res/images/bomber/Bomber1.png"), walk, new Image("res/images/bomber/Bomber2.png")};
		Image[] bomberActive = {active, new Image("res/images/bomber/BomberActive1.png"), active, new Image("res/images/bomber/BomberActive2.png")};
		Image[] bomberDeath = {death};
		Image[] still = {walk};
		
		addAnimation(bomberWalk, 200, "walk");
		addAnimation(bomberActive, 200, "active");
		addAnimation(bomberDeath, 600, "death");
		addAnimation(still, 10, "still");
		
		setAnimation("walk");
		setImage(walk);
		setPos(x, y);
	}
	//Static Methods
	public static void spawn(int delta) throws SlickException {
		if (spawnDelay <= 0 && bomberCount < BOMBERLIMIT && !isMapStopped()) {
			int random = randomGen.nextInt(25);
			if (random <= 11) {
				getWorld().addObject(new Bomber(random * 50,-25));
			}
			spawnDelay = 1000;
		} else {
			spawnDelay -= delta;
		}
	}
	
	public static int getCount() {
		return bomberCount;
	}
	//Instance Methods
	public void update(GameContainer gc, int delta) throws SlickException {
		this.delta = delta;
		if (spawnImmunity > 0) {
			spawnImmunity -= delta;
		}
		if (getAlive()) {
			if (bombPlaced) {
				setAnimation("active");
			} else if (!isMapStopped() || getV().x != 0 && getV().y != 0){
				setAnimation("walk");
			} else {
				setAnimation("still");
			}
			moveBomber();
			placeBomb();
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
	
	public void moveBomber() {
		if (moveTime <= 0) {
			moveRandom = randomGen.nextInt(20) + 1;
			if (spawnImmunity > 0) {
				moveRandom = 3;
			}
			if (getPos().y + getHeight()/2 < 0) {
				moveRandom = randomGen.nextInt(10) + 1;
			}
			switch (moveRandom) {
				case  17: case 18: case 19: case 20:
					dir = 1;
					break;
				case 1: case 2: case 3: case 4: case 5: case 6: 
					dir = 3;
					break;
				case 7: case 9: case 11: case 13: case 15:
					dir = 2;
					break;
				case 8: case 10: case 12: case 14: case 16:
					dir = 4;
					break;
			}
			moveTime = 750;
		} else {
			moveTime -= delta;
		}
		
		setV(0, 0);
		if (dir == 1) {
			setV(getV().x, -MOVESPEED * delta);
		}
		if (dir == 3) {
			setV(getV().x, MOVESPEED * delta);
		}
		if (dir == 4) {
			setV(-MOVESPEED * delta, getV().y);
		}
		if (dir == 2) {
			setV(MOVESPEED * delta, getV().y);
		}
		
		if ((getV().x != 0 || getV().y != 0) && isMapStopped()) {
			setAnimation("walk");
		}
		
		if (getPos().x < getWidth() / 2) {
			changeX(MOVESPEED * delta);
		}
		if (getPos().x > 592 - getWidth() / 2) {
			changeX(-MOVESPEED * delta);
		}
		if (getPos().y > 700 + getHeight() / 2) {
			getWorld().removeObject(this);
			bomberCount--;
		}
		
		changeX(getV().x);
		changeY(getV().y);
	}
	
	public void placeBomb() throws SlickException {
		if (bombDelay <= 0) {
			bombPlaced = false;
			int random = randomGen.nextInt(9);
			if (random <= 1) {
				bombDelay = 2000;
				moveTime = 250;
				dir = 1;
				getWorld().addObject(new Bomb(getPos().x, getPos().y));
				bombPlaced = true;
			} else {
				bombDelay = 1000;
			}
		} else {
			bombDelay -= delta;
		}
		
	}
	
	public void death() throws SlickException {
		if (spawnImmunity <= 0) {
			deathAnimation();
			moveTime = 0;
			setAlive(false);
			bomberCount--;
			int random = randomGen.nextInt(30) + 1;
			if (random == 9) {
				getWorld().addObject(new PowerHealth(getPos()));
			} else if (random / 7 == 0) {
				getWorld().addObject(new PowerMoney(getPos()));
			}
			getWorld().getScoreBoard().addScore(SCORE);
		}
	}
}
