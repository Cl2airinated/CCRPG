import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;

import javax.imageio.ImageIO;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Queue;
import java.util.LinkedList;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;


public class Game extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener {

    private BufferedImage back;
    private BufferedImage backgroundImage; // Background for all screens
    private int key, x, y, screenHeight, screenWidth;
    private ArrayList<Characters> charList;
    private String screen;
    private String words, weaponPos;
    private Characters player;
    private Weapons weapon;
    private Queue<enemy> enemies;
    private File saveFile;
    private boolean enem = false;
    

   
    
   
    private ArrayList<Weapons> weaponList;
    private ArrayList<range> CookieList;

    public Game() {
        new Thread(this).start();
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        saveFile = new File("saveFile2.0.txt");
        key = -1;
        x = 0;
        y = 0;
        charList = setCharList();
        screen = "start";
        words = "";
        weaponPos = "rightpressed";
        //rangedWeap = new ArrayList<range>();
        CookieList= new ArrayList <range>();
       // missiles = new ArrayList<>();

        player = null;
        enemies = setEs();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenHeight = screenSize.height;
        screenWidth = screenSize.width;
        try {
            backgroundImage = ImageIO.read(new File("/Users/clairebrowning/Downloads/CCRPG/src/background.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        weaponList = setweaponList();
    }
   public void readFile(){
    Scanner sc;
    try {
        sc = new Scanner(saveFile);
        while(sc.hasNext()){
            // System.out.println(sc.next());
            words = words + " " + sc.next();
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    
   }
    public void createFile(){
       try{
        if(saveFile.createNewFile()){
            System.out.println("success file");
        }
        else{
            System.out.println("file already exists");}
            
        }
         catch (IOException e){
            e.printStackTrace();
        }
    }
public void writeToFile(Graphics g2d){
    try{
   FileWriter myWriter = new FileWriter(saveFile);
    if(enemies.isEmpty()){
        myWriter.write("win");
        g2d.drawString("you win!", 100, 100);
    }
    else{
        
       if(enem){
        myWriter.write("In your last run, you had "+enemies.size()+" enemies left!");
        // g2d.drawString("You have "+enemies.size()+" enemies left", 100, 100);
    }
    }
    myWriter.close();
        System.out.println("succ lod fil");
    }catch (IOException e){
        e.printStackTrace();
    }

}
    public Queue<enemy> setEs() {
        Queue<enemy> temp = new LinkedList<>();
        temp.add(new stockbroker(100, 100));
        temp.add(new stockbroker(300, 100));
        temp.add(new stockbroker(500, 100));
       // temp.add(new stockbroker(100, 100));

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

    public ArrayList<Weapons> setweaponList() {
        ArrayList<Weapons> temp = new ArrayList<Weapons>();
        temp.add(new wrath(100, 600));
        temp.add(new gold(600, 600));
        temp.add(new basic(1100, 600));
        return temp;

    }
    public ArrayList<range> setCookieList(){
        ArrayList<range> temp= new ArrayList<range>();
        temp.add(new cookiepow(100,100));
        temp.add(new cookiepow(100,100));
        temp.add(new cookiepow(100,100));
        temp.add(new cookiepow(100,100));

        return CookieList;
        
    }

    public void drawStartScreen(Graphics g2d) {
        g2d.drawString(words, 400, 600);
        enem = true;

       Color c = new Color(0,0,0, 200);
       g2d.setColor(c);
       g2d.fillRoundRect(x, y, 200, 200, 35, 35);
       c = new Color(255,255,255);
       g2d.setColor(c);
       ((Graphics2D) g2d).setStroke(new BasicStroke(5));// defineds the width of outlines of graphcs rendered by g2d
       g2d.drawRoundRect(x+5, y+5, 200-10, 200-10, 25, 25);
       g2d.drawString("Choose your player using 1,2,3 or 4", screenWidth/2-100, screenHeight-100);

        for (int i = 0; i < charList.size(); i++) {
            charList.get(i).setW(250);
            charList.get(i).setH(250);
            charList.get(i).drawChar(g2d);
        }
        
    }
   

    public void drawWeaponSelectScreen(Graphics g2d) {
        player.drawChar(g2d);

        for (int i = 0; i < weaponList.size(); i++) {
            Weapons weapon = weaponList.get(i);
            weapon.setX(350 + (i * 50)); // Adjust x position based on index
            weapon.setY(400);
            weapon.drawWeap(g2d);
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
            player.setX(20);
            player.setY(20);
            player.drawChar(g2d);
            Color c = new Color(0,0,0, 200);
       g2d.setColor(c);
       g2d.fillRoundRect(x, y, 200, 200, 35, 35);




       c = new Color(255,255,255);
       g2d.setColor(c);
       ((Graphics2D) g2d).setStroke(new BasicStroke(5));// defineds the width of outlines of graphcs rendered by g2d
       g2d.drawRoundRect(x+5, y+5, 200-10, 200-10, 25, 25);

            g2d.drawString("You picked " + player.toString(), 200, 500);
            // g2d.drawString("Stats"+ )
        }

    }

    public void drawGameScreen(Graphics g2d) {
        if (enemies.peek() != null) {
            enemies.peek().drawChar(g2d);
        }
        if (player != null) {
            player.drawChar(g2d);
        }
        if (weapon != null) {
            weapon.setX(player.getX() + player.getW());
            weapon.drawWeap(g2d);
        }
        g2d.setColor(Color.RED);
    g2d.fillRect(50, 70, 200, 20);  // Draw health bar background
    g2d.setColor(Color.GREEN);
    g2d.fillRect(50, 70, (int) (player.getHealth() * 2), 20);
        player.move(0, 0, screenWidth, screenHeight);        
        

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

    public void setWeapoPosition(){
        switch(weaponPos){
            case "leftpressed":

            weapon.setX(player.getX()-10);
            weapon.setY(player.getY()/2);

            break;

            case "rightpressed":

            weapon.setX(player.getX()-10);
            weapon.setY(player.getY()/2);

            break;

            case "uppressed":

            weapon.setX(player.getX()-10);
            weapon.setY(player.getY()/2);

            break;

            case "downpressed":

            weapon.setX(player.getX()-10);
            weapon.setY(player.getY()/2);

            break;
            
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        System.out.println(key);

        if (code == KeyEvent.VK_ENTER && screen == "weaponSelect") {
            screen = "selection";

        }

        if (code == KeyEvent.VK_1 && screen == "selection") {
            screen = "selection";
            player = charList.get(0);
        } else if (code == KeyEvent.VK_2 && screen == "selection") {
            screen = "selection";

            player = charList.get(1);
        } else if (code == KeyEvent.VK_3 && screen == "selection") {
            screen = "selection";
            player = charList.get(2); // Corrected to get the third character
        }
        if (code == KeyEvent.VK_ENTER && screen == "selection") {
            screen = "weaponSelect";

        }
        if (code == KeyEvent.VK_1 && screen == "weaponSelect") {
            weapon = weaponList.get(0);
        } else if (code == KeyEvent.VK_2 && screen == "weaponSelect") {
            screen = "weaponSelect";

            weapon = weaponList.get(1);
        } else if (code == KeyEvent.VK_2 && screen == "weaponSelect") {
            screen = "weaponSelect";
            weapon = weaponList.get(2);
        }
        if(code == KeyEvent.VK_ENTER && screen == "weaponSelect") {

            screen = "gameScreen";

        }
        if(code == KeyEvent.VK_S){
            player.setDy(-1);
        }
         
        if(code == KeyEvent.VK_D){
            player.setDx(1);
        }
       // else player.setDx(0);
        if(code == KeyEvent.VK_W){
            player.setDy(1);
        }
       // else player.setDy(0);
        if(code == KeyEvent.VK_A){
            player.setDx(-1);
        }
       // else player.setDx(0);
    }
    public boolean collision(int mouseX, int mouseY, Weapons weapon, enemy currentEnemy) {
        boolean collides= (mouseX >= currentEnemy.getX() && mouseX <= currentEnemy.getX() + currentEnemy.getW() &&
                mouseY >= currentEnemy.getY() && mouseY <= currentEnemy.getY() + currentEnemy.getH());
                if (collides) {
                    // Decrease player's health when collision happens
                    if (weapon != null && currentEnemy != null) {
                        player.setHealth(player.getHealth() - 10);  // Decrease health by 10 (or any value you prefer)
                        enemies.remove(); 
                         // Remove the enemy from the list
                    }
                   
                }
                return collides;
            }

            
            
    
    // public void collision(){
    //     if( weapon.getX() + weapon.getWidth() >= enemies.peek().getX() && weapon.getX() <= enemies.peek().getX() + enemies.peek().getW() && weapon.getY() + weapon.getHeight() >= enemies.peek().getY() && weapon.getY() <= enemies.peek().getY() + enemies.peek().getH()){
            
    //     }

    // }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            player.setDy(0);
        }
         
        if(code == KeyEvent.VK_A){
            player.setDx(0);
        }
       // else player.setDx(0);
        if(code == KeyEvent.VK_S){
            player.setDy(0);
        }
       // else player.setDy(0);
        if(code == KeyEvent.VK_D){
            player.setDx(0);
        }
       // else player.setDx(0);
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
    int mouseX = arg0.getX();
    int mouseY = arg0.getY();

    // Check if there are any enemies to check collision with
    if (!enemies.isEmpty()) {
        enemy currentEnemy = enemies.peek();
        // Check if the weapon's bounding box intersects with the enemy's bounding box
        if (weapon != null && collision(mouseX, mouseY, weapon, currentEnemy)) {
            enemies.remove(); // Remove the enemy if collision occurs
        }
    }
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
        // System.out.println("you clicked at" + arg0.getY());
        x = arg0.getX();
        y = arg0.getY();
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }

}
