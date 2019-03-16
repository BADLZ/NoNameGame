package Graphics;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CharacterSelection {

	private JFrame frame;
	private int persIndex;
	private String[] personagens = {"Cacador", "Feiticeiro", "Gladiador"};
	private JLabel nomePersonagem;
	
	public CharacterSelection(JFrame frame) {
		this.frame = frame;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {	
		JButton btnRight = new JButton("right");
		btnRight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					changeLabel(1);
			}
		});
		btnRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changeLabel(1);
			}
		});
		btnRight.setBounds(491, 174, 97, 25);
		frame.getContentPane().add(btnRight);
		
		JButton btnLeft = new JButton("left");
		btnLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changeLabel(-1);
			}
		});
		btnLeft.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					changeLabel(-1);
			}
		});
		btnLeft.setBounds(111, 174, 97, 25);
		frame.getContentPane().add(btnLeft);
		
		JButton btnSelect = new JButton("select");
		btnSelect.setBounds(309, 273, 97, 25);
		frame.getContentPane().add(btnSelect);
		
		nomePersonagem = new JLabel(personagens[persIndex]);
		nomePersonagem.setHorizontalAlignment(SwingConstants.CENTER);
		nomePersonagem.setFont(new Font("Tahoma", Font.BOLD, 16));
		nomePersonagem.setBounds(278, 169, 156, 30);
		frame.getContentPane().add(nomePersonagem);
	}
	
	private void changeLabel(int num) {
		if(persIndex + num < 0) {
			persIndex += num;
			while(persIndex < 0)
				persIndex += 3;
		}else {
			persIndex = (persIndex + num) % personagens.length;
		}
		nomePersonagem.setText(personagens[persIndex]);
	}
}
