package ParteGrafica;

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
	
	public MainWindowManager() {
		this.frame = new JFrame();
		frame.setTitle("DravenPrograms");
//		loginWindow = new LoginWindow(this);
		loginWindow = new LoginWindow(this, frame);

	}
	
	public static void centreWindow(JFrame frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}
	
	
	//corre isto quando faz login
	public void login(String username, String hashedPass) {
		System.out.println(username + " is gonna Play!");
		CharacterSelection s = new CharacterSelection(frame);
	}
	
}
