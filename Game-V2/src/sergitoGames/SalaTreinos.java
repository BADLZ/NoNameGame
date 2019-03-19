package sergitoGames;

import java.util.Scanner;

import Personagens.Gladiador;
import Personagens.Personagens;

public class SalaTreinos {
	
	public void escolherTreino(Personagens p) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Tipos de Treino:");
		System.out.println("1 - Audacia");
		System.out.println("2 - Armas");
		System.out.print("Opcao (1|2) --> ");
		int opcao = sc.nextInt();
		while(opcao != 1 && opcao != 2) {
			System.out.print("Opção (1|2) ----> ");
			opcao = sc.nextInt();
		}
		
		switch (opcao) {
		
		case 1:
			if (custoAudacia(p) == true) {
				treinarAudacia(p);
			}
			else {
				System.out.println("Nao tem Gold suficiente\n");
			}
			break;
			
		case 2:
			if (custoArmas(p) == true) {
				treinarArmas(p);
			}
			else {
				System.out.println("Nao tem Gold suficiente\n");
			}
			break;
		}
	}
	
	public void treinarAudacia(Personagens p) {
		
		System.out.println("Antes Treino");
		System.out.println("Audacia "+p.getAudacia());
		System.out.println("Gold "+p.getCurrentGold());
		
		if (p.getNivel() < 51) {
			p.setCurrentGold(p.getCurrentGold()-(p.getAudacia()*180));
		}
		else if (p.getNivel() < 101) {
			p.setCurrentGold(p.getCurrentGold()-(p.getAudacia()*250));
		}
		else if (p.getNivel()<151) {
			p.setCurrentGold(p.getCurrentGold()-(p.getAudacia()*700));
		}
		else if (p.getNivel()<250) {
			p.setCurrentGold(p.getCurrentGold()-(p.getAudacia()*950));
		}
		else {
			p.setCurrentGold(p.getCurrentGold()-(p.getAudacia()*1600));
		}
		p.setAudacia(p.getAudacia()+1);	
		
		System.out.println("Depois Treino");
		System.out.println("Audácia "+p.getAudacia());
		System.out.println("Gold "+p.getCurrentGold());
	}
	
	public boolean custoAudacia(Personagens p) {
		if (p.getNivel() < 51) {
			if (p.getCurrentGold() < (p.getAudacia()*180)) {
				return false;
			}
		}
		else if (p.getNivel() < 101) {
			if (p.getCurrentGold() < (p.getAudacia()*250)) {
				return false;
			}
		}
		else if (p.getNivel() < 151) {
			if (p.getCurrentGold() < (p.getAudacia()*700)) {
				return false;
			}
		}
		else if (p.getNivel() < 250) {
			if (p.getCurrentGold() < (p.getAudacia()*950)) {
				return false;
			}
		}
		else {
			if (p.getCurrentGold() < (p.getAudacia()*1600)) {
				return false;
			}
		}
		return true;
	}
	
	
	public void treinarArmas(Personagens p) {
		System.out.println("Antes Treino");
		System.out.println("Armas "+p.getTreinoArmas());
		System.out.println("Gold "+p.getCurrentGold()+"\n");
		if (p.getNivel()<31) {
			p.setCurrentGold(p.getCurrentGold()-(p.getTreinoArmas()*150));
		}
		else if (p.getNivel() < 80) {
			p.setCurrentGold(p.getCurrentGold()-(p.getTreinoArmas()*200));
		}
		else if (p.getNivel() < 130) {
			p.setCurrentGold(p.getCurrentGold()-(p.getTreinoArmas()*350));
		}
		else if (p.getNivel() < 170) {
			p.setCurrentGold(p.getCurrentGold()-(p.getTreinoArmas()*700));
		}
		else {
			p.setCurrentGold(p.getCurrentGold()-(p.getTreinoArmas()*1000));
		}
		p.setTreinoArmas(p.getTreinoArmas()+1);
		
		System.out.println("Depois Treino");
		System.out.println("Armas "+p.getTreinoArmas());
		System.out.println("Gold "+p.getCurrentGold());
	}

	
	public boolean custoArmas(Personagens p) {
		if (p.getNivel()<31) {
			if (p.getCurrentGold() < (p.getTreinoArmas()*150)) {
				return false;
			}
		}
		else if (p.getNivel() < 80) {
			if (p.getCurrentGold() < (p.getTreinoArmas()*200)) {
				return false;
			}
		}
		else if (p.getNivel() < 130) {
			if (p.getCurrentGold() < (p.getTreinoArmas()*350)) {
				return false;
			}
		}
		else if (p.getNivel() < 170) {
			if (p.getCurrentGold() < (p.getTreinoArmas()*700)) {
				return false;
			}
		}
		else {
			if (p.getCurrentGold() < (p.getTreinoArmas()*1000)) {
				return false;
			}
		}
		return true;
	}

}
