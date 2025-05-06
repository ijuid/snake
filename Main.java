import javax.swing.*;
import java.awt.*;


public class Main {

    public static void main(String[] args) {
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);


        MenuFrame frame= new MenuFrame(cardLayout, mainPanel); //calls the MyFrame class
        Game gamePanel = new Game(cardLayout, mainPanel);

        mainPanel.add(frame, "Menu");
        mainPanel.add(gamePanel, "Game");

    }

}
