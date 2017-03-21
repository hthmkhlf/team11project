package main;

import javax.swing.JFrame;

/*
 * @author : Haithem Khelif
 * This is the main class.
 */
public class Main {
    public static void main(String[] args) {
    /* Create the instance variables needed to run the game */
//    public static GameWindow GameWindow;
    GameWindow gameWindow = new GameWindow();
    Menu menu = new Menu();
    GameStatus status = new GameStatus();

        // TODO Auto-generated method stub
        // Setting the frame environment
        JFrame frame = new JFrame("Team 11 Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1650, 550);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
        
        if (status.getStatus() == 1) {
        	frame.setContentPane(menu);
        }else if (status.getStatus() == 2) {
        	frame.setContentPane(gameWindow);
        }
     
	}
}