package main;

import java.awt.Font;
import java.awt.Graphics2D;
import state.*;


/**
 * @author Josh Schijns Haithem Khelif
 * This class manages the state of the game, for now there is only one state.
 */
public class Manager {
	private enum State {MENU,PLAY,SCORES,CREDITS,EXIT} //Just add any other states into here
	private PlayState play;
	private MenuState menu;
	private CreditsState credits;
	private Scores scoreBoard;
	private State currentState;


	public Manager(){
		currentState = State.CREDITS;
		loadState(currentState);
	}
	
	// Not sure if this is the right way to do it.
	public State getMenuState() {
	return State.MENU;
	}
	public State getPlayState(){
		return State.PLAY;
	}
	
	public State getCreditsState() {
		return State.CREDITS;
	}
	
	public State getScoresState() {
		return State.SCORES;
	}
	
//	public State getExitState() {
//		return State.EXIT;
//	}
	
	public void loadState(State state){
		if(currentState.equals(State.MENU)){
			menu = new MenuState(this);
		}
		if(currentState.equals(State.PLAY)){
			play = new PlayState(this);
		}
		if(currentState.equals(State.SCORES)){
			scoreBoard = new Scores(this);
		}
		if(currentState.equals(State.CREDITS)){
			credits = new CreditsState(this);
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
			if(currentState.equals(State.CREDITS)){
//				credits.update();
			}
			if(currentState.equals(State.SCORES)){
				scoreBoard.update();
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
			if(currentState.equals(State.CREDITS)){
				credits.draw(graphics);
			}
			if(currentState.equals(State.SCORES)){
				scoreBoard.draw(graphics);
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
