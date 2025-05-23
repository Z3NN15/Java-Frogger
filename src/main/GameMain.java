package main;



import javax.swing.JFrame;

public class GameMain {

	public static final int DELAY = 10;
	public static final int WINDOW_HEIGHT = 800;
	public static final int WINDOW_WIDTH = 800;
	
	
	public static void main(String[] args) {
		new GameMain();
		Assets.init();
		
	}
	
	public GameMain() {
		JFrame frame = new JFrame("Frogger!");
		
		GameComponent gc = new GameComponent();
		frame.add(gc);
		
		
		frame.setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.requestFocusInWindow();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
