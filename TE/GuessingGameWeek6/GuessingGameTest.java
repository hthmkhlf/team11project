public class GuessingGameTest {
	public static void main(String[] args) {
		GuessingGame game = new GuessingGame(2,11);
		game.play();

		GuessingGame game2 = new GuessingGame(5,17);
		game.play();
		game2.play();		
	}

}