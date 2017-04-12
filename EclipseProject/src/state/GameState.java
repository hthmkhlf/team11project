package state;

import java.awt.Graphics2D;

/**
 * @author Josh Schijins
 * This interface contains methods which will respectively switch between and draw the different game states based on
 * user input (key press).
 */

public interface GameState {
	public void update();
	public void draw(Graphics2D graphics);
	public void keyPressed(int key);
}
