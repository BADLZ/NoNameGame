package sergitoGames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class CreateCharacter {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateCharacter window = new CreateCharacter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public CreateCharacter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea username = new JTextArea();
		username.setBounds(177, 76, 224, 22);
		frame.getContentPane().add(username);
		//System.out.println(username.getText());
		
		JTextPane yourUsername = new JTextPane();
		yourUsername.setText("Your Username");
		yourUsername.setBounds(50, 76, 92, 20);
		frame.getContentPane().add(yourUsername);
		
		JTextArea categoria = new JTextArea();
		categoria.setBounds(177, 131, 224, 22);
		frame.getContentPane().add(categoria);
		//System.out.println(categoria.getText());
		
		JTextPane yourCategoria = new JTextPane();
		yourCategoria.setText("Your Categoria");
		yourCategoria.setBounds(50, 131, 92, 20);
		frame.getContentPane().add(yourCategoria);
		
		JButton startButton = new JButton("Start");
		startButton.setBounds(249, 202, 89, 23);
		frame.getContentPane().add(startButton);
		
		//Main m = new Main();
		//m.CreateNewPlayer("Pedro dias", "Hunter");
		//m.CreateNewPlayer(username, categoria);
		//m.CreateNewPlayer(username.getText(), categoria.getText());
	}
}
