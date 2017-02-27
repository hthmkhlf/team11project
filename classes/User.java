/**
 * @author Dou, Zhi Chao
 *
*/
import java.util.Scanner;

public class User{
	private Location userMovement = new Location(0,1);
	private Scanner keyboard = new Scanner(System.in);
	public void movement(){
			System.out.print("Movement: ");
			//calls the location class
			// userMovement.Location(0,1);
  		String movement = keyboard.nextLine();
  		String movementUser = movement.toLowerCase();

				if (movementUser.equals("w")){
					//moves the user position up
					userMovement.setY(-1);
					userMovement.setX(1);
					System.out.println("You jumped!");
				}else if (movementUser.equals("s")){
					//moves the user position down
					userMovement.setY(1);
					userMovement.setX(1);
					System.out.println("You slide!");
				}else {
					userMovement.setX(1);
					System.out.println("You are running");
				}
	}

	public Location getLocation(){
		return userMovement; 
	}
}
