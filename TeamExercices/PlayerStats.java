//Team 11
import java.util.Scanner;
import java.lang.Object;
import java.util.Random;
public class PlayerStats {
  public static void main(String[] args)
  {
    //Declaring Variables
    int userLife,userScore,gameTime,userObstacle;
    String userKey,userLocation;

    Random generator = new Random();
    Scanner userInput = new Scanner(System.in);
    userObstacle = generator.nextInt(5);
    System.out.println(userObstacle);
    System.out.println("Where are you from 0 to 5");
    userLocation = userInput.next();
    int userLocationint = Integer.parseInt(userLocation);

    System.out.print("Enter your action 'w' for jump and 's' for slide ");
    userKey = userInput.next();
    switch (userKey.toLowerCase()){
      case "w":
        //Jump
        System.out.println("Jump");
        userLocationint = userLocationint+1;
        break;
        //Slide
      case "s":
        System.out.println("Slide");
        userLocationint = userLocationint +1;
          break;
      default:
        System.out.println("You are running");
        break;
    }
    if (userLocationint == userObstacle) {
      System.out.println("You crashed");
    }
  }
}
