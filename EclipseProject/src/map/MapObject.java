package map;
/**
 * @author Josh Schijns 
 * This is the parent class to all map objects, will handle its width, height, xCoord and yCoord.
 * Will document more later
 */

import java.awt.Graphics2D;


public abstract class MapObject {
	
	private int xCoordinate = 0;
    private int yCoordinate = 0;
    private int height = 0;
    private int width = 0;
    private static final int MAX_Y = 550;
    private static final int MIN_Y = 0;
    protected int scrollRate = 10;
//    private static final int MAX_X = 1650; // Not currently used

    public MapObject(){
    	setX(0);
    	setY(0);
    }
    
    public MapObject(int newX, int newY){
    	setX(newX);
    	setY(newY);
    }
    public MapObject(int newX, int newY, int height, int width){
       setX(newX);
       setY(newY);
       setHeight(height);
       setWidth(width);
    }
    
    // Abstract methods. draw update and movement are methods all MapObjects must contain and are specific to each subclass
    public abstract void draw(Graphics2D graphics);
    public abstract void update();
    protected abstract void movement();
    
    protected int getScroll(){
    	return scrollRate;
    }

    /**
    * This method sets the Y coordinate
    * @param newY sets Y within the window
    */
    public void setY(int newY){
        if ((newY >= MIN_Y) && (newY <= MAX_Y)){
            yCoordinate = newY;
        }
    }

    /**
    * This method sets the X coordinate
    * @param newX set the X within the window
    */
    public void setX(int newX){
    	xCoordinate =newX;
        
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

