package Graphics;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CharacterSelection extends JLabel{
	private SceneManager sm;
	private int persIndex;

	private JLabel personagem, nomePersonagem, background;
	private ImageIcon leftarrowimg, rightarrowimg, leftarrowpressedimg, rightarrowpressedimg, selectimg,
			selectpressedimg, labelcacadorimg, labelfeiticeitoimg, labelgladiadorimg;

	private ImageIcon cacadorimg, feiticeiroimg, gladiadorimg;
	private ImageIcon[] personagens;
	private ImageIcon[] personagensnome;
	private Dimension size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	private final int screenWidth = size.width;
	private final int screenHeight = size.height;

	public CharacterSelection(SceneManager sm) {
		this.sm = sm;
		initialize();
	}

	private void initialize() {
		initializeImage();
		
		setIcon(background);
		FancyButton btnRight = new FancyButton("btnRight", screenWidth / 2 + 233, screenHeight / 2 - 50, 35, 28,
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

		FancyButton btnLeft = new FancyButton("btnLeft", screenWidth / 2 - 267, screenHeight / 2 - 50, 35, 28,
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

		FancyButton btnSelect = new FancyButton("select", screenWidth / 2 - 110, screenHeight / 2 + 300, 220, 67,
				selectimg, selectpressedimg);
		frame.getContentPane().add(btnSelect);

		personagem = new JLabel(personagens[persIndex]);
		personagem.setBounds(screenWidth / 2 - 290, screenHeight / 2 - 300, 480, 600);
		frame.add(personagem);
		
		
		nomePersonagem = new JLabel(personagensnome[persIndex]);
		nomePersonagem.setBounds(screenWidth / 2 - 125, 5, 250, 80);
		frame.add(nomePersonagem);
		
	}

	private void changeLabel(int num) {
		if (persIndex + num < 0) {
			persIndex += num;
			while (persIndex < 0)
				persIndex += 3;
		} else {
			persIndex = (persIndex + num) % personagens.length;
		}
		nomePersonagem.setIcon(personagensnome[persIndex]);
		personagem.setIcon(personagens[persIndex]);
		frame.repaint();
	}
	
	private void initializeImage() {
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
			cacadorimg = new ImageIcon(ImageIO.read(new File("src/resources/characterSelection/cacador.png")));
			feiticeiroimg = new ImageIcon(ImageIO.read(new File("src/resources/characterSelection/cacador.png")));
			gladiadorimg = new ImageIcon(ImageIO.read(new File("src/resources/characterSelection/cacador.png")));
			background = new JLabel(
					new ImageIcon(ImageIO.read(new File("src/resources/characterSelection/selectionbackground.jpg"))));
			labelcacadorimg = new ImageIcon(ImageIO.read(new File("src/resources/characterSelection/cacadorlabel.png")));
			labelfeiticeitoimg = new ImageIcon(ImageIO.read(new File("src/resources/characterSelection/feiticeirolabel.png")));
			labelgladiadorimg = new ImageIcon(ImageIO.read(new File("src/resources/characterSelection/gladiadorlabel.png")));
			personagensnome = new ImageIcon[]{ labelcacadorimg, labelfeiticeitoimg, labelgladiadorimg };
			personagens = new ImageIcon[]{ cacadorimg, feiticeiroimg, gladiadorimg };
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
