package Graphics.scenes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Graphics.SceneManager;
import Graphics.aesthetics.FancyButton;
import Graphics.aesthetics.FancyPasswordField;
import Graphics.aesthetics.FancyTextField;

public class LoginWindow extends JLabel{
	
	private SceneManager sm;
	
	private JTextField usernameField;
	private JPasswordField passwordField;
	private String username;
	private char[] passwordHash;
	private ImageIcon loginBtnimg, loginBtnpressedimg, registerBtnimg, registerBtnpressedimg, textfieldimg;
	
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setIcon(sm.getBackground());
		usernameField = new FancyTextField("Enter Your Username", sm.screenWidth / 2 - 121, sm.screenHeight / 2 - 103, 240,
				30);
		add(usernameField);

		passwordField = new FancyPasswordField("Enter Your Password", sm.screenWidth / 2 - 121, sm.screenHeight / 2 - 23, 240,
				30);
		add(usernameField);
		add(passwordField);

		JLabel img1 = new JLabel(textfieldimg);
		img1.setBounds(sm.screenWidth / 2 - 210, sm.screenHeight / 2 - 165, 420, 150);
		add(img1);
		JLabel img2 = new JLabel(textfieldimg);
		img2.setBounds(sm.screenWidth / 2 - 210, sm.screenHeight / 2 - 85, 420, 150);
		add(img2);

		FancyButton btnLogin = new FancyButton("btnLogin", sm.screenWidth / 2 - 250, sm.screenHeight / 2 + 50, 200, 67,
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

		FancyButton btnRegister = new FancyButton("btnRegister", sm.screenWidth / 2 + 50, sm.screenHeight / 2 + 50, 200, 67,
				registerBtnimg, registerBtnpressedimg);
		add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sm.changeCards("RegisterWindow");
				
			}
		});
	}

	private void tryLogin() {
		if (usernameField.getText() != null && passwordField.getPassword().length != 0) {
			username = usernameField.getText();
			// --------------------------------------------AVISO--------------------------------------------------
			// falta meter password em hash
			passwordHash = passwordField.getPassword();
			//caso conseguir fazer login
			if(sm.Login(username, passwordHash))
				sm.changeCards("PubScreen");
		}
	}
	
	
}
