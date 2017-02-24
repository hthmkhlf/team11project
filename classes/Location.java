class Location{
    private int xCoordinate = 0;
    private int yCoordinate = 0;
    private static final int MAX_Y = 3;
    private static final int MIN_Y = 0;

    public Location(int newX, int newY){
        xCoordinate = newX;
        yCoordinate = newY;
    }

    /**
    * This method sets the Y coordinate
    * @param newY is the new Y location passed through as an integer
    */
    public void setY(int newY){
        if ((newY >= MIN_Y) && (newY <= MAX_Y)){
            yCoordinate = newY;
        }
    }

    /**
    * This method sets the X coordinate
    * @param newX is the new X location passed through as an integer
    */
    public void setX(int newX){
        if (newX >= xCoordinate){
            xCoordinate = newX;
        }
    }

    public int getXCoord(){
        return xCoordinate;
    }

    public int getYCoord(){
        return yCoordinate;
    }

    public boolean isCollision(int xCoordOther, int yCoordOther){
        boolean collision = false;
        if ((xCoordOther == xCoordinate) && (yCoordOther == yCoordinate)){
            collision = true;
        }
        return collision;
    }


}
