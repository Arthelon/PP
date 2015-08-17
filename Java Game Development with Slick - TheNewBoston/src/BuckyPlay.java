import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class BuckyPlay extends BasicGameState {
	boolean quit = false;
	int[] duration = {200, 200};
	float mouseX;
	float mouseY;
	Vector2f origin;
	Vector2f mouse;
	boolean lineDraw = false;  
	Vector2f speedBullet = new Vector2f(200, 200);
	ArrayList<BuckyBullet> bullet;
	int clickNum = 0;
	Bucky bucky;
	public BuckyPlay (int state) {
		
	}
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		bullet = new ArrayList<BuckyBullet>();
		mouse = new Vector2f(0,0);
		bucky = new Bucky();
		
	}
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();
		mouseX = Mouse.getX();
		mouseY = 600-Mouse.getY();
		if (Mouse.isButtonDown(0)) {
			mouse.set(mouseX, mouseY);
			lineDraw = true;
			origin = new Vector2f(-1*bucky.getPos().x+400, -1*bucky.getPos().y+300);
			Vector2f dir = new Vector2f(mouse.x - 400, mouse.y - 300);
			bullet.add(new BuckyBullet(origin, dir));
		}
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			quit = true;
		}
		
		if (quit) {
			if (input.isKeyDown(Input.KEY_M)) {
				quit = false;
				sbg.enterState(0);
			}
			if (input.isKeyDown(Input.KEY_R)) {
				quit = false;
			}
			if (input.isKeyDown(Input.KEY_Q)) {
				gc.exit();
			}
		}
		for (BuckyBullet b : bullet) {
			if (b.isActive()) {
				b.update(delta);
//			} else if (!b.isActive()) {
//				bullet.remove(0);
			}
		}
		bucky.update(gc, sbg, delta);
	}
	public double getDirectionRad(Vector2f v1, Vector2f v0) {
		   return Math.atan2(v1.x - v0.x, v1.y - v0.y);
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g)
			throws SlickException {
		bucky.render(gc, arg1, g);
		g.drawString("X : "+ bucky.getPos().x +"\n"+"Y : " + bucky.getPos().y, 0, 0);
		if (lineDraw == true) {
			g.drawLine(400, 300, mouse.x, mouse.y);
		} 
		if (quit == true) {
			g.drawString("Resume (R)", 350, 100);
			g.drawString("Menu (M)", 350, 150);
			g.drawString("Quit (Q)", 350, 200);
			if(quit == false) {
				g.clear(); //Removes all graphics
			}
		}
		for (BuckyBullet b : bullet) {
			if (b.isActive()) {
				Vector2f shiftMap = new Vector2f(bucky.getPos().x, bucky.getPos().y);
				System.out.println(shiftMap);
				b.render(gc,g, shiftMap);
			}
		}
	}
	
	@Override
	public int getID() {
		return 1;
	}

}