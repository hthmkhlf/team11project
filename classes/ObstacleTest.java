public class ObstacleTest {
  public static void main(String[] args) {
    Obstacle obs= new Obstacle();


    obs.generateFirstObstacle(2);
    System.out.println("generateFirstObstacle test. Player x = 2.");
    System.out.println("x should be 3, y1 should be 0 or 1, y2 should be y1+1.");
    System.out.print("x: " + obs.obstacle_x_value + " y: " + obs.obstacle_y_value1);
    System.out.println(", " + obs.obstacle_y_value2);
    System.out.println();


    obs.generateConsequentObstacles(5);
    System.out.println("generateConsequentObstacles test. Player x = 5");
    System.out.println("x should be 6 or 7, y1 should be 0 or 1, y2 should be y1+1.");
    System.out.print("x: " + obs.obstacle_x_value + " y: " + obs.obstacle_y_value1);
    System.out.println(", " + obs.obstacle_y_value2);
    System.out.println();

    obs.generateConsequentObstacles(10);
    System.out.println("generateConsequentObstacles test. Player x = 10.");
    System.out.println("x should be 11 or 12, y1 should be 0 or 1, y2 should be y1+1.");
    System.out.print("x: " + obs.obstacle_x_value + " y: " + obs.obstacle_y_value1);
    System.out.println(", " + obs.obstacle_y_value2);
    System.out.println();

    obs.generateConsequentObstacles(25);
    System.out.println("generateConsequentObstacles test. Player x = 25.");
    System.out.println("x should be 26 or 27, y1 should be 0 or 1, y2 should be y1+1.");
    System.out.print("x: " + obs.obstacle_x_value + " y: " + obs.obstacle_y_value1);
    System.out.println(", " + obs.obstacle_y_value2);

  }
}
