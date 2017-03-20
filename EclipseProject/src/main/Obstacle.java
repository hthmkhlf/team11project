package main;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;
import java.util.Random;

/**
 * @author  Katie Tieu
 * This class is a child class to MapObject.
 * The methods in this class will be used to generate obstacles which the player character must avoid,
 * as well as to move and draw the obstacles.
 * Note that only the y-coordinate is randomly generated in this class; the x-coordinate will be generated
 * at a fixed value using the setX method from the parent class.
 */

public class Obstacle extends MapObject {
  private Image image;

  public Obstacle() {
    this(1600, 0, 350, 175);
  }

  public Obstacle(int x, int y, int height, int width) {
    super(x, y, height, width);
    try {
      image = ImageIO.read(new File("src/images/obstacle2.png"));
    } catch(IOException e) {
      e.printStackTrace();  // This will print errors to the console
    }
  }

  public Obstacle(Obstacle other) {
    super(other.getXCoord(), other.getYCoord(), other.getHeight(), other.getWidth());
  }

  @Override
  public void draw(Graphics2D graphics) {
  	graphics.drawImage(image, getXCoord(),getYCoord(),getWidth(),getHeight(),null);
  }

  @Override
  public void update() {
    movement();
  }

  @Override
  protected void movement() {
    setX((int)(getXCoord() - getScroll()));
  }

  /**
   * This method generates the y-coordinate for a new obstacle.
   * This coordinate will either be 0 or 200.
   */
  public void generateY() {
    int chance = new Random().nextInt(2);
    if (chance == 0) {
      setY(0);
    }
    else if (chance == 1) {
      setY(200);
    }
  }

}
