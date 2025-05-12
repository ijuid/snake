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
        this.setFocusable(true); //allows it to respond to keyboard events
        this.setDoubleBuffered(true); // Ensure double buffering is enabled
        this.setBackground(Color.BLACK);
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.requestFocusInWindow();
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
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        for(int i=0; i<SCREEN_HEIGHT/UNIT_SIZE; i++){
            g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_WIDTH); //creates grid lines for x-axis
            g.drawLine(0, i*UNIT_SIZE, SCREEN_HEIGHT, i*UNIT_SIZE); //creates grid lines for y-axis
        }

        //creates apple
        g.setColor(Color.CYAN);
        g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

        //creates snake
        for(int i=0; i<bodyParts; i++){
            if(i==0){
                g.setColor(Color.GREEN);
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
            else{
                g.setColor(Color.CYAN);
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
        }
    }

    public void newApple(){
        appleX = random.nextInt((int) SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        appleY = random.nextInt((int) SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
    }
    public void move(){
        for(int i=bodyParts; i>0; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        switch(direction){
            case 'U':   //if direction moves up the y coordinate of head of snake is subtracted by unit size
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }

    public void checkApple(){

    }

    public void checkCollisions(){
        //checks if head collides with body
        for(int i=bodyParts; i>0; i--){
            if(x[0]==x[i] && y[0]==y[i]){
                running = false;
            }
        }
        //checks if head touches left border
        if(x[0] < 1){
            running = false;
        }
        //check if head touches right border
        if(x[0] > SCREEN_WIDTH-UNIT_SIZE){
            running = false;
        }
        //check if touches top border
        if(y[0] < 0){
            running = false;
        }
        //check if touches bottom border
        if(y[0] > SCREEN_HEIGHT-100){
            running = false;
        }

        if(!running){
            timer.stop();
        }

    }

    public void gameOver(Graphics g){

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(running){
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }
    public class MyKeyAdaptor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    if(direction != 'R'){
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    if(direction != 'L'){
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    if(direction != 'D'){
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    if(direction != 'U'){
                        direction = 'D';
                    }
                    break;
            }

        }
    }
//    @Override
//    public void addNotify() {
//        super.addNotify();
//        requestFocusInWindow(); // Ensure the panel requests keyboard focus
//    }

}
