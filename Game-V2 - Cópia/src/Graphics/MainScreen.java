package Graphics;

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
import javax.swing.SwingUtilities;

public class MainScreen extends JLabel{

	private SceneManager sm;
	private ImageIcon cursorimg, quitBtnimg, quitBtnpressedimg, optionsBtnimg, optionsBtnpressedimg, startBtnimg, startBtnpressedimg;

	private Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	private final int screenWidth = size.width;
	private final int screenHeight = size.height;

	
	public MainScreen(SceneManager sm) {
		this.sm = sm;
		initialize();
	}

	private void initialize() {
		initializeImages();
		setIcon(sm.getBackground());
		setCursor(
				Toolkit.getDefaultToolkit().createCustomCursor(cursorimg.getImage(), new Point(0, 0), "custom cursor"));

		FancyButton quitBtn = new FancyButton("Meu Botao", screenWidth / 2 - 100, screenHeight / 2 + 100, 200, 67,
				quitBtnimg, quitBtnpressedimg);
		add(quitBtn);
		quitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sm.getFrame().dispose();
			}
		});

		FancyButton startBtn = new FancyButton("startBtn", screenWidth / 2 - 100, screenHeight / 2 - 100, 200, 67,
				startBtnimg,startBtnpressedimg);
		startBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				sm.changeCards("LoginWindow");
			}
		});
		add(startBtn);
		
		
		FancyButton optionsBtn = new FancyButton("optionsBtn", screenWidth / 2 - 100, screenHeight / 2, 200, 67,
				optionsBtnimg,optionsBtnpressedimg);
		add(optionsBtn);
		

	}


	private void initializeImages() {
		try {
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
