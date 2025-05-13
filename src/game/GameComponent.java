package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class GameComponent extends JComponent {
	//
	private int numTicks;
	
	// 2 types of objects
//	private List<AbstractObstacle> obstacles = new ArrayList<>();
//	private List<AbstractFly> flies = new ArrayList<>();
//	
//	private Frog frog;
	
	
	public GameComponent() {
//		this.frog = new Frog();
//		
//		this.obstacles.add(new log());
		
		
	}
	
	public void drawScreen() {
		this.repaint();
//		System.out.println("Tick" + this.numTicks);
//		System.out.println("There are " + this.obstacles.size() + " obstacles.");
	}
	

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
//		for (AbstractObstacle : this.obstacles) {
//			obstacle.drawOn(g2);
//		}
	}

	public void updateState() {
		// Each is big enough to be in a helper method.

//		handleCollisions();
	}
	
	
}
