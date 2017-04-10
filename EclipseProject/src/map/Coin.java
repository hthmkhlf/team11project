package map;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

import music.MusicPlayer;

public class Coin extends Collidable {
	
	private BufferedImage[] coin = new BufferedImage[8];
	private int frameNum = 0;
	private int coinPosition;
	private static int coinsCollected = 0;
	private boolean collected = false;
	private MusicPlayer music;
	
	
	public Coin(){
		super(1800,200,45,48);
		for(int frame = 0; frame < 8; frame++)
			try {
				coin[frame] = ImageIO.read(new File("src/images/coin" +(frame+1) + ".png"));
			}catch (IOException e ) {
					e.printStackTrace();
			}
		music = new MusicPlayer("src/soundEffects/coin.wav");
	}
	
	// not sure if we need
	public Coin(Coin other) {
		super(other.getXCoord(), other.getYCoord(), other.getHeight(), other.getWidth());
	}

	@Override
	public void collisionAction(Player player) {
		if(!collected){
			System.out.println("Got a Coin!");
			music.play(false);
			collected = true;
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

}
