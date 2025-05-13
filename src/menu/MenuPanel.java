package menu;

import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import game.GameMain;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MenuPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Buttons
	private JButton newGame;
	private JButton continueGame;
	private JButton exit;
	
	// Colors
	private static final Color BG = Color.BLACK;
	private static final Color BUTTON_BG = Color.DARK_GRAY;
	private static final Color BUTTON_FG = Color.WHITE;
	
	
	public MenuPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Create the buttons
		this.newGame = new JButton("New Game");
		this.continueGame = new JButton("Continue Game");
		this.exit = new JButton("Exit Game");
		
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
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(continueGame);
		add(Box.createRigidArea(new Dimension(0, 10)));
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
				case "New Game": 
					// Close the menu window before opening the game window
					java.awt.Window w1 = javax.swing.SwingUtilities.getWindowAncestor(MenuPanel.this);
					if (w1 != null) w1.dispose();
					
					// Open the game window
					GameMain.main(new String[0]);
					
					break;
					
				case "Continue Game":
					break;
					
				case "Exit Game":
					// Find the window that holds this panel and let swing handle the shut down 
					java.awt.Window w3 = javax.swing.SwingUtilities.getWindowAncestor(MenuPanel.this);
					if (w3 != null) w3.dispose();
					
					break;
				}
			}
		}
		
		

		@Override
		public void paintComponent(java.awt.Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			
			setBackground(BG); //Sets the main menu background color
			
		}
	
}
