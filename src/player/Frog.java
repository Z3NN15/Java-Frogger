
package player;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import game.GameComponent;

/**
 * 
 * @author Ayden Snedigar TODO: Add logic to make sure frog can't go off screen
 */

public class Frog extends AbstractPlayer {

	// Save spawn point for respawn on death
	private final double startX, startY;

	private static final BufferedImage FROG_IMAGE;

	static {
		try {
			FROG_IMAGE = ImageIO.read(new File("src/Images/frog-2.png"));
		} catch (IOException e) {
			throw new RuntimeException("Failed to load frog image", e);
		}
	}

	/**
	 * 
	 * @param gc          The game component you want the frog to be drawn on
	 * @param scaleFactor modifier for the size of the image
	 * @param x           The starting x position of the frog
	 * @param y           The starting y position of the frog
	 */
	public Frog(GameComponent gc, double scaleFactor, double x, double y) {
		super(gc, scaleFactor, x, y, FROG_IMAGE.getWidth(), FROG_IMAGE.getHeight());
		this.startX = x;
		this.startY = y;
		this.scaleFactor = scaleFactor;

		if (isHit) {
			handleDeath();
		}
	}

	@Override
	public void drawOn(Graphics2D g2d) {
		g2d.drawImage(FROG_IMAGE, (int) x, (int) y, (int) WIDTH, (int) HEIGHT, null);
	}

	public boolean handleEat(Fly fly) {
		// Changed to inherited x instead of local x
		return fly.getX() == x;
	}// handleEat

	public void handleDeath() {
		playSoundEffect("src/Audio/alarm_clock.wav");
		this.x = startX;
		this.y = startY;
	}// handleDeath

}
