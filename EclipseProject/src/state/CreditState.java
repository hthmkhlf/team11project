package state;

import main.Manager;
import map.ErrorMessage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

/**
 * @author Josh Schijins
 * This class controls the displaying of credits, or the "credit state" of the game.
 */

public class CreditState implements GameState {
	private Manager manager;
	private BufferedImage creditsBackGround, zachBlach;
	private String teamMembers[];
	private String titles[];
	private String sources[];
	private Font textFont;
	private Font titlesFont;
	private Color aColor = Color.decode("#3A8EF2");
	
	public CreditState(Manager manager){
		this.manager = manager;
		teamMembers = new String[] { "Dou, Zhi Chao", "Flanagan, Emily", "Khelif, Haithem","Schijins, Josh","Tieu, Katie"};
		titles = new String[] {"Credits","Team Members","Art / Sounds"};
		sources = new String[] {"freesound.org","opengameart.org","DJ Zach Blach"};
		textFont = new Font ("Courier New", 1, 20);
		titlesFont = new Font ("SansSerif.bold", 1, 50);
		
		try {
			creditsBackGround = ImageIO.read(new File("src/images/background.png"));
			zachBlach = ImageIO.read(new File("src/images/DjZachBlach.png"));
		} catch(IllegalArgumentException iae) {
			ErrorMessage.addError("Image is null in Credits");
		} catch (IOException ioe) {
			ErrorMessage.addError("Error reading image for Credits");
		}
	}

	@Override
	public void update() {
		// The credits do not need to change once displayed, so this method does not do anything.
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.drawImage(creditsBackGround, 0,0,1650, 550, null);
		graphics.drawImage(zachBlach, 1000, 200, 500,375,null);
		graphics.setColor(aColor);
		graphics.setFont(titlesFont);
		graphics.drawString(titles[0],700, 50);
		graphics.drawString(titles[1],630, 140);
		graphics.setFont (textFont);
		for (int i=0; i < 5; i++) {
			graphics.setColor(Color.BLACK);
			graphics.drawString(teamMembers[i],720, 190+ i*25);
			}
		graphics.setColor(aColor);
		graphics.setFont(titlesFont);
		graphics.drawString(titles[2],650, 350);
		graphics.setFont(textFont);
		for (int i=0; i <= 2; i++) {
			graphics.setColor(Color.BLACK);
			graphics.drawString(sources[i],700, 400+ i*25);
			}
	}

	@Override
	public void keyPressed(int key) {
		if(key == KeyEvent.VK_R){
			manager.setState(manager.getState("MENU"));
		}

	}

}
