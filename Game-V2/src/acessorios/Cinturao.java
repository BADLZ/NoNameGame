package acessorios;

import java.util.Scanner;

import Personagens.Cacador;
import Personagens.Feiticeiro;
import Personagens.Gladiador;
import Personagens.Personagens;

public class Cinturao extends Acessorios {

	@Override
	public void choseWeapon(Personagens p) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1 - Cinturao 1\nStatus:");
		System.out.println("Basico: 10\nConstituicao: 30\nMira: 10\n");
		System.out.println("2 - Cinturao 2\nStatus:");
		System.out.println("Basico: 25\nConstituicao: 10\nMira: 15\n");
		System.out.println("3 - Cinturao 3\nStatus:");
		System.out.println("Basico: 15\nConstituicao: 15\nMira: 20\n");
		System.out.println("Opção (1|2|3) --> ");
		int opcao = sc.nextInt();
		while (opcao!=1 && opcao!=2 && opcao!=3) {
			System.out.println("Opcao invalida");
			opcao = sc.nextInt();
		}
		
		switch (opcao) {
		case 1:
			setNomeArma("Cinturao1");
			setNivelArma(1);
			
			p.setConstituicao(p.getConstituicao()+30);
			p.setMira(p.getMira()+10);
			
			if (p instanceof Gladiador) {
				p.setForca(p.getForca()+10);
			}
			else if (p instanceof Feiticeiro) {
				p.setInteligencia(p.getInteligencia()+10);			
			}
			else if (p instanceof Cacador) {
				p.setDestreza(p.getDestreza()+10);	
			}
			break;
			
		case 2:
			setNomeArma("Cinturao2");
			setNivelArma(1);
			
			p.setConstituicao(p.getConstituicao()+10);
			p.setMira(p.getMira()+15);
			
			if (p instanceof Gladiador) {
				p.setForca(p.getForca()+25);	
			}
			else if (p instanceof Feiticeiro) {
				p.setInteligencia(p.getInteligencia()+25);
			}
			else if (p instanceof Cacador) {
				p.setDestreza(p.getDestreza()+25);
			}

			break;
			
		case 3:
			setNomeArma("Cinturao3");
			setNivelArma(1);
			
			p.setConstituicao(p.getConstituicao()+15);
			p.setMira(p.getMira()+20);
			
			if (p instanceof Gladiador) {
				p.setForca(p.getForca()+15);
			}
			else if (p instanceof Feiticeiro) {
				p.setInteligencia(p.getInteligencia()+15);
			}
			else if (p instanceof Cacador) {
				p.setDestreza(p.getDestreza()+15);
			}
			break;
			
		}
		
	}


	@Override
	public void evolutionCost(Personagens p, int lvlArma) {
		if (lvlArma == 1) {
			setCustoGold(500);
			setCustoTreinoArmas(7);
		}
		else {
			for (int i = 0; i < lvlArma; i++) {
				setCustoTreinoArmas(getCustoTreinoArmas()+4);
				setCustoGold((long) (getCustoGold()+getCustoGold()*0.45));
			}
		}
		
		if ( (p.getCurrentGold() < getCustoGold()) 
				|| (p.getTreinoArmas() < getCustoTreinoArmas()) ) {
			System.out.println("Não tem recursos suficientes");
		}
		else {
			p.setCurrentGold((long) (p.getCurrentGold()-getCustoGold()));
			p.setTreinoArmas(p.getTreinoArmas()-getCustoTreinoArmas());
		}
	}

	
	@Override
	public void itemStats(Personagens p, String weapon, int lvlArma) {
		
		//porque quando se adquire a lvl1 já são introduzidos stats
		if (lvlArma > 1) { 
			
			switch (weapon) {
			
			case "Cinturao1":
				
				for (int i = 0; i < lvlArma-1; i++) {
					p.setConstituicao((int) (p.getConstituicao()+(30+30*0.4)));
					p.setMira((int) (p.getMira()+(10+10*0.4)));
					
					if (p instanceof Gladiador) {
						p.setForca((int) (p.getForca()+(10+10*0.4)));
					}
					else if (p instanceof Feiticeiro) {
						p.setInteligencia((int) (p.getInteligencia()+(10+10*0.4)));
					}
					else if (p instanceof Cacador) {
						p.setDestreza((int) (p.getDestreza()+(10+10*0.4)));
					}
				}
				
				break;
			
			case "Cinturao2":
			
				for (int i = 0; i < lvlArma-1; i++) {
					p.setConstituicao((int) (p.getConstituicao()+(10+10*0.4)));
					p.setMira((int) (p.getMira()+(15+15*0.4)));
					
					if (p instanceof Gladiador) {
						p.setForca((int) (p.getForca()+(25+25*0.4)));
					}
					else if (p instanceof Feiticeiro) {
						p.setInteligencia((int) (p.getInteligencia()+(25+25*0.4)));
					}
					else if (p instanceof Cacador) {
						p.setDestreza((int) (p.getDestreza()+(25+25*0.4)));
					}
				}
				
				break;
				
			case "Cinturao3":

				for (int i = 0; i < lvlArma-1; i++) {
					p.setConstituicao((int) (p.getConstituicao()+(15+15*0.4)));
					p.setMira((int) (p.getMira()+(20+20*0.4)));
					
					if (p instanceof Gladiador) {
						p.setForca((int) (p.getForca()+(15+15*0.4)));
					}
					else if (p instanceof Feiticeiro) {
						p.setInteligencia((int) (p.getInteligencia()+(15+15*0.4)));
					}
					else if (p instanceof Cacador) {
						p.setDestreza((int) (p.getDestreza()+(15+15*0.4)));
					}
				}
				break;
			}
			
		}
		
	}

}
