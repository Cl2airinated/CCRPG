import javax.swing.ImageIcon;

public class gold extends Weapons{
    public gold(){
        super();
    }
    public gold(int x, int y){
        super(x,y,100,100,100,2,150, new ImageIcon("assets/cookieuser2.png"));
    }
    public String tostring(){
        return "gold";
    }
}

