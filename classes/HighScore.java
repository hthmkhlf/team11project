import java.io.*;

public class HighScore{

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

    int currentHighScore = Integer.parseInt(scoreInFile);
    return currentHighScore;
  }

  public boolean compareScores(int currentHighScore, int userNewScore){
    boolean isHigher = false;
    System.out.println("Your score is " + userNewScore);
    if (userNewScore>currentHighScore){
      isHigher = true;
    }else{
      isHigher = false;
    }
    return isHigher;
  }

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

}
