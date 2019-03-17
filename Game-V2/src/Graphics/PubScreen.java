package Graphics;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PubScreen extends JLabel{

	private SceneManager sm;
	private ImageIcon background;
	
	

	private Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	private final int screenWidth = size.width;
	private final int screenHeight = size.height;
	
	
	public PubScreen(SceneManager sm) {
		this.sm = sm;
		initialize();
	}
	
	private void initialize() {
		initializeImages();
		setIcon(background);
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(e.getX() + " " + e.getY());
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	private void initializeImages() {
		try {
			background = new ImageIcon(ImageIO.read(new File("src/resources/InGameImg/mainImg.jpg")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
