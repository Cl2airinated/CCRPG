import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Weapons {
    int dam,durability,dps,x,y,w,h;
    ImageIcon pic;

    public Weapons(){
       
    }
    
    
    public Weapons(int x, int y, int w, int h, int d, int dur, int dp, ImageIcon pic) {
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        dam=d;
        durability=dur;
        dps=dp; 
        this.pic=pic;   
    }

    public void setX(int i) {
        x=i;    
    }


    


    public void drawWeap(Graphics g2d) {
        // TODO Auto-generated method stub
        g2d.drawImage(pic.getImage(), x, y,w,h, null);
    }


    public void setY(int y) {
        this.y = y;
    }


    public void setHeight(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setHeight'");
    }


    public void setWidth(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setWidth'");
    }


    public int getHeight() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHeight'");
    }


    public int getY() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getY'");
    }


    public int getX() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getX'");
    }


    public int getWidth() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWidth'");
    }

   
}
    
       