package player;

import java.awt.geom.Rectangle2D;

import java.awt.image.BufferedImage;
import main.GameObject;

public abstract class AbstractPlayer extends GameObject {
	protected double dx = 0, dy = 0;
	public boolean isHit = false;

	public AbstractPlayer(BufferedImage image, double x, double y) {
		super(image, x, y);
	}

	public void update() {
		// Update the player's position based on dx and dy
//		System.out.println("Updating frog");
		x += dx;
		y += dy;

	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setMoveDelta(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	// Abstract method for handling player/fly death
	public abstract void handleDeath();
	
	@Override
	public Rectangle2D.Double getHitBox() {
		// Do nothing here
		return null;
	}
}
