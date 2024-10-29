import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Characters {

    private int x,y,w,h, speed, health, dmg, stam, dx, dy;
    ImageIcon pic;
    private Weapons weap;
    private ArrayList <Weapons> weaponList;

    public Characters(){
        y=0;
        x=0;
        w=0;
        h=0;
        speed=0;
        health=0;
        stam=0;
        dmg=0;
        dx=0;
        dy=0;
        pic= new ImageIcon();
    }
    
    
    public Characters(int x1, int y1, int width, int height, int sp, int hea, int dam, int st, ImageIcon p, Weapons weap){
        x=x1;
        y=y1;
        width=w;
        height =h;
        speed = sp;
        dmg = dam;
        stam=st;
        pic=p;
        dx=0;
        weap=weap;

    }   
    public Characters(int x1, int y1, int width, int height, int sp, int hea, int dam, int st, ImageIcon p, Weapons weap, ArrayList <Weapons> list){
        x=x1;
        y=y1;
        width=w;
        height =h;
        speed = sp;
        dmg = dam;
        stam=st;
        pic=p;
        dx=0;
        weap=weap;
        weaponList=list;
    }
    public Weapons getWeapon(){
        return weap;
    }
    public void setWeapons( ArrayList <Weapons> list ){
        weaponList=list;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getStam() {
        return stam;
    }

    public void setStam(int stam) {
        this.stam = stam;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public ImageIcon getPic() {
        return pic;
    }

    public void setPic(ImageIcon pic) {
        this.pic = pic;
    }

    public String toString(){
        return "HAVEN'T SET TOSTRING YET";
    }

    public void drawChar(Graphics g2d){
        g2d.drawImage(pic.getImage(), x, y, w, h, null);

        
    }
}
