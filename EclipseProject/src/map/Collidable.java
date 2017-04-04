package map;

/**
 * @author Katie Tieu
 * This is a child class to MapObject and parent class to Obstacle, Boost, and Coin.
 * This class checks for collisions and calls collisionAction accordingly.
 */
public abstract class Collidable extends MapObject{

  public Collidable(){
    this(0, 0, 50, 50);   //Change these values later
  }

  public Collidable(int newX, int newY, int height, int width){
    super(newX, newY, height, width);
  }

  /**
   * Abstract method which controls what happens when a player collides with an object.
   * Specific to each subclass.
   */
  public abstract void collisionAction(Player player);


  /**
   * This method checks whether the player has collided with an object and calls collisionAction() accordingly.
   * @param player the player whose location is being checked
   */
  public boolean collisionCheck(Player player) {
    boolean collision = false;
    int playerLeft = 70; //I use this values instead of getting X because we dont care if his tail or beak run into stuff
    int playerRight = 125;
    int playerTop = player.getYCoord();
    int playerBottom = player.getYCoord() + 80;
    int collidableObjectLeft = this.getXCoord();
    int collidableObjectRight = this.getXCoord() + this.getWidth();
    int collidableObjectTop = this.getYCoord();
    int collidableObjectBottom = this.getYCoord() + this.getHeight();
    
    if (((playerLeft >= collidableObjectLeft) && (playerLeft <= collidableObjectRight))
    || ((playerRight >= collidableObjectLeft) && (playerRight <= collidableObjectRight))) {
      if (((playerTop >= collidableObjectTop) && (playerTop <= collidableObjectBottom))
      || ((playerBottom >= collidableObjectTop) && (playerBottom <= collidableObjectBottom))) {
        collision = true;
      }
    }
    return collision;
  }

}
