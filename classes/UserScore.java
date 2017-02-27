import java.util.Timer;
import java.util.TimerTask;

public class UserScore{
  boolean gameInProgress = true;
  int userScore = 0;
  Timer score = new Timer();

  TimerTask count = new TimerTask() {
    public void run(){
      userScore++;
    }
    };

  public int gameHasEnded(){
        gameInProgress = false;
        score.cancel();
        System.out.println("UserScore " + userScore);
    return userScore;
  }

  public void start() {
    score.scheduleAtFixedRate(count, 0, 3000);
    }

  }

//So in the game class after the loop has ended call userScore = UserScore.gameHasEnded() to end the
//timer and stop counting score. it will return score to the main class, then call
//highscore main class to compare them.
