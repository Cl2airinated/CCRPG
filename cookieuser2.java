import javax.swing.ImageIcon;

public class cookieuser2 extends Characters{
    public cookieuser2(){
        super();
    }

    public cookieuser2(int x, int y){
        super(x,y, 50,50,10,5,5,1, new ImageIcon("C:\\Users\\student\\Downloads\\CCRPG-main\\CCRPG-main\\cookieuser2.jpg"), new gold());
    }
    public String toString(){
        return "cookieuser2"+super.getHealth();

    }
}