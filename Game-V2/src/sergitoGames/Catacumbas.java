package sergitoGames;

import java.util.Random;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Personagens.Gladiador;
import Personagens.Personagens;
import Personagens.Npc;
import Personagens.Cacador;
import Personagens.Feiticeiro;

public class Catacumbas {
	//TODO faltam recompensas
	static Random rand;
	long rewXp;
	long rewGold;

	public boolean number1(Personagens p) {
		
		System.out.println("\nWelcome to the Undead Festival!\n");
	
		boolean battle;
		
		//BRUXINHA
		Npc bruxinha = new Npc("bruxinha");		
		battle = battleNPC(p, bruxinha);
		if (battle == false) {
			System.out.println("Falhou em derrotar o NPC Bruxinha\n");
			return false;
		}
		System.out.println("You defeated Bruxinha!\n");
		rewards1(p, bruxinha);

		
		//PEQUENO GUERREIRO
		Npc pequenoGuerreiro = new Npc("pequenoGuerreiro");
		battle = battleNPC(p, pequenoGuerreiro);
		if (battle == false) {
			System.out.println("Falhou em derrotar o NPC Pequeno Guerreiro\n");
			return false;
		}
		System.out.println("You defeated Pequeno Guerreiro\n");
		rewards1(p, pequenoGuerreiro);

		
		//ARQUEIRO MORTO
		Npc arqueiro = new Npc("arqueiroMorto");
		battle = battleNPC(p, arqueiro);
		if (battle == false) {
			System.out.println("Falhou em derrotar o NPC Arqueiro Morto\n");
			return false;
		}
		System.out.println("You defeated Arqueiro Morto\n");
		rewards1(p, arqueiro);
		

		//ROQUEIRO FANTASMA
		Npc roqueiro = new Npc("roqueiroFantasma");
		battle = battleNPC(p, roqueiro);
		if (battle == false) {
			System.out.println("Falhou em derrotar o NPC Roqueiro Fantasma\n");
			return false;
		}
		System.out.println("You defeated Roqueiro Fantasma\n");
		rewards1(p, roqueiro);
		
		Npc bailarina = new Npc("bailarinaMortifora");
		battle = battleNPC(p, bailarina);
		if (battle == false) {
			System.out.println("Falhou em derrotar o NPC Bailarina Mortífora\n");
			return false;
		}
		System.out.println("You defeated Bailatina Mortífora\n");
		rewards1(p, bailarina);
		
		System.out.println("Congratulations on completing the first floor!\n");
		return true;
	}
	
	public boolean number2(Personagens p) {
		System.out.println("\nPequena Visita as Portas do Inferno\n");
		
		boolean battle;
		
		Npc pecador = new Npc("PecadorEmEspera");		
		battle = battleNPC(p, pecador);
		if (battle == false) {
			System.out.println("Falhou em derrotar o NPC Pecador em Espera\n");
			return false;
		}
		System.out.println("You defeated Pecador em Espera\n");
		rewards2(p, pecador);
		
		Npc chefe = new Npc("chefeDaFila");
		battle = battleNPC(p, chefe);
		if (battle == false) {
			System.out.println("Falhou em derrotar o NPC Chefe da Fila\n");
			return false;
		}
		System.out.println("You defeated Chefe da Fila\n");
		rewards2(p, chefe);
		
		Npc cucumba = new Npc("mestreCucumba");
		battle = battleNPC(p, cucumba);
		if (battle == false) {
			System.out.println("Falhou em derrotar o NPC Mestre Cucumba\n");
			return false;
		}
		System.out.println("You defeated Mestre Cucumba\n");
		rewards2(p, cucumba);

		Npc guardiao = new Npc("guardiaoDoPortao");
		battle = battleNPC(p, guardiao);
		if (battle == false) {
			System.out.println("Falhou em derrotar o NPC Guardião do Portão\n");
			return false;
		}
		System.out.println("You defeated Guardião do Portão\n");
		rewards2(p, guardiao);
		
		Npc portao = new Npc("portaoDemoniaco");
		battle = battleNPC(p, portao);
		if (battle == false) {
			System.out.println("Falhou em derrotar o NPC Guardião do Portão\n");
			return false;
		}
		System.out.println("You defeated Guardião do Portão\n");
		rewards2(p, portao);
		
		System.out.println("Congratulations on completing the second floor!\n");
		return true;
	}
	
