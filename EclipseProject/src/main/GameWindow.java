package main;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.*;
/**
 * 
 * @author Josh Schijns
 * Handles the panel in which everything is drawn onto and manages key listeners
 * The window will be redrawn at a rate of 30 frames per second.
 */

@SuppressWarnings("serial")
public class GameWindow extends JPanel{
	// dimensions for the window
	public static int WINDOW_WIDTH = 1650;
	public static int WINDOW_HEIGHT = 550;
	
	// images
	private Graphics2D graphics;
	private BufferedImage image;
	private Driver driver = new Driver(this);

	/**
	 * Default Constructor, it sets the window size for the panel and sets focus to it.
	 */
	public GameWindow(){
		super();
		setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		setFocusable(true);
		requestFocus();
		addKeyListener(driver);
	}
	
	public void addNotify(){
		super.addNotify();
		if(driver.getThread() == null){
			driver.setThread();
		}
	}
	
	/**
	 * This method is what is run by the thread. The loop within it is used to establish
	 * a frames per second. If the amount of time that occurs is faster than we want, it
	 * will put the thread to sleep to keep a constant rate.
	 */
	
	// draw everything offscreen so it is loaded
	private void gameRender(Manager manager){
		super.paint(graphics);
		manager.draw(graphics);
	}
	
	private void gameDraw(){
		//drawing on the screen
		Graphics graphics2 = this.getGraphics();
		graphics2.drawImage(image, 0, 0, null);
		graphics2.dispose();
	}
	
	public void starting(Manager manager){
		image = new BufferedImage(WINDOW_WIDTH, WINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB);
		graphics = (Graphics2D) image.getGraphics();
		gameRender(manager);
		gameDraw();
	}
}
