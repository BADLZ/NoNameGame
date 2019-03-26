package testesDani;

import javax.swing.JFrame;
import javax.swing.JWindow;

import Personagens.Cacador;
import Personagens.Feiticeiro;
import Personagens.Gladiador;
import Personagens.Personagens;
import accessory.Accessory;
import accessory.Arma;
import database.DatabaseReader;
import database.DatabaseWriter;
import legacyCode.MainWindowManager;
import Graphics.SceneManager;

public class Main {

	public static void main(String[] args) {
		
//		SceneManager sm = new SceneManager();
		
//		testePersonagens();
//		testeLogin();
//		testeDatabaseReader();
//		testeDatabaseWriter();
//		testeDatabaseWriter2();
//		testeRegistaConta();
//		testarLogin();
//		System.out.println(	DatabaseReader.getNumberAccounts());
//		DatabaseWriter.createNewPlayer("BAD AXE", "Feiticeiro", 0);
//		Personagens p = DatabaseReader.getPersonagem(0);
//		DatabaseWriter.storePlayer(p);
//		System.out.println(p);
//		DatabaseWriter.storePlayer(p);
//		testeAccessoryArma();
		System.out.println(DatabaseReader.login("Teste123", "12345678".toCharArray()));
//		equivalencia();
	}
	
	private static void testeAccessoryArma() {
		Cacador c = new Cacador("Grande Testador", 0);
//		c.powerPerLvl(1);
		System.out.println(c + "\n----------------\n----------------\n");
		Arma arma = new Arma("Arma1");
		System.out.println(arma + "\n----------------\n----------------\n");
//		c.equipItem(arma);
//		c.equipItem(arma);
//		c.equipItem(arma);
//		c.equipItem(arma);
//		c.equipItem(arma);
//		c.equipItem(arma);
		System.out.println(c + "\n----------------\n----------------\n");
		arma.setLvl(3);
		System.out.println(c);
		
	}
	
	private static void equivalencia() {
		Cacador c = new Cacador("Grande Testador", 0);
		Gladiador g = new Gladiador("Grande Gladiador", 0);
		Cacador c2 = new Cacador("Grande Cacador", 0);
		Personagens p1 = (Personagens) c;
		Personagens p2 = (Personagens) g;
		Personagens p3 = (Personagens) c2;
		
		System.out.println(p1.getClass().equals(p3.getClass()));
		
		Teste2Extends x = new Teste2Extends("oi");
		Teste3Extends y = new Teste3Extends("aa");
		
		Accessory a1 = (Accessory) x;
		Accessory a2 = (Accessory) y;
		
		System.out.println(a1.getClass().equals(a2.getClass()));
		System.out.println(a1.getClass().getClass().equals(a2.getClass().getClass()));

		
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
		p.lvlUp();
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
		Cacador c = new Cacador("nome", 0);
		if(c instanceof Personagens) {
			Personagens p = (Personagens) c;
			System.out.println(p);
		}
	}
	
	private static void testeToString() {
		
		Cacador c = new Cacador(null, 0);
		Feiticeiro f = new Feiticeiro(null, 0);
		Gladiador g = new Gladiador("Nome qualquer", 0);
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
