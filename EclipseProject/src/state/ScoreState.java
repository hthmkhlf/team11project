package state;

import main.Manager;
import map.ErrorMessage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 * @author Josh Schijins
 * This class controls the game state in which high scores are viewed.
 */

public class ScoreState implements GameState {
	private BufferedImage background;
	private String fileName = "src/main/HighScoreBoard.txt";
	private Scanner inputFile = null;
	private Manager manager;
	private ArrayList<String> highScores = new ArrayList<>();
	
	public ScoreState(Manager manager) {
		this.manager = manager;
		try {
			background = ImageIO.read(new File("src/images/ScoresMenu.png"));
		} catch(IllegalArgumentException iae) {
			ErrorMessage.addError("Image is null in ScoreState");
		} catch (IOException ioe) {
			ErrorMessage.addError("Error reading image for ScoreState");
		}
		getScoreBoard();
	}

	@Override
	public void update() {}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.drawImage(background, 0, 0, 1650, 550, null);
		int count = 0;
		for(String element : highScores){
			count++;
			graphics.setColor(Color.BLACK);
			graphics.setFont(new Font("Garamond", Font.BOLD , 30));
			graphics.drawString(element, 550, 100 + (30*count));
		}
	}
	
	@Override
	public void keyPressed(int key) {
		if(key == KeyEvent.VK_R){
			manager.setState(manager.getState("MENU"));
		}
	}
	
	/**
	 * This method writes new high scores into the file which scores are saved into.
	 */
	private void getScoreBoard(){
		try{
			inputFile = new Scanner(new File(fileName));
		} catch(NullPointerException npe){
			ErrorMessage.addError("File in Scorestate is null");
		} catch(FileNotFoundException fnfe){
			ErrorMessage.addError("File not found in ScoreState");
		}
		while(inputFile.hasNextLine()) {
			String line = inputFile.nextLine();
			highScores.add(line);
		}
		inputFile.close();
	}

}
