package accessory;


public class Arma extends Accessory{

	//ainda n precebi onde querem usar o dano
	protected int dano;
	
	/**
	 * Nao sei se o melhor eh usar armas com diferentes nomes ou 1 classe para cada tipo de arma
	 * pois por 1 lado tens menos classes mas por equanto pode-se deixar assim
	 */
	public Arma(String name) {
		super(name);
		initialize();
	}
	
	public Arma(int tipo) {
		super("Arma" + tipo);
		initialize();
	}
	
	private void initialize() {

		//base costs para evolucoes
		super.baseGoldCost = 450;
		super.baseTreinoArmasCost = 10;
		setAtributos();
		
	}
	
	private void setAtributos() {
		if(super.nomeArma.equalsIgnoreCase("Arma1")) {
			super.constituicao = 30;
			super.mira = 30;
			super.bonusPersonagem = 30;
			//nao sei se 10% eh muito ou pouco...
			super.pBonusPersonagem = 0.1;
		}else if(super.nomeArma.equalsIgnoreCase("Arma2")) {
			super.constituicao = 30;
			super.mira = 20;
			super.bonusPersonagem = 60;
			super.pBonusPersonagem = 0.1;
		}else if(super.nomeArma.equalsIgnoreCase("Arma3")) {
			super.constituicao = 10;
			super.mira = 30;
			super.bonusPersonagem = 50;
			super.pBonusPersonagem = 0.1;
		}else {
			System.out.println("Criaste uma arma inexistene??");
		}
	}
	
	public String toString() {
		String s = super.nomeArma + ": Dano " + this.dano + ", Basico " + super.constituicao + ", Mira " + super.mira; 
		return s;
	}

	@Override
	public long getCustoGoldEvolucao() {
		int nextLvl = super.nivelArma + 1;
		long cost = super.baseGoldCost;
		for (int i = 1; i <= nextLvl; i++) {
			cost += cost*0.35;
		}
		
		return cost;
	}

	@Override
	public int getCustoTreinoArmasEvolucao() {
		int nextLvl = super.nivelArma + 1;
		int cost = super.baseTreinoArmasCost;
		for (int i = 1; i <= nextLvl; i++) {
			cost += 5;
		}
		return cost;
	}

	@Override
	protected void statsLvlUp() {
		int nextLvl = super.nivelArma + 1;
		double percentagem = 0.25;
		super.constituicao += super.constituicao*percentagem;
		super.mira += super.mira*percentagem;
		super.bonusPersonagem += super.bonusPersonagem*percentagem;
	}

	public int getDano() {
		return dano;
	}

}
