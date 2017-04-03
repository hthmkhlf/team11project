//call this class when obstacle3 is created

package map;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;

/**
 * @author Katie Tieu
 * This class is a child class to the Collidable class.
 * The methods in this class will be used to generate collectable objects which give the
 * player a height boost when jumping.
 */

public class Boost extends Collidable{
  private Image image;
  private double boostedJumpSpeed = -15;      // Needs to be adjusted
  private double fallSpeed = 1.5;
  private double distance;
  private final int GROUND = 349;

  public Boost(){
    this(1600, 300, 60, 60);   //may need to change coordinates/size
  }

  public Boost(Obstacle obstacle){
    this(obstacle.getXCoord() - 300, 300, 60, 60);
  }

  public Boost(int newX, int newY, int newHeight, int newWidth){
    super(newX, newY, newHeight, newWidth);
    try{
      image = ImageIO.read(new File("src/image/boost.png"));
    }catch (IOException e){
      e.printStackTrace();  // This will print errors to the console
    }
  }

  public Boost(Boost other){
    super(other.getXCoord(), other.getYCoord(), other.getHeight(), other.getWidth());
  }

  @Override
  public void draw(Graphics2D graphics){
    graphics.drawImage(image, getXCoord(), getYCoord(), getWidth(), getHeight(), null);
  }

  @Override
  public void update(){       //Get rid of this later, I just put it in for now
    movement();
  }

  @Override
  public void movement(){
    setX((int)(getXCoord() - getScroll()));
  }

  // Copied code from movement() in Player
  // Takes player from boost upwards and then down to ground
  // Should merge with Player.movement() at some point to make jumping boolean false
  @Override
  public void collisionAction(Player player){
    for(int timeChange = 0; player.getYCoord() > GROUND;){
      distance = boostedJumpSpeed + (fallSpeed * timeChange);
      player.setY((int)(getYCoord() + distance));
      timeChange++;
    }
  }

}
