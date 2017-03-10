import java.util.Random;
import java.util.Scanner;

public class GuessingGameUpdate{
  public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);
    int randomNumber = new Random().nextInt(10);

    // Sets up output and shows the random number that is generated for testing
    System.out.println(randomNumber);
    System.out.println("I'm thinking of a number between 0-9.");

    // Main Game loop, will continue until a correct number is given

    boolean gameWon = false;
    while (!gameWon){
      // Input validation loop, will exit loop when a string length of one is
      // given and the character is a digit.
      boolean inputNeeded = true;
      String guessString = "0";
      while (inputNeeded){
        System.out.print("Guess a number: ");
        guessString = keyboard.nextLine();
        int lengthOfGuess = guessString.length();
        if (lengthOfGuess == 1){
          char guessChar = guessString.charAt(0);
          boolean guessIsDigit = Character.isDigit(guessChar);
          if(guessIsDigit)
            inputNeeded = false;
          else
            System.out.println("Invalid input, try again");
        }else
          System.out.println("Invalid input, try again");
      }
      // Handles the integer of the guess and compares to random number
      int guessInteger = Integer.parseInt(guessString);
      if (guessInteger == randomNumber){
        System.out.println("You got it right!");
        gameWon = true;
      }else if (guessInteger < randomNumber){
        System.out.println("Too small");
      }else{
        System.out.println("Too big");
      }
    }
  }
}
