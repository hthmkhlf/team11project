// Team 11 , CPSC 233
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

// This is class is to be used with the GuessingGameTest file.
public class GuessingGame {
  int numToGuess = new Random().nextInt(10);
  ArrayList <String>guesses = new ArrayList<>();
  Scanner keyboard = new Scanner(System.in);

// Get user guesses method. Adds valid user guesses to the array list.
// The while loop is acting as the inner loop and the for loop in the GuessingGameTest file is the outer loop.
// The while loop is nested because the outer for loop in GuessingGameTest.java indirectly calls it
  void getGuess() {
    boolean validGuess = false;
    while(!validGuess) {
      System.out.print("What is your guess: ");
      String userGuess = keyboard.nextLine();
      int lengthOfGuess = userGuess.length();
      if (lengthOfGuess == 1) {
        char guessAsChar = userGuess.charAt(0);
        boolean guessIsDigit = Character.isDigit(guessAsChar);
          if (guessIsDigit) {
            guesses.add(userGuess);
            validGuess = true;
          }
          else {
            System.out.println("Invalid guess. Please enter a number between 0 and 9: ");
          }
      }
      else {
        System.out.println("Invalid guess. Please enter a number between 0 and 9: ");
      }
    }
}
// Loop gets each element of the array and prints them.
  void printGuesses() {
    System.out.print("Your guesses: ");
    for (int counter=0 ;counter<guesses.size();counter++) {
      String index = guesses.get(counter);
      System.out.print(index+" ");
    }
  }
}
