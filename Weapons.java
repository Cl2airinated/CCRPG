import javax.swing.ImageIcon;

public class Weapons {
    int dam,durability,dps,x;
    public Weapons(){
       
    }
    
    
    public Weapons(int x, int y, int d, int dur, int dp, ImageIcon pic) {
        dam=d;
        durability=dur;
        dps=dps;    }

    public void setX(int i) {
        x=i;    
    }

   
}
    
       