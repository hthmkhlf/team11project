//package main;
/**
*@author Josh Schijns
*/
import java.awt.*;
//import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameWindow extends JPanel implements KeyListener{

    // dimensions for the window
    public static final int WINDOW_WIDTH = 320;
    public static final int WINDOW_HEIGHT = 240;

    // image for png's, had BufferedImage here, will use again later down the road
    private Image image;
    private Graphics2D graphics;

    public GameWindow(){
        super();
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
    }

    public void paint(Graphics graphics){
        super.paint(graphics);
        // read image
        try {
        	// TODO change the path for the file, figure out how to shorten it in eclipse, make sure to put the double \ due to it being an escape code
            image = ImageIO.read(new File("C:\\Users\\Josh\\Documents\\School\\CPSC233\\team11project\\EclipseProject\\src\\images\\background.png"));
        }   catch (IOException e ) {
        	e.printStackTrace();
        }
        graphics.drawImage(image, 0, 0,this.getWidth(),this.getHeight(), null);
        graphics.drawRect(10,10,100,100);
        //repaint(); // use once we have a timer set up, will call this paint again
    }


    public void keyTyped(KeyEvent key) {

    }
    public void keyPressed(KeyEvent key) {

      System.out.println("Hi");

    }
    public void keyReleased(KeyEvent key) {

    }

}
