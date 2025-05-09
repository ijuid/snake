//import javax.swing.*;
import java.awt.*;

public class GameFrame extends BaseFrame {
    public GameFrame() {
        super();
        this.add(new Game());
        this.setBackground(Color.BLACK);
        this.pack();
//        this.setVisible(true);
    }
}
