package state;

import java.awt.event.KeyEvent;
import java.awt.Graphics2D;
import map.*;
import music.MusicPlayer;

import java.util.ArrayList;

import main.Manager;
/**
 * 
 * @author Josh Schijns Haithem Khelif
 * This is the state of the game when the user is playing the actual Game
 *
 */
public class PlayState {
	private ArrayList<MapObject> objects = new ArrayList<>();
	private Player player;
	private Background background;
	private Ground ground;
	private HighScoreGUI score;
	private Obstacle obstacle;
	private Boost boost;
	private Manager manager;
	
	private int delay = 0;
	private int spawnDelay = 100;
	private int difficulty = 1;
	private boolean gameOver = false;

	/**
	 * Default constructor, initializes all the map objects and spawns the first set of obstacles
	 */
	public PlayState(Manager manager){
		this.manager = manager;
		objects.add(background = new Background());
		objects.add(ground = new Ground());
		objects.add(boost = new Boost());
		objects.add(player = new Player());
		objects.add(score = new HighScoreGUI());
		objects.add(obstacle = new Obstacle());
	}
	
	
	public void update(){
		if(!gameOver){
			for(MapObject element : objects){
				element.movement();
				if(element.collisionCheck(player)){
					((Collidable) element).collisionAction(player);
					if(element instanceof Obstacle){
						gameOver = true;
					}
				}
			}
			destroyCollidables();
			createObstacles();
		}else if(gameOver){
			score.gameOver();
		}
	}
	
	
	public void draw(Graphics2D graphics){
		for(MapObject element : objects){
			element.draw(graphics);
		}	
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
	private void destroyCollidables(){
		ArrayList<MapObject> toRemove = new ArrayList<>();
		for(MapObject element : objects){
			if(element instanceof Collidable){
				if((element.getXCoord()+element.getWidth())< -10){
					toRemove.add(element);
				}
			}
		}
		objects.remove(toRemove);
	}
	
	/**
	 * Based off the difficulty it will keep track of each obstacle and 
	 * re spawn it if it goes off the screen.
	 */
	private void createObstacles(){
		delay++;
		if((delay % spawnDelay)==0 ){
			Obstacle newObstacle;
			objects.add(newObstacle = new Obstacle());
			if(newObstacle.getObstacleSize() == 3){
				Boost newBoost;
				objects.add(newBoost = new Boost(newObstacle));
			}
		}
	}
}
