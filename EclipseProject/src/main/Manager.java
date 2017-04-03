package main;

import java.awt.event.KeyEvent;
import state.*;


/**
 * @author Josh Schijns Haithem Khelif
 * This class manages the state of the game, for now there is only one state.
 */
public class Manager {
	private PlayState play;
//	private MenuState menu;
	private int currentState;
	private final int MENU = 0;
	private final int PLAY = 1;

	public Manager(){
		currentState =PLAY;
		loadState(currentState);
	}
	
	public void loadState(int state){
		if(state == MENU){
//			menu = new MenuState();
		}
		if(state == PLAY){
			play = new PlayState();
		}
	}
	
	
	public void update(){
		if(currentState == MENU){
//			menu.update();
		}
		if(currentState == PLAY){
			play.update();
		}
	}
	
	public void draw(java.awt.Graphics2D graphics){
		if(currentState == MENU){
//			menu.draw(graphics);
		}
		if(currentState == PLAY){
			play.draw(graphics);
		}
		
	}
	
	public void keyPressed(int key){
		if(currentState == MENU){
//			menu.keyPressed(key);
		}
		if(currentState == PLAY){
			play.keyPressed(key);
		}
	}
	public void keyReleased(int key){
		if(currentState == MENU){
//			menu.keyReleased(key);
		}
		if(currentState == PLAY){
			play.keyReleased(key);
		}
	}
	
	public void keyReleased(int key){
		if(currentState == MENU){
//			menu.keyReleased(key);
		}
		if(currentState == PLAY){
			play.keyReleased(key);
		}
	}
	
	
}
