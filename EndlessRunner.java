import java.util.Scanner;
import java.util.Random;

public class EndlessRunner{
    public static void main(String[] args){
        int Y_MIN = 0;
        int Y_MAX = 2;
        int X_MIN = 0;
        boolean obstacle_hit = false;
        int player_x_value = 0;
        int player_y_value = 1;

        Scanner keyboard = new Scanner(System.in);

        //Randomize initial object location
        //objects have a height of 2; thinking being that if an object spawns
        //at y values of 1 and 2 the user has to duck, spwned at 0 and 1 the user
        //has to jump. if statement spawns the second height value based on the randomly
        //generate first value
        int obstacle_x_value = new Random().nextInt(2);
        obstacle_x_value = player_x_value + 1;
        int obstacle_y_value1 = new Random().nextInt(2);
        int obstacle_y_value2 = 0;
        if (obstacle_y_value1 == 0){
          obstacle_y_value2 = 1;
        }
        else if (obstacle_y_value1 == 1){
          obstacle_y_value2 = 2;
        }

        //Welcome the user, get their name
        System.out.println("Welcome to the game. Please enter your name");
        String player_name = keyboard.next();
        System.out.println("Hello, " +player_name);

        //Loop controls the whole game, until an obstacle is hit the loop repeats
        while (obstacle_hit == false){
            System.out.println("You are at x:" + player_x_value + " y:" + player_y_value);
            System.out.print("The next object is at x:" +obstacle_x_value);
            System.out.print(" y:" + obstacle_y_value1);
            System.out.println("," + obstacle_y_value2);
            System.out.println("Enter j to move up one x-block (jump over obstacle), s to move down one y-block (slide under an obstacle), any other key to just keep running");

            String player_input = keyboard.next();

            //Changes user y and x value
            switch (player_input.toLowerCase()) {
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
            }


            //check if player hits obstacle
            if (player_x_value == obstacle_x_value){
              if ((player_y_value == obstacle_y_value1) || (player_y_value == obstacle_y_value2)) {
                  obstacle_hit = true;
                  System.out.println("You hit the obstacle");
              }
            }
            // if user avoids the obstacle by jumping or sliding the player values will increase so they will fully pass the obstacle.
            if ((player_input.equals("s")) || (player_input.equals("j"))) {
              player_x_value= player_x_value +1;
            }

            //check if player successfully passed the obstacle, new obstacle needs
            //to be generated
            if (player_x_value > obstacle_x_value){
              obstacle_x_value = new Random().nextInt(2);
              obstacle_x_value = player_x_value + obstacle_x_value + 1;
              obstacle_y_value1 = new Random().nextInt(2);
              if (obstacle_y_value1 == 0){
                obstacle_y_value2 = 1;
              }
              else if (obstacle_y_value1 == 1){
                obstacle_y_value2 = 2;
              }
            }
            //player jumps over an obstacle
            else if ((player_x_value == obstacle_x_value) && (player_input.equals("j"))) {
                System.out.println("You jumped over the obstacle!");
            }

            //player slides under an obstacle
            else if ((player_x_value == obstacle_x_value) && (player_input.equals("s"))){
              System.out.println("You slid under the obstacle!");
            }
        }


    }
}
