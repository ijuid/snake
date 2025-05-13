import javax.swing.*;
import java.awt.*;

public class GameOver extends JPanel {
    private int applesEaten;
    public GameOver(CardLayout cardLayout, JPanel cardPanel) {
        Game game = new Game();
        applesEaten=game.applesEaten;
        this.setBackground(Color.BLACK);
//        gameOver(this.getGraphics());

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        gameOver(g);
    }

    public void gameOver(Graphics g){
        //text for game over
        // g.setColor(Color.RED);
        g.setFont(new Font("Helvetica", Font.BOLD, 80));
        FontMetrics metrics = g.getFontMetrics();
        g.drawString("Game Over", 500, 500);
        g.setColor(Color.WHITE);
        g.drawString("Score: " + applesEaten, 200, 600);
    }




}
