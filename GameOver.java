import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOver extends JPanel {
    JButton restartButton;

    public GameOver(CardLayout cardLayout, JPanel cardPanel, Game game) {
        this.setLayout(new BorderLayout()); //sets the general layout to be border
        int applesEaten = game.getApplesEaten();
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.BLACK);//colour for center
        ImageIcon newIcon = new ImageIcon("images/GameOver.png");
        newIcon.setImage(newIcon.getImage().getScaledInstance(800, 125, Image.SCALE_DEFAULT));
        centerPanel.add(new JLabel(newIcon));

        JPanel imagePanel = new JPanel(); //new panel object
        imagePanel.setPreferredSize(new Dimension(1000, 200));//size of top panel
        imagePanel.setBackground(new Color(42, 51, 51));  //colour of top panel
        imagePanel.setBackground(Color.BLACK);  //colour of top panel

        JLabel Score = new JLabel();
        Score.setText("Score: " + applesEaten);
        Score.setFont(new Font("Helvetica", Font.ITALIC | Font.BOLD, 65));
        Score.setForeground(Color.ORANGE);
        Score.setHorizontalAlignment(SwingConstants.CENTER);
        Score.setVerticalAlignment(SwingConstants.CENTER);
        Score.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        imagePanel.add(Score);
//        centerPanel.add(Score);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout()); //buttons are flow layout
        buttonPanel.setPreferredSize(new Dimension(300, 430)); //creates size of panel
        buttonPanel.setBackground(Color.BLACK);

        restartButton = new JButton("Restart");
        restartButton.setPreferredSize(new Dimension(300, 100)); //changes size of buttons
        restartButton.setFont(new Font("Helvetica", Font.BOLD, 40));
        restartButton.setHorizontalTextPosition(SwingConstants.LEFT);
        restartButton.setForeground(new Color(22, 247, 228));
//        restartButton.setForeground(Color.GREEN);
        restartButton.setBackground(new Color(42, 51, 51));
        restartButton.setFocusable(false);

        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Game game = new Game(cardLayout, cardPanel);
                cardPanel.add(game, "Game");
                cardLayout.show(cardPanel, "Game");
                cardPanel.revalidate();
                cardPanel.repaint();  // Ensure the panel updates

                // Request focus for the Game panel
                game.requestFocusInWindow();

            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0)); // Exit game
        exitButton.setPreferredSize(new Dimension(300, 100)); //changes size of buttons
        exitButton.setFont(new Font("Helvetica", Font.BOLD, 40));
//        exitButton.setForeground(new Color(170, 83, 232));
        exitButton.setBackground(new Color(42, 51, 51));
//        exitButton.setForeground(Color.RED);
        exitButton.setForeground(new Color(170, 83, 232));

        exitButton.setFocusable(false);


        buttonPanel.add(restartButton); //makes buttons flow layout
        buttonPanel.add(exitButton);  //makes buttons flow layout


        restartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        JPanel left = new JPanel();
        JPanel right = new JPanel();
        left.setPreferredSize(new Dimension(10, 10));
        right.setPreferredSize(new Dimension(10, 10));
        left.setBackground(Color.BLACK);
        right.setBackground(Color.BLACK);

        this.add(buttonPanel, BorderLayout.SOUTH); //puts the panel that holds the buttons in the bottom
        this.add(imagePanel, BorderLayout.NORTH); //puts the panel that holds the image
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(left, BorderLayout.WEST);
        this.add(right, BorderLayout.EAST);

    }


}
