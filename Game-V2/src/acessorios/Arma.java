package acessorios;

import java.util.Scanner;

import Personagens.Cacador;
import Personagens.Feiticeiro;
import Personagens.Gladiador;
import Personagens.Personagens;

public class Arma extends Acessorios {
	
	@Override
	public void choseWeapon(Personagens p) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1 - Arma 1\nStatus:");
		System.out.println("Dano: 10\nBasico: 30\nConstituição: 30\nMira: 30\n");
		System.out.println("2 - Arma 2\nStatus:");
		System.out.println("Dano: 10\nBasico: 60\nConstituição: 30\nMira: 20\n");
		System.out.println("3 - Arma 3\nStatus:");
		System.out.println("Dano: 10\nBasico: 50\nConstituição: 10\nMira: 30\n");
		System.out.println("Opção (1|2|3) --> ");
		int opcao = sc.nextInt();
		while (opcao!=1 && opcao!=2 && opcao!=3) {
			System.out.println("Opcao inválida");
			opcao = sc.nextInt();
		}
		
		switch (opcao) {
		case 1:
			setNomeArma("Arma1");
			setNivelArma(1);
			
			p.setConstituicao(p.getConstituicao()+30);
			p.setMira(p.getMira()+30);
			
			if (p instanceof Gladiador) {
				p.setForca(p.getForca()*10);
				p.setForca(p.getForca()+30);
			}
			else if (p instanceof Feiticeiro) {
				p.setInteligencia(p.getInteligencia()*10);
				p.setInteligencia(p.getInteligencia()+30);			
			}
			else if (p instanceof Cacador) {
				p.setDestreza(p.getDestreza()*10);
				p.setDestreza(p.getDestreza()+30);	
			}
			break;
			
		case 2:
			setNomeArma("Arma2");
			setNivelArma(1);
			
			p.setConstituicao(p.getConstituicao()+30);
			p.setMira(p.getMira()+20);
			
			if (p instanceof Gladiador) {
				p.setForca(p.getForca()*10);
				p.setForca(p.getForca()+60);	
			}
			else if (p instanceof Feiticeiro) {
				p.setInteligencia(p.getInteligencia()*10);
				p.setInteligencia(p.getInteligencia()+60);
			}
			else if (p instanceof Cacador) {
				p.setDestreza(p.getDestreza()*10);
				p.setDestreza(p.getDestreza()+60);
			}
			
			break;
			
		case 3:
			setNomeArma("Arma3");
			setNivelArma(1);
			
			p.setConstituicao(p.getConstituicao()+10);
			p.setMira(p.getMira()+30);
			
			if (p instanceof Gladiador) {
				p.setForca(p.getForca()*10);
				p.setForca(p.getForca()+50);
			}
			else if (p instanceof Feiticeiro) {
				p.setInteligencia(p.getInteligencia()*10);
				p.setInteligencia(p.getInteligencia()+50);
			}
			else if (p instanceof Cacador) {
				p.setDestreza(p.getDestreza()*10);
				p.setDestreza(p.getDestreza()+50);
			}
			break;
			
		}
		
	}


	@Override
	public void evolutionCost(Personagens p, int lvlArma) {
		if (lvlArma == 1) {
			setCustoGold(450);
			setCustoTreinoArmas(10);
		}
		else {
			for (int i = 0; i < lvlArma; i++) {
				setCustoTreinoArmas(getCustoTreinoArmas()+5);
				setCustoGold((long) (getCustoGold()+getCustoGold()*0.35));
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
			
			case "Arma1":
				
				for (int i = 0; i < lvlArma-1; i++) {
					p.setConstituicao((int) (p.getConstituicao()+(30+30*0.25)));
					p.setMira((int) (p.getMira()+(30+30*0.25)));
					
					if (p instanceof Gladiador) {
						p.setForca((int) (p.getForca()*(10+10*0.25)));
						p.setForca((int) (p.getForca()+(30+30*0.25)));
					}
					else if (p instanceof Feiticeiro) {
						p.setInteligencia((int) (p.getInteligencia()*(10+10*0.25)));
						p.setInteligencia((int) (p.getInteligencia()+(30+30*0.25)));
					}
					else if (p instanceof Cacador) {
						p.setDestreza((int) (p.getDestreza()*(10+10*0.25)));
						p.setDestreza((int) (p.getDestreza()+(30+30*0.25)));
					}
				}
				
				break;
			
			case "Arma2":
				
				for (int i = 0; i < lvlArma-1; i++) {
					p.setConstituicao((int) (p.getConstituicao()+(60+60*0.25)));
					p.setMira((int) (p.getMira()+(20+20*0.25)));
					
					if (p instanceof Gladiador) {
						p.setForca((int) (p.getForca()*(10+10*0.25)));
						p.setForca((int) (p.getForca()+(10+10*0.25)));
					}
					else if (p instanceof Feiticeiro) {
						p.setInteligencia((int) (p.getInteligencia()*(10+10*0.25)));
						p.setInteligencia((int) (p.getInteligencia()+(10+10*0.25)));
					}
					else if (p instanceof Cacador) {
						p.setDestreza((int) (p.getDestreza()*(10+10*0.25)));
						p.setDestreza((int) (p.getDestreza()+(10+10*0.25)));
					}
				}
				
				break;
				
			case "Arma3":
				
				for (int i = 0; i < lvlArma-1; i++) {
					p.setConstituicao((int) (p.getConstituicao()+(10+10*0.25)));
					p.setMira((int) (p.getMira()+(30+30*0.25)));
					
					if (p instanceof Gladiador) {
						p.setForca((int) (p.getForca()*(10+10*0.25)));
						p.setForca((int) (p.getForca()+(50+50*0.25)));
					}
					else if (p instanceof Feiticeiro) {
						p.setInteligencia((int) (p.getInteligencia()*(10+10*0.25)));
						p.setInteligencia((int) (p.getInteligencia()+(50+50*0.25)));
					}
					else if (p instanceof Cacador) {
						p.setDestreza((int) (p.getDestreza()*(10+10*0.25)));
						p.setDestreza((int) (p.getDestreza()+(50+50*0.25)));
					}
				}
				break;
			}
			
		}
		
	}

	

}
