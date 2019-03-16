package Graphics;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainWindowManager {
	
	private JFrame frame;
	private LoginWindow loginWindow;
	private MainScreen mainScreen;
	
	public MainWindowManager() {
		this.frame = new JFrame();
		frame.setTitle("Game");
		Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = size.width;                                   
		int screenHeight = size.height;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
//		loginWindow = new LoginWindow(this);
		
		mainScreen = new MainScreen(this, frame);
		frame.setVisible(true);
//		loginWindow = new LoginWindow(this, frame);

	}
	
	public static void centreWindow(JFrame frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
	
	public void openLoginWindow() {
		clearWindow();
		loginWindow = new LoginWindow(this, frame);
	}
	
	//corre isto quando faz login
	public void login(String username, String hashedPass) {
		clearWindow();
		System.out.println(username + " is gonna Play!");
		CharacterSelection s = new CharacterSelection(frame);
	}
	
	private void clearWindow() {
		frame.getContentPane().removeAll();
		frame.repaint();
	}
	
}
