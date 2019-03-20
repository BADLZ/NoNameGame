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
		super.percentageEvolutionStats = 0.25;
		super.percentageEvolutionGold = 0.35;
		super.incrementEvolutionWeapon = 5;
		initialize();
	}
	
	public Arma(int tipo) {
		super("Arma" + tipo);
		super.percentageEvolutionStats = 0.25;
		super.percentageEvolutionGold = 0.35;
		super.incrementEvolutionWeapon = 5;
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

		}else if(super.nomeArma.equalsIgnoreCase("Arma2")) {
			super.constituicao = 60;
			super.mira = 20;
			super.bonusPersonagem = 10;
		}else if(super.nomeArma.equalsIgnoreCase("Arma3")) {
			super.constituicao = 10;
			super.mira = 30;
			super.bonusPersonagem = 50;
		}else {
			System.out.println("Criaste uma arma inexistente??");
		}
	}
	
	public String toString() {
		String s = super.nomeArma + ": Dano " + this.dano + ", Basico " + super.constituicao + ", Mira " + super.mira; 
		return s;
	}


	public int getDano() {
		return dano;
	}

}
