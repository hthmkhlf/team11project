

public class HighScoreMain{
  private int userNewScore = 0;

  int setUserNewScore( int newScore){
    userNewScore = newScore;
  }

  public void runHighScore(int userNewScore){
    HighScore highScore = new HighScore();
    int currentHighScore = highScore.previousHighScore();
    boolean isHigher = highScore.compareScores(currentHighScore, userNewScore);
    if (isHigher){
      System.out.println("You got the new high score!");
      highScore.writeInNewScore(userNewScore);
    }
    else{
      System.out.println("You did not get a new high score.");
      System.out.println("The score to beat is " + currentHighScore);
    }
  }
}
