package Graphics;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.glass.ui.Cursor;

import Scenes.Scenes;
import javafx.scene.Scene;

public class MainScreen {

	private JFrame frame;
	JLabel background = null;
	private ImageIcon cursorimg, quitBtnimg, quitBtnpressedimg, optionsBtnimg, optionsBtnpressedimg, startBtnimg, startBtnpressedimg;

	private Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	private final int screenWidth = size.width;
	private final int screenHeight = size.height;

	/**
	 * Create the application.
	 */
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		initializeImages();
		Scenes s = new Scenes();
		
		
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setContentPane(background);
		frame.setCursor(
				Toolkit.getDefaultToolkit().createCustomCursor(cursorimg.getImage(), new Point(0, 0), "custom cursor"));

		FancyButton quitBtn = new FancyButton("Meu Botao", screenWidth / 2 - 100, screenHeight / 2 + 100, 200, 67,
				quitBtnimg, quitBtnpressedimg);
		frame.add(quitBtn);
		quitBtn.CloseActionListener();

		FancyButton startBtn = new FancyButton("startBtn", screenWidth / 2 - 100, screenHeight / 2 - 100, 200, 67,
				startBtnimg,startBtnpressedimg);
		frame.add(startBtn);
		
		
		FancyButton optionsBtn = new FancyButton("optionsBtn", screenWidth / 2 - 100, screenHeight / 2, 200, 67,
				optionsBtnimg,optionsBtnpressedimg);
		frame.add(optionsBtn);
		

	}

	private void initializeImages() {
		try {
			background = new JLabel(new ImageIcon(ImageIO.read(new File("src/resources/InGameImg/mainImg.jpg"))));
			cursorimg = new ImageIcon(ImageIO.read(new File("src/resources/MainScreenImg/pointer.png")));
			quitBtnimg = new ImageIcon(ImageIO.read(new File("src/resources/MainScreenImg/quitBtn.png")));
			quitBtnpressedimg = new ImageIcon(ImageIO.read(new File("src/resources/MainScreenImg/quitBtnpressed.png")));
			optionsBtnimg = new ImageIcon(ImageIO.read(new File("src/resources/MainScreenImg/optionsBtn.png")));
			optionsBtnpressedimg = new ImageIcon(ImageIO.read(new File("src/resources/MainScreenImg/optionsBtnpressed.png")));
			startBtnimg = new ImageIcon(ImageIO.read(new File("src/resources/MainScreenImg/startBtn.png")));
			startBtnpressedimg = new ImageIcon(ImageIO.read(new File("src/resources/MainScreenImg/startBtnpressed.png")));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public JFrame getFrame() {
		return frame;
	}

}
