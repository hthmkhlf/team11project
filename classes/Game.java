/**
* @author: Haithem Khelif
* Team: 11
* @since: 13/02/2017 1:02 AM
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
    public User user = new User();
    public Obstacle obstacle = new Obstacle();
    public Interface configuration = new Interface();
    public GameStats stats = new GameStats();

/* This Class will gather all the data needed from the other classes
* Will not return anything
*/
    private void Setup() {
      // int Y_MIN = 0;
      // int Y_MAX = 2;
      // int X_MIN = 0;
      boolean obstacle_hit = false;
      int player_x_value = ;
      int player_y_value = ;
      int obstacle_y_value = ;
      int obstacle_y_value1 = ;
      int obstacle_y_value2 = ;
    }

/**
* This method gets data from the Obstacle class and the User class.
* Then checks if there is a collision between the player and the obstacle.
* Returns boolean
*/
    private boolean collision(int player_x_value,int player_y_value) {
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
    return obstacle_hit;
    }

/**
* Method acts like a main loop
*/
    private void Play(int player_x_value,int player_y_value,int obstacle_y_value,int obstacle_y_value1,int obstacle_y_value2) {

      while (obstacle_hit == false){
        System.out.println("You are at x:" + player_x_value + " y:" + player_y_value);
        System.out.print("The next object is at x:" +obstacle_x_value);
        System.out.print(" y:" + obstacle_y_value1);
        System.out.println("," + obstacle_y_value2);
        System.out.println("Enter j to move up one x-block (jump over obstacle), s to move down one y-block (slide under an obstacle), any other key to just keep running");

        String player_input = keyboard.next();

    }
  }
}
