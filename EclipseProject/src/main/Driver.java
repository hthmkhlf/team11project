package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import map.ErrorMessage;

public class Driver implements Runnable, KeyListener {
	
	private Thread thread; 
	private boolean running;
	private int FPS = 30;
	private double averageFPS; //used to check if running smoothly
	private Manager manager;
	private GameWindow gameWindow;
	
	public Driver(GameWindow newGame){
		manager = new Manager();
		gameWindow = newGame;
	}
	
	public Thread getThread(){
		return thread;
	}
	public void setThread(){
		thread = new Thread(this);
		thread.start();
	}
	
	/**
	 * This method is what is run by the thread. The loop within it is used to establish
	 * a frames per second. If the amount of time that occurs is faster than we want, it
	 * will put the thread to sleep to keep a constant rate.
	 */
	public void run() {
		running = true;
		
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
			gameWindow.starting(manager);
			
			// This is used to calculate the time that has elapsed since starting the timer,
			// the wait time is used to put the thread to sleep so it lasts the targetTime.
			// The total time keeps track of how long it takes to run through 30 frames and establishes an
			// average rate. 
			elapsedTime = (System.nanoTime() - startTime) / 1000000;
			waitTime = targetTime - elapsedTime;
			if(waitTime < 0){
				waitTime = 5;
			}
			try{
				Thread.sleep(waitTime);
			}catch(IllegalArgumentException iae){
				ErrorMessage.addError("Sleep time is negative millis");
	        }catch (InterruptedException ioe) {
	        	ErrorMessage.addError("Thread Interrupted");
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
	
	public void gameUpdate(){
		manager.update();
	}
	
	/**
	 * Handles key pressed
	 * @param key is the key pressed 
	 */
	public void keyPressed(KeyEvent key) {
		manager.keyPressed(key.getKeyCode());
		
	}
	
	/**
	 * Handles key pressed
	 * @param key is the key pressed 
	 */
	public void keyReleased(KeyEvent key) {
		manager.keyReleased(key.getKeyCode());
	}

	// Not used but need
	public void keyTyped(KeyEvent key) {}

}
