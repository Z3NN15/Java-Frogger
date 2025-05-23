package main;



import javax.swing.JFrame;

public class GameMain {

	public static final int DELAY = 10;
	public static final int WINDOW_HEIGHT = 800;
	public static final int WINDOW_WIDTH = 800;
	
	
	public static void main(String[] args) {
		// Initialize assets
		Assets.init();
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
