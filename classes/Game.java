/**
* @author: Haithem Khelif
* Team: 11
* @since: 26/02/2017 10:?? PM
*
* This class "Game.java" is the main class in order to
* have the game running all the other classe should be
* within the same directory.I made all the methods private
* because other classes must serve this class and not vice versa.
*/

import java.util.Scanner;
import java.util.Random;
public class Game {

/*
* Create class instances and objects.
*/
  // public User userUser = new User();
  public Grid userGrid = new Grid();
  public Interface userInterface = new Interface();
  public FrameTimerMain userFrameTimer = new FrameTimerMain();
  public Location userLocation = new Location(0,1);
  public Obstacle userObstacle = new Obstacle();
  public HighScoreMain userHighScore = new HighScoreMain();


/* This Class will gather all the data needed from the other classes
* Will not return anything
*/
    private void Setup() {
      boolean obstacle_hit = false;
      int obstacle_x_value;
      int obstacle_y_value;
      int distanceFromPlayer;
      int xCoordinate;
      int yCoordinate;
    }

/**
* This method gets data from the Obstacle class and the User class.
* Then checks if there is a collision between the player and the obstacle.
* Returns boolean
*/
    // private boolean Collision(int player_x_value,int player_y_value) {
    //   if (player_x_value == obstacle_x_value){
    //     if ((player_y_value == obstacle_y_value1) || (player_y_value == obstacle_y_value2)) {
    //         obstacle_hit = true;
    //         System.out.println("You hit the obstacle");
    //     }
    //   }
    //   // if user avoids the obstacle by jumping or sliding the player values will increase so they will fully pass the obstacle.
    //   if ((player_input.equals("s")) || (player_input.equals("j"))) {
    //     player_x_value= player_x_value +1;
    //   }
    // return obstacle_hit;
    // }
}
