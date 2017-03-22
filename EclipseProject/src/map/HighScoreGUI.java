package map;

import main.HighScore;

import java.awt.Graphics2D;
/**
 * Creates the GUI for the Score of the current Player
 * @author Josh Schijns and Emily Flanagan.
 *
 */
public class HighScoreGUI extends MapObject {
	private HighScore highScore = new HighScore();
	private int score = 0;
	
	public HighScoreGUI(){
		super(1500,10);
		highScore.start();		
	}
	
	@Override
	public void draw(Graphics2D graphics) {
		String display = "Score: " + score;
		graphics.drawString(display, getXCoord(), getYCoord());
	}

	@Override
	public void update() {
		movement();
	}

	@Override
	protected void movement() {
		score = highScore.getUserScore();
	}
}
