package World;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Entity.Bullet;
import Entity.GameObject;
import Entity.HealthBar;
import Entity.Player;
import Entity.ScoreBoard;
import Entity.Shooter;
import Entity.Sprite;

public class Game extends BasicGameState {
	
	private int screenX;
	private int screenY;
	private Music backMusic;
	private boolean first = false;
	private boolean end = false;
	private int mapY;
	private final float MAPSPEED = 0.0005f;
	
	
	private ArrayList<GameObject> objectList = new ArrayList<GameObject>();
	private ArrayList<GameObject> addList = new ArrayList<GameObject>();
	private ArrayList<GameObject> removeList = new ArrayList<GameObject>();
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	private ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	
	private Player player;
	private ScoreBoard scoreboard;
	private HealthBar healthbar;
	
	private Image map;
	
	public Game(int screenX, int screenY) {
		this.screenX = screenX;
		this.screenY = screenY;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
//		backMusic = new Music("res/sound/levelTheme.ogg");
		if (first) {
//			backMusic.loop();
			player = new Player();
			scoreboard = new ScoreBoard();
			healthbar = new HealthBar();
			addObject(player);
			addObject(scoreboard);
			addObject(healthbar);
			
			map = new Image("res/images/startMap.png");
			mapY = -(map.getHeight() - screenY);
		}
		first = true;
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		map.draw(0, mapY);
		for (GameObject object : objectList) {
			object.render(gc, g);
		}
		g.drawString("" + player.getPos(), 200, 0);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Shooter.spawn(delta);
		updateObjects(gc, delta);
		if (end) {
			sbg.getState(2).init(gc, sbg);
			sbg.enterState(2);
		}
	}
	
	public void updateObjects(GameContainer gc, int delta) throws SlickException {
		for (GameObject object : objectList) {
			object.update(gc, delta);
			if (object instanceof Sprite) {
				sprites.add((Sprite)object);
			}
			if (object instanceof Bullet) {
				bullets.add((Bullet)object);
			}
		}
		for (Sprite sprite : sprites) {
			spriteCheck((Sprite)sprite);
		}
		for (GameObject object : addList) {
			objectList.add(object);
		}
		for (GameObject object : removeList) {
			objectList.remove(object);
		}
		mapY += delta * MAPSPEED;
		
		sprites.clear();
		bullets.clear();
		addList.clear();
		removeList.clear();
	}
	
	public void addObject(GameObject object) {
		addList.add(object);
		object.setWorld(this);
	}
	
	public void removeObject(GameObject object) {
		removeList.add(object);
	}
	
	public ScoreBoard getScoreBoard() {
		return scoreboard;
	}
	
	public HealthBar getHealthBar() {
		return healthbar;
	}
	
	
	public void spriteCheck(Sprite sprite) {
		for (Bullet bullet : bullets) {
			if (!bullet.getImmune() && sprite.collide(bullet.getPos())) {
				sprite.death();
				removeObject(bullet);
			}
		}
		for (Sprite newSprite : sprites) {
			if (sprite == newSprite) {
				continue;
			}
			sprite.collideMove(sprite.getCollide(newSprite));
		}
	}
	
	public void endGame() {
		end = true;
	}

	@Override
	public int getID() {
		return 1;
	}

}
