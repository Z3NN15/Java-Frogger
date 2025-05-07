package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameAdvanceListener implements ActionListener {
	
	private GameComponent gc;
	
	public GameAdvanceListener(GameComponent gameComponent) {
		this.gc = gameComponent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		advanceOneTick();
	}

	public void advanceOneTick() {
		// The component uses user actions from listeners
		// to change the state of the game.

		// update screen
		this.gc.updateState();
		this.gc.drawOn();
	}
}
