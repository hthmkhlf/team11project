//call this class when obstacle3 is created

package map;
import java.awt.Graphics2d;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;

/**
 * @author Katie Tieu
 * This class is a child class to MapObject           //may need to change if Collectable class is made
 * The methods in this class will be used to generate collectable objects which give the
 * player a height boost when jumping.
 */

public class Boost extends MapObject{
  private Image image;

  public Boost(){
    this(1600, 300, 80, 80);   //may need to change coordinates/size
  }

  public Boost(Obstacle obs){
    this(obs.getXCoord() - 200, 300, 80, 80);
  }

  public Boost(int newX, int newY, int newHeight, int newWidth){
    setX(newX);
    setY(newY);
    setHeight(newHeight);
    setWidth(newWidth);
    try{
      image = ImageIO.read(new File("src/image/boost.png"));  //may need to change file name
    }catch (IOException e){
      e.printStackTrace();  // This will print errors to the console
    }
  }

  @Override
  public void draw(Graphics2D graphics){
    graphics.drawImage(image, getXCoord(), getYCoord(), getWidth(), getHeight());
  }

  @Override
  public void update(){       //Get rid of this later, I just put it in for now
    movement();
  }

  @Override
  public void movement(){
    setX((int)(getXCoord() - getScroll()));
  }

  public void boostUp(){
    
  }

}
