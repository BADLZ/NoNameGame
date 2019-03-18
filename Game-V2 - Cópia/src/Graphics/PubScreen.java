package Graphics;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PubScreen extends JLabel{

	private SceneManager sm;
	private ImageIcon background;

	public PubScreen(SceneManager sm) {
		this.sm = sm;
		initialize();
	}
	
	private void initialize() {
		initializeImages();
		
		setIcon(background);
		

	}
	
	private void initializeImages() {
		try {
			background = new ImageIcon(ImageIO.read(new File("src/resources/ThePub/pubScreen.png"))
					.getScaledInstance(sm.screenWidth, sm.screenHeight, Image.SCALE_SMOOTH));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
