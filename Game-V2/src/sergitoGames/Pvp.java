package sergitoGames;

import Personagens.Cacador;
import Personagens.Feiticeiro;
import Personagens.Gladiador;
import Personagens.Personagens;

public class Pvp {
	
	//Neste caso, player A dá a ordem
	public void battlePVP(Personagens a, Personagens b) {
		
		a.powerPerLvl(a.getNivel());
		b.powerPerLvl(b.getNivel());				
			
		//DANO
		double danoA;
		double danoB;
		
		if (a instanceof Gladiador) {
			danoA = a.getForca();
		}
		else if (a instanceof Feiticeiro) {
			danoA = a.getInteligencia();
		}
		else if (a instanceof Cacador) {
			danoA = a.getDestreza();
		}
		else  {
			System.out.println("Player not found - DAMAGE = 0");
			danoA = 0;
		}
		
		if (b instanceof Gladiador) {
			danoB = b.getForca();
		}
		else if (b instanceof Feiticeiro) {
			danoB = b.getInteligencia();
		}
		else if (b instanceof Cacador) {
			danoB = b.getDestreza();
		}
		else  {
			System.out.println("Player not found - DAMAGE = 0");
			danoB = 0;
		}
		
		//VIDA
		double vidaA = a.getConstituicao()*50;
		double vidaB = b.getConstituicao()*50;	
		
		boolean fight = true;
		
		while(fight) {			
			System.out.println("Vida actual de "+a.getName() + ": "+vidaA);
			System.out.println("Vida actual de "+b.getName() + ": "+vidaB);
	
			//valores random
			danoA = danoA + danoA*random10()/100;			
			danoB = danoB + danoB*random10()/100;
		
			
			//arredondar a 2 casas decimais
			danoA = Math.round(danoA * 100.0) / 100.0;
			danoB = Math.round(danoB * 100.0) / 100.0;
			
			if (a instanceof Gladiador) {
				System.out.println(((Gladiador) a).getName()+" ataca com "+danoA+" de dano");
			}
			else if (a instanceof Feiticeiro) {
				System.out.println(((Feiticeiro) a).getName()+" ataca com "+danoA+" de dano");
			}
			else {
				System.out.println(((Cacador) a).getName()+" ataca com "+danoA+" de dano");
			}
					
			if (b instanceof Gladiador) {
				System.out.println(((Gladiador) b).getName()+" ataca com "+danoB+" de dano");
			}
			else if (b instanceof Feiticeiro) {
				System.out.println(((Feiticeiro) b).getName()+" ataca com "+danoB+" de dano");
			}
			else {
				System.out.println(((Cacador) b).getName()+" ataca com "+danoB+" de dano");
			}
			
			//começa player A
			if (a.getAudacia() >= b.getAudacia()) {
				System.out.println("Player A attacks first");
				
				vidaB = vidaB - danoA;
				vidaB = Math.round(vidaB * 100.0) / 100.0;
				
				vidaA = vidaA - danoB;
				vidaA = Math.round(vidaA * 100.0) / 100.0;								
			}
			
			//começa player B
			else {
				System.out.println("Player B attacks first");
				
				vidaA = vidaA - danoB;
				vidaA = Math.round(vidaA * 100.0) / 100.0;
				
				vidaB = vidaB - danoA;
				vidaB = Math.round(vidaB * 100.0) / 100.0;
			}
			
			if (vidaA <= 0) {
				System.out.println("\nPlayer "+b.getName()+" wins!\n");
				fight = false;
			}
			else if (vidaB <= 0) {
				System.out.println("\nPlayer "+a.getName()+" wins!\n");
				fight = false;
			}	
		}
		
	}
	
	public int random10() {		
		int r = (int) (Math.random() * (10 - -10)) + -10;
		System.out.println("random: "+r);
		return r;
	}

}
