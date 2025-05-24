package terrains;

/**
 * Terrain is an abstract class that represents a game object that can be
 * drawn on the screen. It extends the GameObject class and provides a
 * constructor to initialize the image, position, and size of the terrain.
 * 
 * @author Ayden Snedigar and Chris Renda
 */
public abstract class AbstractTerrain extends GameObject {
	
	public Terrain(BufferedImage image, int x, int y, int width, int height) {
		super(image, x, y, width, height);
	}
	
	@Override
	public void drawOn(Graphics2D g2D) {
		g2D.drawImage(image, x, y, WIDTH, HEIGHT);
	}
	
	public abstract void checkTerrainCollision(AbstractPlayer frog);
	
	
}
