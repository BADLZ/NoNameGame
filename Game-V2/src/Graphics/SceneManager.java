package Graphics;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Graphics.scenes.CharacterSelection;
import Graphics.scenes.Dungeon;
import Graphics.scenes.InGameLobby;
import Graphics.scenes.LoginWindow;
import Graphics.scenes.MainScreen;
import Graphics.scenes.PubScreen;
import Graphics.scenes.RegisterWindow;
import Graphics.scenes.TrainingRoom;
import Personagens.Personagens;
import database.DatabaseReader;
import database.DatabaseWriter;
import legacyCode.LogSign;

public class SceneManager {

	private MainScreen mainScreen;
	private LoginWindow loginwindow;
	private CharacterSelection characterselection;
	private RegisterWindow registerwindow;
	private PubScreen pubscreen;
	private Dungeon dungeon;
	private TrainingRoom trainingroom;
	private InGameLobby ingamelobby;
	
	
	private Personagens p;
	private String name;
	private JFrame frame;
	private LogSign logsign;
	private CardLayout cl;
	private JPanel cards;
	private MainScreen mainscreen;
	
	
	private ImageIcon background;
	private Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	public final int screenWidth = size.width;
	public final int screenHeight = size.height;
	public SceneManager() {
		try {
			background = new ImageIcon(ImageIO.read(new File("src/resources/InGameImg/mainImg.jpg")).getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		mainscreen = new MainScreen(this);
		loginwindow = new LoginWindow(this);
		characterselection = new CharacterSelection(this);
		registerwindow = new RegisterWindow(this);
		pubscreen = new PubScreen(this);
		trainingroom = new TrainingRoom(this);
		dungeon = new Dungeon(this);
		ingamelobby = new InGameLobby(this);
		
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
		cards.add(trainingroom, "TrainingRoom");
		cards.add(pubscreen, "PubScreen");
		cards.add(dungeon, "Dungeon");
		
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
	
	public ImageIcon getBackground() {
		return background;
	}
	
}
