package GameObjects;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JComponent;
import javax.swing.JFrame;

import Game.GameObject;

public abstract class Frog extends GameObject{
	private JFrame frame;
	private BufferedImage frog;
	private int WIDTH;
	private int HEIGHT;
	private int speed;
	private int x,y;
	private Clip deathSound;
	private boolean deathFlag;
	
	public Frog() {
		WIDTH=frog.getWidth();
		HEIGHT=frog.getHeight();
		frog=ImageIO.read(new File("src/Images/frog.png"));
		}
	public boolean hitbox(int HEGHT,int WIDTH) {
		return deathFlag;
		
	}
	public boolean handleEat(Fly fly) {
		if(fly.getX()==x) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean handleDeath(boolean isHit) {
		if(isHit) {
			playSoundEffect();
			return true;
		}
		return false;
	}
		private void playSoundEffect() {
			try {
				AudioInputStream a=AudioSystem.getAudioInputStream(new File("src/Audio/alarm_clock.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(a);
				clip.start();
				
			} catch (UnsupportedAudioFileException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(Exception e) {
				System.err.println("Caught "+ e.getMessage());
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
