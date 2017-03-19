package main;

import java.awt.event.KeyEvent;



public class Manager {
	private Player player;
	private Obstacle obstacle; 
	private Background background;
	private Ground ground;
	
	public Manager(){
		player = new Player();
		obstacle = new Obstacle();
		background = new Background();
		ground = new Ground();
		
	}
	public void update(){
		player.update();
		background.update();
		ground.update();
		obstacle.update();
	}
	
	public void draw(java.awt.Graphics2D graphics){
		background.draw(graphics);
		ground.draw(graphics);		
		obstacle.draw(graphics);
		player.draw(graphics);
		
	}
	
	public void keyPressed(int key){
		if(key == KeyEvent.VK_UP){
			player.toggleJump();
		}
	}
}
