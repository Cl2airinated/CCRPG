import java.util.ArrayList;

import javax.swing.ImageIcon;

public class cookieuser1 extends Characters{
    public cookieuser1(){
        super();
    }

    public cookieuser1(int x, int y){
        super(x,y, 50,50,10,5,5,1, new ImageIcon("assets/cookieuser1.png"), new basic());
        super.getWeapon().setX(super.getX()+super.getW());
        super.setWeapons(setList());
    }
    public String toString(){
         return "cookieuser1"+super.getHealth();
        //return "cookieuser1";


    }

    public ArrayList <Weapons> setList(){
        ArrayList <Weapons> temp= new ArrayList <Weapons> ();
        temp.add(new gold());
        temp.add(new basic());
        temp.add(new wrath());
        return temp;
    }
}