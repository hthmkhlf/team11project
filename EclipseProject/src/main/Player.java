package main;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;

public class Player extends MapObject {
	private BufferedImage[] image = new BufferedImage[8];
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
	private int frameNum = 0;
	
	public Player(){
		this(50,350,100,100);
	}
	
	public Player(int newX, int newY, int height, int width){
		super(newX, newY, height, width);
		for(int frame = 0; frame < 8; frame++)
			try {
				image[frame] = ImageIO.read(new File("src/images/player" +(frame+1) + ".png"));
			}catch (IOException e ) {
					e.printStackTrace();
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
	
	
	public void toggleJump(){
		if(!jumping){
			jumping = true;
			frameNum = 0;
		}
	}
	public void update(){
		movement();
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
