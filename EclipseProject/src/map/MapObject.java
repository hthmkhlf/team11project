package map;
/**
 * @author Josh Schijns 
 * This is the parent class to all map objects, will handle its width, height, xCoord and yCoord.
 * Has three abstract methods, draw(), update(); and movement();
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
    public abstract void movement();
    public abstract boolean collisionCheck(Player player);
    
    /**
     * Scroll rate is the rate at which the map moves each frame
     * @return scrollRate
     */
    protected int getScroll(){
    	return scrollRate;
    }

    /**
    * This method sets the X coordinate
    * @param newX set the X to a new location, no restriction due to objects moving on and off screen
    */
    public void setX(int newX){
    	xCoordinate =newX;
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
     * Setter for height
     * @param height has to be greater than 0
     */
    public void setHeight(int height){
        if (height >= 0){
            this.height = height;
        }
    }
	
    /**
     * Setter for width
     * @param width has to be greater than 0
     */
    public void setWidth(int width){
        if (width >= 0){
            this.width = width;
        }
    }

    /**
     * Getter for xCoordinate
     * @return xCoordinate
     */
    public int getXCoord(){
        return xCoordinate;
    }

    /**
     * Getter for yCoordinate
     * @return yCoordinate
     */
    public int getYCoord(){
        return yCoordinate;
    }
    
    /**
     * Getter for height
     * @return height
     */
    public int getHeight(){
    	return height;
    }
    
    /**
     * Getter for width
     * @return width
     */
    public int getWidth(){
    	return width;
    }

}

