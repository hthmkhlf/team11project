package main;

import map.ErrorMessage;
import state.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;



/**
 * @author Josh Schijns Haithem Khelif
 * This class manages the state of the game.
 */

public class Manager {
	private enum State {MENU,PLAY,CREDIT,SCORES}
	private PlayState play;
	private MenuState menu;
	private State currentState;
	private CreditState credit;
	private ScoreState score;
	private BufferedImage image;

	public Manager() {
		currentState = State.MENU;
		loadState(currentState);
		try {
            image = ImageIO.read(new File("src/images/loadingScreen.png"));
		} catch(IllegalArgumentException iae) {
			ErrorMessage.addError("Image is null in Manager");
        } catch (IOException ioe) {
        	ErrorMessage.addError("Error reading image for loadingScreen");
        }
	}
	
	public State getState(String aState) {
		return State.valueOf(aState);
	}
	
	public void loadState(State state) {
		if (currentState.equals(State.MENU)) {
			if(menu == null){
				menu = new MenuState(this);
			}
		} else if(currentState.equals(State.PLAY)) {
			play = new PlayState(this);
		} else if (currentState.equals(State.CREDIT)) {
			credit = new CreditState(this);
		} else if (currentState.equals(State.SCORES)) {
			score = new ScoreState(this);
		}
	}
	
	private void unloadState(State state) {
		currentState = null;
	}
	
	public void setState(State state) {
		unloadState(currentState);
		currentState = state;
		loadState(currentState);
	}
	
	public void update() {
		try {
			if (currentState.equals(State.MENU)) {
				menu.update();
			} else if (currentState.equals(State.PLAY)) {
				play.update();
			} else if (currentState.equals(State.CREDIT)) {
				credit.update();
			} else if (currentState.equals(State.SCORES)) {
				score.update();
			}
		} catch (NullPointerException e) {
			// do nothing
		}
	}
	
	public void draw(Graphics2D graphics) {
		try {
			if (currentState.equals(State.MENU)) {
				menu.draw(graphics);
			} else if (currentState.equals(State.PLAY)) {
				play.draw(graphics);
			} else if (currentState.equals(State.CREDIT)) {
				credit.draw(graphics);
			} else if (currentState.equals(State.SCORES)) {
				score.draw(graphics);
			}
		} catch (NullPointerException exception) {
			graphics.drawImage(image,0,0,1650,550,null);
		}
		
	}
	
	public void keyPressed(int key) {
		if (currentState.equals(State.MENU)) {
			menu.keyPressed(key);
		} else if (currentState.equals(State.PLAY)) {
			play.keyPressed(key);
		} else if (currentState.equals(State.CREDIT)) {
			credit.keyPressed(key);
		} else if (currentState.equals(State.SCORES)) {
			score.keyPressed(key);
		}
	}
	
	public void keyReleased(int key) {
		if (currentState.equals(State.MENU)) {
//			menu.keyReleased(key);
		} else if (currentState.equals(State.PLAY)) {
			play.keyReleased(key);
		} else if (currentState.equals(State.CREDIT)) {
//			credit.keyReleased(key);
		} else if (currentState.equals(State.SCORES)) {
//			score.keyReleased(key);
		}
	}
	
	
}
