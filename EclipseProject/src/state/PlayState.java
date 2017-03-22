package state;

import java.awt.event.KeyEvent;
import java.awt.Graphics2D;
import map.Background;
import map.Ground;
import map.HighScoreGUI;
import map.Obstacle;
import map.Player;

public class PlayState {
	// All stuff commented out is me trying to figure out a way to spawn multiple obstacles
	
	private Player player;
//	private Obstacle[] obstacle; 
	private Background background;
	private Ground ground;
	private HighScoreGUI score;
	private int difficulty = 1;
//	private Obstacle obstacle;
//	private int frameCount = 0;
//	private int obstacleNumber = 0;

	public PlayState(){
		player = new Player();
		obstacle = new Obstacle[5];
		background = new Background();
		ground = new Ground();
		score = new HighScoreGUI();
//		spawnObstacles();
//		obstacle = new Obstacle();
		
	}
	public void update(){
		player.update();
		background.update();
		ground.update();
//		for (int count = 0; count < 5; count++){
//			obstacle[count].update();
//		}
		score.update();
//		obstacle.update();
//		spawn();
	}
	
	public void draw(java.awt.Graphics2D graphics){
		background.draw(graphics);
		ground.draw(graphics);		
//		for (int count = 0; count < 5; count++){
//			obstacle[count].draw(graphics);
//		}
		player.draw(graphics);
		score.draw(graphics);
//		obstacle.draw(graphics);
		
		
	}
	
	public void keyPressed(int key){
		if(key == KeyEvent.VK_UP){
			player.toggleJump();
		}
	}
	
//	public void spawnObstacles(){
//		int distanceBetween = 1700 / difficulty; 
//		for(int count = 0; count < 5; count++){
//			obstacle[count] = new Obstacle((int)1700+(count*distanceBetween));
//			
//		}		
//	}
	
//	public void spawn(){
//		frameCount++;
//		if((frameCount/120) == 1){
//			obstacle = new Obstacle();
//			frameCount = 0;
//			obstacleNumber++;
//			if (obstacleNumber == 2){
//				obstacleNumber = 0;
//			}
//		}
//	}

}
