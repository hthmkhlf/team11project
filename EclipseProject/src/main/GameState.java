package main;

public class GameState {
	
	public enum STATE {
		GAME,
		MENU,
		SCORES,
		CREDITS
	}
	
	STATE aState;
	int state;
	
	public GameState(STATE aState) {
		this.aState = aState;
	}
	

	public void State() {
		switch(aState) {
		case GAME:
			state = 1;
			break;
		case MENU:
			state = 2;
			break;
		case SCORES:
			state = 3;
			break;
		case CREDITS:
			state = 4;
			break;
		default:
			state = 1;
			break;
			
		}
	}
}
