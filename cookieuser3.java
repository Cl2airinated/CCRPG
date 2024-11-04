import javax.swing.ImageIcon;

public class cookieuser3 extends Characters{
    public cookieuser3(){
        super();
    }

    public cookieuser3(int x, int y){
        super(x,y, 50,50,10,5,5,1, new ImageIcon("assets/cookieuser3.png"),new gold());
    }
    public String toString(){
        return "cookieuser3"+super.getHealth();

    }
}