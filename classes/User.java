/**
 * @author Dou, Zhi Chao
 *
*/
import java.util.Scanner;

public class User{
	public void movement(){
			System.out.print("Movement: ");
			//calls the location class
			Location userMovement = new Location(0,1);
			// userMovement.Location(0,1);
			Scanner keyboard = new Scanner(System.in);
  		String movement = keyboard.nextLine();
  		String movementUser = movement.toLowerCase();

				if (movementUser.equals("w")){
					//moves the user position up
					userMovement.setY(0);
					System.out.println("You jumped!");
				}else if (movementUser.equals("s")){
					//moves the user position down
					userMovement.setY(2);
					System.out.println("You slide!");
				}
	}
}
