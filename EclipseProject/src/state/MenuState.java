package state;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import main.Manager;

import javax.imageio.ImageIO;

public class MenuState {
//	 BackGround image
	private BufferedImage image,Start,Scores,Credits,Exit,KeyMap;
	private Manager manager;

	//Initiate Game Status
	
	public MenuState(Manager manager){		
		try {
			image = ImageIO.read(new File("src/images/background.png"));
	
		}catch (IOException e ) {
			e.printStackTrace();
		}
				
		try {
			Start = ImageIO.read(new File("src/images/startGameIcon.png"));
		}catch (IOException e ) {
			e.printStackTrace();
		}
	
	
		try {
			Scores = ImageIO.read(new File("src/images/Scores.png"));
		}catch (IOException e ) {
			e.printStackTrace();
		}
	
		try {
			Credits = ImageIO.read(new File("src/images/Credits.png"));
		}catch (IOException e ) {
			e.printStackTrace();
		}
		
		try {
			Exit = ImageIO.read(new File("src/images/endGameIcon.png"));
		}catch (IOException e ) {
			e.printStackTrace();
		}
		
		try {
			KeyMap = ImageIO.read(new File("src/images/KeyMap.png"));
		}catch (IOException e ) {
			e.printStackTrace();
		}
		
		this.manager = manager;
	
	
	}


	public void draw(Graphics2D graphics) {
	    graphics.drawImage(image, 0, 0,1650, 550, null);      
	    graphics.drawImage(Start, 600, 0, null);  
	    graphics.drawImage(Scores, 600, 100, null);
	    graphics.drawImage(Credits, 600, 200, null);
	    graphics.drawImage(Exit, 600, 300, null);
	    graphics.drawImage(KeyMap, 100, 250,null);

	}
	
	public void keyPressed(int key){
		if(key == KeyEvent.VK_P){
			manager.setState(manager.getPlayState());
		}
	}
}
