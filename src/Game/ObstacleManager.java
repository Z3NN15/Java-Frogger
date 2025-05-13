package Game;

import java.awt.Graphics;
import GameObjects.Log;
import GameObjects.Car;

public class ObstacleManager {
	private List<GameObject> obstacles;
	
	public ObstacleManager() {
		obstacles = new ArrayList<>();
		
	}
	
	public void updateAll() {
		Log.update();
		Car.update();
	}
	
	public void drawAll(Graphics g) {
		Log.draw();
		Car.draw();
	}

}
