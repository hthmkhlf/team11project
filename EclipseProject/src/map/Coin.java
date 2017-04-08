package map;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Coin extends Collidable{
	private BufferedImage[] coin = new BufferedImage[8];
	private int frameNum = 0;
	private int coinPosition;
	Obstacle obstacle = new Obstacle();
	public Coin(){
		this(650);
		
		
	}

	/**
	 * Creates coins off screen. Will have more than one position. Will be on top of each Obstacle.
	 * @param newY
	 */
	public Coin(int newX) {
		// TODO Auto-generated constructor stub
		for(int frame = 0; frame < 8; frame++)
			try {
				coin[frame] = ImageIO.read(new File("src/images/coin" +(frame+1) + ".png"));
			}catch (IOException e ) {
					e.printStackTrace();
			}
		if(obstacle.getObstacleSize() ==1 ) {
			setHeight(50);
			this.setY(490);
		}
		if(obstacle.getObstacleSize() ==2 ) {
			setHeight(50);
			this.setY(515);
		}
		if(obstacle.getObstacleSize() ==3 ) {
			setHeight(50);
			this.setY(620);
		}
	}
	
	public Coin(Coin other) {
		super(other.getXCoord(), other.getYCoord(), other.getHeight(), other.getWidth());
	}
	
	public void draw(Graphics2D graphics){	
		int num = frameNum / 5;
		graphics.drawImage(coin[num], getXCoord(),getYCoord(),getWidth(),getHeight(),null);
		frameNum++;
		if (frameNum == 30){
			frameNum = 0;
		}
	}

	public void movement() {
		setX((int)(getXCoord() - getScroll()));
	}
	@Override
	public void collisionAction(Player player) {
		// TODO Auto-generated method stub
		// Add coin sound when coin is touched.
		
	}

}
