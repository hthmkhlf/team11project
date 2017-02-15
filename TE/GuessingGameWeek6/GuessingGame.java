// Team 11 , CPSC 233
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

// This is class is to be used with the GuessingGameTest file.
public class GuessingGame {
  private int numToGuess;
  private int maxGuess = 10;
  private int minGuess;
  private ArrayList <String> guesses = new ArrayList<>();

public GuessingGame(int minVal, int maxVal){
    setMinGuess(minVal);
    setMaxGuess(maxVal);
}

// This method is public so it can be called outside of the class, is the main game loop
public void play(){
   numToGuess = new Random().nextInt(maxGuess - minGuess);
   numToGuess += minGuess;
   System.out.println(numToGuess);
   boolean gameWon = false;
   String playerGuess = "";
   while (!gameWon){
      playerGuess = getGuess();
      if (checkLastGuess(playerGuess)){
        gameWon = true;
      }
   }
   System.out.println("You guessed " + numToGuess + " correctly!");
}


  // Public so the user can set the maxGuess number
  private void setMaxGuess(int newMax){
      if (newMax >= 0){
        maxGuess = newMax;
      }
  }


  // Public so the user can set the minGuess number
  private void setMinGuess(int newMin) {
    if (newMin >=0 && newMin<maxGuess) {
      minGuess = newMin;
    }
  }


// Get user guesses method. Adds valid user guesses to the array list.
// The while loop is acting as the inner loop and the for loop in the GuessingGameTest file is the outer loop.
// The while loop is nested because the outer for loop in GuessingGameTest.java indirectly calls it
// Private since this method is only called within the class by play()
  private String getGuess() {
    Scanner keyboard = new Scanner(System.in);
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
// Private since this method is only called within the class by play()
  private void printGuesses() {
    System.out.print("Your guesses: ");
    for (int counter=0 ;counter<guesses.size();counter++) {
      String index = guesses.get(counter);
      System.out.print(index+" ");
    }
  }


  // Private since this method is only called within the class by play()
  private boolean checkLastGuess(String playerGuess) {
    boolean lastGuess = false;
    int userGuessInt = Integer.parseInt(playerGuess);
    if (userGuessInt == numToGuess) {
      lastGuess = true;
    }
    return lastGuess;
  }


  // Private since this method is only called within the class, not sure where yet
  private double getAverageGuess() {
    int sum = 0;
    for (int counter=0 ;counter<guesses.size();counter++) {
      String index = guesses.get(counter);
      int indexInt = Integer.parseInt(index);
      sum = sum + indexInt;
    }
    double average = sum/5;
    return average;
  }


  // Private since this method is only called within the class by getGuess()
  private boolean isValidGuess(String userGuess) {
    boolean validGuess = false;
    int lengthOfGuess = userGuess.length();
    String maxGuessString = ""+maxGuess;
    boolean allDigits = true;
    if (lengthOfGuess <= maxGuessString.length()) {
      for (int index = 0; index < lengthOfGuess && (allDigits); index++) {
        char guessAsChar = userGuess.charAt(index);
        boolean guessIsDigit = Character.isDigit(guessAsChar);
        if(!guessIsDigit){
          allDigits = false;
        }
      }
        if (allDigits){
          int userGuessInt = Integer.parseInt(userGuess);
          if (userGuessInt < maxGuess && userGuessInt >= minGuess){
            guesses.add(userGuess);
            validGuess = true;
          }else{
            System.out.println("Invalid guess. Please enter a number between "+minGuess+" and " +(maxGuess-1)+": ");
          }
        }else {
            System.out.println("Invalid guess. Please enter a number between "+minGuess+" and " +(maxGuess-1)+": ");
        }
    }else {
      System.out.println("Invalid guess. Please enter a number between "+minGuess+" and " +(maxGuess-1)+": ");
    }
    return validGuess;
  }
}
