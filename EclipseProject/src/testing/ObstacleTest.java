import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class ObstacleTest{

  // Testing constructor which takes no arguments
  @Test
  public void test1(){
    Obstacle o = new Obstacle();
    assertEquals("Expected x-coordinate to be 1600", 1600, o.getXCoord());
  }

  @Test
  public void test2(){
    Obstacle o = new Obstacle();
    assertEquals("Expected y-coordinate to be 0", 0, o.getYCoord());
  }

  @Test
  public void test3(){
    Obstacle o = new Obstacle();
    assertEquals("Expected height to be 300", 300, o.getHeight());
  }

  @Test
  public void test4(){
    Obstacle o = new Obstacle();
    assertEquals("Expected width to be 150", 150, o.getWidth());
  }

  // Testing constructor which takes four arguments
  @Test
  public void test5(){
    Obstacle o = new Obstacle(1, 2, 3, 4);
    assertEquals("Expected x-coordinate to be 1", 1, o.getXCoord());
  }

  @Test
  public void test6(){
    Obstacle o = new Obstacle(1, 2, 3, 4);
    assertEquals("Expected y-coordinate to be 2", 2, o.getYCoord());
  }

  @Test
  public void test7(){
    Obstacle o = new Obstacle(1, 2, 3, 4);
    assertEquals("Expected height to be 3", 3, o.getHeight());
  }

  @Test
  public void test8(){
    Obstacle o = new Obstacle(1, 2, 3, 4);
    assertEquals("Expected width to be 4", 4, o.getWidth());
  }

  // Testing copy constructor + potential privacy leaks
  @Test
  public void test9(){
    Obstacle o1 = new Obstacle(1000, 20, 30, 40);
    Obstacle o2 = new Obstacle(o1);
    assertEquals("Expected o2 x-coordinate to be 1000", 1000, o2.getXCoord());
  }

  @Test
  public void test10(){
    Obstacle o1 = new Obstacle(1000, 20, 30, 40);
    Obstacle o2 = new Obstacle(o1);
    assertEquals("Expected o2 y-coordinate to be 20", 20, o2.getYCoord());
  }

  @Test
  public void test11(){
    Obstacle o1 = new Obstacle(1000, 20, 30, 40);
    Obstacle o2 = new Obstacle(o1);
    assertEquals("Expected o2 height to be 30", 30, o2.getHeight());
  }

  @Test
  public void test12(){
    Obstacle o1 = new Obstacle(1000, 20, 30, 40);
    Obstacle o2 = new Obstacle(o1);
    assertEquals("Expected o2 width to be 40", 40, o2.getWidth());
  }

  @Test
  public void test13(){
    Obstacle o1 = new Obstacle();
    Obstacle o2 = new Obstacle(o1);
    o2.setX(1000);
    assertEquals("Expected o1 x-coordinate to be 1600", 1600, o1.getXCoord());
  }

  @Test
  public void test14(){
    Obstacle o1 = new Obstacle();
    Obstacle o2 = new Obstacle(o1);
    o2.setY(30);
    assertEquals("Expected o1 y-coordinate to be 0", 0, o1.getYCoord());
  }

  @Test
  public void test15(){
    Obstacle o1 = new Obstacle();
    Obstacle o2 = new Obstacle(o1);
    o2.setHeight(15);
    assertEquals("Expected o1 height to be 300", 300, o1.getHeight());
  }

  @Test
  public void test16(){
    Obstacle o1 = new Obstacle();
    Obstacle o2 = new Obstacle(o1);
    o2.setWidth(45);
    assertEquals("Expected o1 width to be 150", 150, o1.getWidth());
  }

  // Testing generateY
  @Test
  public void test17(){
    Obstacle o = new Obstacle();
    o.generateY();
    String yAsString = Integer.toString(o.getYCoord());
    assertThat("Expected y-coordinate be 0 or 100", yAsString, anyOf(is("0"), is("100")));
  }
}
