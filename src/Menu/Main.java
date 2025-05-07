package Menu;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;


public class Main {
	private static int WINDOW_HEIGHT = 800;
	private static int WINDOW_WIDTH = 800;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> createGUI());
	}
	
	public static void createGUI() {
		JFrame frame = new JFrame("Frogger! Main Menu");
		
		// GUI elements should go below this line
		MenuPanel menuPanel = new MenuPanel();
	
		frame.add(menuPanel);
		
		//
		
		
		// Shouldn't need to change any of these
		frame.setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.requestFocusInWindow();
	}

}
