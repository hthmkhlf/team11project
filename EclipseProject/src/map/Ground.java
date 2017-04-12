package map;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 * Sets up and draws the ground for the map
 * @author Josh Schijns
 *
 */
public class Ground extends MapObject {
	private BufferedImage image;
	/**
	 * Default constructor, calls MapObject to set it's values and loads the image
	 */

	public Ground(){
		this(0);
	}
	public Ground(int xCoord){
		super(xCoord,0,525,1650);
		try {
            image = ImageIO.read(new File("src/images/layer2.png"));
		}catch(IllegalArgumentException iae){
			ErrorMessage.addError("Image is null Ground");
		}catch (IOException ioe) {
			ErrorMessage.addError("Error reading image for layer2");
		}
	}

	@Override
	public void draw(Graphics2D graphics) {		
		graphics.drawImage(image, getXCoord(),getYCoord(),getWidth(),getHeight(),null);
	}

	@Override
	public void movement() {
		setX((int)(getXCoord() - getScroll()));
		if (getXCoord() <= -getWidth()){
			setX(1650);
		}
	}

}
