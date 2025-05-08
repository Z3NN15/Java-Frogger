package GameObjects;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.sound.sampled.Clip;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;

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
