package state;

import java.awt.event.KeyEvent;
import java.awt.Graphics2D;
import map.*;
/**
 * 
 * @author Josh Schijns
 * This is the state of the game when the user is playing the actual Game
 *
 */
public class PlayState {
	private boolean collision = false;
	private Player player;
	private Obstacle[] obstacle; 
	private Background background;
	private Ground ground;
	private HighScoreGUI score;
	private int difficulty = 2;

	/**
	 * Default constructor, initializes all the map objects and spawns the first set of obstacles
	 */
	public PlayState(){
		player = new Player();
		obstacle = new Obstacle[difficulty];
		background = new Background();
		ground = new Ground();
		score = new HighScoreGUI();
		createObstacles();		
	}
	
	
	public void update(){
		if(!collision){
			player.update();
			background.update();
			ground.update();
			for (int count = 0; count < difficulty; count++){
				obstacle[count].update();
			}
			score.update();
			spawnObstacles();
		}
	}
	
	public void draw(Graphics2D graphics){
		background.draw(graphics);
		ground.draw(graphics);		
		for (int count = 0; count < difficulty; count++){
			obstacle[count].draw(graphics);
		}
		player.draw(graphics);
		score.draw(graphics);		
	}
	
	/**
	 * Makes the player jump
	 * @param key is the key pressed, if UP then will make player jump.
	 */
	public void keyPressed(int key){
		if(key == KeyEvent.VK_UP){
			player.toggleJump();
			player.setSpeed(true);
		}
	}
	
	/**
	 * Toggles the speed variable so the player no longer gains jump speed
	 * @param key is the key pressed, releasing UP will only do something.
	 */
	public void keyReleased(int key){
		if (key == KeyEvent.VK_UP){
			player.setSpeed(false);
		}
	}
	
	/**
	 * Based off the difficulty will spawn that many objects within the screen
	 */
	private void createObstacles(){
		int distanceBetween = 1700 / difficulty; 
		for(int count = 0; count < difficulty; count++){
			obstacle[count] = new Obstacle((int)1700+(count*distanceBetween));
			
		}		
	}
	
	/**
	 * Based off the difficulty it will keep track of each obstacle and 
	 * re spawn it if it goes off the screen.
	 */
	private void spawnObstacles(){
		for(int count = 0; count < difficulty; count++){
			if (isCollided(obstacle[count])){
				collision = true;
				System.out.println("You have collided with an Obstacle!!");
			}
			if (obstacle[count].getXCoord() < -obstacle[count].getWidth()){
				obstacle[count] = new Obstacle(1700);
			}
		}	
	}
	
	private boolean isCollided(Obstacle other){
		boolean collided = false;
		int startX = 70;
		int endX = 125;
		int startY = player.getYCoord();
		int endY = player.getYCoord() + 80;
		if (((startX >= other.getXCoord()) && (startX <= other.getXCoord()+other.getWidth()))
				|| ((endX >= other.getXCoord())&&(endX <= (other.getXCoord()+other.getWidth())))){
			if (((startY >= other.getYCoord())&&(startY <= (other.getYCoord()+other.getHeight())))
					|| ((endY >= other.getYCoord())&&(endY <= (other.getYCoord()+other.getHeight())))){
				collided = true;
			}
		}
		return collided;
	}
	
}
