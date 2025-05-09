import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 1000;
    static final int SCREEN_HEIGHT = 1000;
    static final int UNIT_SIZE = 35; //originally 25
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 75; //the speed
    final int[] x = new int[GAME_UNITS]; //x coordinates of bodyParts
    final int[] y = new int[GAME_UNITS]; //y coordinates of bodyParts
    int bodyParts= 6;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R'; //snake begins going right
    boolean running = false;
    Timer timer;
    Random random;

    public Game() {
        super();
        this.setBackground(Color.BLACK);
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setFocusable(true); //allows it to respond to keyboard events
        this.addKeyListener(new MyKeyAdaptor());

        startGame();
    }

    public void startGame(){
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponents(g);
        draw(g);
    }

    public void draw(Graphics g){
        for(int i=0; i<1000/UNIT_SIZE; i++){
            g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, 1000);
            g.drawLine(0, i*UNIT_SIZE, 1000, i*UNIT_SIZE);
        }
    }

    public void newApple(){

    }
    public void move(){

    }
    public void checkApple(){

    }
    public void checkCollisions(){

    }
    public void gameOver(Graphics g){

    }
    @Override
    public void actionPerformed(ActionEvent e){

    }
    public class MyKeyAdaptor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){

        }
    }
}
