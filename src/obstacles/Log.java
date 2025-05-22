
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
			LOG_IMAGE = ImageIO.read(new File("src/Images/log.png"));
		} catch (IOException e) {
			throw new RuntimeException("Failed to load log image", e);
		}
	}
	
	public Log(GameComponent gc, double x, double y, double speed) {
		super(gc, x, y, LOG_IMAGE.getWidth(), LOG_IMAGE.getHeight(), speed);
		
		this.WIDTH = LOG_IMAGE.getWidth();
		this.HEIGHT = LOG_IMAGE.getHeight();
		this.x = x;
		this.y = y;
		this.speed = speed;
		
		this.offScreen = false;
	}
	
	@Override
	public void collideWithPlayer(AbstractPlayer frog) {
		frog.handleCollision(this);
	}

	@Override
	public void drawOn(Graphics2D g2d) {
		g2d.drawImage(LOG_IMAGE, (int) x, (int) y, null);
	}
	
}

