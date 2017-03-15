import static org.junit.Assert.*;
import org.junit.Test;

public class LocationTest {

  // Testing setter and getter for X coordinate
  @Test
  public void test1(){
    MapObject location = new MapObject(0,0);
    assertEquals("Expected initial X Coordinate to be 0",0,location.getXCoord());
  }

  @Test
  public void test2(){
    MapObject location = new MapObject(1,1);
    assertEquals("Expected X Coordinate to be 1", 1, location.getXCoord());
  }

  @Test
  public void test3(){
    MapObject location = new MapObject(0,0);
    location.setX(2);
    assertEquals("Expected X coordinate to be 2",2,location.getXCoord());
  }

  @Test
  public void test4(){
    MapObject location = new MapObject(2,2);
    location.setX(5);
    assertEquals("Expected x coordinate to be 7",7,location.getXCoord());
  }

  // Testing setter and getter for Y coordinate
  @Test
  public void test5(){
    MapObject location = new MapObject(0,0);
    assertEquals("Expected initial y coordinate to be 0",0,location.getYCoord());
  }

  @Test
  public void test6(){
    MapObject location = new MapObject(1,2);
    location.setY(1);
    assertEquals("Setting y location to above limit, expecting to stay at 2", 2, location.getYCoord());
  }

  @Test
  public void test7(){
    MapObject location = new MapObject(1,1);
    location.setY(-1);
    assertEquals("Expected to be 0", 0, location.getYCoord());
  }

  // Testing isCollision
  @Test
  public void test8(){
    MapObject location = new MapObject(2,2);
    assertEquals("Setting other to (2,2), expecting to be true", true, location.isCollision(2,2));
  }

  @Test
  public void test9(){
    MapObject location = new MapObject(3,0);
    assertEquals("Setting other to (3,1), expecting false", false, location.isCollision(3,1));
  }

  @Test
  public void test10(){
    MapObject location = new MapObject(0,0);
    assertEquals("Setting other to (1,1), expecting false", false, location.isCollision(1,1));
  }
}
