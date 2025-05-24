package main;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;



public abstract class GameObject {
	protected double x, y;
	protected BufferedImage src;
	
	/**
	 * Constructor for the GameObject class
	 * 
	 * @param image Image used for the object (Frog, Car, Log, etc.)
	 * @param x initial horizontal position of the image
	 * @param y initial vertical position of the image
	 */
	public GameObject(BufferedImage image, double x, double y) {
		src = image;
		this.x = x;
		this.y = y;
	}
	

	// Image jawn methods to draw them jawns on screen
	public void drawOn(Graphics2D g2d) {
		g2d.drawImage(src, (int) x, (int) y, null);
		drawHitBox(g2d);
	}
	
	public abstract Rectangle2D.Double getHitBox();
	
	public boolean overlaps(GameObject other) {
		return this.getHitBox().intersects(other.getHitBox());
	}
	
	public void drawHitBox(Graphics2D g2d) {
		Rectangle2D.Double hitBox = this.getHitBox();
		g2d.setColor(java.awt.Color.RED);
		g2d.draw(hitBox);
	}
	
	
	public boolean isOffScreen() {
		boolean x1 = x + src.getWidth() < 0;
		boolean x2 = x > GameMain.WINDOW_WIDTH;
		boolean y1 = y < 0;
		boolean y2 = y > GameMain.WINDOW_HEIGHT;
		
		return x1 || x2 || y1 || y2;
	}

}
