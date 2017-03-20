import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

public class HighScore{
  private int userNewScore = 0;
  private boolean gameInProgress = true;
  private int userScore = 0;
  public int currentHighScore = 0;
  private Timer score = new Timer();

  public void highScoreBoard() {
  String fileName = "HighScoreBoard.txt";
  String line = null;

  try{
    FileReader fileReader = new FileReader(fileName);
    BufferedReader bufferedReader = new BufferedReader(fileReader);

    while((line = bufferedReader.readLine()) != null){
      System.out.println(line);
    }
    bufferedReader.close();
  }
  catch(FileNotFoundException ex){
    System.out.println("Unable to open file");
  }
  catch(IOException ex){
    System.out.println("Error reading file");
  }
}


//user score
//runs a timertask to use as score keeping
  TimerTask count = new TimerTask() {
    public void run(){
      userScore++;
    }
  };
  //used from game class when game has ended timer is stopped and user score is passed through
  public int gameHasEnded(){
    gameInProgress = false;
    score.cancel();
    System.out.println("UserScore " + userScore);
    return userScore;
  }
  //starts timertask
  public void start() {
    score.scheduleAtFixedRate(count, 0, 3000);
  }

//high score validation
/**
*writes in the previous high score from the file HighScores.txt
*to be used with HighScoreMain and Game class
*/
  public int previousHighScore() {
    String fileName = "HighScores.txt";
    String line = null;
    String scoreInFile = "";
    try{
      FileReader fileReader = new FileReader(fileName);
      BufferedReader bufferedReader = new BufferedReader(fileReader);

      while((line = bufferedReader.readLine()) != null){
        scoreInFile = line;
      }
      bufferedReader.close();
    }
    catch(FileNotFoundException ex){
      System.out.println("Unable to open file");
    }
    catch(IOException ex){
      System.out.println("Error reading file");
    }

    currentHighScore = Integer.parseInt(scoreInFile);
    return currentHighScore;
  }

/**
*takes the currentHighScore from the game calss and compares it to the one written
*in from the file
*/
  public boolean compareScores(){
    boolean isHigher = false;
    System.out.println("Your score is " + this.userNewScore);
    if (this.userNewScore > this.currentHighScore){
      isHigher = true;
    }else{
      isHigher = false;
    }
    return isHigher;
  }

/**
changes score in file to the new score if applicable
*/
  public void writeInNewScore(int userNewScore){
    String fileName = "HighScores.txt";
    BufferedWriter bWriter = null;
    FileWriter fWriter = null;

    try{
      String writeIn = String.valueOf(userNewScore);
      fWriter = new FileWriter(fileName);
      bWriter = new BufferedWriter(fWriter);
      bWriter.write(writeIn);
      bWriter.close();
      fWriter.close();
    }
    catch(IOException ex){
      ex.printStackTrace();
      }
  }

// implements high score
//takes score from game class to update user score
  public void setUserNewScore( int newScore){
    userNewScore = newScore;
  }
//takes user score passes it into the highscore class
//compares the two.
  public void runHighScore( int userNewScore){
    HighScore highScore = new HighScore();
    currentHighScore = highScore.previousHighScore();
    boolean isHigher = highScore.compareScores();
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
