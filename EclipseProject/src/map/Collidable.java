package map;

/**
 * This is a child class to MapObject and parent class to Obstacle, Boost, and Coin.
 * This class contains the abstract method actionCollision()
 * which controls what happens when the player collides with an object
 * depending on what object it is.
 */
public abstract class Collidable extends MapObject{

  public Collidable(){
	  super(0, 0, 50, 50);   //Change these values later
  }

  public Collidable(int newX, int newY, int height, int width){
    super(newX, newY, height, width);
  }

  /**
   * Abstract method which is specific to each subclass.
   */
  public abstract void actionCollision();


// more or less copied + pasted from PlayState, hopefully this is ok?
  /**
   * This method checks whether the player has collided with an object
   * and calls actionCollision() accordingly.
   * @param obstacle the obstacle which is checked
   * @param boost the boost which is checked
   * @param coin the coin which is checked
   * @param the player whose coordinates are used
   */
  public void collisionCheck(Obstacle obstacle, Boost boost, Coin coin, Player player){
    int startX = 70;
		int endX = 125;
		int startY = player.getYCoord();
		int endY = player.getYCoord() + 80;
		if (((startX >= obstacle.getXCoord()) && (startX <= obstacle.getXCoord()+obstacle.getWidth()))
				|| ((endX >= obstacle.getXCoord())&&(endX <= (obstacle.getXCoord()+obstacle.getWidth())))){
			if (((startY >= obstacle.getYCoord())&&(startY <= (obstacle.getYCoord()+obstacle.getHeight())))
					|| ((endY >= obstacle.getYCoord())&&(endY <= (obstacle.getYCoord()+obstacle.getHeight())))){
				obstacle.actionCollision();
			}
		}else if (((startX >= boost.getXCoord()) && (startX <= boost.getXCoord()+boost.getWidth()))
				|| ((endX >= boost.getXCoord())&&(endX <= (boost.getXCoord()+boost.getWidth())))){
			if (((startY >= boost.getYCoord())&&(startY <= (boost.getYCoord()+boost.getHeight())))
					|| ((endY >= boost.getYCoord())&&(endY <= (boost.getYCoord()+boost.getHeight())))){
				boost.actionCollision();
			}
    }else if (((startX >= coin.getXCoord()) && (startX <= coin.getXCoord()+coin.getWidth()))
				|| ((endX >= coin.getXCoord())&&(endX <= (coin.getXCoord()+coin.getWidth())))){
			if (((startY >= coin.getYCoord())&&(startY <= (coin.getYCoord()+coin.getHeight())))
					|| ((endY >= coin.getYCoord())&&(endY <= (coin.getYCoord()+coin.getHeight())))){
				coin.actionCollision();
			}
    }
  }

}
