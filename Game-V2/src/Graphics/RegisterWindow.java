package Graphics;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

public class RegisterWindow extends JLabel {
	
	private Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	private final int screenWidth = size.width;
	private final int screenHeight = size.height;
	
	private SceneManager sm;

	private JTextField usernameField, emailField;
	private JPasswordField passwordField;
	private ImageIcon background, registerBtnimg, registerBtnpressedimg, textfieldimg;

	public RegisterWindow(SceneManager sm) {
		this.sm = sm;
		
		initializeImage();
		
		setIcon(background);
		usernameField = new FancyTextField("Enter Your Username", screenWidth / 2 - 121, screenHeight / 2 - 113, 240,
				30);
		add(usernameField);

		passwordField = new FancyPasswordField("Enter Your Password", screenWidth / 2 - 121, screenHeight / 2 - 23, 240,
				30);
		emailField = new FancyTextField("Enter Your Email", screenWidth / 2 - 121, screenHeight / 2 - 203, 240,
				30);
		add(usernameField);
		add(passwordField);
		add(emailField);
		
		JLabel img1 = new JLabel(textfieldimg);
		img1.setBounds(screenWidth / 2 - 210, screenHeight / 2 - 175, 420, 150);
		add(img1);
		JLabel img2 = new JLabel(textfieldimg);
		img2.setBounds(screenWidth / 2 - 210, screenHeight / 2 - 85, 420, 150);
		add(img2);
		JLabel img3 = new JLabel(textfieldimg);
		img3.setBounds(screenWidth / 2 - 210, screenHeight / 2 - 265, 420, 150);
		add(img3);
		

		FancyButton btnRegister = new FancyButton("btnRegister", screenWidth / 2 - 100, screenHeight / 2 + 50, 200, 67,
				registerBtnimg, registerBtnpressedimg);
		add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(emailField.getText().split("@").length!=2) {
					JPopupMenu l = new JPopupMenu();
					
					return;
				}
				if((emailField.getText().split("@"))[1].split("\\.").length!=2) {
					return;
				}
				if(usernameField.getText().length()<=5) {
					return;
				}
				if(passwordField.getPassword().length<=7) {
					return;
				}
				sm.setRegisterInfo(emailField.getText(), usernameField.getText(), passwordField.getPassword());
				sm.changeCards("CharacterSelection");
			}
		});
	}

	private void initializeImage() {
		try {
			registerBtnimg = new ImageIcon(ImageIO.read(new File("src/resources/MainScreenImg/registerBtn.png")));
			registerBtnpressedimg = new ImageIcon(
					ImageIO.read(new File("src/resources/MainScreenImg/registerBtnpressed.png")));
			textfieldimg = new ImageIcon(ImageIO.read(new File("src/resources/MainScreenImg/textfieldimg.png")));
			background = new ImageIcon(ImageIO.read(new File("src/resources/InGameImg/mainImg.jpg")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
