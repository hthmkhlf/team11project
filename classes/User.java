import java.util.Scanner;

public class User{
	 private int player_x_value = 0;
	 private int player_y_value = 1;
	 private String player_name = "";
	 Scanner keyboard = new Scanner(System.in);

	 public String movement(String user_input){
    // String player_input = keyboard.next();
    switch (user_input.toLowerCase()) {

		  case "j":
			  player_y_value = 2;
			  player_x_value = player_x_value + 1;
			  System.out.println("You jumped!");
			  break;

		  case "s":
			  player_y_value = 0;
			  player_x_value = player_x_value + 1;
			  System.out.println("You slid!");
			  break;

		  default:
			  player_y_value = 1;
			  player_x_value = player_x_value + 1;
				System.out.println("You moved!");
			  break;
	  }
		return user_input;
  }

	 public String getName(){
	  System.out.println("Welcome to the game. Please enter your name");
		String player_name = keyboard.next();
		return player_name;
	 }

	 public int getPlayer_x_value() {
	 	return player_x_value;
	 }

	 public int getPlayer_y_value() {
	 	return player_y_value;
	 }

}
