/*
Class is used to display Interface
Author Josh Schijns
*/
public class Interface{
    /**
    This prints out the text for the intereface, takes the coordinates for
    the obstacle and player
    */
    public void printDisplay(int playerX, int playerY, int obsX, int obsY1, int obsY2){
      System.out.println("Enter (j) to jump\nEnter (s) to slide\nAny key to keep running");
      System.out.println("You are at x: " + playerX + " y: " + playerY);
      System.out.print("The next object is at x: " +obsX);
      System.out.print(" y: " + obsY1);
      System.out.println(" and " + obsY2);
      System.out.print("What will you do: ");
    }
}
