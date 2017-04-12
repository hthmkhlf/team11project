package map;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

import javax.imageio.ImageIO;

import music.MusicPlayer;

public class Coin extends Collidable {
	
	private BufferedImage[] coin = new BufferedImage[8];
	private int frameNum = 0;
	private static int coinsCollected = 0;
	private boolean collected = false;
	private MusicPlayer music;
	private static final int MAX_Y = 435;
	private static final int MIN_Y = 100;
	private static final int MAX_X = 2300;
	private static final int MIN_X = 1800;
	private Random random = new Random();
	
	
	
	public Coin(){
		super(1800,200,45,48);
		setX(random.nextInt(MAX_X-MIN_X + 1) + MIN_X);
		setY(random.nextInt(MAX_Y-MIN_Y + 1) + MIN_Y);
		for(int frame = 0; frame < 8; frame++)
			try {
				coin[frame] = ImageIO.read(new File("src/images/coin" +(frame+1) + ".png"));
			}catch(IllegalArgumentException iae){
    			ErrorMessage.addError("Image is null in Coin");
			}catch (IOException ioe) {
				ErrorMessage.addError("Error reading image for coin");
			}
		music = new MusicPlayer("src/soundEffects/coinSound.wav");
	}
	
	@Override
	public void collisionAction(Player player) {
		if(!collected){
			collected = true;
			System.out.println("Got a Coin!");
			music.play(false);
			coinsCollected++;
		}

	}

	@Override
	public void draw(Graphics2D graphics) {
		if(!collected){
			int num = frameNum / 5;
			graphics.drawImage(coin[num], getXCoord(),getYCoord(),getWidth(),getHeight(),null);
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
	
	public int getCollectedcoins() {
		return coinsCollected;
		
	}
	
	public static void resetCoin() {
		coinsCollected = 0;
	}

}
