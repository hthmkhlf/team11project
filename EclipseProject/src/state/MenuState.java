package state;

import main.Manager;
import music.MusicPlayer;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author Josh Schijins and Haithem Khelif
 * This class controls the main menu from which the player can play the game, look at credits,
 * look at high scores, or exit the game.
 */

public class MenuState implements GameState {
	private BufferedImage image,start,scores,credits,exit,keyMap;
	private Manager manager;
	private MusicPlayer music;
	
	public MenuState(Manager manager) {
		try {
			image = ImageIO.read(new File("src/images/background.png"));
			start = ImageIO.read(new File("src/images/startGameIcon.png"));
			scores = ImageIO.read(new File("src/images/Scores.png"));
			credits = ImageIO.read(new File("src/images/Credits.png"));
			exit = ImageIO.read(new File("src/images/endGameIcon.png"));
			keyMap = ImageIO.read(new File("src/images/KeyMap.png"));
		} catch(IOException e ) {
			e.printStackTrace();
		}
		this.manager = manager;
		music = new MusicPlayer("src/music/BirdRunFullnew.wav");
		music.play(true);
	}
	
	@Override
	public void update(){
		if(!(music.playing())){
			music.play(true);
		}
	}

	@Override
	public void draw(Graphics2D graphics) {
	    graphics.drawImage(image, 0, 0,1650, 550, null);      
	    graphics.drawImage(start, 600, 0, null);  
	    graphics.drawImage(scores, 600, 100, null);
	    graphics.drawImage(credits, 600, 200, null);
	    graphics.drawImage(exit, 600, 300, null);
	    graphics.drawImage(keyMap, 100, 250,null);

	}
	
	@Override
	public void keyPressed(int key){
		if(key == KeyEvent.VK_P){
			music.stop();
			manager.setState(manager.getState("PLAY"));
		}else if(key == KeyEvent.VK_C){
			manager.setState(manager.getState("CREDIT"));
		}else if(key == KeyEvent.VK_E){
			manager.setState(manager.getState("EXIT"));
		}else if(key == KeyEvent.VK_S){
			manager.setState(manager.getState("SCORES"));
		}
		
	}
	
}
