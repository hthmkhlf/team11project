package main;


import java.awt.Graphics; //new
import java.io.File; // new
import java.io.IOException; // new
import javax.imageio.ImageIO; //new
import java.awt.*;
/**
 * @author Dou, Zhi Chao
 *  
*/

// Some changes were made to this class since it now has inheritance
// No longer need a bunch of the previous methods due to extending Location
// TODO create a moveDown method, other stuff to further the user class
public class User extends Location{
	private Image image;
	
	public User(){
		super(50,220);
		setHeight(100);
		setWidth(100);
	}

	
	public void moveUp(){
		setY((getYCoord()-5)); // we will eventually establish a loop so pressing jump smoothly adjusts Xcoord
	}
	
	public void drawPlayer(Graphics graphics){
		try {
			image = ImageIO.read(new File("src\\images\\player1.png"));
		}catch (IOException e ) {
				e.printStackTrace();
		}
		graphics.drawImage(image, getXCoord(),getYCoord(),getHeight(),getWidth(),null);
		
	}

	
}
