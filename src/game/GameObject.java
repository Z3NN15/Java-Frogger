package game;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;



public abstract class GameObject {
	protected double x, y;
	protected double dx, dy;
	protected double WIDTH = 0;
	protected double HEIGHT = 0;
	protected double scaleFactor = 1.0;
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
	public GameObject(GameComponent gc, double scaleFactor, double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.scaleFactor = scaleFactor;
		this.WIDTH = width * scaleFactor;
		this.HEIGHT = height * scaleFactor;
		this.gc = gc;
	}

	// Abstract method to draw them jawns on screen
	public abstract void drawOn(Graphics2D g2d);
	
	public double getScaleFactor() {
		return scaleFactor;
	}
	
	public void setScaleFactor(double scaleFactor) {
		this.scaleFactor = scaleFactor;
		WIDTH *= scaleFactor;
		HEIGHT *= scaleFactor;
	}
	
	protected abstract boolean isRemoved();
	
	protected abstract void markToRemove();
	
	// A bunch of getters
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getWidth() {
		return this.WIDTH;
	}
	
	public double getHeight() {
		return this.HEIGHT;
	}
	
	public Rectangle2D.Double getHitBox() {
		return new Rectangle2D.Double(this.x, this.y, getWidth(), getHeight());
	}
	
	public boolean overlaps(GameObject other) {
		return getHitBox().intersects(other.getHitBox());
	}
	
	
	public boolean isOffScreen() {
		boolean x1 = x + getWidth() < 0;
		boolean x2 = x > gc.getWidth();
		boolean y1 = y < 0;
		boolean y2 = y > gc.getHeight();
		
		return x1 || x2 || y1 || y2;
	}

}
