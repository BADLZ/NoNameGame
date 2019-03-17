package testesDani;

import javax.swing.JFrame;
import javax.swing.JWindow;

import Graphics.MainWindowManager;
import Graphics.SceneManager;
import Personagens.Cacador;
import Personagens.Feiticeiro;
import Personagens.Gladiador;
import Personagens.Personagens;
import database.DatabaseReader;
import database.DatabaseWriter;

public class Main {

	public static void main(String[] args) {
		
		SceneManager sm = new SceneManager();
		
//		testePersonagens();
//		testeLogin();
//		testeDatabaseReader();
//		testeDatabaseWriter();
//		testeDatabaseWriter2();
//		testeRegistaConta();
//		testarLogin();
		
	}
	
	private static void testarLogin() {
		System.out.println(DatabaseReader.login("Teste2", "123".toCharArray()));
	}
	
	private static void testeDatabaseWriter() {
//		DatabaseWriter.CreateNewPlayer("Teste1", "Gladiador");
	}
	
	private static void testeRegistaConta() {
		String nome = "Teste2";
		char[] password = "123".toCharArray();
		String email = "123@gmail.com";
//		System.out.println(DatabaseWriter.existsAccount(nome));
		DatabaseWriter.createAccout(nome, password, email);
	}
	
	private static void testeDatabaseWriter2() {
		Personagens p = DatabaseReader.getPersonagem("Teste1");
		System.out.println(p);
		p.lvlUp(p);
		p.setCurrentGold(20);
		System.out.println(p);
		DatabaseWriter.storePlayer(p);
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
