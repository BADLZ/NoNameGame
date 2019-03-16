package Graphics;

import javax.swing.JFrame;

public class MainWindowManager {
	
	private JFrame frame;
	private LoginWindow loginWindow;
	private MainScreen mainScreen;
	
	public MainWindowManager() {
		this.frame = new JFrame();
		frame.setTitle("Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		mainScreen = new MainScreen(this, frame);
		frame.setVisible(true);

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
