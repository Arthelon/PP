
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;


public class BuckyBullet extends Sprite {
	private Vector2f  pos; //position of bullet
	
	private static int maxLife = 2000; 
	private int lived;
	private boolean active;
	private boolean dontDraw;
	private Vector2f dir;
	
	public BuckyBullet (Vector2f origin, Vector2f dir) {
		this.pos  = origin;
		this.active = true;
		this.dontDraw = false;
		this.lived = 0;
		this.dir = dir;
	}
	public void update(int t) { //takes delta as parameter
		if (active) {
			// Translating the bullet's position:
			System.out.println(dir.getTheta());
			pos.x += t*0.2f * Math.cos(Math.toRadians(dir.getTheta())); 
			pos.y += t*0.2f * Math.sin(Math.toRadians(dir.getTheta()));
			lived += t;
			if (lived >= maxLife) {
				this.active = false;
			}
		}
	}
	public void disable() {
		dontDraw = true;
	}
	public void render(GameContainer gc, Graphics g, Vector2f change) {
		if (!dontDraw) {
			g.drawOval(pos.getX() - 10 + change.x, pos.getY() - 10 + change.y, 20, 20);
		}
	}
	public void setActive(boolean hi) {
		this.active = hi;
	}
	public boolean isActive() {
		return active;
	}
}
