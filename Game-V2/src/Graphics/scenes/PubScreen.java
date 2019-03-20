package Graphics.scenes;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Graphics.SceneManager;

public class PubScreen extends JLabel {
	private boolean focusFrame = false;
	private boolean focusOld = false;
	private boolean focusBarTender = false;

	private SceneManager sm;
	private ImageIcon background, focusframeImg;

	public PubScreen(SceneManager sm) {
		this.sm = sm;
		initialize();
	}

	private void initialize() {
		initializeImages();
		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println(e.getX() + " " + e.getY());
				if (!focusBarTender && !focusOld && !focusFrame
						&& e.getX() > 465 && e.getX() < 784 && e.getY() > 105 && e.getY() < 341) {
					setIcon(focusframeImg);
					focusFrame = true;
					return;
				}
				else if (focusFrame) {
					setIcon(background);
					focusFrame = false;
					return;
				}
				
				if (!focusBarTender && !focusOld && !focusFrame
						&& e.getX() > 465 && e.getX() < 784 && e.getY() > 105 && e.getY() < 341) {
					setIcon(focusframeImg);
					focusFrame = true;
					return;
				}
				

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		setIcon(background);

	}

	private void initializeImages() {
		try {
			background = new ImageIcon(ImageIO.read(new File("src/resources/ThePub/pubScreen.png"))
					.getScaledInstance(sm.screenWidth, sm.screenHeight, Image.SCALE_SMOOTH));
			focusframeImg = new ImageIcon(ImageIO.read(new File("src/resources/ThePub/focusframe.png"))
					.getScaledInstance(sm.screenWidth, sm.screenHeight, Image.SCALE_SMOOTH));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
