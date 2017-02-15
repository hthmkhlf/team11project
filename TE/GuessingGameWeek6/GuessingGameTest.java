public class GuessingGameTest {
	public static void main(String[] args) {
		GuessingGame game = new GuessingGame(10,21);
		game.play();

		GuessingGame game2 = new GuessingGame(17);
		game.play();
		game2.play();

		game = new GuessingGame();
		game.play();
	}

}
