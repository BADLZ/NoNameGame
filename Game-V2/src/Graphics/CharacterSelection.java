package Graphics;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CharacterSelection {

	private JFrame frame;
	private int persIndex;
	private String[] personagens = { "Cacador", "Feiticeiro", "Gladiador" };
	private JLabel nomePersonagem;
	private ImageIcon leftarrowimg, rightarrowimg, leftarrowpressedimg, rightarrowpressedimg, selectimg,
			selectpressedimg;

	private Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	private final int screenWidth = size.width;
	private final int screenHeight = size.height;

	public CharacterSelection(JFrame frame) {
		this.frame = frame;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		try {
			leftarrowimg = new ImageIcon(ImageIO.read(new File("src/resources/characterSelection/leftarrow.png")));
			rightarrowimg = new ImageIcon(ImageIO.read(new File("src/resources/characterSelection/rightarrow.png")));
			leftarrowpressedimg = new ImageIcon(
					ImageIO.read(new File("src/resources/characterSelection/leftarrowpressed.png")));
			rightarrowpressedimg = new ImageIcon(
					ImageIO.read(new File("src/resources/characterSelection/rightarrowpressed.png")));
			selectimg = new ImageIcon(ImageIO.read(new File("src/resources/characterSelection/select.png")));
			selectpressedimg = new ImageIcon(
					ImageIO.read(new File("src/resources/characterSelection/selectpressed.png")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		FancyButton btnRight = new FancyButton("btnRight", screenWidth / 2 + 133, screenHeight / 2 - 50, 35, 28,
				rightarrowimg, rightarrowpressedimg);
		btnRight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					changeLabel(1);
			}
		});
		btnRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changeLabel(1);
			}
		});
		frame.getContentPane().add(btnRight);

		FancyButton btnLeft = new FancyButton("btnLeft", screenWidth / 2 - 167, screenHeight / 2 - 50, 35, 28,
				leftarrowimg, leftarrowpressedimg);
		btnLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				changeLabel(-1);
			}
		});
		btnLeft.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT)
					changeLabel(-1);
			}
		});
		frame.getContentPane().add(btnLeft);

		FancyButton btnSelect = new FancyButton("select", screenWidth / 2 - 110, screenHeight / 2 + 130, 220, 67,
				selectimg, selectpressedimg);
		frame.getContentPane().add(btnSelect);

		nomePersonagem = new JLabel(personagens[persIndex]);
		nomePersonagem.setHorizontalAlignment(SwingConstants.CENTER);
		nomePersonagem.setFont(new Font("Tahoma", Font.BOLD, 16));
		nomePersonagem.setBounds(278, 169, 156, 30);
		frame.getContentPane().add(nomePersonagem);
	}

	private void changeLabel(int num) {
		if (persIndex + num < 0) {
			persIndex += num;
			while (persIndex < 0)
				persIndex += 3;
		} else {
			persIndex = (persIndex + num) % personagens.length;
		}
		nomePersonagem.setText(personagens[persIndex]);
	}
}
