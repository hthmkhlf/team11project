import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class ObstacleTest{

  // Testing generateTopX
  @Test
  public void test1(){
    Obstacle o = new Obstacle();
    assertEquals("Expected initial x to be 0", 0, o.getXCoord());
  }

  @Test
  public void test2(){
    Obstacle o = new Obstacle();
    o.generateTopX(1);
    String xAsString = Integer.toString(o.getXCoord());
    assertThat("Set player x at 1", xAsString, anyOf(is("2"), is("3")));
  }

  @Test
  public void test3(){
    Obstacle o = new Obstacle();
    o.generateTopX(-1);
    String xAsString = Integer.toString(o.getXCoord());
    assertThat("Set player x at -1", xAsString, anyOf(is("0"), is("1")));
  }

  @Test
  public void test4(){
    Obstacle o = new Obstacle();
    o.generateTopX(30);
    String xAsString = Integer.toString(o.getXCoord());
    assertThat("Set player x at 30", xAsString, anyOf(is("31"), is("32")));
  }

  // Testing generateTopY
  @Test
  public void test5(){
    Obstacle o = new Obstacle();
    assertEquals("Expected initial to be 0", 0, o.getYCoord());
  }

  @Test
  public void test6(){
    Obstacle o = new Obstacle();
    o.generateTopY();
    String yAsInt = Integer.toString(o.getYCoord());
    assertThat("Expected y-coordinate be 0 or 1", yAsInt, anyOf(is("0"), is("1")));
  }

  // Testing generateBottomX
  @Test
  public void test7(){
    Obstacle o1 = new Obstacle();
    Obstacle o2 = new Obstacle();
    o1.generateTopX(1);
    o2.generateBottomX(o1);
    assertEquals("Set player x at 1", o1.getXCoord(), o2.getXCoord());
  }

  @Test
  public void test8(){
    Obstacle o1 = new Obstacle();
    Obstacle o2 = new Obstacle();
    o1.generateTopX(-1);
    o2.generateBottomX(o1);
    assertEquals("Set player x at -1", o1.getXCoord(), o2.getXCoord());
  }

  @Test
  public void test9(){
    Obstacle o1 = new Obstacle();
    Obstacle o2 = new Obstacle();
    o1.generateTopX(656);
    o2.generateBottomX(o1);
    assertEquals("Set player x at 656", o1.getXCoord(), o2.getXCoord());
  }

  // Testing generateBottomY
  @Test
  public void test10(){
    Obstacle o1 = new Obstacle();
    Obstacle o2 = new Obstacle();
    o1.generateTopY();
    o2.generateBottomY(o1);
    String yAsString = Integer.toString(o2.getYCoord());
    assertThat("Expected y-coordinate to be 1 or 2", yAsString, anyOf(is("1"), is("2")));
  }

}
