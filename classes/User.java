import java.util.Scanner;

public class User{	
	 int player_x_value = 0;
	 int player_y_value = 1;
	 String player_name = "";
	 Scanner keyboard = new Scanner(System.in);

	 public movement(player_x_value,player_y_value,player_input){
	  switch (player_input.toLowerCase())
	  String player_input = keyboard.next();

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
					  break;
		return player_input
	  }

	 public getName(player_name){
	  System.out.println("Welcome to the game. Please enter your name");

			String player_name = keyboard.next();

			System.out.println(player_name);
		return player_name
	 }

}
