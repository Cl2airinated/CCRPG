import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class range extends Weapons{
	public range(){
super();
}
public range(int x, int y, int w, int h, int dam, int dur, int dp, ImageIcon pic){
super(x,y,w,h,dam,dur,dp,dp, dp, pic);
}
public void drawRang(Graphics g2d) {
	// TODO Auto-generated method stub
	g2d.drawImage(pic.getImage(), x, y,w,h, null);
}
public ImageIcon getPic() {
	return pic;
}

public void setPic(ImageIcon pic) {
	this.pic = pic;
}


}
