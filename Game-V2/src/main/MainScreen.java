package main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainScreen {

	private JFrame frame;
	JLabel background = null;
	/**
	 * @wbp.nonvisual location=257,709
	 */
	private final JButton closeButton = new JButton("New button");
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

		try {
			background = new JLabel(new ImageIcon(ImageIO.read(new File("src/resources/InGameImg/mainImg.jpg"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    frame.setUndecorated(true);
		frame.setContentPane(background);
		
		FancyButton f1 = new FancyButton("Meu Botao", 100, 100, 50, 50,"src/resources/InGameImg/mainImg.jpg");
		frame.add(f1);
		f1.CloseActionListener();
		
	}

}
