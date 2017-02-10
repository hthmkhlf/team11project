// Team 11 , CPSC 233
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

// This is class is to be used with the GuessingGameTest file.
public class GuessingGame {
  private int numToGuess;
  private int maxGuess = 10;
  ArrayList <String>guesses = new ArrayList<>();

public void play(){
   numToGuess = new Random().nextInt(maxGuess);
   boolean gameWon = false;
   while (!gameWon){
     String playerGuess = getGuess();
     gameWon = checkLastGuess();
   }
}

  public void setMaxGuess(int newMax){
      if (newMax >= 0){
        maxGuess = newMax;
      }else{
        System.out.println("Guess number should be greater than 0");
      }
  }
// Get user guesses method. Adds valid user guesses to the array list.
// The while loop is acting as the inner loop and the for loop in the GuessingGameTest file is the outer loop.
// The while loop is nested because the outer for loop in GuessingGameTest.java indirectly calls it
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
  private void printGuesses() {
    System.out.print("Your guesses: ");
    for (int counter=0 ;counter<guesses.size();counter++) {
      String index = guesses.get(counter);
      System.out.print(index+" ");
    }
  }
  private boolean checkLastGuess() {
    boolean lastGuess = false;
    String lastGuessArray = guesses.get(-1);
    int userGuessInt = Integer.parseInt(lastGuessArray);
    if (userGuessInt == numToGuess) {
      lastGuess = true;
    }
    return lastGuess;
  }
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
  private boolean isValidGuess(String userGuess) {
    boolean validGuess = false;
    int lengthOfGuess = userGuess.length();
    String maxGuessString = ""+maxGuess;
    if (lengthOfGuess <= maxGuessString.length()) {
      char guessAsChar = userGuess.charAt(0);
      boolean guessIsDigit = Character.isDigit(guessAsChar);
        if (guessIsDigit){
          int userGuessInt = Integer.parseInt(userGuess);
          if (userGuessInt < maxGuess){
            guesses.add(userGuess);
            validGuess = true;
          }else{
            System.out.println("Invalid guess. Please enter a number between 0 and " +(maxGuess-1)+": ");
          }
        }else {
          System.out.println("Invalid guess. Please enter a number between 0 and " +(maxGuess-1)+": ");
        }
    }else {
      System.out.println("Invalid guess. Please enter a number between 0 and " +(maxGuess-1)+": ");
    }
    return validGuess;
  }
}
