package game;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;



public abstract class GameObject {
	protected double x, y;
	protected double dx, dy;
	protected final double width, height;
	private boolean removed;
	protected final GameComponent gc;
	
	/**
	 * 
	 * @param gc
	 * @param x
	 * @param y
	 * @param dx
	 * @param dy
	 * @param width
	 * @param height
	 */
	public GameObject(GameComponent gc, double x, double y, double width, double height, double dy, double dx) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.width = width;
		this.height = height;
		this.gc = gc;
	}
	
	// draw them jawns on screen
	public abstract void drawOn(Graphics2D g2d);
	
	
	public abstract void onRemove();
	
	public void update() {
		x += this.dx;
		y += this.dy;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
	public void markRemoved() {
		removed = true;
	}
	
	// A bunch of getters
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public Rectangle2D.Double getHitBox() {
		return new Rectangle2D.Double(this.x, this.y, getWidth(), getHeight());
	}
	
	public boolean overlaps(GameObject other) {
		return getHitBox().intersects(other.getHitBox());
	}
	
	
	public boolean isOffScreen() {
		boolean x1 = x < 0;
		boolean x2 = x > gc.getWidth();
		boolean y1 = y < 0;
		boolean y2 = y > gc.getHeight();
		
		return x1 || x2 || y1 || y2;
	}

}
