import javax.swing.JApplet;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class ButtonDemo extends JApplet implements ActionListener,KeyListener{
    public void init(){
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.WHITE);

        contentPane.setLayout(new FlowLayout());

        JButton sunnyButton = new JButton("Sunny");
        contentPane.add(sunnyButton);
        sunnyButton.addActionListener(this);
        JButton cloudyButton = new JButton("Cloudy");
        contentPane.add(cloudyButton);
        cloudyButton.addActionListener(this);

        contentPane.addKeyListener(this);
        contentPane.requestFocusInWindow();
    }

    public void actionPerformed(ActionEvent e){
        Container contentPane = getContentPane();
        if (e.getActionCommand().equals("Sunny")){
            contentPane.setBackground(Color.BLUE);
        }else if(e.getActionCommand().equals("Cloudy")){
            contentPane.setBackground(Color.GRAY);
        }else{
            System.out.println("Error in button interface");
        }
    }


    public void keyTyped(KeyEvent j){
      System.out.println("Key Typed \'j\'");
    }

    public void keyPressed(KeyEvent j){
      System.out.println("Key pressed \'j\'");
    }

    public void keyReleased(KeyEvent j){
      System.out.println("Key released \'j\'");
    }
}
