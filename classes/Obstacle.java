import java.util.Random;

/**
 * @author  Katie Tieu
 * This class is meant to be used by the Game class.
 * The methods in this class will be used to generate obstacles
 * which the player character must avoid.
 */

public class Obstacle {
  private int obstacle_x_value = -1;
  private int obstacle_y_value = 0;
  private int distanceFromPlayer = 0;

  /**
   * This method generates the x-coordinate for a new obstacle.
   * The distance from the player is random, but it will always be
   * between 1-3 spaces in front of them.
   */
  private void generateObstacleXValue(int player_x_value) {
    distanceFromPlayer = new Random().nextInt(3) + 1;
    obstacle_x_value = player_x_value + distanceFromPlayer;
  }

  /**
   * This method generates the y-coordinate for a new obstacle.
   * This coordinate will either be 0 or 1
   */
  private void generateObstacleYValue() {
    obstacle_y_value = new Random().nextInt(2);
  }

  /**
   * This method allows the new x-coordinate to be passed to
   * the main Game class.
   */
  public int getObstacleX() {
    return obstacle_x_value;
  }

  /**
   * This method allows the new y-coordinate to be passed to
   * the main Game class.
   */
  public int getObstacleY() {
    return obstacle_y_value;
  }

}
