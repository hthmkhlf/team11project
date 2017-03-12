package main;
/**
* I plan to add more, will use the location class to grab the location
* of each thing, obstacle and player to add into the grid
* A note, 0,0 is the top left corner, as you go down y increases
* and for the coordinates of the grid in [][], it goes [y][x]
* @author Josh Schijns
*/

public class Grid{
    private static final char PLAYER = 'P';
    private static final char OBSTACLE = 'X';
    private static final char EMPTY = ' ';
    // The initital grid
    private char [][] startConfig ={
        {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}
    };

    private char [][] grid = startConfig;

    /**
    * This method will draw the grid out
    * @param playerX is the X coordinate of the player
    * @param playerY is the Y coordinate of the player
    */
    public void drawGrid(int playerX,int playerY, int obsOneX, int obsOneY,
      int obsTwoX, int obsTwoY){
        grid [playerY][playerX] = PLAYER;
        grid [obsOneY][obsOneX] = OBSTACLE;
        grid [obsTwoY][obsTwoX] = OBSTACLE;
        for (int row = 0; row <3; row++){
            System.out.print("|");
            for (int column = 0; column < 10; column++){
                System.out.print(grid[row][column]+ "|");
            }
            System.out.println();
        }
    }

    public void adjustGrid(){
        for (int row = 0; row <3; row++){
            for (int column = 0; column < 10; column++){
                if (grid [row][column] == PLAYER){
                    grid [row][column] = EMPTY;
                }
            }
        }
    }

}
