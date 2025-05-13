package game;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;


public abstract class GameObject {
	private double x, y;
	private double dy;
	private double dx; 
	private double width;
	private double height;
	private boolean removeObstacle;
	protected GameComponent gc;
	
	public GameObject(GameComponent component, double x, double y, double dx, double dy, double width, double height) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.gc = component;
	}
	
	public abstract void onRemove();
	public abstract void drawOn(Graphics2D g2d);
	
	public void update() {
		this.x += this.dx;
		this.y += this.dy;
	}
	
	public boolean removeObstacle() {
		return this.removeObstacle;
	}
	
	public void markToRemove() {
		this.removeObstacle = true;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public Rectangle2D.Double getHitBox() {
		return new Rectangle2D.Double(this.x, this.y, getWidth(), getHeight());
	}
	
	public boolean overlaps(GameObject other) {
		return getHitBox().intersects(other.getHitBox());
	}
	
	
	public boolean isOffScreen() {
		boolean x1 = x < 0;
		boolean x2 = x + GameMain.WINDOW_WIDTH > gc.getWidth();
		boolean y1 = y < 0;
		boolean y2 = y + GameMain.WINDOW_HEIGHT > gc.getHeight();
		
		return x1 || x2 || y1 || y2;
	}
	
	
	
	
	public abstract void collideWithPlayer(AbstractPlayer frog);

}
