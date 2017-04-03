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
	private BufferedImage imageTwo;
	private BufferedImage imageThree;
	/**
	 * Default constructor, calls MapObject to set it's values and loads the image
	 */
	public Ground(){
		super(0,0,525,1650);
		try {
            image = ImageIO.read(new File("src/images/layer2.png"));
            imageTwo = ImageIO.read(new File("src/images/layer2.png"));
            imageThree = ImageIO.read(new File("src/images/layer2.png"));
        }catch (IOException e ) {
        	e.printStackTrace(); // this will print errors to the console
        }
	}

	@Override
	public void draw(Graphics2D graphics) {		
		graphics.drawImage(image, getXCoord(),getYCoord(),getWidth(),getHeight(),null);
		graphics.drawImage(imageTwo, getXCoord()+ getWidth(),getYCoord(),getWidth(),getHeight(),null);
		graphics.drawImage(imageThree, getXCoord()+ (getWidth()*2),getYCoord(),getWidth(),getHeight(),null);
		if (getXCoord() < -(2*getWidth())){
			setX(0);
		}
	}

	@Override
	public void movement() {
		setX((int)(getXCoord() - getScroll()));
//		if (getXCoord() < -(getWidth())){
//			setX(getWidth()*2);
//		}
	}

	@Override
	public boolean collisionCheck(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

}
