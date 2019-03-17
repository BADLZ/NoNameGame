package Graphics;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Personagens.Personagens;
import database.DatabaseReader;
import database.DatabaseWriter;
import sergitoGames.LogSign;

public class SceneManager {

	
	MainScreen mainScreen;
	LoginWindow loginwindow;
	CharacterSelection characterselection;
	RegisterWindow registerwindow;
	
	
	Personagens p;
	String name;
	JFrame frame;
	LogSign logsign;
	CardLayout cl;
	JPanel cards;
	MainScreen mainscreen;
	public SceneManager() {
		mainscreen = new MainScreen(this);
		loginwindow = new LoginWindow(this);
		characterselection = new CharacterSelection(this);
		registerwindow = new RegisterWindow(this);
		
		
		
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
		cards.add(registerwindow, "RegisterWindow");
		//falta crear PubScreen
	}
	
	public boolean Login(String name, char[] password) {
		if(DatabaseReader.login(name, password)) {
			Personagens p = DatabaseReader.getPersonagem(name);
			if(p == null) {
				cl.show(cards, "CharacterSelection");
				return false;
			}
			this.name = name;
			return true;
		}
			
		return true;
	}
	
	public boolean createPersonagem(String category) {
		return DatabaseWriter.createNewPlayer(name, category);
	}
	
	public boolean setRegisterInfo(String email, String name, char[] password) {
		this.name = name;
		//Ir a database criar o gajo
		return DatabaseWriter.createAccout(name, password, email);
		
	}
	
	
	public void changeCards(String cardName) {
		cl.show(cards, cardName);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
}
