//Team 11 , CPSC 233
import java.util.Random;
import java.util.Scanner;

public class GuessingGame{
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    int randomNumber = new Random().nextInt(10);

    // Sets up output
    System.out.println(randomNumber);
    System.out.println("I'm thinking of a number between 0-9.");

    // A while loop to make sure a valid input is entered
    boolean needInput = true;
    while (needInput){
      System.out.print("Guess a number: ");
      String guessAsString = keyboard.nextLine();
      // Gets length of input to determine if 1
      int lengthOfGuess = guessAsString.length();

      // Determines if the input is valid or not
      if (lengthOfGuess == 1) {
        // Gets the character to check if it is a digit
        char charGuess = guessAsString.charAt(0);
        boolean guessDigit = Character.isDigit(charGuess);
        if (guessDigit) {
          int guess = Integer.parseInt(guessAsString);
          // If user guess matches random number, then program will finish
          if (guess == randomNumber) {
            System.out.println("You got it right!");
            needInput = false;
          }
          // If use guess is too small, program will continue promping user
          else if (guess < randomNumber) {
            System.out.println("Too small");
          }
          // If use guess is too big, program will continue promping user
          else {
            System.out.println("Too big");
          }
        }
        // If user input is not a 1 digit number between 0 to 9, program will promp invalid input
        // and will continue promping user
        else {
          System.out.println("Invalid input, try again"); //isn't digit
        }
      }
      else {
        System.out.println("Invalid input, try again"); //if not length 1
      }
    }
  }

}
