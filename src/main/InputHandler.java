package main;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import player.Frog;

/**
 * Handles keyboard input for controlling the {@link Frog} character in the game.
 * Implements the {@link KeyListener} interface to respond to arrow key presses and releases.
 * 
 * <p>
 * When an arrow key is pressed, the corresponding movement delta is set on the frog,
 * allowing it to move in the specified direction by a fixed step size.
 * When the key is released, the movement delta is reset to zero, stopping the frog's movement.
 * </p>
 *
 * @author Ayden Snedigar and Chris Renda
 */
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
		case KeyEvent.VK_UP -> frog.setMoveDelta(0, -stepY);
//			System.out.println("UP");

		case KeyEvent.VK_DOWN -> frog.setMoveDelta(0, stepY);
//			System.out.println("DOWN");
		case KeyEvent.VK_LEFT -> frog.setMoveDelta(-stepX, 0);
//			System.out.println("LEFT");
		case KeyEvent.VK_RIGHT -> frog.setMoveDelta(stepX, 0);
//			System.out.println("RIGHT");
		}
	}
	
	/**
	 * Handles the event when a key is released.
	 * <p>
	 * This method is triggered whenever a key is released on the keyboard.
	 * It checks which key was released and, for the arrow keys (UP, DOWN, LEFT, RIGHT),
	 * it resets the frog's movement delta to (0, 0), effectively stopping its movement.
	 * For any other key, it also resets the movement delta.
	 *
	 * @param e the KeyEvent containing information about the released key
	 */
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

	/**
	 * Invoked when a key has been typed.
	 * This method is not used in this implementation.
	 *
	 * @param e the KeyEvent associated with the key typed
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// Not used		
	}
	
}
