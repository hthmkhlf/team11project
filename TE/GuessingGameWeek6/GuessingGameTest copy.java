public class GuessingGameTest {
	public static void main(String[] args) {
		GuessingGame game = new GuessingGame();
		System.out.println("Number to guess: " + game.numToGuess);
		for (int counter = 0; counter < 5; counter++) {
			game.getGuess();
		}
		
	}

}