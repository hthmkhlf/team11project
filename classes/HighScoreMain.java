

public class HighScoreMain{
  public static void main(String[] args){
    HighScore highScore = new HighScore();
    int userNewScore = 0;
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
