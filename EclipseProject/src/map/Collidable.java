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
  public abstract void collisionAction();
  public abstract void collisionAction(Player player);


// more or less copied + pasted from PlayState
  /**
   * This method checks whether the player has collided with an object
   * and calls actionCollision() accordingly.
   * Colliding with an obstacle causes the player to lose and the game to end.
   * Colliding with a coin increases the player's score.
   * Colliding with a boost gives a one-time boost to the player's jump.
   * @param obstacle the obstacle which is checked
   * @param boost the boost which is checked
   * @param coin the coin which is checked
   * @param the player whose coordinates are used
   */
  public void collisionCheck(Obstacle obstacle, Boost boost, Coin coin, Player player){
    int playerLeft = 70;
    int playerRight = 125;
    int playerTop = player.getYCoord();
    int playerBottom = player.getYCoord() + 80;
    if (((playerLeft >= obstacle.getXCoord()) && (playerLeft <= obstacle.getXCoord()+obstacle.getWidth()))
      || ((playerRight >= obstacle.getXCoord())&&(playerRight <= (obstacle.getXCoord()+obstacle.getWidth())))){
      if (((playerTop >= obstacle.getYCoord())&&(playerTop <= (obstacle.getYCoord()+obstacle.getHeight())))
        || ((playerBottom >= obstacle.getYCoord())&&(playerBottom <= (obstacle.getYCoord()+obstacle.getHeight())))){
				obstacle.collisionAction();
      }
    }else if (((playerLeft >= boost.getXCoord()) && (playerLeft <= boost.getXCoord()+boost.getWidth()))
      || ((playerRight >= boost.getXCoord())&&(playerRight <= (boost.getXCoord()+boost.getWidth())))){
      if (((playerTop >= boost.getYCoord())&&(playerTop <= (boost.getYCoord()+boost.getHeight())))
        || ((playerBottom >= boost.getYCoord())&&(playerBottom <= (boost.getYCoord()+boost.getHeight())))){
        boost.collisionAction(player);
      }
    }else if (((playerLeft >= coin.getXCoord()) && (playerLeft <= coin.getXCoord()+coin.getWidth()))
      || ((playerRight >= coin.getXCoord())&&(playerRight <= (coin.getXCoord()+coin.getWidth())))){
      if (((playerTop >= coin.getYCoord())&&(playerTop <= (coin.getYCoord()+coin.getHeight())))
        || ((playerBottom >= coin.getYCoord())&&(playerBottom <= (coin.getYCoord()+coin.getHeight())))){
        coin.actionCollision();
      }
    }
  }

}
