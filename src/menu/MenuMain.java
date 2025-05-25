package menu;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * The {@code MenuMain} class serves as the entry point for the Frogger game's
 * main menu. It initializes and displays the main menu window using Swing
 * components.
 * <p>
 * The main method schedules the creation of the GUI on the Event Dispatch
 * Thread (EDT) to ensure thread safety for Swing operations.
 * </p>
 * <ul>
 * <li>{@code WINDOW_HEIGHT} and {@code WINDOW_WIDTH} define the dimensions of
 * the main menu window.</li>
 * <li>{@code createGUI()} sets up the JFrame, adds the main menu panel, and
 * configures window properties.</li>
 * </ul>
 */
public class MenuMain {

    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 400;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> createGUI()
        );
    }

    public static void createGUI() {
        JFrame frame = new JFrame("Frogger! Main Menu");

        // GUI elements should go below this line
        MenuPanel menuPanel = new MenuPanel();

        frame.add(menuPanel);

        // Shouldn't need to change any of these
        frame.setSize(
                WINDOW_HEIGHT,
                WINDOW_WIDTH
        );
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.requestFocusInWindow();
    }

}
