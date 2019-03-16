package testesDani;

import javax.swing.JFrame;
import javax.swing.JWindow;

import Graphics.MainWindowManager;
import Personagens.Cacador;
import Personagens.Feiticeiro;
import Personagens.Gladiador;

public class Main {

	public static void main(String[] args) {
		
		testeLogin();
		
	}
	
	private static void testeLogin() {
		MainWindowManager m = new MainWindowManager();
		
	}
	
	private static void testeToString() {
		
		Cacador c = new Cacador(null);
		Feiticeiro f = new Feiticeiro(null);
		Gladiador g = new Gladiador("Nome qualquer");
		System.out.println(c);
		c.powerPerLvl(4);
		System.out.println(c);
		//System.out.println(f);
		//System.out.println(g);
		
	}

	private static void testeDiferenca() {
		JFrame fr = new JFrame("The Frame");
	    fr.setSize(300, 300);
	    fr.setLocation(100, 100);

	    JWindow w = new JWindow();
	    w.setSize(300, 300);
	    w.setLocation(500, 100);

	    fr.setVisible(true);
	    w.setVisible(true);
	}
	
}
