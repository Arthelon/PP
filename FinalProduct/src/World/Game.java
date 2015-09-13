package World;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Entity.Player;
import Entity.gameObject;

public class Game extends BasicGameState {
	
	private int screenX;
	private int screenY;
	private Music backMusic;
	private boolean first = false;
	private int mapY;
	private final float MAPSPEED = 0.0005f;
	
	
	private ArrayList<gameObject> objectList = new ArrayList<gameObject>();
	private Player player;
	
	private Image map;
	
	public Game(int screenX, int screenY) {
		this.screenX = screenX;
		this.screenY = screenY;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
//		backMusic = new Music("res/sound/levelTheme.ogg");
//		if (first) {
//			backMusic.loop();
//		} 
		player = new Player();
		addObject(player);
		first = true;
		map = new Image("res/images/startMap.png");
		mapY = -(map.getHeight() - screenY);
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		map.draw(0, mapY);
		for (gameObject object : objectList) {
			object.render(gc, sbg, g);
		}
		g.drawString("" + mapY, 0, 0);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		for (gameObject object : objectList) {
			object.update(gc, sbg, delta);
		}
		mapY += delta * MAPSPEED;
	}
	
	public void addObject(gameObject object) {
		objectList.add(object);
	}
	
	public void removeObject(gameObject object) {
		objectList.remove(object);
	}
	

	@Override
	public int getID() {
		return 1;
	}

}
