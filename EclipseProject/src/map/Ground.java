package map;

import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
/**
* @author Josh Schijns
* This class controls the ground, drawing and updating movement.
*/
public class Ground extends MapObject {
	private BufferedImage image;
	
	public Ground(){
		super(0,0,525,1650);
		try {
            image = ImageIO.read(new File("src/images/layer2.png"));
        }catch (IOException e ) {
        	e.printStackTrace(); // this will print errors to the console
        }
	}

	@Override
	public void draw(Graphics2D graphics) {
		// TODO Auto-generated method stub
		
		graphics.drawImage(image, getXCoord(),getYCoord(),getWidth(),getHeight(),null);
		graphics.drawImage(image, getXCoord()+ getWidth(),getYCoord(),getWidth(),getHeight(),null);
		if (getXCoord() < -(getWidth())){
			setX(0);
		}

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		movement();
	}

	@Override
	protected void movement() {
		// TODO Auto-generated method stub
		setX((int)(getXCoord() - scrollRate));
	}

}
