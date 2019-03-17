package Graphics;

import java.awt.Dimension;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginWindow extends JLabel{
	
	private SceneManager sm;
	
	private JTextField usernameField;
	private JPasswordField passwordField;
	private String username;
	private String passwordHash;
	private MainWindowManager parentClass;
	private ImageIcon background, loginBtnimg, loginBtnpressedimg, registerBtnimg, registerBtnpressedimg, textfieldimg;
	
	

	private Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	private final int screenWidth = size.width;
	private final int screenHeight = size.height;

	public LoginWindow(SceneManager sm) {
		this.sm = sm;
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
			background = new ImageIcon(ImageIO.read(new File("src/resources/InGameImg/mainImg.jpg")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		setIcon(background);
		usernameField = new FancyTextField("Enter Your Username", screenWidth / 2 - 121, screenHeight / 2 - 103, 240,
				30);
		add(usernameField);

		passwordField = new FancyPasswordField("Enter Your Password", screenWidth / 2 - 121, screenHeight / 2 - 23, 240,
				30);
		add(usernameField);
		add(passwordField);

		JLabel img1 = new JLabel(textfieldimg);
		img1.setBounds(screenWidth / 2 - 210, screenHeight / 2 - 165, 420, 150);
		add(img1);
		JLabel img2 = new JLabel(textfieldimg);
		img2.setBounds(screenWidth / 2 - 210, screenHeight / 2 - 85, 420, 150);
		add(img2);

		FancyButton btnLogin = new FancyButton("btnLogin", screenWidth / 2 - 250, screenHeight / 2 + 50, 200, 67,
				loginBtnimg, loginBtnpressedimg);

		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tryLogin();
			}
		});
		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					tryLogin();
			}
		});
		add(btnLogin);

		FancyButton btnRegister = new FancyButton("btnRegister", screenWidth / 2 + 50, screenHeight / 2 + 50, 200, 67,
				registerBtnimg, registerBtnpressedimg);
		add(btnRegister);

	}

	private void tryLogin() {
		if (usernameField.getText() != null && passwordField.getPassword().length != 0) {
			username = usernameField.getText();
			// --------------------------------------------AVISO--------------------------------------------------
			// falta meter password em hash
			passwordHash = new String(passwordField.getPassword());
			System.out.println("nome: " + username + " password: " + Arrays.toString(passwordField.getPassword()));

			sm.changeCards("CharacterSelection");
		}
	}
}
