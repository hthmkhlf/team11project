package main;

import java.io.*;
import java.util.*;

/**
*@author Emily Flanagan
*@since 2017-03-20
* This is a child class of Game class
*/

public class HighScore{
  private boolean gameInProgress = true;
  private int userScore = 0;
  private int currentHighScore = 0;
  private Timer score = new Timer();

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

  public int getUserScore() {
    return userScore;
  }
/**
* Finds the previous high score from the file HighScores.txt
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
    currentHighScore = this.previousHighScore();
    boolean isHigher = this.compareScores();
    if (isHigher){
      System.out.println("You got the new high score!");
      this.writeInNewScore();
    }
    else{
      System.out.println("You did not get a new high score.");
      System.out.println("The score to beat is " + currentHighScore);
    }
    this.updateHighScoreBoard(this.userName, this.userScore);
  }
  /**
  * Reads all high scores in from the file HighScoreBoard.txt
  *Prints each score on the line with the name of who got it
  */

  public void updateHighScoreBoard(String playerName, int userScore) {
    ArrayList<String> scores = new ArrayList<>();
    String fileName = "HighScoreBoard.txt";
    String line = null;

    try{
      FileReader fileReader = new FileReader(fileName);
      BufferedReader bufferedReader = new BufferedReader(fileReader);

      while((line = bufferedReader.readLine()) != null){
        System.out.println(line);
        scores.add(line);
      }
      bufferedReader.close();
    }
    catch(FileNotFoundException ex){
      System.out.println("Unable to open file");
    }
    catch(IOException ex){
      System.out.println("Error reading file");
    }

    String name = "     " + playerName;
    String newScore = Integer.toString(userScore) + name;
    scores.add(newScore);
    Collections.sort(scores);
    Collections.reverse(scores);
    printBoardToScreen(scores);
}

public void printBoardToScreen(ArrayList scores){
  String fileName = "HighScoreBoard.txt";
  try{
    FileWriter fWriter = new FileWriter(fileName);
    BufferedWriter bWriter = new BufferedWriter(fWriter);
    int size = scores.size();
    if (size>10){
      size = 10;
    }
    for (int i=0; i<size; i++) {
      String writeIn = scores.get(i).toString();
      bWriter.write(writeIn);
      bWriter.newLine();
    }
    bWriter.close();
    fWriter.close();
  }
  catch(IOException ex){
    ex.printStackTrace();
    }
}


}
