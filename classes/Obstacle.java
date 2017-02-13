/**
 * @author  Katie Tieu
 * This class is to be used in conjunction with Game.java.
 * The methods in this class will be used to generate obstacles which the player character must avoid.
 */

public class Obstacle {
  int obstacle_x_value;
  int obstacle_y_value1;
  int obstacle_y_value2;

  /**
   * This method randomly generates the coordinates of the first obstacle in the game
   * All obstacles have a height of 2.
   * The bottom coordinate of the obstacle is determined by the randomly generated number.
   * The top coordinate is determined by the if statement.
   */
  void generateFirstObstacle() {
    obstacle_x_value = new Random().nextInt(2);
    obstacle_x_value = player_x_value + 1;
    obstacle_y_value1 = new Random().nextInt(2);
    obstacle_y_value2 = 0;
    if (obstacle_y_value1 == 0){
      obstacle_y_value2 = 1;
    } else if (obstacle_y_value1 == 1){
      obstacle_y_value2 = 2;
    }
  }

  /**
   * This method generates all consequent obstacles after the first one.
   * If the player has successfully passed the last obstacle, a new one will be generated.
   */
  void generateConsequentObstacles() {
    if (player_x_value > obstacle_x_value){
      obstacle_x_value = new Random().nextInt(2);
      obstacle_x_value = player_x_value + obstacle_x_value + 1;
      obstacle_y_value1 = new Random().nextInt(2);
      if (obstacle_y_value1 == 0){
        obstacle_y_value2 = 1;
      } else if (obstacle_y_value1 == 1){
        obstacle_y_value2 = 2;
      }
    }
  }

}
