package Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Bullet extends GameObject {
	private float speed;
	private int time;
	private int limit;
	
	public Bullet(Vector2f pos, float rot, float speed, int limit) throws SlickException {
		super();
		setImage(new Image("res/images/bullet.png"));
		setPos(pos.x - getWidth()/2, pos.y - getHeight()/2);
		setRot(rot);
		time = 0;
		this.speed = speed;
		this.limit = limit;
	}
	public Bullet(float x, float y, float rot, float speed, int limit) throws SlickException {
		this(new Vector2f(x, y), rot, speed, limit);
	}
	
	@Override
	public void update(GameContainer gc, int delta) {
		float moveX = (float) Math.cos(Math.toRadians(getRot() - 90));
		float moveY = (float) Math.sin(Math.toRadians(getRot() - 90));
		changeX(moveX * delta * speed);
		changeY(moveY * delta * speed);
		
		time += delta;
		if (time >= limit) {
			getWorld().removeObject(this);
		}
	}
	
	public boolean getImmune() {
		if (time <= 100) return true;
		return false;
	}

}
