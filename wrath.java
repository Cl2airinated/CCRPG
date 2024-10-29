import javax.swing.ImageIcon;

public class wrath extends Weapons{
    public wrath(){
        super();
    }
    public wrath(int x, int y){
        super(x,y,100,2,150, new ImageIcon("cookieuser3.png") );
    }
    public String tostring(){
        return "wrath";
    }
}

