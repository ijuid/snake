import javax.swing.*;

public class BaseFrame extends JFrame {
    public BaseFrame() {
        this.setTitle("Snake");
        ImageIcon newIcon = new ImageIcon("images/apple.png");
        this.setIconImage(newIcon.getImage());
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); //brings frame to middle
        this.setResizable(false);
        this.setVisible(true);
    }
}
