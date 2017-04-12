package map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class ErrorMessage extends MapObject{

	private static ArrayList<String> errors = new ArrayList<String>();
	
	public ErrorMessage(){
		super(0,500);
	}
	
	
	public static void addError(String message){
		errors.add(message);
	}
	
	public void draw(Graphics2D graphics) {
		int distance = 0;
		graphics.setColor(Color.RED);
		for(String message : errors){
			graphics.drawString(message, 0 + distance, 10);
			distance += 50;
		}
	}

	public void movement() {}


	public boolean collisionCheck(Player player) {
		return false;
	}

}
