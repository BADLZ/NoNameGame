package acessorios;

import java.util.Scanner;

import Personagens.Cacador;
import Personagens.Feiticeiro;
import Personagens.Gladiador;
import Personagens.Personagens;

public class Armadura extends Acessorios {

	@Override
	public void choseWeapon(Personagens p) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1 - Armadura 1\nStatus:");
		System.out.println("Basico: 60\nConstituicao: 30\nMira: 60\n");
		System.out.println("2 - Armadura 2\nStatus:");
		System.out.println("Basico: 25\nConstituicao: 100\nMira: 25\n");
		System.out.println("3 - Armadura 3\nStatus:");
		System.out.println("Basico: 50\nConstituicao: 50\nMira: 50\n");
		System.out.println("Opção (1|2|3) --> ");
		int opcao = sc.nextInt();
		while (opcao!=1 && opcao!=2 && opcao!=3) {
			System.out.println("Opcao invalida");
			opcao = sc.nextInt();
		}
		
		switch (opcao) {
		case 1:
			setNomeArma("Armadura1");
			setNivelArma(1);
			
			p.setConstituicao(p.getConstituicao()+30);
			p.setMira(p.getMira()+60);
			
			if (p instanceof Gladiador) {
				p.setForca(p.getForca()+60);
			}
			else if (p instanceof Feiticeiro) {
				p.setInteligencia(p.getInteligencia()+60);			
			}
			else if (p instanceof Cacador) {
				p.setDestreza(p.getDestreza()+60);	
			}
			break;
			
		case 2:
			setNomeArma("Armadura2");
			setNivelArma(1);
			
			p.setConstituicao(p.getConstituicao()+100);
			p.setMira(p.getMira()+25);
			
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
			setNomeArma("Armadura3");
			setNivelArma(1);
			
			p.setConstituicao(p.getConstituicao()+50);
			p.setMira(p.getMira()+50);
			
			if (p instanceof Gladiador) {
				p.setForca(p.getForca()+50);
			}
			else if (p instanceof Feiticeiro) {
				p.setInteligencia(p.getInteligencia()+50);
			}
			else if (p instanceof Cacador) {
				p.setDestreza(p.getDestreza()+50);
			}
			break;
			
		}
		
	}


	@Override
	public void evolutionCost(Personagens p, int lvlArma) {
		if (lvlArma == 1) {
			setCustoGold(700);
			setCustoTreinoArmas(10);
		}
		else {
			for (int i = 0; i < lvlArma; i++) {
				setCustoTreinoArmas(getCustoTreinoArmas()+5);
				setCustoGold((long) (getCustoGold()+getCustoGold()*0.6));
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
			
			case "Armadura1":
				
				for (int i = 0; i < lvlArma-1; i++) {
					p.setConstituicao((int) (p.getConstituicao()+(30+30*0.5)));
					p.setMira((int) (p.getMira()+(60+60*0.5)));
					
					if (p instanceof Gladiador) {
						p.setForca((int) (p.getForca()+(60+60*0.5)));
					}
					else if (p instanceof Feiticeiro) {
						p.setInteligencia((int) (p.getInteligencia()+(60+60*0.5)));
					}
					else if (p instanceof Cacador) {
						p.setDestreza((int) (p.getDestreza()+(60+60*0.5)));
					}
				}
				break;
			
			case "Armadura2":
				
				for (int i = 0; i < lvlArma-1; i++) {
					p.setConstituicao((int) (p.getConstituicao()+(100+100*0.5)));
					p.setMira((int) (p.getMira()+(25+25*0.5)));
					
					if (p instanceof Gladiador) {
						p.setForca((int) (p.getForca()+(25+25*0.5)));
					}
					else if (p instanceof Feiticeiro) {
						p.setInteligencia((int) (p.getInteligencia()+(25+25*0.5)));
					}
					else if (p instanceof Cacador) {
						p.setDestreza((int) (p.getDestreza()+(25+25*0.5)));
					}
				}
				
				break;
				
			case "Armadura3":
				
				for (int i = 0; i < lvlArma-1; i++) {
					p.setConstituicao((int) (p.getConstituicao()+(50+50*0.5)));
					p.setMira((int) (p.getMira()+(50+50*0.5)));
					
					if (p instanceof Gladiador) {
						p.setForca((int) (p.getForca()+(50+50*0.5)));
					}
					else if (p instanceof Feiticeiro) {
						p.setInteligencia((int) (p.getInteligencia()+(50+50*0.5)));
					}
					else if (p instanceof Cacador) {
						p.setDestreza((int) (p.getDestreza()+(50+50*0.5)));
					}
				}
				break;
			}
			
		}
		
	}

}
