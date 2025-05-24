package main;

import assets.Backgrounds;
import assets.Sounds;
import assets.Sprites;
import javax.swing.JFrame;

/**
 * The GameMain class is the entry point for the Frogger game. It initializes
 * the game assets and sets up the main game window.
 *
 * @author Ayden Snedigar and Chris Renda
 */
public class GameMain {

    public static final int DELAY = 10;
    public static final int WINDOW_HEIGHT = 800;
    public static final int WINDOW_WIDTH = 800;

    public static void main(String[] args) {
        // Initialize assets
        Sprites.init();
        Backgrounds.init();
        Sounds.init();
        // Initialize the game
        new GameMain();
    }

    public GameMain() {
        JFrame frame = new JFrame("Frogger!");

        GameComponent game = new GameComponent();
        frame.add(game);
        game.requestFocusInWindow();

        frame.setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
