package game;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import player.Frog;

public class InputHandler {
	private final JComponent component;
	private final Frog frog;
	private final double stepX, stepY;

	/**
	 * 
	 * @param component
	 * @param frog
	 */
	public InputHandler(GameComponent gc, double dx, double dy) {
		this.component = gc.getComponent();
		this.frog = gc.getFrog();
		this.stepX = dx;
		this.stepY = dy;

		component.setFocusable(true);
		initBindings();
	} // constructor
	
	public void initBindings() {
		InputMap im = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = component.getActionMap();
		
		bind(
				im, 
				am, 
				"moveLeft",
				KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), () -> frog.update(-stepX, 0)
			);
		
		bind(
				im, 
				am, 
				"moveRight",
				KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), () -> frog.update(stepX, 0)
			);
		
		bind(
				im, 
				am, 
				"moveUp",
				KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), () -> frog.update(0, -stepY)
			);
		
		bind(
				im, 
				am, 
				"moveDown",
				KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), () -> frog.update(0, stepY)
			);
		
	} // constructor
	
	private void bind(InputMap im, ActionMap am, String name, KeyStroke key, Runnable action) {
		im.put(key, name);
		am.put(name, new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				action.run();
				component.repaint();
			}
		});
	}
}
