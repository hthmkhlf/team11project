package main;
/**
*@author Josh Schijns
*/
import java.awt.*;
//import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;
import javax.swing.Timer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameWindow extends JPanel implements KeyListener{

    // dimensions for the window
    public static final int WINDOW_WIDTH = 320;
    public static final int WINDOW_HEIGHT = 240;

    // image for png's, had BufferedImage here, will use again later down the road
    private Image image;
//    private Image player;
    private Graphics2D graphics;
    private User player = new User();

    public GameWindow(){
        super();
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
        // This creates a timer for repainting, so in essence will paint everything every 200ms
        Timer timer = new Timer(200,
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        repaint();
                    }
                });
          timer.setInitialDelay(1000);
          timer.start();
    }

    public void paint(Graphics graphics){
        super.paint(graphics);
        // read image
        try {
        	// TODO change the path for the file, figure out how to shorten it in eclipse, make sure to put the double \ due to it being an escape code
            image = ImageIO.read(new File("src\\images\\background.png"));
        }   catch (IOException e ) {
        	e.printStackTrace(); // this will print errors to the console
        }
        graphics.drawImage(image, 0, 0,this.getWidth(),this.getHeight(), null);
        player.drawPlayer(graphics);
      
    }


    public void keyTyped(KeyEvent key) {

    }
    public void keyPressed(KeyEvent key) {

    	if (key.getKeyCode() == KeyEvent.VK_UP ) {
    		System.out.println("You Jumped !");
    		player.moveUp();
    	}else if (key.getKeyCode() == KeyEvent.VK_DOWN) {
    		System.out.println("You Slided !");
    	}

    }
    public void keyReleased(KeyEvent key) {

    }

}
