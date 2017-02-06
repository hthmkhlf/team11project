public class Game {
    User user = new User;
    Obstacle obstacle = new Obstacle;
    Interface configuration = new Interface;


    public void Setup() {
      int Y_MIN = 0;
      int Y_MAX = 2;
      int X_MIN = 0;
      boolean obstacle_hit = false;
      int player_x_value = 0;
      int player_y_value = 1;
    }

    public void Play() {
      //Main loop
      while (obstacle_hit == false){
          System.out.println("You are at x:" + player_x_value + " y:" + player_y_value);
          System.out.print("The next object is at x:" +obstacle_x_value);
          System.out.print(" y:" + obstacle_y_value1);
          System.out.println("," + obstacle_y_value2);
          System.out.println("Enter j to move up one x-block (jump over obstacle), s to move down one y-block (slide under an obstacle), any other key to just keep running");

          String player_input = keyboard.next();

    }

    public void collision() {
    // Check if there is a collision between the player and the obstacle.
                //check if player hits obstacle
            if (player_x_value == obstacle_x_value){
              if ((player_y_value == obstacle_y_value1) || (player_y_value == obstacle_y_value2)) {
                  obstacle_hit = true;
                  System.out.println("You hit the obstacle");
              }
            }
            // if user avoids the obstacle by jumping or sliding the player values will increase so they will fully pass the obstacle.
            if ((player_input.equals("s")) || (player_input.equals("j"))) {
              player_x_value= player_x_value +1;
            }

    }
}
