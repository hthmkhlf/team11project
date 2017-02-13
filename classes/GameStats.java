public class GameStats{
  int MAX_DIFFICULTY = 5

  int time = 0;
  int difficulty = 0;
  int score = 0;
  int highScore = 0;


  public void checkHighscore(){
    highScore = ; //write in high score from file
    if (userScore > score){
      highScore = score;
      System.out.println("You got the new high score!");
      System.out.println(userName + score);
    }
  }
  public void Tracktime(){
  //runs timer
  //at time:
  //call interface to redraw frame
  //at timer
  time = time + 1;
  System.out.println("Time:" +time);
  }

  public void score(){
    score = time*10;
  }

  public void updateDifficulty(){
    if (difficulty < MAX_DIFFICULTY){
      if (timeInterval > 100){
        difficulty = difficulty + 1;
      }
    else{
      System.out.println("Max speed reached!");
    }
    }
  }
}
