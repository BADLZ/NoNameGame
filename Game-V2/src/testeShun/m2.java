package testeShun;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Graphics.FancyButton;

public class m2 extends JLabel{
	myteste myteste;
	private ImageIcon background, cursorimg, quitBtnimg, quitBtnpressedimg, optionsBtnimg, optionsBtnpressedimg, startBtnimg, startBtnpressedimg;

	private Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	private final int screenWidth = size.width;
	private final int screenHeight = size.height;

	/**
	 * Create the application.
	 * @param myteste 
	 */
	public m2(myteste myteste) {
		this.myteste = myteste;
		initialize();
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		initializeImages();
		
		this.setIcon(background);
		setCursor(
				Toolkit.getDefaultToolkit().createCustomCursor(cursorimg.getImage(), new Point(0, 0), "custom cursor"));

		FancyButton quitBtn = new FancyButton("Meu Botao", screenWidth / 2 - 100, screenHeight / 2 + 100, 200, 67,
				quitBtnimg, quitBtnpressedimg);
		add(quitBtn);
		quitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		FancyButton startBtn = new FancyButton("startBtn", screenWidth / 2 - 100, screenHeight / 2 - 100, 200, 67,
				startBtnimg,startBtnpressedimg);
		startBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				myteste.mudaCards();
			}
		});
		add(startBtn);
		
		
		FancyButton optionsBtn = new FancyButton("optionsBtn", screenWidth / 2 - 100, screenHeight / 2, 200, 67,
				optionsBtnimg,optionsBtnpressedimg);
		add(optionsBtn);
		

	}


	private void initializeImages() {
		try {
			background =new ImageIcon(ImageIO.read(new File("src/resources/InGameImg/mainImg.jpg")));
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


}
