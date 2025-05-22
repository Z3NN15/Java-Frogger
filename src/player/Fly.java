
package player;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class Fly extends AbstractPlayer{

	private BufferedImage fly;
	
	public Fly() {
		WIDTH=fly.getWidth();
		HEIGHT=fly.getHeight();
		fly=ImageIO.read(new File("src/Images/HappyFly.png"));

	}
	public int getX() {
		return x;
	}
	public void handleIsEaten() {
		
	}
}
