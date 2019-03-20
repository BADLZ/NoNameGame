package accessory;

import java.util.ArrayList;

import Personagens.Personagens;

public abstract class Accessory {

	protected int nivelArma = 1;
	//qual diferenca entre custoGold e custoTreinoArmas
	protected long baseGoldCost;
	protected int baseTreinoArmasCost;
	protected String nomeArma;
	
	//bonus que acessorio da a cada atributo
	protected int statusBase, constituicao, mira;
	//representam percentagem que aumentam num atributo especifico
	protected double pStatusBase, pConstituicao, pMira;
	//treinoarmas audacia - algum destes e necessario?
	
	protected int bonusPersonagem;
	protected double pBonusPersonagem;
	
	
	public Accessory(String name) {
		this.nomeArma = name;
	}
	
	//--------------------------------
	public long getCustoCompraGold() {
		return baseGoldCost;
	}
	
	public int getCustoCompraTreinoArmas() {
		return baseTreinoArmasCost;
	}
	
	public String getNomeArma() {
		return nomeArma;
	}
	
	public int getNivelArma() {
		return nivelArma;
	}
	//-----------------------------
	
	public void lvlUp(Personagens p) {
		//TODO
		//evolui o nivel de arma e aumenta os parametros especificos da arma, se calhar vuncao tem de ser abstract
		//tira dinheiro do personagem
		long goldCost = getCustoGoldEvolucao();
		int trainingCost = getCustoTreinoArmasEvolucao();
		if(p.getCurrentGold() >= goldCost && p.getTreinoArmas() >= trainingCost) {
			p.setCurrentGold(p.getCurrentGold() - goldCost);
			p.setTreinoArmas(p.getTreinoArmas() - trainingCost);
			statsLvlUp();
			nivelArma += 1;
		}
	}
	
	/**
	 * usar este metodo quando se quer colocar 1 acessorio a nivel especifico
	 * por exemplo quando se guarda o acessorio em formato de texto e se tem de recrea-lo
	 **/
	public void setLvl(int lvl) {
		for(int i = this.nivelArma; i < lvl; i++) {
			statsLvlUp();
			nivelArma += 1;
		}
	}
	
	public boolean compraAcessorio(Personagens p) {
		if(p.getCurrentGold() >= baseGoldCost && p.getTreinoArmas() >= baseTreinoArmasCost) {
			p.setCurrentGold(p.getCurrentGold() - baseGoldCost);
			p.setTreinoArmas(p.getTreinoArmas() - baseTreinoArmasCost);
			p.equipItem(this);
			return true;
		}
		return false;
	}
	
	public abstract long getCustoGoldEvolucao();
	public abstract int getCustoTreinoArmasEvolucao();
	protected abstract void statsLvlUp();
	//-----------------------------
	public int getStatusBase() {
		return statusBase;
	}
	public int getConstituicao() {
		return constituicao;
	}
	public int getMira() {
		return mira;
	}
	public int getBonusPersonagem() {
		return bonusPersonagem;
	}
	
	public ArrayList<Integer> getAtributos(){
		ArrayList<Integer> result = new ArrayList<>();
		result.add(getStatusBase());
		result.add(getConstituicao());
		result.add(getMira());
		result.add(getBonusPersonagem());
		return result;
	}
	//-------------------------------
	public double getPStatusBase() {
		return pStatusBase;
	}
	public double getPConstituicao() {
		return pConstituicao;
	}
	public double getPMira() {
		return pMira;
	}
	public double getPBonusPersonagem() {
		return pBonusPersonagem;
	}
	
	public ArrayList<Double> getPAtributos(){
		ArrayList<Double> result = new ArrayList<>();
		result.add(getPStatusBase());
		result.add(getPConstituicao());
		result.add(getPMira());
		result.add(getPBonusPersonagem());
		return result;
	}
	//-----------------------------
	/**
	public void setStatusBase(int statusBase) {
		this.statusBase = statusBase;
	}
	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}
	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}
	public void setForca(int forca) {
		this.forca = forca;
	}
	public void setConstituicao(int constituicao) {
		this.constituicao = constituicao;
	}
	public void setMira(int mira) {
		this.mira = mira;
	}
	public void setBonusPersonagem(int bonusPersonagem) {
		this.bonusPersonagem = bonusPersonagem;
	}
	//-------------------------------
	public void setPStatusBase(double pStatusBase) {
		this.pStatusBase = pStatusBase;
	}
	public void setPInteligencia(double pInteligencia) {
		this.pInteligencia = pInteligencia;
	}
	public void setPDestreza(double pDestreza) {
		this.pDestreza = pDestreza;
	}
	public void setPForca(double pForca) {
		this.pForca = pForca;
	}
	public void setPConstituicao(double pConstituicao) {
		this.pConstituicao = pConstituicao;
	}
	public void setPMira(double pMira) {
		this.pMira = pMira;
	}
	public void setPBonusPersonagem(int pBonusPersonagem) {
		this.pBonusPersonagem = pBonusPersonagem;
	}
	**/
	//-----------------------------
}
