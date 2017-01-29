import java.util.Random;
import java.util.Scanner;



public class RandomNumberGuess {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int randomNumber = new Random().nextInt(10);

		// Sets up output
		System.out.println(randomNumber);
		System.out.println("I'm thinking of a number between 0-9.");
		System.out.print("Guess a number: ");
		String guessAsString = keyboard.next();

		// Gets length of input to determine if 1
		int lengthOfGuess = guessAsString.length();

		// Determines if the input is valid or not
		if (lengthOfGuess == 1) {
			// Gets the character to check if it is a digit
			char charGuess = guessAsString.charAt(0);
			boolean guessDigit = Character.isDigit(charGuess);
			if (guessDigit) {
				int guess = Integer.parseInt(guessAsString);
				if (guess == randomNumber) {
					System.out.println("You got it right!");
				}
				else if (guess < randomNumber) {
					System.out.println("Too small");
				}
				else {
					System.out.println("Too big");
				}
			}
			else {
				System.out.println("Invalid input");
			}
		}
		else {
			System.out.println("Invalid input");
		}
	}
}
