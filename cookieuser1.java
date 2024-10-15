import javax.swing.ImageIcon;

public class cookieuser1 extends Characters{
    public cookieuser1(){
        super();
    }

    public cookieuser1(int x, int y){
        super(x,y, 50,50,10,5,5,1, new ImageIcon("C:\\Users\\student\\Downloads\\CCRPG-main\\CCRPG-main\\cookieuser1.png"), new gold());
      //  super.getWeapon().setX(super.getX()+super.getW());
    }
    public String toString(){
        return "cookieuser1"+super.getHealth();

    }
}