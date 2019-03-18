package sergitoGames;

import Personagens.Gladiador;
import Personagens.Personagens;

public class SalaTreinos {
	
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
	
	public static void main(String[] args) {
		
	
	}

}
