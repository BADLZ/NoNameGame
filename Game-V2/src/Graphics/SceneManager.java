package Graphics;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sergitoGames.LogSign;

public class SceneManager {

	
	MainScreen mainScreen;
	LoginWindow loginwindow;
	CharacterSelection characterselection;
	
	
	JFrame frame;
	LogSign logsign;
	CardLayout cl;
	JPanel cards;
	MainScreen mainscreen;
	public SceneManager() {
		mainscreen = new MainScreen(this);
		loginwindow = new LoginWindow(this);
		characterselection = new CharacterSelection(this);
		
		frame = new JFrame();
		cl = new CardLayout();
		cards = new JPanel(cl);
		frame.add(cards);
		

		frame.setTitle("Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setVisible(true);
		
		cards.add(mainscreen, "mainscreen");
		cards.add(loginwindow, "LoginWindow");
		cards.add(characterselection, "CharacterSelection");
	}
	
	public void Login(String name, char[] password) {
		
	}
	
	public void changeCards(String cardName) {
		cl.show(cards, cardName);
	}
	public JFrame getFrame() {
		return frame;
	}
	
}
