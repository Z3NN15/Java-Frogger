package main;

import assets.Sprites;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.Timer;
import player.Frog;

/**
 * GameComponent is a custom component that handles the game loop and rendering
 * of the game objects. It extends JComponent and uses a Timer to update the
 * game state and repaint the component at a fixed frame rate. It also manages
 * the level and the frog object.
 *
 * @author Ayden Snedigar and Chris Renda
 */
public class GameComponent extends JComponent {

    private static final long serialVersionUID = 1L;
    private static final int FPS = 60;
    private final Timer timer;
    private final Frog frog;
    @SuppressWarnings("unused")
    private final ObstacleManager obstacleManager;
    @SuppressWarnings("unused")
    private TerrainManager terrainManager;
    @SuppressWarnings("unused")
    private final LevelManager levelManager;

    public GameComponent() {
        frog = new Frog(
                400,
                800 - (Sprites.FROG.getHeight() / 2)
        );
        obstacleManager = new ObstacleManager();
        terrainManager = new TerrainManager(1); //Start at level 1
        levelManager = new LevelManager(terrainManager);

        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new InputHandler(
                frog,
                10,
                10
        ));

        timer = new Timer(1000 / FPS, e -> {
            actionPerformed(e);
        });
        timer.start();

    }

    /**
     * Handles action events, typically triggered by a timer or user
     * interaction. Updates the game state and repaints the component to reflect
     * any changes.
     *
     * @param e the ActionEvent that triggered this method
     */
    public void actionPerformed(java.awt.event.ActionEvent e) {
        this.updateState();
        this.repaint();
    }

    /**
     * Called when the component is added to a container or made displayable.
     * This method ensures that the component requests focus within its window
     * after being added, allowing it to receive keyboard input. Overrides the
     * {@code addNotify} method of the superclass to add custom behavior.
     */
    @Override
    public void addNotify() {
        super.addNotify();
        this.requestFocusInWindow();
    }

    /**
     * Overrides the paintComponent method to render all game elements.
     * <p>
     * This method first calls the superclass implementation to ensure proper
     * painting behavior. It then casts the Graphics object to Graphics2D for
     * advanced rendering capabilities. The method proceeds to draw the terrain,
     * obstacles, and the frog character by delegating to their respective draw
     * methods.
     *
     * @param g the Graphics context in which to paint
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        terrainManager.drawAll(g2d);
        ObstacleManager.drawAll(g2d);
        frog.drawOn(g2d);
    }

    /**
     * Updates the state of the game by performing the following actions:
     * <ul>
     * <li>Updates all terrain elements based on the current state of the
     * frog.</li>
     * <li>Updates all obstacles based on the current state of the frog.</li>
     * <li>Updates the frog's own state.</li>
     * </ul>
     * This method should be called once per game tick to ensure all game
     * entities are synchronized.
     */
    public void updateState() {
        terrainManager.updateAll(this.frog);
        ObstacleManager.updateAll(this.frog);
        frog.update();
    }
}
