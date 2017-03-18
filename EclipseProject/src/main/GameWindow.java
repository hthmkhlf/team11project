package main;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
/**
* @author Josh Schijns
* Handles the panel in which everything is drawn onto.
*/

@SuppressWarnings("serial")
public class GameWindow extends JPanel implements Runnable, KeyListener{
	// dimensions for the window
	public static int WINDOW_WIDTH = 1650;
	public static int WINDOW_HEIGHT = 550;
	
	// images
	private Graphics2D graphics;
	private BufferedImage image;
	private Player player = new Player();
	private Background background = new Background(); // maybe set up a manager to do this
	
	private int FPS = 30;
	private double averageFPS;
	
	
	
	private Thread thread;
	private boolean running;
	
	public GameWindow(){
		super();
		setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		setFocusable(true);
		requestFocus();
	}
	
	public void addNotify(){
		super.addNotify();
		if(thread == null){
			thread = new Thread(this);
			thread.start();
		}
		addKeyListener(this);
	}
	
	public void run(){
		running = true;
		
		image = new BufferedImage(WINDOW_WIDTH, WINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB);
		graphics = (Graphics2D) image.getGraphics();
		//used for establishing time
		long startTime;
		long elapsedTime;
		long waitTime;
		long totalTime = 0;
		int frameCount = 0;
		int maxFrameCount = 30;
		long targetTime = 1000 / FPS;
		
		
		while(running){
			startTime = System.nanoTime();
			
			gameUpdate();
			gameRender();
			gameDraw();
			// This is used to calculate the time that has elapsed since starting the timer,
			// the wait time is used to put the thread to sleep so it lasts the targetTime.
			// The total time keeps track of how long it takes to run through 30 frames and establishes an
			// average rate. 
			elapsedTime = (System.nanoTime() - startTime) / 1000000;
			waitTime = targetTime - elapsedTime;
			if(waitTime < 0){
				waitTime = 0;
			}
			try{
				Thread.sleep(waitTime);
			}catch(Exception e){
				e.printStackTrace();
			}
			totalTime += System.nanoTime() - startTime;
			frameCount++;
			if(frameCount == maxFrameCount){
				averageFPS = 1000.0 / ((totalTime / frameCount) / 1000000);
				frameCount = 0;
				totalTime = 0;
			}
			
		}
	}
	
	private void gameUpdate(){
		//updating everthing
		player.update();
		background.update();
	}
	
	private void gameRender(){
		//draw everything to offscreen so it is loaded
		super.paint(graphics);
		
		background.draw(graphics);
		graphics.drawString("FPS: "+ averageFPS, 10, 10);
		player.draw(graphics);
		
	}
	
	private void gameDraw(){
		//drawing on the screen
		Graphics graphics2 = this.getGraphics();
		graphics2.drawImage(image, 0, 0, null);
		graphics2.dispose();
	}
	
	public void keyTyped(KeyEvent key){}
	public void keyPressed(KeyEvent key){
		if(key.getKeyCode() == KeyEvent.VK_UP){
			player.toggleJump();
		}
	}
	public void keyReleased(KeyEvent key){}
}
