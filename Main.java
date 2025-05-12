import javax.swing.*;
import java.awt.*;


public class Main {
    JFrame frame = new JFrame("CardLayout demo");

    public Main() {
        JFrame frame = new JFrame("CardLayout demo");
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        MenuFrame menuFrame = new MenuFrame(cardLayout, cardPanel);
        Game game = new Game();

        cardPanel.add(menuFrame, "Menu");
        cardPanel.add(game, "Game");

        frame.setTitle("Snake");
        ImageIcon newIcon = new ImageIcon("images/apple.png");
        frame.setIconImage(newIcon.getImage());
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); //brings frame to middle
        frame.setResizable(false);
        frame.add(cardPanel);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
        });

    }

}


