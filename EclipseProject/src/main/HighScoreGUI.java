package main;

import main.HighScore;

import java.awt.Graphics2D;

public class HighScoreGUI extends MapObject {
	private HighScore highScore = new HighScore();
	private int score = 0;
	
	public HighScoreGUI(){
		super(1500,10);
		highScore.start();
		//Not sure if we need to buffer an image or not, will decide later		
	}
	
	@Override
	public void draw(Graphics2D graphics) {
		// can change the font later
		String display = "Score: " + score;
		graphics.drawString(display, getXCoord(), getYCoord());
		

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		movement();

	}

	@Override
	protected void movement() {
		// TODO Auto-generated method stub
		score = highScore.getUserScore();

	}

}
