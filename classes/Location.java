/**
* @author Josh Schijns
* This class is used for coordinates for the player and obstacles,
* the coordinates can be changed or retrieved.
*/

public class Location{
    private int xCoordinate = 0;
    private int yCoordinate = 0;
    private static final int MAX_Y = 2;
    private static final int MIN_Y = 0;

    public Location(int newX, int newY){
        xCoordinate = newX;
        yCoordinate = newY;
    }

    /**
    * This method sets the Y coordinate
    * @param changeY is the amount the Y coord will change
    */
    public void setY(int changeY){
        int newY = yCoordinate + changeY;
        if ((newY >= MIN_Y) && (newY <= MAX_Y)){
            yCoordinate = yCoordinate + changeY;
        }else{
            yCoordinate = yCoordinate;
        }
    }

    /**
    * This method sets the X coordinate
    * @param changeX is the amount the X coord is to change
    */
    public void setX(int changeX){
        if (((xCoordinate + changeX) >= xCoordinate) && (xCoordinate < 9)){
            xCoordinate = xCoordinate + changeX;
        }else if(xCoordinate >= 9){
            xCoordinate = 0;
        }
    }

    public int getXCoord(){
        return xCoordinate;
    }

    public int getYCoord(){
        return yCoordinate;
    }

    /**
    *This method determines if there is a collision or not
    * @param xCoordOther is the x coordinate of the other object
    * @param yCoordOther is the y coordinate of the other object
    */
    public boolean isCollision(int xCoordOther, int yCoordOther){
        boolean collision = false;
        if ((xCoordOther == xCoordinate) && (yCoordOther == yCoordinate)){
            collision = true;
        }
        return collision;
    }

}
