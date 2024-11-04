import javax.swing.ImageIcon;

public class enemy  extends Characters{
    public enemy(){
        super();
    }
    public enemy(int x, int y, int w, int h, int spped, int hea, int dam, int st, ImageIcon pic, Weapons weap){
        super(x, y, w, h, spped, hea, dam, st, pic, weap);
    }

    public String toString(){
        return this.getX()+ " " + this.getY() + " "+ this.getW() + " " + this.getH() + " " + this.getPic();
    }
    
}
