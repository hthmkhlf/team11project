// package main;
/**
*@author Josh Schijns
*/
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameWindow extends JPanel implements KeyListener{

    // dimensions for the window
    public static final int WINDOW_WIDTH = 320;
    public static final int WINDOW_HEIGHT = 240;

    // image for png's
    private BufferedImage image;
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
            image = ImageIO.read(new File("background.png"));
        }   catch (IOException e ) {

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
