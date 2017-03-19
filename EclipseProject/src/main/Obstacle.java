package main;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;

import java.util.Random;
import java.util.Timer;
//???????????????????????????????????????
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author  Katie Tieu
 * This class is to be used by the Game class.
 * The methods in this class will be used to generate obstacles which the player character must avoid.
 */

public class Obstacle extends MapObject {
  private Image image;

  public Obstacle() {
    this(1600, 0, 150, 75);
  }

  public Obstacle(int x, int y, int height, int width) {
    super(x, y, height, width);
    try {
      image = ImageIO.read(new File("src/images/obstacle2.png"));
    } catch(IOException e) {
      e.printStackTrace();  // This will print errors to the console
    }

//???????????????????????????????????????
    Timer timer = new Timer(200, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          movement();
          draw();
        }
      });
  }


  public Obstacle(Obstacle other) {
    super(other.getXCoord(), other.getYCoord(), 75, 75);
  }

//???????????????????????????????????????
  public void draw(Graphics2D graphics) {
    graphics.drawImage(image, getXCoord(), getYCoord(), getHeight(), getWidth(), null);
  }

//???????????????????????????????????????
  public void update() {
    movement();
  }

//???????????????????????????????????????
  protected void movement() {
    setX(getXCoord() - 1);
  }

  /**
   * This method generates the y-coordinate for a new obstacle.
   * This coordinate will either be 0 or 175.
   */
  public void generateTopY() {
    int chance = new Random().nextInt(2);
    if (chance == 0) {
      setY(0);
    }
    else if (chance == 1) {
      setY(175);
    }
  }

  /**
   * This method generates the y-coordinate for a second obstacle.
   * This y-coordinate will always be one higher than that of the first obstacle (175 or 350)
   * so they will be stacked on top of each other.
   * @param other the other (top) obstacle from which the y-coordinate is taken and added to.
   */
  // public void generateBottomY(Obstacle other) {
  //   other = new Obstacle(other);
  //   setY(other.getYCoord() + 175);
  // }

}
