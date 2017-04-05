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

  public Boost(){
    this(1630, 200, 60, 60);   //may need to change coordinates/size
  }

  public Boost(Obstacle obstacle){
	  this(obstacle.getXCoord() - 70, 200, 60, 60);
  }

  public Boost(int newX, int newY, int newHeight, int newWidth){
    super(newX, newY, newHeight, newWidth);
    try{
      image = ImageIO.read(new File("src/images/boost.png"));
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
  public void movement(){
    setX((int)(getXCoord() - getScroll()));
  }

  // created a method in player to add to the jump speed of the bird temporarily
  @Override
  public void collisionAction(Player player){
	  //maybe include a boost sound effect here
	  player.boost();
  }

}
