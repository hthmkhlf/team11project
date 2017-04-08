package state;

import java.awt.Color;
import java.awt.Desktop;
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
//	private Desktop desktop;
//	private String url = "https://github.com/haidev12/Team-11/blob/master/README.md";
//    Desktop desktop = Desktop.getDesktop();



	public CreditsState(Manager manager) {
		//Names are sorted alphabetically
		teamMembers = new String[] { "Dou, Zhi Chao", "Flanagan, Emily", "Haithem Khelif","Josh Schijns","Katie Tieu"};
	}
	
	public void draw(Graphics2D graphics) {
		for (int i=0; i < 5; i++) {
			graphics.setColor(Color.BLACK);
			graphics.drawString(teamMembers[i],700, 150+ i*25);
			}

	}
	public void keyPressed(int key){
		if(key == KeyEvent.VK_R){
			manager.setState(manager.getMenuState());
		}
	}
	
}
