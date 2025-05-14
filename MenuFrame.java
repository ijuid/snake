import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JPanel {
    JButton startButton;

    MenuFrame(CardLayout cardLayout, JPanel cardPanel) {
//        this.setBackground(new Color(42, 51, 51));
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.BLACK);//colour for center
        ImageIcon newIcon = new ImageIcon("images/snakeFont.png");
        centerPanel.add(new JLabel(newIcon));

        JPanel imagePanel = new JPanel(); //new panel object
        imagePanel.setPreferredSize(new Dimension(300, 200));//size of top panel
        imagePanel.setBackground(new Color(42, 51, 51));  //colour of top panel
        imagePanel.setBackground(Color.BLACK);  //colour of top panel

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout()); //buttons are flow layout
        buttonPanel.setPreferredSize(new Dimension(300, 430)); //creates size of panel
        buttonPanel.setBackground(Color.BLACK);

        startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(300, 100)); //changes size of buttons
        startButton.setFont(new Font("Helvetica", Font.BOLD, 40));
        startButton.setHorizontalTextPosition(SwingConstants.LEFT);
        startButton.setForeground(new Color(22, 247, 228));
        startButton.setBackground(new Color(42, 51, 51));
        startButton.setFocusable(false);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game(cardLayout, cardPanel);
                cardPanel.add(game, "Game");
                cardLayout.show(cardPanel, "Game");
                cardPanel.revalidate();
                cardPanel.repaint();  // Ensure the panel updates

                // Request focus for the Game panel
                Component gamePanel = cardPanel.getComponent(1); // Assuming "Game" is at index 1
                gamePanel.requestFocusInWindow();

            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0)); // Exit game
        exitButton.setPreferredSize(new Dimension(300, 100)); //changes size of buttons
        exitButton.setFont(new Font("Helvetica", Font.BOLD, 40));
        exitButton.setForeground(new Color(170, 83, 232));
        exitButton.setBackground(new Color(42, 51, 51));
        exitButton.setFocusable(false);


        buttonPanel.add(startButton); //makes buttons flow layout
        buttonPanel.add(exitButton);  //makes buttons flow layout

        this.setLayout(new BorderLayout()); //sets the general layout to be border

        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(buttonPanel, BorderLayout.SOUTH); //puts the panel that holds the buttons in the bottom
        this.add(imagePanel, BorderLayout.NORTH); //puts the panel that holds the image
        this.add(centerPanel, BorderLayout.CENTER);

    }



}
