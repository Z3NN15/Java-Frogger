package GameObjects;

import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Fly extends JComponent{
	private JFrame frame;
	private int x;
	private int y;
	private int WIDTH;
	private int HEIGHT;
	private int speed;
	private BufferedImage image;
	
	public Fly() {
		
	}
	public void handleIsEaten() {
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
	}
}
