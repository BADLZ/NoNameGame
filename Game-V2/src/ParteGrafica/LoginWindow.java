package ParteGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javafx.scene.input.KeyCode;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginWindow {

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private String username, passwordHash;
	private MainWindowManager parentClass;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//														//just because I have to
//					LoginWindow window = new LoginWindow(new MainWindowManager());
//					window.frame.setVisible(true);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public LoginWindow(MainWindowManager parentClass) {
		this.parentClass = parentClass;
		frame = new JFrame();
		initialize();
		MainWindowManager.centreWindow(frame);
		frame.setVisible(true);
	}
	
	public LoginWindow(MainWindowManager parentClass, JFrame frame) {
		this.parentClass = parentClass;
		this.frame = frame;
		initialize();
		MainWindowManager.centreWindow(frame);
		this.frame.setVisible(true);
	}
	
	/**
	 * Create the application.
	 */
	/**
	public LoginWindow() {
		initialize();
		MainWindowManager.centreWindow(frame);
		frame.setVisible(true);
	}
	*/

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setToolTipText("Nome");
		usernameField.setBounds(215, 131, 263, 22);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
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
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
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
		btnLogin.setBounds(215, 254, 97, 25);
		frame.getContentPane().add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(363, 254, 97, 25);
		frame.getContentPane().add(btnRegister);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Password");
		passwordField.setBounds(215, 198, 263, 22);
		frame.getContentPane().add(passwordField);
	}
	
	private void tryLogin() {
		if(usernameField.getText() != null && passwordField.getPassword().length != 0) {
			username = usernameField.getText();
			//--------------------------------------------AVISO--------------------------------------------------
			//falta meter password em hash
			passwordHash = String.valueOf(passwordField.getPassword());
			System.out.println("nome: " + username + " password: " + passwordHash);
			
			//fechar janela
//			frame.dispose();
			frame.getContentPane().removeAll();
			frame.repaint();
			parentClass.login(username, passwordHash);
		}
	}
}
