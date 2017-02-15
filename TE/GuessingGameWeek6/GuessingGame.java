import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

/**
 * @author Team 11, CPSC 233
 * @since 14/02/2017
 * This class is to be used by the GuessingGameTest.java file.
 * The methods in this class are used to run a game in which
 * a random number is generated for the user to guess.
 */

public class GuessingGame {
  private int numToGuess;
  private static final int MAX_DEFAULT = 10;
  private static final int MIN_DEFAULT = 0;
  private int maxGuess = 10;
  private int minGuess = 0;
  private ArrayList <String> guesses = new ArrayList<>();

//Fixed last week problems
  public GuessingGame(int minVal, int maxVal) {
    setMinGuess(minVal);
    setMaxGuess(maxVal);
  }
//This one is not really working.
  public GuessingGame() {
    this(MIN_DEFAULT, MAX_DEFAULT);
  }

  public GuessingGame(int maxVal) {
    this(MIN_DEFAULT, maxVal);
  }




/**
 * The main loop from which the game is run.
 * This method is public so it can be called by GuessingGameTest.
 */
  public void play() {
    // Generates the random number to be guessed (between minGuess and maxGuess)
    numToGuess = new Random().nextInt(maxGuess - minGuess);
    numToGuess += minGuess;
    System.out.println(numToGuess);

    String playerGuess = "";
    boolean gameWon = false;

    // The main game loop which will run as long as the random number has not been guessed
    // Gets the user's guess and checks if it is correct or not
    while (!gameWon) {
      playerGuess = getGuess();
      if (checkLastGuess(playerGuess)) {
        gameWon = true;
      }
    }
    System.out.println("You guessed " + numToGuess + " correctly!");
  }

/**
 * Sets the maximum number the user can guess.
 * This method is public so that the user can choose the number (must be >= 0).
 *
 * @param newMax the number taken from the user which will be used as the maxGuess if valid.
 */
  public void setMaxGuess(int newMax) {
    if (newMax >= 0) {
      maxGuess = newMax;
    }
  }

/**
 * Sets the minimum number the user can guess.
 * Method is public so the user can choose the number (must be >= 0, < maxGuess).
 *
 * @param newMin the number taken from the user which will be used as the minGuess if valid.
 */
  public void setMinGuess(int newMin) {
    if (newMin >= 0 && newMin < maxGuess) {
      minGuess = newMin;
    }
  }

/**
 * Takes the user's guess and repeatedly reprompts if input is invalid.
 *
 * The while loop in this method is a nested inner loop which is indirectly called by the
 * outer for loop in GuessingGameTest.
 * This method is private because it is only called by the play() method within this class.
 *
 * @return the user's valid guess
 */
  private String getGuess() {
    Scanner keyboard = new Scanner(System.in);
    String userGuess = "";
    boolean validGuess = false;

    while (!validGuess) {
      System.out.print("What is your guess: ");
      userGuess = keyboard.nextLine();
      validGuess = isValidGuess(userGuess);
    }
    return userGuess;
  }


/**
 * Gets each element of the guesses array and prints it.
 * Method is private because it is only called by the play() method within this class.
 */
  private void printGuesses() {
    System.out.print("Your guesses: ");
    for (int counter = 0; counter < guesses.size(); counter++) {
      String index = guesses.get(counter);
      System.out.print(index + " ");
    }
  }

/**
 * Checks if the user's guess is the same as the random number generated.
 * This method is private because it will only be called by the play() method within this class.
 *
 * @param playerGuess the user's input (after validation).
 * @return true if the user's guess is the same as the random number.
 */
  private boolean checkLastGuess(String playerGuess) {
    boolean lastGuess = false;
    int userGuessInt = Integer.parseInt(playerGuess);
    if (userGuessInt == numToGuess) {
      lastGuess = true;
    }
    return lastGuess;
  }

/**
 * Takes each element of the guesses array and gets the average of all of the guesses.
 * This method is private because it will only be called within the class.
 *
 * @return the average of all of the guesses
 */
  private double getAverageGuess() {
    int sum = 0;
    for (int counter = 0; counter < guesses.size(); counter++) {
      String index = guesses.get(counter);
      int indexInt = Integer.parseInt(index);
      sum = sum + indexInt;
    }
    double average = sum/5;
    return average;
  }

/**
 * Takes the user's input and checks if it is a valid guess by checking its length and
 * whether it is a digit or not.
 * This method is private because it is only called by the getGuess() method within this class.
 *
 * @param userGuess the user's input (before validation).
 * @return true if the input is a valid digit within minGuess and maxGuess.
 */
  private boolean isValidGuess(String userGuess) {
    boolean validGuess = false;
    int lengthOfGuess = userGuess.length();
    String maxGuessString = ""+maxGuess;
    boolean allDigits = true;

    // Checks whether the length of the string is equal to or less than that of the maxGuess
    if (lengthOfGuess <= maxGuessString.length()) {
        // Goes through each character in the input and checks if it is a digit or not
        for (int index = 0; index < lengthOfGuess && (allDigits); index++) {
            char guessAsChar = userGuess.charAt(index);
            boolean guessIsDigit = Character.isDigit(guessAsChar);
            if (!guessIsDigit) {
              allDigits = false;
            }
        }

      if (allDigits) {
        int userGuessInt = Integer.parseInt(userGuess);
        // Checks if the user's guess is within the valid range
        if (userGuessInt < maxGuess && userGuessInt >= minGuess){
          guesses.add(userGuess);
          validGuess = true;
        // Error message if the guess is out of range
        } else {
          System.out.println("Invalid guess. Please enter a number between "+minGuess+" and " +(maxGuess-1)+": ");
        }
      // Error message if the guess is not a digit
      } else {
        System.out.println("Invalid guess. Please enter a number between "+minGuess+" and " +(maxGuess-1)+": ");
      }
    // Error message if the length of the guess is too big
    } else {
      System.out.println("Invalid guess. Please enter a number between "+minGuess+" and " +(maxGuess-1)+": ");
    }
    return validGuess;
  }

}
