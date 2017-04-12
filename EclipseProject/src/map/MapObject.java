package map;

import java.awt.Graphics2D;

/**
 * @author Josh Schijns 
 * This is the abstract parent class to all objects which are created on the map.
 * The methods in this class handle width, height, xCoord and yCoord.
 * Additionally, the two abstract methods draw() and movement() are contained here.
 */

public abstract class MapObject {
    private int xCoordinate = 0;
    private int yCoordinate = 0;
    private int height = 0;
    private int width = 0;
    protected static int scrollRate = 10;
    private static final int MAX_Y = 550;
    private static final int MIN_Y = 0;

    public MapObject() {
    	setX(0);
    	setY(0);
    }
    
    public MapObject(int newX, int newY) {
    	setX(newX);
    	setY(newY);
    }
    
    public MapObject(int newX, int newY, int height, int width) {
       setX(newX);
       setY(newY);
       setHeight(height);
       setWidth(width);
    }
    
    /**
     * Abstract methods. draw() and movement() are methods all MapObjects
     * must contain and are specific to each subclass.
     */
    public abstract void draw(Graphics2D graphics);
    public abstract void movement();

    /**
     * This method sets the rate at which the map objects move across the screen.
     * @param scroll is the new speed at which objects will scroll.
     */
    public static void setScroll(int scroll) {
    	scrollRate = scroll;
    }
    
    /**
     * This method returns the scroll rate.
     * @return scrollRate is the scrolling speed.
     */
    protected static int getScroll(){
    	return scrollRate;
    }

    /**
     * This method sets the x-coordinate for an object.
     * There is no restriction on this value due to objects constantly moving on and off screen.
     * @param newX is the new value which the x-coordinate is set to.
     */
    public void setX(int newX) {
    	xCoordinate = newX;
    }	
	
    /**
    * This method sets the y-coordinate for an object.
    * The new value must be within the coordinates of the window.
    * @param newY is the new value which the y-coordinate is set to.
    */
    public void setY(int newY) {
        if ((newY >= MIN_Y) && (newY <= MAX_Y)) {
            yCoordinate = newY;
        }
    }

    /**
     * This method sets the height for an object.
     * Height must a positive number.
     * @param height is the new value which the height is set to.
     */
    public void setHeight(int height) {
        if (height >= 0) {
            this.height = height;
        }
    }
	
    /**
     * This method sets the width for an object.
     * Width must be a positive number.
     * @param width is the new value which the width is set to.
     */
    public void setWidth(int width) {
        if (width >= 0) {
            this.width = width;
        }
    }

    /**
     * This method is a getter for xCoordinate.
     * @return xCoordinate is the x-coordinate of the object. 
     */
    public int getXCoord() {
        return xCoordinate;
    }

    /**
     * This method is a getter for yCoordinate.
     * @return yCoordinate is the y-coordinate of the object.
     */
    public int getYCoord() {
        return yCoordinate;
    }
    
    /**
     * This method is a getter for height.
     * @return height is the height of the object.
     */
    public int getHeight() {
    	return height;
    }
    
    /**
     * This method is a getter for width.
     * @return width is the width of the object.
     */
    public int getWidth() {
    	return width;
    }

}
