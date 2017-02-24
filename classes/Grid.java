// I plan to add more, will use the location class to grab the location
// of each thing, obstacle and player to add into the grid
// A note, 0,0 is the top left corner, as you go down y increases
// and for the coordinates of the grid in [][], it goes [y][x]

class Grid{
    private static final char PLAYER = 'P';
    private static final char OBSTACLE = 'X';
    private static final char EMPTY = ' ';

    // The initital grid
    private static char [][] startConfig ={
        {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' ',' ',' ',' ',' ',' '}
    };

    // This method will draw the grid out
    public void drawGrid(){
        char [][] grid = startConfig;
        for (int row = 0; row <3; row++){
            System.out.print("|");
            for (int column = 0; column < 10; column++){
                System.out.print(grid[row][column]+ "|");
            }
            System.out.println();
        }
    }


}
