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
  public String getGuess() {
    String userGuess = "";
    boolean validGuess = false;
    while(!validGuess) {
      System.out.print("What is your guess: ");
      userGuess = keyboard.nextLine();
      validGuess = isValidGuess(userGuess);
}
  return userGuess;
}
// Loop gets each element of the array and prints them.
  void printGuesses() {
    System.out.print("Your guesses: ");
    for (int counter=0 ;counter<guesses.size();counter++) {
      String index = guesses.get(counter);
      System.out.print(index+" ");
    }
  }
  boolean checkLastGuess() {
    boolean lastGuess = false;
    String lastGuessArray = guesses.get(-1);
    int userGuessInt = Integer.parseInt(lastGuessArray);
    if (userGuessInt == numToGuess) {
      lastGuess = true;
    }
    return lastGuess;
}
  double getAverageGuess() {
    int sum = 0;
    for (int counter=0 ;counter<guesses.size();counter++) {
      String index = guesses.get(counter);
      int indexInt = Integer.parseInt(index);
      sum = sum + indexInt;
    }
    double average = sum/5;
    return average;
  }
  boolean isValidGuess(String userGuess) {
    boolean validGuess = false;
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
    return validGuess;
  }
}
