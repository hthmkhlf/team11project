package map;

import main.HighScore;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author Josh Schijns and Emily Flanagan.
 * This class is a child class to MapObject.
 * The methods in this class create the GUI for the score of the current player (the score
 * which is displayed on-screen during gameplay).
 */

public class HighScoreGUI extends MapObject {
	private HighScore highScore;
	private Coin coin;
	private BufferedImage coinIcon;
	private int score = 0;
	private int coinScore = 0;
	private boolean gameOver = false;
	
	public HighScoreGUI() {
		super(1500, 50);
		highScore = new HighScore();
		highScore.setUserName();
		highScore.start();
		coin = new Coin();
		try {
			coinIcon = ImageIO.read(new File("src/images/coin1.png"));
		} catch(IllegalArgumentException iae) {
			ErrorMessage.addError("Image is null in HighScoreGUI");
		} catch (IOException ioe) {
			ErrorMessage.addError("Error reading image for coin1");
		}
	}
	
	@Override
	public void draw(Graphics2D graphics) {
		String display = ("Score: " + score);
		String coinScoreString = "" + coinScore;
		graphics.setColor(Color.BLACK);
		graphics.drawString(display, getXCoord(), getYCoord() + 25);
		graphics.drawImage(coinIcon, getXCoord() + 75, getYCoord() + 10, 20, 20, null);
		graphics.drawString(coinScoreString, getXCoord() + 100, getYCoord() + 25);
		if (gameOver) {
			graphics.setFont(new Font ("Garamond", Font.BOLD, 100));
			graphics.drawString("GAME OVER", 500, 250);
		}
	}

	@Override
	public void movement() {
		score = highScore.getUserScore();
		coinScore = coin.getCollectedcoins();
	}
	
	/**
	 * This method calls the gameHasEnded() method from the HighScore class.
	 * It stops the accumulation of points and declares game over.
	 */
	public void gameOver(){
		highScore.gameHasEnded();
		gameOver = true;
	}

}
