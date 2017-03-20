import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

/**
*@author Emily Flanagan
*@since 2017-03-20
*/

public class HighScore{
  private boolean gameInProgress = true;
  private int userScore = 0;
  public int currentHighScore = 0;
  private Timer score = new Timer();

/**
*/
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

/**
* defines the event for Timer; adds 1 point to user score every second
*/
  TimerTask count = new TimerTask() {
    public void run(){
      userScore++;
    }
  };

/**
* Starts the timer
*/
  public void start() {
    score.scheduleAtFixedRate(count, 0, 3000);
  }

//high score validation
/**
* Finds the previous high score from the file HighScores.txt
* Used by Game class
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
* Takes the currentHighScore from the game class and compares it to the one
* written in from the file. Called by runHighScore.
*/
  public boolean compareScores(){
    boolean isHigher = false;
    System.out.println("Your score is " + this.userScore);
    if (this.userScore > this.currentHighScore){
      isHigher = true;
    }else{
      isHigher = false;
    }
    return isHigher;
  }

/**
* Changes score in HighScores.txt file to the new score, if applicable
*/
  public void writeInNewScore(){
    String fileName = "HighScores.txt";
    BufferedWriter bWriter = null;
    FileWriter fWriter = null;

    try{
      String writeIn = String.valueOf(this.userScore);
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

/**
* Called by Game class when collision occurs (game over);
* Calls compareScores. Prints the high score to screen and
* records it in file for next game occurance.
*/
  public void gameHasEnded(){
    gameInProgress = false;
    score.cancel();
    currentHighScore = highScore.previousHighScore();
    boolean isHigher = highScore.compareScores();
    if (isHigher){
      System.out.println("You got the new high score!");
      highScore.writeInNewScore();
    }
    else{
      System.out.println("You did not get a new high score.");
      System.out.println("The score to beat is " + currentHighScore);
    }
  }

}
