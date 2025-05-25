package menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import main.GameMain;

/**
 * MenuPanel is a custom JPanel that serves as the main menu for the Frogger
 * game. It displays three buttons: "New Game", "Continue Game", and "Exit
 * Game", each with custom styling and centered alignment. The panel handles
 * button actions to start a new game, continue a previous game (functionality
 * placeholder), or exit the application. The background and button colors are
 * set for a consistent theme.
 *
 * <p>
 * Usage:
 * <ul>
 * <li>Displays the main menu UI for the game.</li>
 * <li>Handles user interactions with menu buttons.</li>
 * </ul>
 * </p>
 *
 * <p>
 * Dependencies:
 * <ul>
 * <li>Requires GameMain.main(String[]) to launch the game window.</li>
 * </ul>
 * </p>
 *
 * @author Ayden Snedigar
 */
public class MenuPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    // Buttons
    private final JButton newGame;
    private final JButton continueGame;
    private final JButton exit;

    // Colors
    private static final Color BG = Color.BLACK;
    private static final Color BUTTON_BG = Color.DARK_GRAY;
    private static final Color BUTTON_FG = Color.WHITE;

    public MenuPanel() {
        setLayout(
                new BoxLayout(
                        this,
                        BoxLayout.Y_AXIS
                )
        );

        // Create the buttons
        newGame = new JButton("New Game");
        continueGame = new JButton("Continue Game");
        exit = new JButton("Exit Game");

        // Center them jawns
        newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        continueGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Set the color of the buttons
        newGame.setBackground(BUTTON_BG);
        newGame.setForeground(BUTTON_FG);

        continueGame.setBackground(BUTTON_BG);
        continueGame.setForeground(BUTTON_FG);

        exit.setBackground(BUTTON_BG);
        exit.setForeground(BUTTON_FG);

        // Add the buttons to the panel with spacing
        add(Box.createVerticalGlue());

        add(newGame);

        add(Box.createRigidArea(
                new Dimension(
                        0,
                        10
                )
        ));

        add(continueGame);

        add(Box.createRigidArea(
                new Dimension(
                        0,
                        10
                )
        ));

        add(exit);

        add(Box.createVerticalGlue());

        // Link the buttons what they should do
        newGame.addActionListener(new ButtonListener());
        continueGame.addActionListener(new ButtonListener());
        exit.addActionListener(new ButtonListener());

    }

    // Button logic
    private class ButtonListener implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonLabel = e.getActionCommand(); //Get the button label

            switch (buttonLabel) {
                case "New Game" -> {
                    // Close the menu window before opening the game window
                    java.awt.Window w1 = javax.swing.SwingUtilities.getWindowAncestor(MenuPanel.this);
                    if (w1 != null) {
                        w1.dispose();
                    }

                    // Open the game window
                    GameMain.main(new String[0]);
                }

                case "Continue Game" -> {
                    //TODO: Figure this out in the future...maybe
                }

                case "Exit Game" -> {
                    // Find the window that holds this panel and let swing handle the shut down 
                    java.awt.Window w3 = javax.swing.SwingUtilities.getWindowAncestor(MenuPanel.this);
                    if (w3 != null) {
                        w3.dispose();
                    }
                }
            }
        }
    }

    @Override
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        //Sets the main menu background color
        setBackground(BG);
    }

}
