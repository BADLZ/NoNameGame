package main;

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

import com.sun.glass.ui.Cursor;


public class MainScreen {

	private JFrame frame;
	JLabel background = null;
	
	private Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	private final int screenWidth = size.width;
	private final int screenHeight = size.height;
	private ImageIcon cursor;
	/**
	 * @wbp.nonvisual location=257,709
	 */
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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

		
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    frame.setUndecorated(true);
		frame.setContentPane(background);
		frame.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				cursor.getImage(),
				new Point(0,0),"custom cursor"));
		
		

		FancyButton f1 = new FancyButton("Meu Botao", screenWidth/2-25
				, screenHeight/2+300, 50, 50,"src/resources/InGameImg/mainImg.jpg");
		frame.add(f1);
		f1.CloseActionListener();
		
		
		
	}
	
	private void initializeImages() {
		try {
			background = new JLabel(new ImageIcon(ImageIO.read(new File("src/resources/InGameImg/mainImg.jpg"))));
			cursor = new ImageIcon(ImageIO.read(new File("src/resources/MainScreenImg/pointer.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
