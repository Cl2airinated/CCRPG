import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Weapons {
    int dam,durability,dps,x,y,w,h,dx,dy;
    int speed;
    int damage;
    int H;
    ImageIcon pic;

    public Weapons(){
       
    }
    
    
    public Weapons(int x, int y, int w, int h, int d, int durability, int dps, int speed,int damage, ImageIcon pic) {
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        this.damage=damage;
        this.durability=durability;
        this.dps=dps; 
        dx=0;
		dy=0;
        this.speed=speed;
        this.damage=damage;
    
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


    public void setHeight(int h) {
        
        this.h=h;

    }


    public void setWidth(int w) {
        this.w=w;
    }


    public int getHeight() {
        return h;
    }


    public int getY() {
        return y;
    }


    public int getX() {
        return x;
    }


    public int getWidth() {
        return w;
    }
    public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx += dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy1) {
		dy += dy1;
	}
    public void move() {
		x+=dx;
		y+=dy;
		
	}


    public ImageIcon getPic() {
        return pic;
    }

    public void setPic(ImageIcon pic) {
        this.pic = pic;
    }


    public int getSpeed() {
        
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


    // public int getH() {
    //     return H;
    // }
    // public void setH(){
    //     this.H=H;
    // }


   
}
    
       