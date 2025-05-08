package GameObjects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Terrain {
	private JFrame frame;
	private int x;
	private int y;
	private int WIDTH;
	private int HEIGHT;
	private int speed;
	private BufferedImage image;
	private boolean terrianLoaded;
	
	public Terrain() {
		
	}
	public boolean isHit() {
		return terrianLoaded;
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
	}
}
