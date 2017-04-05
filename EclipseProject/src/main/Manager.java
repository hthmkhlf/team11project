package main;

import java.awt.Font;
import java.awt.Graphics2D;
import state.*;


/**
 * @author Josh Schijns Haithem Khelif
 * This class manages the state of the game, for now there is only one state.
 */
public class Manager {
	private enum State {MENU,PLAY} //Just add any other states into here
	private PlayState play;
	private MenuState menu;
	private State currentState;


	public Manager(){
		currentState = State.MENU;
		loadState(currentState);
	}
	
	public State getPlayState(){
		return State.PLAY;
	}
	
	public void loadState(State state){
		if(currentState.equals(State.MENU)){
			menu = new MenuState(this);
		}
		if(currentState.equals(State.PLAY)){
			play = new PlayState(this);
		}
	}
	
	public void setState(State state){
		currentState = state;
		loadState(currentState);
	}
	
	public void update(){
		try{
			if(currentState.equals(State.MENU)){
				menu.update();
			}
			if(currentState.equals(State.PLAY)){
				play.update();
			}
		}catch (NullPointerException e){}
	}
	
	public void draw(Graphics2D graphics){
		try{
			if(currentState.equals(State.MENU)){
				menu.draw(graphics);
			}
			if(currentState.equals(State.PLAY)){
				play.draw(graphics);
			}
		}catch (NullPointerException exception){
			graphics.setFont(new Font ("Garamond", Font.BOLD , 100));
			graphics.drawString("LOADING", 600, 250);
		}
		
	}
	
	public void keyPressed(int key){
		if(currentState.equals(State.MENU)){
			menu.keyPressed(key);
		}
		if(currentState.equals(State.PLAY)){
			play.keyPressed(key);
		}
	}
	
	public void keyReleased(int key){
		if(currentState.equals(State.MENU)){
//			menu.keyReleased(key);
		}
		if(currentState.equals(State.PLAY)){
			play.keyReleased(key);
		}
	}
	
	
}
