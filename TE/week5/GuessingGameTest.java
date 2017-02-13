public class GuessingGameTest {
	public static void main(String[] args) {
		GuessingGame game = new GuessingGame();
		game.setMinGuess(5);
		game.setMaxGuess(20);
		game.play();
	}

}