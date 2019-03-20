package accessory;

public class Chapeu extends Accessory {

	public Chapeu(String name) {
		super(name);

		initialize();
	}

	public Chapeu(int tipo) {
		super("Arma" + tipo);

		initialize();
	}

	private void initialize() {
		super.percentageEvolutionStats = 0.5;
		super.percentageEvolutionGold = 0.6;
		super.incrementEvolutionWeapon = 5;
		
		//base costs para evolucoes
		super.baseGoldCost = 700;
		super.baseTreinoArmasCost = 10;
		setAtributos();
		
	}
	
	private void setAtributos() {
		if(super.nomeArma.equalsIgnoreCase("Chapeu1")) {
			super.bonusPersonagem = 60;
			super.constituicao = 30;
			super.mira = 60;
			
		}else if(super.nomeArma.equalsIgnoreCase("Chapeu2")) {
			super.bonusPersonagem = 25;
			super.constituicao = 100;
			super.mira = 25;
		
		}else if(super.nomeArma.equalsIgnoreCase("Chapeu3")) {
			super.bonusPersonagem = 50;
			super.constituicao = 50;
			super.mira = 50;
			
		}else {
			System.out.println("Criaste uma arma inexistente??");
		}
	}
	
	public String toString() {
		String s = super.nomeArma + ": Basico " +super.bonusPersonagem+", Constituição "+ super.constituicao + ", Mira " + super.mira; 
		return s;
	}
}
