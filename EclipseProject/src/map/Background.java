package map;

import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Sets up the background for the game and scrolls at a slower rate
 * @author Josh Schijns
 *
 */
public class Background extends MapObject {
	private BufferedImage image;
	private double rate = 2;
	
	/**
	 * Default constructor, calls MapObject to set it's values and loads the image
	 */
	public Background(){
		super(0,0,550,1700);
		try {
            image = ImageIO.read(new File("src/images/layer1.png"));
		}catch(IllegalArgumentException iae){
    			ErrorMessage.addError("Image is null in Background");
        }catch (IOException ioe) {
        	ErrorMessage.addError("Error reading image for layer1");
        }
	}
		
	
	@Override
	public void draw(Graphics2D graphics) {
        graphics.drawImage(image, getXCoord(), getYCoord(),getWidth(),getHeight(), null);
        graphics.drawImage(image, getXCoord() + getWidth(), getYCoord(),getWidth(),getHeight(), null);
        if (getXCoord() < -(getWidth())){
        	setX(0);
        }
	}

	@Override
	public void movement() {
		setX((int)(getXCoord() - rate));
	}


	@Override
	public boolean collisionCheck(Player player) {
		return false;
	}

}
