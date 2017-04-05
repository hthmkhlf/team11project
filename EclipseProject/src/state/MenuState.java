package state;


import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Manager;

public class MenuState {
//	 BackGround image
	private BufferedImage image,start,scores,credits,exit,keyMap;
	private Manager manager;

	//Initiate Game Status
	
	public MenuState(Manager manager){		

		try {
			image = ImageIO.read(new File("src/images/background.png"));
			start = ImageIO.read(new File("src/images/startGameIcon.png"));
			scores = ImageIO.read(new File("src/images/Scores.png"));
			credits = ImageIO.read(new File("src/images/Credits.png"));
			exit = ImageIO.read(new File("src/images/endGameIcon.png"));
			keyMap = ImageIO.read(new File("src/images/KeyMap.png"));
		}catch (IOException e ) {
			e.printStackTrace();
		}
		this.manager = manager;
	
	
	}
	
	public void update(){}


	public void draw(Graphics2D graphics) {
	    graphics.drawImage(image, 0, 0,1650, 550, null);      
	    graphics.drawImage(start, 600, 0, null);  
	    graphics.drawImage(scores, 600, 100, null);
	    graphics.drawImage(credits, 600, 200, null);
	    graphics.drawImage(exit, 600, 300, null);
	    graphics.drawImage(keyMap, 100, 250,null);

	}
	
	public void keyPressed(int key){
		if(key == KeyEvent.VK_P){
			manager.setState(manager.getPlayState());
		}
	}
}
