import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class ObstacleTest{

  // Testing generateTopObstacleX
  @Test
  public void test1(){
    Obstacle o = new Obstacle();
    assertEquals("Expected initial x to be -1", -1, o.getXValue());
  }

  @Test
  public void test2(){
    Obstacle o = new Obstacle();
    o.generateTopX(0);
    String xAsString = Integer.toString(o.getXValue());
    assertThat("Set player x in front of obstacle", xAsString, anyOf(is("2"), is("3")));
  }

  @Test
  public void test3(){
    Obstacle o = new Obstacle();
    o.generateTopX(-2);
    assertEquals("Set player x behind obstacle", -1, o.getXValue());
  }

  @Test
  public void test4(){
    Obstacle o = new Obstacle();
    o.generateTopX(-1);
    assertEquals("Set player on obstacle", -1, o.getXValue());
  }

  // Testing generateTopObstacleY
  @Test
  public void test5(){
    Obstacle o = new Obstacle();
    assertEquals("Expected initial to be 0", 0, o.getYValue());
  }

  @Test
  public void test6(){
    Obstacle o = new Obstacle();
    o.generateTopY(0);
    String yAsInt = Integer.toString(o.getYValue());
    assertThat("Set player x in front of obstacle", yAsInt, anyOf(is("0"), is("1")));
  }

  @Test
  public void test7(){
    Obstacle o = new Obstacle();
    o.generateTopY(-2);
    assertEquals("Set player x behind obstacle", 0, o.getYValue());
  }

  @Test
  public void test8(){
    Obstacle o = new Obstacle();
    o.generateTopY(-1);
    assertEquals("Set player x on obstacle", 0, o.getYValue());
  }

  // Testing generateBottomObstacleX
  @Test
  public void test9(){
    Obstacle o1 = new Obstacle();
    Obstacle o2 = new Obstacle();
    o1.generateTopX(0);
    o2.generateBottomX(o1);
    assertEquals("Set player x in front of obstacle", o1.getXValue(), o2.getXValue());
  }

  @Test
  public void test10(){
    Obstacle o1 = new Obstacle();
    Obstacle o2 = new Obstacle();
    o1.generateTopX(-2);
    o2.generateBottomX(o1);
    assertEquals("Set player x behind obstacle", o1.getXValue(), o2.getXValue());
  }

  @Test
  public void test11(){
    Obstacle o1 = new Obstacle();
    Obstacle o2 = new Obstacle();
    o1.generateTopX(-1);
    o2.generateBottomX(o1);
    assertEquals("Set player x on obstacle", o1.getXValue(), o2.getXValue());
  }

  //Testing generateBottomObstacleY
  @Test
  public void test12(){
    Obstacle o1 = new Obstacle();
    Obstacle o2 = new Obstacle();
    o1.generateTopY(0);
    o2.generateBottomY(o1);
    assertEquals("Set player x in front of obstacle", (o1.getYValue() + 1), o2.getYValue());
  }

  @Test
  public void test13(){
    Obstacle o1 = new Obstacle();
    Obstacle o2 = new Obstacle();
    o1.generateTopY(-2);
    o2.generateBottomY(o1);
    assertEquals("Set player x behind obstacle", 1, o2.getYValue());
  }

  @Test
  public void test14(){
    Obstacle o1 = new Obstacle();
    Obstacle o2 = new Obstacle();
    o1.generateTopY(-1);
    o2.generateBottomY(o1);
    assertEquals("Set player x on obstacle", (o1.getYValue() + 1), o2.getYValue());
  }
}
