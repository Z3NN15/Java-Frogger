package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.Timer;
import player.Frog;

public class GameComponent extends JComponent {
	private static final long serialVersionUID = 1L;
	
	/**
	 * The number of frames per second for the game loop.
	 * This determines how often the game state is updated and the screen is redrawn.
	 */
	private static final int FPS = 60;
	
	// Level manager
	// private final LevelManager levelManager;
	private final int level = 1;
	
	// Player
	private final Frog frog;
	
	//Obstacles
	@SuppressWarnings("unused")
	private final ObstacleManager obstacleManager;
	
	//Keyboard input handler
	@SuppressWarnings("unused")
	private final InputHandler inputHandler;

	// Swing Timer for the game loop
	private final Timer timer;
	
	/**
	 * Constructor for the game component.
	 * Initializes the player, obstacles, and input handler.
	 */
	public GameComponent() {
		frog = new Frog(this, 0.25, 400, 400);
		
		//DONE: Add obstacles here
		//TODO: Get them jawns working properly
		obstacleManager = new ObstacleManager(this);

		inputHandler = new InputHandler(this, 50, 50);
		
		timer = new Timer(1000 / FPS, e -> {
			this.drawScreen();
		});
		
		timer.start();
		
	}
	
	/**
	 * Draw the game screen.
	 * This method is called by the timer at a fixed interval.
	 */
	public void drawScreen() {
		this.repaint();
		this.updateState();
	}
	
	public int getLevel() {
		return level;
	}
	
	public Frog getFrog() {
		return frog;
	}
	
	public JComponent getComponent() {
		return this;
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
		
		//DONE: Draw the player
		frog.drawOn(g2d);
		
		//TODO:Draw the obstacles
		ObstacleManager.drawAll(g2d);
	}

	/**
	 * Advance the game state by one tick:
	 * - Move everything
	 * - Check for collisions
	 * - Remove off-screen objects
	 */
	public void updateState() {
		ObstacleManager.updateAll();
	}
	
	
}
