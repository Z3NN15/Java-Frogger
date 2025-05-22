
package obstacles;


import java.awt.Graphics2D;
import game.GameComponent;
import player.AbstractPlayer;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;


public class Log extends AbstractObstacle{
	private static final BufferedImage LOG_IMAGE;
	
	static {
		try {
			LOG_IMAGE = ImageIO.read(new File("src/Images/8-bit log.png"));
		} catch (IOException e) {
			throw new RuntimeException("Failed to load log image", e);
		}
	}
	
	public Log(GameComponent gc, double scaleFactor, double x, double y, double speed) {
		super(gc, scaleFactor, x, y, LOG_IMAGE.getWidth(), LOG_IMAGE.getHeight(), speed);
		
		this.x = x;
		this.y = y;
		this.speed = speed;
		
		this.offScreen = false;
	}
	
	@Override
	public void collideWithPlayer(AbstractPlayer frog) {
		// Check if the frog is on the log
		if (frog.getX() < x + WIDTH && frog.getX() + frog.getWidth() > x && 
			frog.getY() < y + HEIGHT && frog.getY() + frog.getHeight() > y) {
			// Move the frog with the log
			frog.update(speed, 0);
		}
	}

	@Override
	public void drawOn(Graphics2D g2d) {
		g2d.drawImage(LOG_IMAGE, (int) x, (int) y, null);
	}
	
}

