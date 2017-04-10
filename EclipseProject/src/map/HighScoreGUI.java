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
 * Creates the GUI for the Score of the current Player
 * @author Josh Schijns and Emily Flanagan.
 *
 */
public class HighScoreGUI extends MapObject {
	private HighScore highScore;
	private Coin coin;
	private int score = 0;
	private int coinScore = 0;
	private boolean gameOver = false;
	private BufferedImage coinIcon;
	
	public HighScoreGUI(){
		super(1500,50);
		highScore = new HighScore();
		highScore.setUserName();
		highScore.start();
		coin = new Coin();
		try {
			coinIcon = ImageIO.read(new File("src/images/coin1.png"));
		}catch (IOException e ) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void draw(Graphics2D graphics) {
		String display = ("Score: " + score);
		String coinScoreString = ""+coinScore;
		graphics.setColor(Color.BLACK);
		graphics.drawString(display, getXCoord(), getYCoord()+25);
		graphics.drawImage(coinIcon, getXCoord()+75, getYCoord()+10,20,20,null);
		graphics.drawString(coinScoreString, getXCoord()+100, getYCoord()+25);
		if(gameOver){
			graphics.setFont(new Font ("Garamond", Font.BOLD , 100));
			graphics.drawString("GAME OVER", 500, 250);
		}
	}

	@Override
	public void movement() {
		score = highScore.getUserScore();
		coinScore = coin.getCollectedcoins();
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
