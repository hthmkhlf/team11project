package map;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


/**
 * Controls the Player and allows movement of it.
 * @author Dou, Zhi Chao and Josh Schijns.
 * 
 */
public class Player extends MapObject {
	private BufferedImage[] image = new BufferedImage[8];
	// Used for when the player is jumping.
	private boolean jumping = false;
	
	// These variables are used for the players jump algorithm and animations with it. 
	private final double MAX_SPEED = -35;
	private final double MIN_SPEED = -15;
	private double jumpSpeed = -15;
	private double fallSpeed = 1.5;
	private double distance;
	private int timeChange = 0;
	private final int GROUND = 349;
	private int frameNum = 0;
	private boolean speed = false;
	
	
	
	public Player(){
		this(50,350,100,100);
	}
	/**
	 * Constructor for Player, loads all the images for the player
	 * @param newX is the x-coord it will start at
	 * @param newY is the y-coord it will start at
	 * @param height is the height of the player
	 * @param width is the width of the player
	 */
	public Player(int newX, int newY, int height, int width){
		super(newX, newY, height, width);
		for(int frame = 0; frame < 8; frame++)
			try {
				image[frame] = ImageIO.read(new File("src/images/player" +(frame+1) + ".png"));
			}catch(IllegalArgumentException iae){
    			ErrorMessage.addError("Image is null in Player");
			}catch (IOException ioe) {
				ErrorMessage.addError("Error reading image for player");
			}		
	}
	
	public void draw(Graphics2D graphics){
		if (!jumping){	
			int num = frameNum / 5;
			graphics.drawImage(image[num], getXCoord(),getYCoord(),getWidth(),getHeight(),null);
			frameNum++;
			if (frameNum == 40){
				frameNum = 0;
			}
		}else{
			graphics.drawImage(image[frameNum], getXCoord(),getYCoord(),getWidth(),getHeight(),null);
			frameNum++;
			if (frameNum==8){
				frameNum = 0;
			}
		}
	}
	
	/**
	 * Resets the jump speed to its minimal value after the player lands.
	 * Also prevents the player from jumping another time while already jumping
	 */
	public void toggleJump(){
		if(!jumping){
			jumping = true;
			frameNum = 0;
			jumpSpeed = MIN_SPEED;
		}
	}
		
	
	/**
	 * toggles the speed boolean which allows the player to go faster or not
	 * @param speeding if it is true will allow the player to continue to gain speed.
	 */
	public void setSpeed(boolean speeding){
		if(speeding){
			speed = true;
		}else{
			speed = false;
		}
	}
	
	public void boost(){
		//Thinking this is where the boost will come into play, make it like a double jump
		jumpSpeed = jumpSpeed - 10;
	}
	
	/**
	 * Controls the movement of the player
	 */
	public void movement(){
		if((speed) && (jumpSpeed >  MAX_SPEED)){
			jumpSpeed--;
		}
		// Allows the player to change its y coordinate over time to create a smooth jump
		if(jumping){
			distance = jumpSpeed + fallSpeed * timeChange;
			timeChange++;
			setY((int)(getYCoord() + distance));
			distance = 0;
			if (getYCoord() > GROUND ){
				jumping = false;
				timeChange = 0;
				setY(GROUND + 1);
			}
		}
	}

}
