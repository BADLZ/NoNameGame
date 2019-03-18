package Graphics.scenes;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Graphics.SceneManager;
import Graphics.aesthetics.FancyButton;

public class CharacterSelection extends JLabel{
	private SceneManager sm;
	private int persIndex;

	private JLabel personagem, nomePersonagem;
	private ImageIcon background, leftarrowimg, rightarrowimg, leftarrowpressedimg, rightarrowpressedimg, selectimg,
			selectpressedimg, labelcacadorimg, labelfeiticeitoimg, labelgladiadorimg;

	private String[] categorias = {"Cacador", "Feiticeiro", "Gladiador"};
	private ImageIcon cacadorimg, feiticeiroimg, gladiadorimg;
	private ImageIcon[] personagens;
	private ImageIcon[] personagensnome;


	public CharacterSelection(SceneManager sm) {
		this.sm = sm;
		initialize();
		
	}

	private void initialize() {
		initializeImage();
		
		setIcon(background); 
		FancyButton btnRight = new FancyButton("btnRight", sm.screenWidth / 2 + 233, sm.screenHeight / 2 - 50, 35, 28,
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
		add(btnRight);

		FancyButton btnLeft = new FancyButton("btnLeft", sm.screenWidth / 2 - 267, sm.screenHeight / 2 - 50, 35, 28,
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
		add(btnLeft);

		FancyButton btnSelect = new FancyButton("select", sm.screenWidth / 2 - 110, sm.screenHeight / 2 + 300, 220, 67,
				selectimg, selectpressedimg);
		btnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(sm.createPersonagem(categorias[persIndex]))
					sm.changeCards("PubScreen");
			}
		});
		add(btnSelect);
		

		personagem = new JLabel(personagens[persIndex]);
		personagem.setBounds(sm.screenWidth / 2 - 290, sm.screenHeight / 2 - 300, 480, 600);
		add(personagem);
		
		
		nomePersonagem = new JLabel(personagensnome[persIndex]);
		nomePersonagem.setBounds(sm.screenWidth / 2 - 125, 5, 250, 80);
		add(nomePersonagem);
		
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
		repaint();
	}
	
	private void initializeImage() {
		try {
			background = new ImageIcon(ImageIO.read(new File("src/resources/characterSelection/selectionbackground.png")).getScaledInstance(sm.screenWidth, sm.screenHeight, Image.SCALE_SMOOTH));
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
			feiticeiroimg = new ImageIcon(ImageIO.read(new File("src/resources/characterSelection/feiticeiro.png")));
			gladiadorimg = new ImageIcon(ImageIO.read(new File("src/resources/characterSelection/gladiador.png")));
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
