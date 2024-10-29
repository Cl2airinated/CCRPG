import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Queue;
import java.util.LinkedList;

public class Game extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener {

    private BufferedImage back;
    private BufferedImage backgroundImage; // Background for all screens
    private int key, x, y;
    private ArrayList<Characters> charList;
    private String screen;
    private Characters player;
    private Queue <enemy> enemies;
    private ArrayList<range> rangedWeap;
    private ArrayList<meme> meleeWeap;

    public Game() {
        new Thread(this).start();
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        key = -1;
        x = 0;
        y = 0;
        charList = setCharList();
        screen = "start";
        rangedWeap=new ArrayList<range>();
        player = null;
        enemies=setEs();
        try {
            backgroundImage = ImageIO.read(new File("/Users/clairebrowning/Downloads/CCRPG/src/background.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public Queue <enemy> setEs(){
            Queue <enemy> temp= new LinkedList <>();
            temp.add(new stockbroker(100,100));
            return temp;
        }

        // Load the background image for all screens
       
    

    public ArrayList<Characters> setCharList() {
        ArrayList<Characters> temp = new ArrayList<>();
        temp.add(new cookieuser1(100, 200));
        temp.add(new cookieuser2(600, 200));
        temp.add(new cookieuser3(1100, 200));
        return temp;
    }
    // public ArrayList<Weapons> setweaponList(){
    //     ArrayList<Weapons> temp = new ArrayList<Weapons>();

    // }

    public void drawStartScreen(Graphics g2d) {
        for (int i = 0; i < charList.size(); i++) {
            charList.get(i).setW(250);
            charList.get(i).setH(250);
            charList.get(i).drawChar(g2d);
        }
    }

    public void drawScreens(Graphics g2d) {
        // Draw the background image for all screens
        if (backgroundImage != null) {
            g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
        }

        switch (screen) {
            case "start":
                drawStartScreen(g2d);
                break;
            case "selection":
                drawSelectScreen(g2d);
                break;
            case "weaponSelect":
            drawWeaponSelectScreen(g2d);
                break;
            case "gameScreen":
            drawGameScreen(g2d);
        }
    }

    public void drawSelectScreen(Graphics g2d) {
        if (player != null) {
            player.drawChar(g2d);
            g2d.drawString("You picked " + player.toString(), 200, 500);
           // g2d.drawString("Stats"+ )
        }
    
    }
    public void drawGameScreen(Graphics g2d) {
        enemies.peek().drawChar(g2d);
    
    }
    
    public void drawWeaponSelectScreen(Graphics g2d){

    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(5);
                repaint();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        Graphics2D twoDgraph = (Graphics2D) g;
        if (back == null)
            back = (BufferedImage) (createImage(getWidth(), getHeight()));

        Graphics g2d = back.createGraphics();
        g2d.clearRect(0, 0, getSize().width, getSize().height);
        g2d.setFont(new Font("Broadway", Font.BOLD, 50));
        drawScreens(g2d);
        twoDgraph.drawImage(back, null, 0, 0);
    }
    

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();
        System.out.println(key);

        if (key == 32) {
            screen = "selection";
            player = charList.get(0);
        }
       else if (key == 49) {
            screen = "selection";
            
            player = charList.get(1);
        }
       else if (key == 50) {
            screen = "selection";
            player = charList.get(2); // Corrected to get the third character
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        x = arg0.getX();
        y = arg0.getY();
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        System.out.println("entered");
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        System.out.println("exited");
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        System.out.println("you clicked at" + arg0.getY());
        x = arg0.getX();
        y = arg0.getY();
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }
}
