package GameObjects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;


public class Log extends JComponent{
	private JPanel panel;
	private int x;
	private int y;
	private int WIDTH;
	private int HEIGHT;
	private int speed;
	private boolean offscreen;
	
	public Log() {
		
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

