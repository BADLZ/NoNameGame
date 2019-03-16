package Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

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
	private String username, passwordHash;
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
		
		
		JLabel j = new JLabel(textfieldimg);
		j.setBounds(screenWidth/2-160, screenHeight/2-135, 420, 150);
		frame.add(j);

		FancyTextField usernameField = new FancyTextField("Enter Your Username", screenWidth / 2 - 265 / 2,
				screenHeight / 2 - 80, 265, 30);
		frame.getContentPane().add(usernameField);

		FancyTextField passwordField = new FancyTextField("Enter Your Password", screenWidth / 2 - 263 / 2,
				screenHeight / 2 , 263, 22);
		frame.getContentPane().add(usernameField);
		frame.getContentPane().add(passwordField);

		JLabel nameLabel = new JLabel("Nome:");
		nameLabel.setForeground(Color.GRAY);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameLabel.setBounds(127, 128, 76, 22);
		frame.getContentPane().add(nameLabel);

		JLabel passwordLabel = new JLabel("Pass:");
		passwordLabel.setForeground(Color.GRAY);
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordLabel.setBounds(127, 195, 76, 22);
		frame.getContentPane().add(passwordLabel);

		FancyButton btnLogin = new FancyButton("btnLogin", screenWidth / 2 - 250, screenHeight / 2 + 50, 200, 67,
				loginBtnimg, loginBtnpressedimg);
		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					tryLogin();
				}
			}
		});
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
			passwordHash = String.valueOf(passwordField.getPassword());
			System.out.println("nome: " + username + " password: " + passwordHash);

			// fechar janela
//			frame.dispose();

			parentClass.login(username, passwordHash);
		}
	}
}
