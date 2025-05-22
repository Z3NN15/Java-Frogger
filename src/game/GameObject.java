package game;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;



public abstract class GameObject {
	protected double x, y;
	protected double dx, dy;
	protected static double WIDTH = 0;
	protected static double HEIGHT = 0;
	protected double scaleFactor = 1.0;
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
	public GameObject(GameComponent gc, double scaleFactor, double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.scaleFactor = scaleFactor;
		WIDTH = width * scaleFactor;
		HEIGHT = height * scaleFactor;
		this.gc = gc;
	}

	// draw them jawns on screen
	public abstract void drawOn(Graphics2D g2d);
	
	public double getScaleFactor() {
		return scaleFactor;
	}
	
	public void setScaleFactor(double scaleFactor) {
		this.scaleFactor = scaleFactor;
		WIDTH *= scaleFactor;
		HEIGHT *= scaleFactor;
	}
	
	public abstract void onRemove();
	
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
	
	public static double getWidth() {
		return WIDTH;
	}
	
	public double getHeight() {
		return HEIGHT;
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
