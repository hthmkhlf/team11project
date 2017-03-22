package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Menu extends JPanel implements ActionListener{
		// BackGround image
	private Image image;
	
	//Create Buttons
	JButton startButton = new JButton();
	JButton scores = new JButton();
	JButton credits = new JButton();
	
	//Initiate Game Status

	public Menu(){
		super();
		super.setLayout(new GridLayout(3,0));
		
		try {
			image = ImageIO.read(new File("src/images/menu_background.jpg"));

		}catch (IOException e ) {
			e.printStackTrace();
		}
				
		try {
			Image start = ImageIO.read(new File("src/images/iconStart.png"));
			startButton.setIcon(new ImageIcon(start));
			startButton.setBorderPainted(false);
			startButton.setContentAreaFilled(false);
			startButton.setFocusPainted(false);
			startButton.setOpaque(false);
			super.add(startButton);
		}catch (IOException e ) {
			e.printStackTrace();
		}


		try {
			Image start = ImageIO.read(new File("src/images/iconScores.png"));
			scores.setIcon(new ImageIcon(start));
			scores.setBorderPainted(false);
			scores.setContentAreaFilled(false);
			scores.setFocusPainted(false);
			scores.setOpaque(false);
			super.add(scores);
		}catch (IOException e ) {
			e.printStackTrace();
		}

		try {
			Image start = ImageIO.read(new File("src/images/iconCredits.png"));
			credits.setIcon(new ImageIcon(start));
			credits.setBorderPainted(false);
			credits.setContentAreaFilled(false);
			credits.setFocusPainted(false);
			credits.setOpaque(false);
			super.add(credits);
		}catch (IOException e ) {
			e.printStackTrace();
		}
		
		startButton.addActionListener(this);

	}
	

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, -300, this);         
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		}
}
