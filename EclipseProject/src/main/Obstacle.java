import java.util.Random;

/**
 * @author  Katie Tieu
 * This class is to be used by the Game class.
 * The methods in this class will be used to generate obstacles which the player character must avoid.
 */

public class Obstacle extends Location {
  private int distanceFromPlayer = 0;

  public Obstacle() {
    super(0,0);
  }

  public Obstacle(int x, int y) {
    super(x,y);
  }

  public Obstacle(Obstacle other) {
    super(other.getXCoord(), other.getYCoord());
  }

  /**
   * This method checks generates the x-coordinate for a new obstacle.
   * The distance from the player is random, but it will always be 1-2 spaces in front of them.
   * @param player_x_value the user's x-coordinate which is used to determine the location of the next obstacle
   */
  public void generateTopX(int player_x_value) {
    distanceFromPlayer = new Random().nextInt(2) + 1;
    setX(player_x_value + distanceFromPlayer);
  }

  /**
   * This method generates the y-coordinate for a new obstacle.
   * This coordinate will either be 0 or 1.
   */
  public void generateTopY() {
    setY(new Random().nextInt(2));
  }

  /**
   * This method generates the x-coordinate for a second obstacle.
   * This x-coordinate will always be the same as that of the first obstacle.
   * @param other the other (top) obstacle from which the x-coordinate is taken.
   */
  public void generateBottomX(Obstacle other) {
    other = new Obstacle(other);
    setX(other.getXCoord());
  }

  /**
   * This method generates the y-coordinate for a second obstacle.
   * This y-coordinate will always be one higher than that of the first obstacle (1 or 2)
   * so they will be stacked on top of each other.
   * @param other the other (top) obstacle from which the y-coordinate is taken and added to.
   */
  public void generateBottomY(Obstacle other) {
    other = new Obstacle(other);
    setY(other.getYCoord() + 1);
  }

}
