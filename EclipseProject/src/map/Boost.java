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
  private boolean boosted = false;
  
  public Boost(){
    this(1630, 200, 60, 100);   //may need to change coordinates/size
  }

  public Boost(Obstacle obstacle){
	  this(obstacle.getXCoord() - 100, 200, 60, 100);
  }

  public Boost(int newX, int newY, int newHeight, int newWidth){
	  super(newX, newY, newHeight, newWidth);
	  try{
		  image = ImageIO.read(new File("src/images/Boost.png"));
	  }catch(IllegalArgumentException iae){
		  ErrorMessage.addError("Image is null in Boost");
	  }catch (IOException ioe) {
		  ErrorMessage.addError("Error reading image for Boost");
	  }
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
	  if(!boosted){
		  player.boost();
		  boosted = true;
	  }
  }

}
