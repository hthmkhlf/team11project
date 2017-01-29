import java.util.Scanner;

class GridGame {
	static char [][] startConfig ={
		{' ',' ',' ',' ',' ',' ',' ',' ',' '},
		{' ',' ',' ',' ',' ',' ',' ',' ',' '},
		{' ',' ',' ',' ',' ',' ',' ',' ',' '}
	};
	public static final char PLAYER = 'P';
	public static final char OBSTACLE = 'X';
	public static final char EMPTY = ' ';

	public static void main(String[] args) {
    	char [][] grid = startConfig;
    	grid[1][0] = PLAYER;
			grid[2][2] = OBSTACLE;
			grid[1][2] = OBSTACLE;
    	for (int  row = 0; row < 3; row++){
    		System.out.print("|");
    		for (int column = 0; column < 9; column++){
    			System.out.print(grid[row][column] + "|");
    		}
    		System.out.println();
    	}
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Welcome to our game, the player will move every turn.");
    System.out.println("Controls are as follows: 'W' to jump, 'S' to slide,");
    System.out.println("and any key to keep moving.\n");

    /** What I am thinking here is having the controls in a loop, where it will take what
     you enter, if 'w' or 's' then will move them up and over, then skip turn and
		 move up and over back to original height.
    */
    int playerLocX = 0, playerLocY = 1, playerNewX=0, playerNewY=1;
		boolean gameOver = false;

    while (!gameOver){//main game loop
    	if (playerLocY == 0){
    		playerNewX = playerLocX + 1;
    		playerNewY = playerLocY + 1;
    	}else if (playerLocY == 2){
    		playerNewX = playerLocX + 1;
    		playerNewY = playerLocY - 1;
    	}else{
    		System.out.print("Movement: ");
    		String movement = keyboard.nextLine();
    		String movementUser = movement.toLowerCase();
				if (movementUser.equals("w")){
					playerNewX = playerLocX + 1;
					playerNewY = playerLocY - 1;
					System.out.println("You jumped!");
				}else if (movementUser.equals("s")){
					playerNewX = playerLocX + 1;
					playerNewY = playerLocY + 1;
					System.out.println("You slide!");
				}else{
					playerNewX = playerLocX + 1;
				}
    	}
			//Scanning to see what is in position, and reprint grid with new movement
			if (grid[playerNewY][playerNewX]== OBSTACLE){
				System.out.println("You have hit an obstacle, Game Over!");
				gameOver = true;
			}else{
				grid[playerLocY][playerLocX] = EMPTY;
				grid[playerNewY][playerNewX] = PLAYER;
				playerLocX = playerNewX;
				playerLocY = playerNewY;
			}
			for (int  row = 0; row < 3; row++){
				System.out.print("|");
				for (int column = 0; column < 9; column++){
					System.out.print(grid[row][column] + "|");
				}
				System.out.println();
			}
			System.out.println("*******************************");
			if (playerLocX >=8){
				gameOver = true;
				System.out.println("You Won!");
			}
    } //end of while loop
  }
}
