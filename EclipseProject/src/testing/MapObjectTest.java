import static org.junit.Assert.*;
import org.junit.Test;

public class MapObjectTest {

  // Testing default
  @Test
  public void test1(){
    MapObject location = new MapObject();
    assertEquals("Expected initial X Coordinate to be 0",0,location.getXCoord());
  }
  // Testing setter and getter for X coordinate
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
    assertEquals("Expected x coordinate to be 5",5,location.getXCoord());
  }

  // Testing setter and getter for Y coordinate
  @Test
  public void test5(){
    MapObject location = new MapObject(0,0);
    assertEquals("Expected initial y coordinate to be 0",0,location.getYCoord());
  }

  @Test
  public void test6(){
    MapObject location = new MapObject(1,200);
    location.setY(2000);
    assertEquals("Setting y location to above limit, expecting to stay at 200", 200, location.getYCoord());
  }

  @Test
  public void test7(){
    MapObject location = new MapObject(1,1);
    location.setY(-1);
    assertEquals("Expected to be 1", 1, location.getYCoord());
  }

  // Testing Contructor with 4 arguments
  @Test
  public void test8(){
    MapObject location = new MapObject(100,100,100,100);
    location.setHeight(400);
    assertEquals("Expected height to be 400", 400, location.getHeight());
  }

  @Test
  public void test9(){
    MapObject location = new MapObject(3,0,100,200);
    location.setWidth(-200);
    assertEquals("Expected width to be 200", 200, location.getWidth());
  }

  @Test
  public void test10(){
    MapObject location = new MapObject(0,0);
    assertEquals("Should get the scroll rate of 10", 10, location.getScroll());
  }
}
