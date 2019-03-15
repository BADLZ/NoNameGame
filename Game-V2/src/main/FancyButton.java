package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FancyButton extends JButton{
	
	private static final long serialVersionUID = 5214107909544213465L;

	/**
	 * @param name - Button name
	 * @param posX - X position of the button
	 * @param posY - Y postion of the button
	 * @param width - Width of the button
	 * @param height - Height of the button
	 * @param imgPath - BackGround Image path
	 */
	public FancyButton(String name, int posX, int posY, int width, int height, String imgPath) {
		this.setName(name);
		setBounds(posX, posY, width, height);
		setContentAreaFilled(false);
		setBorder(BorderFactory.createEmptyBorder());
		setFocusable(false);
		try {
			setIcon(new ImageIcon(ImageIO.read(new File(imgPath))));
		} catch (IOException e) {
		}
	}
	
	/**
	 * Creates a actionListener to close the parent frame
	 */
	public void CloseActionListener() {
		JFrame topFrame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				topFrame.dispose();
			}
		});
	}

}
