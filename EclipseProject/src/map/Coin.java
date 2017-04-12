package map;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;
import javax.imageio.ImageIO;
import music.MusicPlayer;

/**
 * @author Haithem Khelif
 * This class is a child class to MapObject.
 * The methods in this class are used to create and manage collectable coins which are
 * counted as the player collects them. 
 */

public class Coin extends Collidable {
	private Random random = new Random();
	private MusicPlayer music;
	private BufferedImage[] coin = new BufferedImage[8];
	private int frameNum = 0;
	private boolean collected = false;
	private static int coinsCollected = 0;
	private static final int MAX_Y = 435;
	private static final int MIN_Y = 100;
	private static final int MAX_X = 2300;
	private static final int MIN_X = 1800;
	
	public Coin() {
		super(1800,200,45,48);
		setX(random.nextInt(MAX_X-MIN_X + 1) + MIN_X);
		setY(random.nextInt(MAX_Y-MIN_Y + 1) + MIN_Y);
		for(int frame = 0; frame < 8; frame++)
			try {
				coin[frame] = ImageIO.read(new File("src/images/coin" +(frame+1) + ".png"));
			} catch(IllegalArgumentException iae){
    			ErrorMessage.addError("Image is null in Coin");
			} catch (IOException ioe) {
				ErrorMessage.addError("Error reading image for coin");
			}
		music = new MusicPlayer("src/soundEffects/coinSound.wav");
	}
	
	@Override
	public void collisionAction(Player player) {
		if(!collected){
			collected = true;
			music.play(false);
			coinsCollected++;
		}
	}

	@Override
	public void draw(Graphics2D graphics) {
		if(!collected){
			int num = frameNum / 5;
			graphics.drawImage(coin[num], getXCoord(), getYCoord(), getWidth(), getHeight(), null);
			frameNum++;
			if (frameNum == 40){
				frameNum = 0;
			}
		}
	}

	@Override
	public void movement() {
		setX((int)(getXCoord() - getScroll()));

	}
	
	/**
	 * This method a getter for coinsCollected.
	 * @return coinsCollected is the number of coins collected by the player during the game.
	 */
	public int getCollectedcoins() {
		return coinsCollected;
	}
	
	/**
	 * This method sets the number of coins collected to 0.
	 */
	public static void resetCoin() {
		coinsCollected = 0;
	}

}
