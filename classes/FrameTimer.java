import java.util.Timer;
import java.util.TimerTask;

public class FrameTimer{
  int player_x_value = 0;
  Timer timer = new Timer();

  TimerTask count = new TimerTask() {
    public void run(){
      System.out.println("Redraw frame");
      player_x_value++;
    }
  };

  public void start() {
    timer.scheduleAtFixedRate(count, 0, 3000);
  }
}
