public class Obstacle {
  int obstacle_x_value;
  int obstacle_y_value1;
  int obstacle_y_value2;

  //Randomize initial object location
  //Objects have a height of 2; if an object spawns at y values of 1 and 2
  //the user has to duck, spawned at 0 and 1 the user has to jump.
  //The bottom coordinate of the obstacleis determined by the randomly generated
  //number, top coordinate is then determined by the if statement
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

  //Checks if the player has successfully passed the obstacle
  //If so, a new obstacle will be generated
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

  void trackObstacleLocation() {
    //to be implemented later
  }

}
