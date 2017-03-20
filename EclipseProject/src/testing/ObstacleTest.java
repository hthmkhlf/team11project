import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class ObstacleTest{

  // Testing constructor which takes no arguments
  public void test1(){
    Obstacle o = new Obstacle();
    assertEquals("Expected x-coordinate to be 1600", 1600, o.getXCoord());
  }

  public void test2(){
    Obstacle o = new Obstacle();
    assertEquals("Expected y-coordinate to be 0", 0, o.getYCoord());
  }

  public void test3(){
    Obstacle o = new Obstacle();
    assertEquals("Expected height to be 350", 350, o.getHeight());
  }

  public void test4(){
    Obstacle o = new Obstacle();
    assertEquals("Expected width to be 175", 175, o.getWidth());
  }

  // Testing constructor which takes four arguments
  public void test5(){
    Obstacle o = new Obstacle(1, 2, 3, 4);
    assertEquals("Expected x-coordinate to be 1", 1, o.getXCoord());
  }

  public void test6(){
    Obstacle o = new Obstacle(1, 2, 3, 4);
    assertEquals("Expected y-coordinate to be 2", 2, o.getYCoord());
  }

  public void test7(){
    Obstacle o = new Obstacle(1, 2, 3, 4);
    assertEquals("Expected height to be 3", 3, o.getHeight());
  }

  public void test8(){
    Obstacle o = new Obstacle(1, 2, 3, 4);
    assertEquals("Expected width to be 4", 4, o.getWidth());
  }

  // Testing copy constructor
  public void test9(){
    Obstacle o1 = new Obstacle();
    Obstacle o2 = new Obstacle(o1);
    o1.setX(1000);
    assertEquals("Expected x-coordinate to be 1600", 1600, o2.getXCoord());
  }

  public void test10(){
    Obstacle o1 = new Obstacle();
    o1.setX(1000);
    Obstacle o2 = new Obstacle(o1);
    assertEquals("Expected x-coordinate to be 1000", 1000, o2.getXCoord());
  }

  public void test11(){
    Obstacle o1 = new Obstacle();
    Obstacle o2 = new Obstacle(o1);
    o1.setY(30);
    assertEquals("Expected y-coordinate to be 0", 0, o2.getYCoord());
  }

  public void test12(){
    Obstacle o1 = new Obstacle();
    o1.setY(45);
    Obstacle o2 = new Obstacle(o1);
    assertEquals("Expected y-coordinate to be 45", 45, o2.getYCoord());
  }


  // Testing generateY
  public void test13(){
    Obstacle o = new Obstacle();
    o.generateY();
    String yAsString = Integer.toString(o.getYCoord());
    assertThat("Expected y-coordinate be 0 or 200", yAsString, anyOf(is("0"), is("200")));
  }

//
//
//   // Testing generateTopX
//   @Test
//   public void test1(){
//     Obstacle o = new Obstacle();
//     assertEquals("Expected initial x to be 0", 0, o.getXCoord());
//   }
//
//   @Test
//   public void test2(){
//     Obstacle o = new Obstacle();
//     o.generateTopX(1);
//     String xAsString = Integer.toString(o.getXCoord());
//     assertThat("Set player x at 1", xAsString, anyOf(is("2"), is("3")));
//   }
//
//   @Test
//   public void test3(){
//     Obstacle o = new Obstacle();
//     o.generateTopX(-1);
//     String xAsString = Integer.toString(o.getXCoord());
//     assertThat("Set player x at -1", xAsString, anyOf(is("0"), is("1")));
//   }
//
//   @Test
//   public void test4(){
//     Obstacle o = new Obstacle();
//     o.generateTopX(30);
//     String xAsString = Integer.toString(o.getXCoord());
//     assertThat("Set player x at 30", xAsString, anyOf(is("31"), is("32")));
//   }
//
//   // Testing generateTopY
//   @Test
//   public void test5(){
//     Obstacle o = new Obstacle();
//     assertEquals("Expected initial to be 0", 0, o.getYCoord());
//   }
//
//   @Test
//   public void test6(){
//     Obstacle o = new Obstacle();
//     o.generateTopY();
//     String yAsInt = Integer.toString(o.getYCoord());
//     assertThat("Expected y-coordinate be 0 or 1", yAsInt, anyOf(is("0"), is("1")));
//   }
//
//   // Testing generateBottomX
//   @Test
//   public void test7(){
//     Obstacle o1 = new Obstacle();
//     Obstacle o2 = new Obstacle();
//     o1.generateTopX(1);
//     o2.generateBottomX(o1);
//     assertEquals("Set player x at 1", o1.getXCoord(), o2.getXCoord());
//   }
//
//   @Test
//   public void test8(){
//     Obstacle o1 = new Obstacle();
//     Obstacle o2 = new Obstacle();
//     o1.generateTopX(-1);
//     o2.generateBottomX(o1);
//     assertEquals("Set player x at -1", o1.getXCoord(), o2.getXCoord());
//   }
//
//   @Test
//   public void test9(){
//     Obstacle o1 = new Obstacle();
//     Obstacle o2 = new Obstacle();
//     o1.generateTopX(656);
//     o2.generateBottomX(o1);
//     assertEquals("Set player x at 656", o1.getXCoord(), o2.getXCoord());
//   }
//
//   // Testing generateBottomY
//   @Test
//   public void test10(){
//     Obstacle o1 = new Obstacle();
//     Obstacle o2 = new Obstacle();
//     o1.generateTopY();
//     o2.generateBottomY(o1);
//     String yAsString = Integer.toString(o2.getYCoord());
//     assertThat("Expected y-coordinate to be 1 or 2", yAsString, anyOf(is("1"), is("2")));
//   }
//
// }
}
