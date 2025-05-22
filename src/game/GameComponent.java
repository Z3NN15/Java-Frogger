package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.Timer;
import player.Frog;
import obstacles.AbstractObstacle;

public class GameComponent extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int FPS = 60;
	
	// Player
	private final Frog frog;
	
	// All the obstacle jawns go in here
	private List<AbstractObstacle> obstacles = new ArrayList<>();
	
	// All the flies go in here
//	private List<AbstractFly> flies = new ArrayList<>();	

	private final Timer timer;
	
	public GameComponent() {
		frog = new Frog(this, 0.25, 400, 400);
		
		//TODO: Add obstacles here
		
		InputHandler inputHandler = new InputHandler(this, frog, 50, 50);
		
		timer = new Timer(1000 / FPS, e -> {
			this.drawScreen();
		});
		
		timer.start();
		
	}
	
	public void drawScreen() {
		this.repaint();
		this.updateState();
	}
	
	@Override
	public void addNotify() {
		super.addNotify();
		this.requestFocusInWindow();
	}
	

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		// Draw the player
		frog.drawOn(g2d);
		
		//TODO:Draw the obstacles
		
	}

	/**
	 * Advance the game state by one tick:
	 * - Move everything
	 * - Check for collisions
	 * - Remove off-screen objects
	 */
	public void updateState() {
		obstacles.forEach(AbstractObstacle::update);
		
		for (AbstractObstacle obstacle : obstacles) {
			if (frog.overlaps(obstacle)) {
				obstacle.collideWithPlayer(frog);
			}
		}
	}
	
	
}
