package state;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

import main.Manager;
import main.Main;

public class CreditsState extends Main {
	private Manager manager;
	private BufferedImage CreditsBackGround;
	private String teamMembers[];
	private String titles[];
	private String sources[];
	private Font textFont;
	private Font titlesFont;
	private Color aColor = Color.decode("#3A8EF2");



	public CreditsState(Manager manager) {
		//Arrays of multiple strings
		teamMembers = new String[] { "Dou, Zhi Chao", "Flanagan, Emily", "Haithem Khelif","Josh Schijns","Katie Tieu"}; //Names are sorted alphabetically
		titles = new String[] {"Credits","Team Members","Art / Sounds"};
		sources = new String[] {"freesound.org","opengameart.org"};
		// Set Font Used and Import Images If required
		textFont = new Font ("Courier New", 1, 20);
		titlesFont = new Font ("SansSerif.bold", 1, 50);
		
		try {
			CreditsBackGround = ImageIO.read(new File("src/images/background.png"));
		}catch (IOException e ) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D graphics) {
//		graphics.setBackground(Color.BLACK);
		graphics.drawImage(CreditsBackGround, 0,0,1650, 550, null);  
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
		for (int i=0; i <= 1; i++) {
			graphics.setColor(Color.BLACK);
			graphics.drawString(sources[i],700, 400+ i*25);
			}

	}
	public void keyPressed(int key){
		if(key == KeyEvent.VK_R){
			manager.setState(manager.getMenuState());
		}
	}
	
}
