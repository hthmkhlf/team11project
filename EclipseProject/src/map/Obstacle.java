package map;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.Random;
import music.MusicPlayer;

/**
 * @author  Katie Tieu
 * This class is a child class to Collidable.
 * This class is used to generate obstacles which the player character must avoid, as well as to move and draw the obstacles.
 * Note that only the y-coordinate and height are randomly generated in this class; the obstacle is always spawned
 * with the same x-coordinate and width.
 */

public class Obstacle extends Collidable {
	private BufferedImage image;
	private MusicPlayer music;
	private int obstacleSize;

  	public Obstacle(){
  		this(1700);
  	}
	
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
		this.setWidth(75);
		
		try {
            image = ImageIO.read(new File("src/images/obstacle" + obstacleSize + ".png"));
		} catch(IllegalArgumentException iae) {
			ErrorMessage.addError("Image is null in Obstacle.");
		} catch (IOException ioe) {
			ErrorMessage.addError("Error reading image for obstacles.");
		}
		
		music = new MusicPlayer("src/soundEffects/gameOver.wav");
	}

	public Obstacle(Obstacle other) {
		super(other.getXCoord(), other.getYCoord(), other.getHeight(), other.getWidth());
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.drawImage(image, getXCoord(), getYCoord(), getWidth(), getHeight(), null);
	}

	@Override
	public void movement() {
		setX((int)(getXCoord() - getScroll()));
	}

	
	@Override
	public void collisionAction(Player player) {
		music.play(false);		// Plays a sound effect when the player loses.
	}

	/**
	 * This method is a getter for obstacleSize.
	 * @return obstacleSize is one of three possible sizes for the obstacle randomly generated upon creation.
	 */
	public int getObstacleSize() {
		return obstacleSize;
	}
	
}
