package acessorios;

import Personagens.Personagens;

public class Insignias extends Acessorios {

	@Override
	public void itemStats(Personagens p, String weapon, int lvlArma) {
		
		//TODO lvlArma neste caso não interessa
		
		switch (weapon) {
		//TODO também aumenta audacia, mas ainda não se sabe o valor
		case "UndeadDestroier":
			setNomeArma("UndeadDestroier");
			setNivelArma(1);
			
			p.setInteligencia(p.getInteligencia()+120);
			p.setDestreza(p.getDestreza()+120);
			p.setForca(p.getForca()+120);
			p.setConstituicao(p.getConstituicao()+120);
			p.setMira(p.getMira()+120);
			//p.setAudacia(p.getAudacia()+?);
			break;
			
		case "knockHellsDoor":
			setNomeArma("knockHellsDoor");
			setNivelArma(2);
			
			p.setInteligencia(p.getInteligencia()+240);
			p.setDestreza(p.getDestreza()+240);
			p.setForca(p.getForca()+240);
			p.setConstituicao(p.getConstituicao()+240);
			p.setMira(p.getMira()+240);	
			//p.setAudacia(p.getAudacia()+?);
			break;
			
		}
		
	}

	@Override
	public void choseWeapon(Personagens p) {
		//nothing here
		//Insignias are rewards
		
	}

	@Override
	public void evolutionCost(Personagens p, int lvlArma) {
		//nothing
		//Insignias are given for free
		//after completing Catabumbas		
	}

}
