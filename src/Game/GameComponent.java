package Game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class GameComponent extends JComponent {
	
	public GameComponent() {
		throw new UnsupportedOperationException("TODO: Implement this jawn");
	}
	
	public void drawOn() {
		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
	}

	public void updateState() {
		// Each is big enough to be in a helper method.

//		handleCollisions();
	}
}
