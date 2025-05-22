
package player;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

import game.GameComponent;
import obstacles.AbstractObstacle;
import obstacles.Log;
import obstacles.Car;
import obstacles.Terrain;
import player.Fly;

/**
 * 
 * @author Ayden Snedigar
 *	TODO: Add logic to make sure frog can't go off screen
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
	 * @param gc The game component you want the frog to be drawn on
	 * @param scaleFactor modifier for the size of the image
	 * @param x The starting x position of the frog
	 * @param y The starting y position of the frog
	 */
	public Frog(GameComponent gc, double scaleFactor, double x, double y) {
		super(gc, scaleFactor, x, y, FROG_IMAGE.getWidth(), FROG_IMAGE.getHeight());
		this.startX = x;
		this.startY = y;
		this.deathFlag = false;
		this.scaleFactor = scaleFactor;
	}

	@Override
	public void drawOn(Graphics2D g2d) {
		g2d.drawImage(FROG_IMAGE, (int) x, (int) y, (int) WIDTH, (int) HEIGHT, null);
	}

	@Override
	public void addFly() {
		// TODO implement this method
//		this.flyCount++;
	}

	@Override
	public void removeFly() {
		// TODO implement this method
//		if (this.flyCount > 0) {
//			this.flyCount--;
//		}
	}

	@Override
	public void handleCollision(AbstractObstacle o) {

		if (o instanceof Log) {
			this.x += o.getSpeed();
			if (this.x < o.getX() || this.x + WIDTH > o.getX() + AbstractObstacle.getWidth()) {
				this.deathFlag = true;
			}
		} else if (o instanceof Car) {
			this.deathFlag = handleDeath(true);
		} else if (o instanceof Terrain) {
			this.deathFlag = handleDeath(true);
		}

	}

	private void playSoundEffect() {
		// Play sound effect when the player dies
		try {
			AudioInputStream a = AudioSystem.getAudioInputStream(new File("src/Audio/alarm_clock.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(a);
			clip.start();

		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Caught " + e.getMessage());
		}

	}// playSoundEffect

	public boolean handleEat(Fly fly) {
		// Changed to inherited x instead of local x
		return fly.getX() == x;
	}// handleEat

	public boolean handleDeath(boolean isHit) {
		if (isHit) {
			playSoundEffect();
			this.x = startX;
			this.y = startY;
			return true;
		}
		return false;
	}// handleDeath

	@Override
	public void onRemove() {
		// TODO Auto-generated method stub
		
	}

}
