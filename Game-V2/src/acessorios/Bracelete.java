package acessorios;

import java.util.Scanner;

import Personagens.Cacador;
import Personagens.Feiticeiro;
import Personagens.Gladiador;
import Personagens.Personagens;

public class Bracelete extends Acessorios {

	@Override
	public void choseWeapon(Personagens p) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1 - Bracelete 1\nStatus:");
		System.out.println("Basico: 10\nConstituicao: 80\nMira: 10\n");
		System.out.println("2 - Bracelete 2\nStatus:");
		System.out.println("Basico: 60\nConstituicao: 15\nMira: 25\n");
		System.out.println("3 - Bracelete 3\nStatus:");
		System.out.println("Basico: 20\nConstituicao: 40\nMira: 20\n");
		System.out.println("Opção (1|2|3) --> ");
		int opcao = sc.nextInt();
		while (opcao!=1 && opcao!=2 && opcao!=3) {
			System.out.println("Opcao invalida");
			opcao = sc.nextInt();
		}
		
		switch (opcao) {
		case 1:
			setNomeArma("Bracelete1");
			setNivelArma(1);
			
			p.setConstituicao(p.getConstituicao()+80);
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
			setNomeArma("Bracelete2");
			setNivelArma(1);
			
			p.setConstituicao(p.getConstituicao()+15);
			p.setMira(p.getMira()+25);
			
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
			
		case 3:
			setNomeArma("Bracelete3");
			setNivelArma(1);
			
			p.setConstituicao(p.getConstituicao()+40);
			p.setMira(p.getMira()+20);
			
			if (p instanceof Gladiador) {
				p.setForca(p.getForca()+20);
			}
			else if (p instanceof Feiticeiro) {
				p.setInteligencia(p.getInteligencia()+20);
			}
			else if (p instanceof Cacador) {
				p.setDestreza(p.getDestreza()+20);
			}
			break;
			
		}
		
	}


	@Override
	public void evolutionCost(Personagens p, int lvlArma) {
		if (lvlArma == 1) {
			setCustoGold(400);
			setCustoTreinoArmas(6);
		}
		else {
			for (int i = 0; i < lvlArma; i++) {
				setCustoTreinoArmas(getCustoTreinoArmas()+3);
				setCustoGold((long) (getCustoGold()+getCustoGold()*0.4));
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
			
			case "Bracelete1":
				
				for (int i = 0; i < lvlArma-1; i++) {
					p.setConstituicao((int) (p.getConstituicao()+(80+80*0.3)));
					p.setMira((int) (p.getMira()+(10+10*0.3)));
					
					if (p instanceof Gladiador) {
						p.setForca((int) (p.getForca()+(10+10*0.3)));
					}
					else if (p instanceof Feiticeiro) {
						p.setInteligencia((int) (p.getInteligencia()+(10+10*0.3)));
					}
					else if (p instanceof Cacador) {
						p.setDestreza((int) (p.getDestreza()+(10+10*0.3)));
					}
				}
				
				break;
			
			case "Bracelete2":
				
				for (int i = 0; i < lvlArma-1; i++) {
					p.setConstituicao((int) (p.getConstituicao()+(15+15*0.3)));
					p.setMira((int) (p.getMira()+(25+25*0.3)));
					
					if (p instanceof Gladiador) {
						p.setForca((int) (p.getForca()+(60+60*0.3)));
					}
					else if (p instanceof Feiticeiro) {
						p.setInteligencia((int) (p.getInteligencia()+(60+60*0.3)));
					}
					else if (p instanceof Cacador) {
						p.setDestreza((int) (p.getDestreza()+(60+60*0.3)));
					}
				}
				
				break;
				
			case "Bracelete3":
				
				for (int i = 0; i < lvlArma-1; i++) {
					p.setConstituicao((int) (p.getConstituicao()+(40+40*0.3)));
					p.setMira((int) (p.getMira()+(20+20*0.3)));
					
					if (p instanceof Gladiador) {
						p.setForca((int) (p.getForca()+(40+40*0.3)));
					}
					else if (p instanceof Feiticeiro) {
						p.setInteligencia((int) (p.getInteligencia()+(40+40*0.3)));
					}
					else if (p instanceof Cacador) {
						p.setDestreza((int) (p.getDestreza()+(40+40*0.3)));
					}
				}
				break;
			}
			
		}
		
	}

}
