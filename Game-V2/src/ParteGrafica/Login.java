package ParteGrafica;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login{
	
	private JFrame frame;
	private int width, heigth;
	
	public Login(JFrame frame) {
		width = 900;
		heigth = 700;
		
		this.frame = frame;
		frame.setSize(width, heigth);
		centreWindow(frame);
		Container pane = frame.getContentPane();
		pane.setLayout(null);
		
		//bounds - x, y , largura, altura
		
		JLabel nameLabel = new JLabel();
		nameLabel.setText("Nome:");
		nameLabel.setBounds((width-200)/2 + 60, heigth - 185, 200, 30);
		Font font = new Font(nameLabel.getFont().getName(), nameLabel.getFont().getStyle(), 20);
		nameLabel.setFont(font);
		pane.add(nameLabel);
		
		
		JTextField usernameField = new JTextField();
		usernameField.setBounds((width-200)/2, heigth - 150, 200, 30);
		font = new Font(usernameField.getFont().getName(), usernameField.getFont().getStyle(), 20);
		usernameField.setFont(font);
		pane.add(usernameField);
		
		JButton startBtn = new JButton();
		startBtn.setText("start");
		
		chooseCharacter();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void chooseCharacter() {
		String[] characters = {"Cacador", "Feiticeiro", "Gladiador"};
		//---------------------
		
		
	}
	
	private void centreWindow(JFrame frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	}

}