	//TODO aleatorio entre -20 e 20
	public boolean battleNPC(Personagens p, Npc npc) {
		//TODO por enquanto não tem ARMA
		npc.statusNpc(npc.getName()); //status NPC
		p.powerPerLvl(p.getNivel()); //status PLAYER
		
		//DANO
		double danoP;
		double danoNPC;
		
		if (p instanceof Gladiador) {
			danoP = p.getForca();
		}
		else if (p instanceof Feiticeiro) {
			danoP = p.getInteligencia();
		}
		else if (p instanceof Cacador) {
			danoP = p.getDestreza();
		}
		else  {
			System.out.println("Player not found - DAMAGE = 0");
			danoP = 0;
		}
		
		//danoNPC
		if (npc.getAttBase().equalsIgnoreCase("inteligencia")) {
			System.out.println("ATTBASE - INTELIGENCIA");
			danoNPC = npc.getInteligencia();
		}
		else if (npc.getAttBase().equalsIgnoreCase("forca")) {
			System.out.println("ATTBASE - FORCA");
			danoNPC = npc.getForca();
		}
		else if (npc.getAttBase().equalsIgnoreCase("destreza")) {
			System.out.println("ATTBASE - DESTREZA");
			danoNPC = npc.getDestreza();
		}
		else {
			System.out.println("FALHA AO ENCONTRAR ATRIBUTO BASE");
			danoNPC = 0;
		}

		
		//VIDA
		double vidaNPC = npc.getConstituicao()*50;
		double vidaP = p.getConstituicao()*50;		
		
		while(true) {			
			System.out.println("Vida actual Player: "+vidaP);
			System.out.println("Vida actual NPC: "+vidaNPC+"\n");
	
			//valores random
			danoP = danoP + danoP*random20()/100;			
			danoNPC = danoNPC + danoP*random20()/100;
		
			
			//arredondar a 2 casas decimais
			danoP = Math.round(danoP * 100.0) / 100.0;
			danoNPC = Math.round(danoNPC * 100.0) / 100.0;
			
			
			if (p instanceof Gladiador) {
				System.out.println(((Gladiador) p).getName()+" ataca com "+danoP+" de dano");
			}
			else if (p instanceof Feiticeiro) {
				System.out.println(((Feiticeiro) p).getName()+" ataca com "+danoP+" de dano");
			}
			else {
				System.out.println(((Cacador) p).getName()+" ataca com "+danoP+" de dano");
			}
			vidaNPC = vidaNPC - danoP;
			vidaNPC = Math.round(vidaNPC * 100.0) / 100.0;

			System.out.println(npc.getName()+" ataca com "+danoNPC+" de dano");
			vidaP = vidaP - danoNPC;
			vidaP = Math.round(vidaP * 100.0) / 100.0;
			
			if (vidaNPC <= 0) {
				System.out.print("\nCongratularions, you win!\n");
				return true;
			}
			else if (vidaP <= 0) {
				System.out.print("\nYou lose, better luck next time\n");
				return false;
			}
		}
		
	}

	
	public double randomCrit() {
		rand = new Random();
		double random = rand.nextInt(100);
		return random/100;
	}
	
	//Recompensa Catacumba 1
	public void rewards1(Personagens p, Npc n) {			
		System.out.println("\nYour Rewards:");
		//rewXp = (n.getNivel()+(n.getNivel()/2))*22188*1;
		rewXp = 1500*(n.getNivel()-10)*1;
		rewGold = 100*n.getNivel()/2*1;
		System.out.println("XP GAINED: "+rewXp);
		System.out.println("GOLD GAINED: "+rewGold);
		Personagens.updateXp(p, rewXp);
		p.setCurrentGold(p.getCurrentGold()+rewGold);
		System.out.println();
	}
	
	//Recompensas Catacumba 2
	public void rewards2(Personagens p, Npc n) {			
		System.out.println("\nYour Rewards:");
		rewXp = (n.getNivel()+(n.getNivel()/2))*22188*2;
		rewGold = 100*n.getNivel()/2*2;
		System.out.println("XP GAINED: "+rewXp);
		System.out.println("GOLD GAINED: "+rewGold);
		Personagens.updateXp(p, rewXp);
		p.setCurrentGold(p.getCurrentGold()+rewGold);	
		System.out.println();
	}
	
	public int random20() {		
		int r = (int) (Math.random() * (20 - -20)) + -20;
		System.out.println("random: "+r);
		return r;
	}

	
}
