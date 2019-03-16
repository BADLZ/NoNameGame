package testesDani;

import javax.swing.JFrame;
import javax.swing.JWindow;

import Graphics.MainWindowManager;
import Personagens.Cacador;
import Personagens.Feiticeiro;
import Personagens.Gladiador;
import Personagens.Personagens;

public class Main {

	public static void main(String[] args) {
		
//		testePersonagens();
//		testeLogin();
//		testeDatabaseReader();
		testeDatabaseWriter();
		
	}
	
	private static void testeDatabaseWriter() {
//		DatabaseWriter.CreateNewPlayer("Teste1", "Gladiador");
	}
	
	private static void testeDatabaseReader(){
		Personagens p = DatabaseReader.getPersonagem("BAD AXE");
		if(p instanceof Gladiador)
			System.out.println(p);
		else
			System.out.println("o personagem nao e um gladiador");
	}
	
	private static void testeLogin() {
		MainWindowManager m = new MainWindowManager();
		
	}
	
	private static void testePersonagens() {
		Cacador c = new Cacador("nome");
		if(c instanceof Personagens) {
			Personagens p = (Personagens) c;
			System.out.println(p);
		}
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
