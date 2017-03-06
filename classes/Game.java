/**
* @author Haithem Khelif
* Team: 11
* @since 26/02/2017 12:00 PM
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
  private User user = new User();
  private Grid grid = new Grid();
  // public FrameTimerMain userFrameTimer = new FrameTimerMain();
  private Obstacle obstacle = new Obstacle();
  
  private UserScore userScoreKeeping = new UserScore();
  private HighScoreMain highscoreCheck = new HighScoreMain();

  public void play() {
    boolean obstacle_hit = false;
    //This is the main loop once the player hits an obstacle the game os over.
    while (!obstacle_hit) {
      grid.drawGrid(user.getLocationX(),user.getLocationY(),obstacle.getLocationX()
        ,obstacle.getLocationY(),obstacle.getLocationX(),obstacle.getLocationY());
      user.movement();
      grid.adjustGrid();
      if ((user.getCollision(obstacle.getLocationX(),obstacle.getLocationY())) ||
        ( user.getCollision(obstacle.getLocationX(),obstacle.getLocationY()))) {
        obstacle_hit = true;
        System.out.println("You hit the obstacle Game Over");
      }
    }
    //In progress
    // int userScore = userScoreKeeping.gameHasEnded();
    // highscoreCheck.setUserNewScore(userScore);
    // highscoreCheck.runHighScore(userScore);
  }
}
