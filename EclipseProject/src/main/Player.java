package main;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;

public class Player extends MapObject {
	private Image image;
	// I use these two booleans for when the player is jumping
	private boolean jumping = false;
	private boolean falling = false; // will use this for animations possibly, but not sure
	
	// -20 is good for a small jump, -30 for a big jump, add in a key released function for later
	// These variables are used for the players jump algorithm 
	private double jumpSpeed = -25;
	private double fallSpeed = 1.5;
	private double distance;
	private int timeChange = 0;
	private final int GROUND = 349;
	
	public Player(){
		this(50,350,100,100);
	}
	
	public Player(int newX, int newY, int height, int width){
		super(newX, newY, height, width);
		try {
			image = ImageIO.read(new File("src/images/player1.png"));
		}catch (IOException e ) {
				e.printStackTrace();
		}
		
	}
	
	public void draw(Graphics2D graphics){
		graphics.drawImage(image, getXCoord(),getYCoord(),getHeight(),getWidth(),null);
	}
	
	
	public void toggleJump(){
		if(!jumping){
			jumping = true;
		}
	}
	public void update(){
		movement();
	}
	private void animation(){
		// Not sure if animation should be in here or create another class possibly?
	}
	
	
	protected void movement(){
		if(jumping){
			distance = jumpSpeed + fallSpeed * timeChange;
			timeChange++;
			setY((int)(getYCoord() + distance));
			if (distance > 0){
				falling = true;
			}
			distance = 0;
			if (getYCoord() > GROUND ){
				jumping = false;
				timeChange = 0;
				falling = false;
				setY(GROUND + 1);
			}
		}
	}
}
