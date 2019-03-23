package legacyCode;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Graphics.scenes.LoginWindow;
import Graphics.scenes.MainScreen;
import Personagens.Cacador;
import Personagens.Feiticeiro;
import Personagens.Gladiador;

public class MainWindowManager extends JLabel{

	private JFrame frame;
	private LoginWindow loginWindow;
	private MainScreen mainScreen;
	private LogSign logsign;

	public MainWindowManager() {
		this.frame = new JFrame();
		frame.setTitle("Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
//		mainScreen = new MainScreen(this, frame);
		frame.setVisible(true);
		logsign = new LogSign();
	}

	public void openLoginWindow() {
		clearWindow();
	}

	// corre isto quando faz login
//	public void login(String username) {
//		String dados = logsign.login(username);
//		if (dados != null) {
//			createPlayer(dados.split(""));
//		} else {
//			clearWindow();
//		}
//	}

	private void createPlayer(String[] dados) {
		switch (dados[1]) {
		case "Cacador":
			Cacador c = new Cacador(dados[0], 0);
			c.powerPerLvl(Integer.parseInt(dados[2]));
			c.setCurrentXp(Long.parseLong(dados[3]));
			c.setCurrentGold(Long.parseLong(dados[4]));
			break;
		case "Feiticeiro":
			Feiticeiro f = new Feiticeiro(dados[0], 0);
			f.powerPerLvl(Integer.parseInt(dados[2]));
			f.setCurrentXp(Long.parseLong(dados[3]));
			f.setCurrentGold(Long.parseLong(dados[4]));
			break;
		case "Gladiador":
			Gladiador g = new Gladiador(dados[0], 0);
			g.powerPerLvl(Integer.parseInt(dados[2]));
			g.setCurrentXp(Long.parseLong(dados[3]));
			g.setCurrentGold(Long.parseLong(dados[4]));
			break;
		default:
			System.out.println("Error");
			break;
		}
	}

	private void clearWindow() {
		frame.getContentPane().removeAll();
		frame.repaint();
	}

}
