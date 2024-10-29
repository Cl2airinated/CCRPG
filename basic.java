import javax.swing.ImageIcon;

public class basic extends Weapons{
    public basic(){
        super();
    }
    public basic(int x, int y){
        super(x,y,100,2,150, new ImageIcon("cookieuser1.png"));
    }
    public String tostring(){
        return "basic";
    }
}

