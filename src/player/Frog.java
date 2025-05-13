package player;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JComponent;
import javax.swing.JFrame;

import game.GameObject;

public abstract class Frog extends AbstractPlayer {
	private BufferedImage frog;
	private int WIDTH;
	private int HEIGHT;
	private int speed;

	private Clip deathSound;
	private Clip moveSound;
	private boolean deathFlag;

	public Frog() {
		WIDTH = frog.getWidth();
		HEIGHT = frog.getHeight();
	}

	public boolean hitbox(int HEGHT, int WIDTH) {
		return deathFlag;

	}

	public boolean handleDeath(boolean isHit) {
		if (isHit) {
			deathSoundEffect();
			return true;
		}
		return false;
	}

	private void moveSoundEffect() {
		try {
			AudioInputStream a = AudioSystem.getAudioInputStream(new File("src/Audio/frog-croak.mp3"));
			moveSound = AudioSystem.getClip();
			moveSound.open(a);
			moveSound.start();

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
	
	public void deathSoundEffect() {
		try {
			AudioInputStream a = AudioSystem.getAudioInputStream(new File("src/Audio/womp-womp_ZSD1fGH.mp3"));
			deathSound = AudioSystem.getClip();
			deathSound.open(a);
			deathSound.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Caught " + e.getMessage());
		}
	}
	
	public void moveDelta() {

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

	}
}
