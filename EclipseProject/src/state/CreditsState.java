package state;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

import main.Manager;
import main.Main;

public class CreditsState extends Main {
	private Manager manager;
	private String teamMembers[];
	private String titles[];
	private Font namesFont;
	private Font titlesFont;



	public CreditsState(Manager manager) {
		//Names are sorted alphabetically
		teamMembers = new String[] { "Dou, Zhi Chao", "Flanagan, Emily", "Haithem Khelif","Josh Schijns","Katie Tieu"};
		//
		titles = new String[] {"Team Members","About The Used Images"};
		// Font Used and Images If required
		namesFont = new Font ("Courier New", 1, 20);
		titlesFont = new Font ("Courier New", 2, 25);
	}
	
	public void draw(Graphics2D graphics) {
//		graphics.setBackground(Color.BLACK);
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, 1650, 550);
		graphics.setFont(titlesFont);
		
		
		graphics.setFont (namesFont);
		for (int i=0; i < 5; i++) {
			graphics.setColor(Color.WHITE);
			graphics.drawString(teamMembers[i],775, 175+ i*25);
			}

	}
	public void keyPressed(int key){
		if(key == KeyEvent.VK_R){
			manager.setState(manager.getMenuState());
		}
	}
	
}
