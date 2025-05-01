import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyFrame() {
        this.setTitle("Snake"); //gives title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allows for the program to close when pressing close button
        this.setSize(500, 500); //sets size of frame
        this.setVisible(true); //allows frame to be visible
        ImageIcon image = new ImageIcon("snake.png"); //create a new icon

        this.setIconImage(image.getImage()); //create an icon on the window panel
        this.getContentPane().setBackground(new Color(110,142,91)); //creates background colour

        JLabel label = new JLabel(); //new label object
        this.add(label); //adds label to the Jframe
        label.setIcon(image); //adds an image of the snake
        label.setText("Hello World"); //adds text
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM); //puts text under image
        label.setForeground(Color.white);
        label.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        label.setIconTextGap(0);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(0, 0, 500, 500);

        label.setBackground(Color.black);
        label.setOpaque(true);

        this.setLayout(null);
    }

}
