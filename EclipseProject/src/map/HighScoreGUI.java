package map;

import main.HighScore;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
/**
 * Creates the GUI for the Score of the current Player
 * @author Josh Schijns and Emily Flanagan.
 *
 */
public class HighScoreGUI extends MapObject {
	private HighScore highScore;
	private int score = 0;
	private boolean gameOver = false;
	
	public HighScoreGUI(){
		super(1550,50);
		highScore = new HighScore();
		highScore.start();		
	}
	
	@Override
	public void draw(Graphics2D graphics) {
		String display = ("Score: " + score);
		graphics.setColor(Color.BLACK);
		graphics.drawString(display, getXCoord(), getYCoord());
		if(gameOver){
			graphics.setFont(new Font ("Garamond", Font.BOLD , 100));
			graphics.drawString("GAME OVER", 600, 250);
		}
	}

	@Override
	public void movement() {
		score = highScore.getUserScore();
	}

	@Override
	public boolean collisionCheck(Player player) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void gameOver(){
		highScore.gameHasEnded();
		gameOver = true;
	}
}
