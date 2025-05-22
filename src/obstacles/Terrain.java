package obstacles;

public class Terrain extends AbstractObstacle {
	
	public Terrain(BufferedImage image, int x, int y, int width, int height, int speed) {
		super(image, x, y, width, height, speed);
	}
	
	@Override
	public void drawOn(Graphics2D g) {
		g.drawImage(image, x, y, WIDTH, HEIGHT, null);
	}
	
	@Override
	public void collideWithPlayer(AbstractPlayer frog) {
		// No collision effect with terrain
	}
	
	@Override
	public String getType() {
		return "Terrain";
	}

}
