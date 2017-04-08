package state;

///**
//*@author Haithem Khelif
//*This Class will be used to display the Scores tables.
//*Will have the name and score of all the players.
//*Will read from the file only we won't write anything to it.
//*/

import java.util.Scanner;

import javax.imageio.ImageIO;

import com.sun.glass.events.KeyEvent;

import main.Manager;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Scores {
	private Manager manager;
	private String Filename = "src/main/HighScoreBoard.txt";
	private Scanner inputFile = null;
	private BufferedImage ScoresBackGround;
	public Scores(Manager manager) {
		try {
			ScoresBackGround = ImageIO.read(new File("src/images/ScoresMenu.png"));
		}catch (IOException e ) {
			e.printStackTrace();
		}
	}

	public void update() {
		try
		{
			inputFile = new Scanner(new File(Filename));
		}
		catch(FileNotFoundException e)
		{
			// print the error on the screen will do it later
			System.out.println("Can't open File");
		}
		while(inputFile.hasNextLine()) {
			String line = inputFile.nextLine();
			//Ignore next file just for testing purposes
			System.out.println(line);
		}
		inputFile.close();

	}
	public void draw(Graphics2D graphics) {
		//Will draw the scores read from the file just need to figure out how to pause the Thread
//		g.drawString();
		graphics.drawImage(ScoresBackGround, 0,0,1650, 550, null);  
	}
	
	// Need to work on how to make the game return to the main menu
	public void keyPressed(int key){
		if(key == KeyEvent.VK_R){
			manager.setState(manager.getMenuState());
		}
	}
}
