package map;

import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.io.*;
import sun.audio.*;

/**
 * @author  Katie Tieu
 * This class is a child class to MapObject.
 * The methods in this class will be used to generate obstacles which the player character must avoid,
 * as well as to move and draw the obstacles.
 * Note that only the y-coordinate is randomly generated in this class; the x-coordinate will be generated
 * at a fixed value using the setX method from the parent class.
 */

public class Obstacle extends Collidable {
	private BufferedImage image;
	private int obstacleSize;

  		public Obstacle(){
  			this(1700);
  		}
	
	/**
	 * Creates an obstacle off screen and loads the image.
	 * Obstacle will be one of three varying heights randomly determined upon creation.
	 * @param newX is the xCoordinate that it sets it to.
	 */
	public Obstacle(int newX){
		this.setX(newX);
		obstacleSize = (new Random().nextInt(3)) + 1;
		switch (obstacleSize){
			case 1: setHeight(75);
					this.setY(390);
					break;
			case 2: setHeight(150);
					this.setY(315);
					break;
			case 3: setHeight(245);
					this.setY(220);
					break;
		}
		setWidth(75);
		try {
            image = ImageIO.read(new File("src/images/obstacle"+ obstacleSize +".png"));
        }catch (IOException e ) {
        	e.printStackTrace();
        }
	}

	public Obstacle(Obstacle other) {
		super(other.getXCoord(), other.getYCoord(), other.getHeight(), other.getWidth());
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.drawImage(image, getXCoord(),getYCoord(),getWidth(),getHeight(),null);
	}

	@Override
	public void movement() {
		setX((int)(getXCoord() - getScroll()));
	}

	
	// Plays a sound effect when the player loses
	@Override
	@SuppressWarnings("restriction")
	public void collisionAction(Player player){
		try {
			String gameOver = "src/music/gameover.wav";
			InputStream in = new FileInputStream(gameOver);
			AudioStream audio = new AudioStream(in);
			AudioPlayer.player.start(audio);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int getObstacleSize(){
		return obstacleSize;
	}
}
