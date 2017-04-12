package state;

import java.awt.Graphics2D;

public interface GameState {
	public void update();
	public void draw(Graphics2D graphics);
	public void keyPressed(int key);
}
