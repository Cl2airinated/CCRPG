import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
	private static final int WIDTH =1800;
	private static final int HEIGHT=1600;
	
	public Main () {
		super("test Demo");
		setSize(WIDTH, HEIGHT);
		Game play = new Game();
		((Component) play).setFocusable(true);
		//misha was here
		
		Color RoyalBlue = new Color(255,255,255);
		
		
		setBackground(RoyalBlue);
		
		
		getContentPane().add(play);
		
		setVisible(true);
		addWindowListener(new WindowListener(){

			@Override
			public void windowOpened(WindowEvent e) {
				play.createFile();
				play.readFile();
			}

			@Override
			public void windowClosing(WindowEvent e) {
				play.writeToFile(getGraphics());
				}

			@Override
			public void windowClosed(WindowEvent e) {
				}

			@Override
			public void windowIconified(WindowEvent e) {
				}

			@Override
			public void windowDeiconified(WindowEvent e) {
				}

			@Override
			public void windowActivated(WindowEvent e) {
				}

			@Override
			public void windowDeactivated(WindowEvent e) {
				}

		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	public static void main(String[] args) {
		Main run = new Main();
		

	}


}
