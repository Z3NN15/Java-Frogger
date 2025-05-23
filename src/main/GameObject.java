package main;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;



public abstract class GameObject {
	private double WIDTH, HEIGHT;
	protected double x, y;
	protected BufferedImage src;
	
	/**
	 * Constructor for the GameObject class
	 * 
	 * @param spriteImage Image to be drawn
	 * @param x horizontal position of the image
	 * @param y vertical position of the image
	 */
	public GameObject(BufferedImage image, double x, double y) {
		this.src = image;
		this.x = x;
		this.y = y;
		this.WIDTH = src.getWidth();
		this.HEIGHT = src.getHeight();
	}
	

	// Image jawn methods to draw them jawns on screen
	public void drawOn(Graphics2D g2d) {
		g2d.drawImage(src, (int) x, (int) y, null);
		this.drawHitBox(g2d);
	}
	
	// A bunch of getters
	public double getWidth() {
		return this.WIDTH;
	}
	
	public double getHeight() {
		return this.HEIGHT;
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
		boolean x1 = x + this.getWidth() < 0;
		boolean x2 = x > GameMain.WINDOW_WIDTH;
		boolean y1 = y < 0;
		boolean y2 = y > GameMain.WINDOW_HEIGHT;
		
		return x1 || x2 || y1 || y2;
	}

}
