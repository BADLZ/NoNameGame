package sergitoGames;

import java.util.Random;

//import sergitoGames.Personagens;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Personagens.Gladiador;
import Personagens.Personagens;

public class Missoes {
	
	//private int lvl;

	static Random randMission;
		
	//contadores
	static int countReward = 0;
	
	//Missão 1
	static long gainXp;
	static long gainGold;
	
	//Missão 2
	static long gainXp2; 
	static long gainGold2;
	
	static int countMissions = 0;
	
	static int choice;

	
	public Missoes() {

	}
	
	
	public String randomMission() {
		
		String[] mission = {"Mission1", 
				"Mission2",
				"Mission3",
				"Mission4",
				"Mission5",
				"Mission6",
				"Mission7",
				"Mission8",
				"Mission9",
				"Mission10",
				"Mission11", 
				"Mission12",
				"Mission13",
				"Mission14",
				"Mission15",
				"Mission16",
				"Mission17",
				"Mission18",
				"Mission19",
				"Mission20"};
		
		/* podia ser assim tmb acho eu (n foi testado)
		String[] mission = new String[20];
		for(int i = 1; i <= 20; i++) {
			mission[i-1] = "Mission" + i;
		}
		*/
		
		randMission = new Random();
		
        int randomNumber = randMission.nextInt(mission.length);
		
		return mission[randomNumber];
	}
	
	public void firstMission(Personagens p) {
		System.out.println("Congratulations on your first mission!\n");
		//p.setCurrentXp(44);
		p.updateXp(44);
		p.setCurrentGold(50);
	}
	
	public void choseMission(Personagens p, int lvl) {
		
		Scanner sc = new Scanner(System.in);
		
		long xpPerLvl;
		
		xpPerLvl = (lvl*10)*(lvl-1);		
		
		long goldPerLvl = 20*lvl;
		
		int randXp = (int) (Math.random()*(85-70)) + 70;
		int randGold = 100 - randXp; 
		gainXp = randXp*xpPerLvl/100;		
		gainGold = randGold*goldPerLvl/100;
		
		//Missão 2		
		int randXp2 = (int) (Math.random()*(20-5)) + 5;
		int randGold2 = 100 - randXp2;
		
		gainXp2 = randXp2* xpPerLvl/100;
		gainGold2 = randGold2*goldPerLvl/100;
		
		//Menu
		
		System.out.println("Chose your Mission:");
		System.out.println("1 - " + randomMission());
		System.out.println("EXP - " + gainXp);
		System.out.println("Gold - " + gainGold);
		System.out.println();
		System.out.println("2 - " + randomMission());
		System.out.println("EXP - " + gainXp2);
		System.out.println("Gold - " + gainGold2);
		System.out.print("Option (1|2) ----> ");
		//opcao assim de certeza fica 1 ou 2
		//choice = 0 --> tem que ser pelo scanner senão dá erro
		choice = sc.nextInt();
		while(choice != 1 && choice != 2) {
			System.out.print("Option (1|2) ----> ");
			choice = sc.nextInt();
		}
		
		
		switch (choice) {

		case 1:
			//p.setCurrentXp(p.getCurrentXp()+gainXp);
			p.updateXp(gainXp); 
			moedasNegras(p);
			p.setCurrentGold(p.getCurrentGold()+gainGold);			
			break;
		
		case 2:
			//p.setCurrentXp(p.getCurrentXp()+gainXp2);
			p.updateXp(gainXp2);
			moedasNegras(p);
			p.setCurrentGold(p.getCurrentGold()+gainGold2);	
			break;	
		}
		System.out.println();
		
		//sc.close();
	}
	
	/*Se o Personagem tiver 4 fragmentos, forja para 1 moeda*/
	public boolean moedasNegras(Personagens p) {
		
		if (!p.getName().equalsIgnoreCase("Jamal")) {
			int probabilidade = (int) (Math.random()*100);
			
			if (probabilidade <= 3) { //probabilidade de 3%
				p.setFragmentos(p.getFragmentos()+1);
				System.out.println("You earned a Fragment!");
				
				while (p.getFragmentos()>=4) {
					System.out.println("You forged fragments into a Black Coin!");
					p.setMoedasNegras(p.getMoedasNegras()+1);
					p.setFragmentos(p.getFragmentos()-4); //fragmentos
				}
				
				return true;
			}	
		}
		return false; //não recebe nada
	}
	
	
}
