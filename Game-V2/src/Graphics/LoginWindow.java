package Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginWindow {

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private String username;
	private String passwordHash;
	private MainWindowManager parentClass;
	private ImageIcon loginBtnimg, loginBtnpressedimg, registerBtnimg, registerBtnpressedimg, textfieldimg;

	private Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	private final int screenWidth = size.width;
	private final int screenHeight = size.height;

	public LoginWindow(MainWindowManager parentClass, JFrame frame) {
		this.parentClass = parentClass;
		this.frame = frame;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			loginBtnimg = new ImageIcon(ImageIO.read(new File("src/resources/MainScreenImg/loginBtn.png")));
			loginBtnpressedimg = new ImageIcon(
					ImageIO.read(new File("src/resources/MainScreenImg/loginBtnpressed.png")));
			registerBtnimg = new ImageIcon(ImageIO.read(new File("src/resources/MainScreenImg/registerBtn.png")));
			registerBtnpressedimg = new ImageIcon(
					ImageIO.read(new File("src/resources/MainScreenImg/registerBtnpressed.png")));
			textfieldimg = new ImageIcon(ImageIO.read(new File("src/resources/MainScreenImg/textfieldimg.png")));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		


		usernameField = new FancyTextField("Enter Your Username", screenWidth / 2 - 121,
				screenHeight / 2 - 103, 240, 30);
		frame.getContentPane().add(usernameField);

		passwordField = new FancyPasswordField("Enter Your Password", screenWidth / 2 - 121,
				screenHeight / 2  - 23, 240, 30);
		frame.getContentPane().add(usernameField);
		frame.getContentPane().add(passwordField);
		
		JLabel img1 = new JLabel(textfieldimg);
		img1.setBounds(screenWidth/2-210, screenHeight/2-165, 420, 150);
		frame.add(img1);
		JLabel img2 = new JLabel(textfieldimg);
		img2.setBounds(screenWidth/2-210, screenHeight/2-85, 420, 150);
		frame.add(img2);
	

		FancyButton btnLogin = new FancyButton("btnLogin", screenWidth / 2 - 250, screenHeight / 2 + 50, 200, 67,
				loginBtnimg, loginBtnpressedimg);
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tryLogin();
			}
		});
		frame.add(btnLogin);

		FancyButton btnRegister = new FancyButton("btnRegister", screenWidth / 2 + 50, screenHeight / 2 + 50, 200, 67,
				registerBtnimg, registerBtnpressedimg);
		frame.add(btnRegister);
		

	}

	private void tryLogin() {
		if (usernameField.getText() != null && passwordField.getPassword().length != 0) {
			username = usernameField.getText();
			// --------------------------------------------AVISO--------------------------------------------------
			// falta meter password em hash
			passwordHash = new String(passwordField.getPassword());
			System.out.println("nome: " + username + " password: " + Arrays.toString(passwordField.getPassword()));

			// fechar janela
//			frame.dispose();

			parentClass.login(username);
		}
	}
}
