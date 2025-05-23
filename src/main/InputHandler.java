package main;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import player.Frog;

public class InputHandler implements KeyListener {
	private final Frog frog;
	private final double stepX, stepY;

	/**
	 * 
	 * @param component
	 * @param frog
	 */
	public InputHandler(Frog frog, double dx, double dy) {
		this.frog = frog;
		this.stepX = dx;
		this.stepY = dy;
	} //InputHandler()

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch (key) {
		case KeyEvent.VK_UP:
			frog.setMoveDelta(0, -stepY);
//			System.out.println("UP");
			break;

		case KeyEvent.VK_DOWN:
			frog.setMoveDelta(0, stepY);
//			System.out.println("DOWN");
			break;
		case KeyEvent.VK_LEFT:
			frog.setMoveDelta(-stepX, 0);
//			System.out.println("LEFT");
			break;
		case KeyEvent.VK_RIGHT:
			frog.setMoveDelta(stepX, 0);
//			System.out.println("RIGHT");
			break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch (key) {
		case KeyEvent.VK_UP:

		case KeyEvent.VK_DOWN:

		case KeyEvent.VK_LEFT:

		case KeyEvent.VK_RIGHT:

		default:
			frog.setMoveDelta(0, 0);
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// Not used		
	}
	
}
