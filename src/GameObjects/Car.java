package GameObjects;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;

public class Car extends JComponent {
	private JFrame frame;
	private int x;
	private int y;
	private int WIDTH;
	private int HEIGHT;
	private int speed;
	private boolean offscreen;
	private BufferedImage carSprite;
	private Clip crashSound;
	
	public Car(JFrame frame) {
		WIDTH=carSprite.getWidth();
		HEIGHT=carSprite.getHeight();
		carSprite=ImageIO.read(new File("src/Images/Car.png"));

	}
	
	public boolean hitbox(int HEIGHT , int WIDTH ) {
		return offscreen;
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
	}
}
