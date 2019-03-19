package acessorios;

import java.util.Scanner;

import Personagens.Cacador;
import Personagens.Feiticeiro;
import Personagens.Gladiador;
import Personagens.Personagens;

public class Botas extends Acessorios {
	
	@Override
	public void choseWeapon(Personagens p) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1 - Botas 1\nStatus:");
		System.out.println("Basico: 15\nConstituição: 40\nMira: 15\n");
		System.out.println("2 - Botas 2\nStatus:");
		System.out.println("Basico: 40\nConstituição: 20\nMira: 10\n");
		System.out.println("3 - Botas 3\nStatus:");
		System.out.println("Basico: 30\nConstituição: 10\nMira: 30\n");
		System.out.println("Opção (1|2|3) --> ");
		int opcao = sc.nextInt();
		while (opcao!=1 && opcao!=2 && opcao!=3) {
			System.out.println("Opcao inválida");
			opcao = sc.nextInt();
		}
		
		switch (opcao) {
		case 1:
			setNomeArma("Botas");
			setNivelArma(1);
			
			p.setConstituicao(p.getConstituicao()+40);
			p.setMira(p.getMira()+15);
			
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
			
		case 2:
			setNomeArma("Botas2");
			setNivelArma(1);
			
			p.setConstituicao(p.getConstituicao()+20);
			p.setMira(p.getMira()+10);
			
			if (p instanceof Gladiador) {
				p.setForca(p.getForca()+40);	
			}
			else if (p instanceof Feiticeiro) {
				p.setInteligencia(p.getInteligencia()+40);
			}
			else if (p instanceof Cacador) {
				p.setDestreza(p.getDestreza()+40);
			}
			
			break;
			
		case 3:
			setNomeArma("Botas3");
			setNivelArma(1);
			
			p.setConstituicao(p.getConstituicao()+10);
			p.setMira(p.getMira()+30);
			
			if (p instanceof Gladiador) {
				p.setForca(p.getForca()+30);
			}
			else if (p instanceof Feiticeiro) {
				p.setInteligencia(p.getInteligencia()+30);
			}
			else if (p instanceof Cacador) {
				p.setDestreza(p.getDestreza()+30);
			}
			break;
			
		}
		
	}


	@Override
	public void evolutionCost(Personagens p, int lvlArma) {
		if (lvlArma == 1) {
			setCustoGold(300);
			setCustoTreinoArmas(5);
		}
		else {
			for (int i = 0; i < lvlArma; i++) {
				setCustoTreinoArmas(getCustoTreinoArmas()+3);
				setCustoGold((long) (getCustoGold()+getCustoGold()*0.3));
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
			
			case "Botas1":
				
				for (int i = 0; i < lvlArma-1; i++) {
					p.setConstituicao((int) (p.getConstituicao()+(40+40*0.2)));
					p.setMira((int) (p.getMira()+(15+15*0.25)));
					
					if (p instanceof Gladiador) {
						p.setForca((int) (p.getForca()+(15+15*0.2)));
					}
					else if (p instanceof Feiticeiro) {
						p.setInteligencia((int) (p.getInteligencia()+(15+15*0.2)));
					}
					else if (p instanceof Cacador) {
						p.setDestreza((int) (p.getDestreza()+(15+15*0.2)));
					}
				}
				
				break;
			
			case "Botas2":
				
				for (int i = 0; i < lvlArma-1; i++) {
					p.setConstituicao((int) (p.getConstituicao()+(60+60*0.2)));
					p.setMira((int) (p.getMira()+(20+20*0.2)));
					
					if (p instanceof Gladiador) {
						p.setForca((int) (p.getForca()+(10+10*0.2)));
					}
					else if (p instanceof Feiticeiro) {
						p.setInteligencia((int) (p.getInteligencia()+(10+10*0.2)));
					}
					else if (p instanceof Cacador) {
						p.setDestreza((int) (p.getDestreza()+(10+10*0.2)));
					}
				}
				
				break;
				
			case "Botas3":
				
				for (int i = 0; i < lvlArma-1; i++) {
					p.setConstituicao((int) (p.getConstituicao()+(10+10*0.2)));
					p.setMira((int) (p.getMira()+(30+30*0.2)));
					
					if (p instanceof Gladiador) {
						p.setForca((int) (p.getForca()+(50+50*0.2)));
					}
					else if (p instanceof Feiticeiro) {
						p.setInteligencia((int) (p.getInteligencia()+(50+50*0.2)));
					}
					else if (p instanceof Cacador) {
						p.setDestreza((int) (p.getDestreza()+(50+50*0.2)));
					}
				}
				break;
			}
			
		}
		
	}

}
