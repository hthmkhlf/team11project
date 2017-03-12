/**
* @author Josh Schijns
* This class is used for coordinates for the player and obstacles,
* the coordinates can be changed or retrieved.
*/

public class Location{
    private int xCoordinate = 0;
    private int yCoordinate = 0;
    private int height = 0;
    private int width = 0;
    private static final int MAX_Y = 2; // Need to change this to match the window created
    private static final int MIN_Y = 0;
    private static final int MAX_X = 400; // Need to change this to match window created as well

    public Location(int newX, int newY){
       setX(newX);
       setY(newY);
    }

    /**
    * This method sets the Y coordinate
    * @param newY sets Y within the window
    */
    private void setY(int newY){
        if ((newY >= MIN_Y) && (newY <= MAX_Y)){
            yCoordinate = newY;
        }
    }

    /**
    * This method sets the X coordinate
    * @param newX set the X within the window
    */
    private void setX(int newX){
        if ((newX >= 0) && (newX <= MAX_X)){
            xCoordinate =newX;
        }
    }

    public int getXCoord(){
        return xCoordinate;
    }

    public int getYCoord(){
        return yCoordinate;
    }
    
    public int getHeight(){
    	return height;
    }
    
    public int getWidth(){
    	return width;
    }
    
    public void setWidth(int width){
        if (width >= 0){
            this.width = width;
        }
    }
    
    public void setHeight(int height){
        if (height >= 0){
            this.height = height;
        }
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
