package main;

import javax.swing.JFrame;

/*
 * @author : Haithem Khelif
 * This is the main class.
 */
public class Main {
    /* Create the instance variables needed to run the game */
    public static GameWindow GameWindow;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // Setting the frame environment
        JFrame frame = new JFrame("Team 11 Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 350);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);
        
        GameWindow = new GameWindow();
        frame.setVisible(true);
        frame.setContentPane(GameWindow);
    }

}
