public class GuessingGameTest {
	public static void main(String[] args) {
		GuessingGame game = new GuessingGame();
		System.out.println("Number to guess: " + game.numToGuess);
		boolean guessedNumber = false;
		
		while (!guessedNumber) {
			game.getGuess();
			guessedNumber = game.checkLastGuess();
		}
		
		game.printGuesses();
		System.out.println("Average: " + game.getAverageGuess());
		
		System.out.println("\n**** Testing isValidGuess *********");
		System.out.printf("Parameter: %s\tReturn value: %b\n","0",game.isValidGuess("0"));
		System.out.printf("Parameter: %s\tReturn value: %b\n","-1",game.isValidGuess("-1"));
		System.out.printf("Parameter: %s\tReturn value: %b\n","9",game.isValidGuess("9"));
		System.out.printf("Parameter: %s\tReturn value: %b\n","10",game.isValidGuess("10"));
		System.out.printf("Parameter: %s\tReturn value: %b\n","a",game.isValidGuess("a"));
		System.out.printf("Parameter: %s\tReturn value: %b\n","5a",game.isValidGuess("5a"));
	}

}