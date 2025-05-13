package GameObjects;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.sound.sampled.Clip;
import javax.swing.JComponent;
import javax.swing.JFrame;
public class Frog extends JComponent{
	private JFrame frame;
	private BufferedImage image;
	private int WIDTH;
	private int HEIGHT;
	private int speed;
	private Clip deathSound;
	private boolean deathFlag;
	
	public Frog(JFrame frame) {
		
	}
	public boolean hitbox(int HEGHT,int WIDTH) {
		return deathFlag;
		
	}
	public boolean handleEat(Fly fly) {
		return deathFlag;
	}
	public boolean handleDeath(boolean isHit) {
		return isHit;
		
	}
	public void moveDelta() {
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
	}
}
