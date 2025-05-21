package GameObjects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import java.io.File;


public class Log extends JComponent{
	private JPanel panel;
	private int x;
	private int y;
	private int WIDTH;
	private int HEIGHT;
	private int speed;
	private boolean offscreen;
	private BufferedImage log;
	
	public Log() {
		WIDTH=log.getWidth();
		HEIGHT=log.getHeight();
		log=ImageIO.read(new File("src/Images/log.png"));

	}
	public boolean hitbox() {
		return offscreen;
		
	}
	public void move() {
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
	}
	
	
}

