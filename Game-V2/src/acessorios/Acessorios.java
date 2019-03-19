package acessorios;

import Personagens.Personagens;

public abstract class Acessorios {
	
	private int nivelArma;
	private long custoGold;
	private int custoTreinoArmas;
	private String nomeArma;
	
	public abstract void itemStats(Personagens p, String weapon, int lvlArma);
	
	public abstract void choseWeapon(Personagens p);
	
	public abstract void evolutionCost(Personagens p, int lvlArma);
	

	public int getNivelArma() {
		return nivelArma;
	}

	public void setNivelArma(int nivelArma) {
		this.nivelArma = nivelArma;
	}

	public double getCustoGold() {
		return custoGold;
	}

	public void setCustoGold(long custoGold) {
		this.custoGold = custoGold;
	}

	public int getCustoTreinoArmas() {
		return custoTreinoArmas;
	}

	public void setCustoTreinoArmas(int custoTreinoArmas) {
		this.custoTreinoArmas = custoTreinoArmas;
	}

	public String getNomeArma() {
		return nomeArma;
	}

	public void setNomeArma(String nomeArma) {
		this.nomeArma = nomeArma;
	}

}
