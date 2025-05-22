package player;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

import game.GameComponent;
import game.GameObject;

public abstract class AbstractPlayer extends GameObject {
	protected double dx, dy;
	public boolean isHit = false;

	public AbstractPlayer(GameComponent gc, double scaleFactor, double x, double y, double width, double height) {
		super(gc, scaleFactor, x, y, width, height);
	}

	public void update(double dx, double dy) {
		// Update the player's position based on dx and dy
		x += dx;
		y += dy;

	}
	
	@Override
	public boolean isRemoved() {
		//Do nothing
		return false;
	}
	
	@Override
	protected void markToRemove() {
		//Do nothing
	}

	// Abstract method for handling player/fly death
	public abstract void handleDeath();

	public void playSoundEffect(String filePath) {
		// Play sound effect when the player dies
		try {
			AudioInputStream a = AudioSystem.getAudioInputStream(new File(filePath));
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

	}

}
