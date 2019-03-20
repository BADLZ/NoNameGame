package accessory;

public class Cinturao extends Accessory {

	public Cinturao(String name) {
		super(name);

		initialize();
	}

	public Cinturao(int tipo) {
		super("Arma" + tipo);

		initialize();
	}

	private void initialize() {
		super.percentageEvolutionStats = 0.4;
		super.percentageEvolutionGold = 0.45;
		super.incrementEvolutionWeapon = 4;
		
		//base costs para evolucoes
		super.baseGoldCost = 500;
		super.baseTreinoArmasCost = 7;
		setAtributos();
		
	}
	
	private void setAtributos() {
		if(super.nomeArma.equalsIgnoreCase("Cinturao1")) {
			super.bonusPersonagem = 10;
			super.constituicao = 30;
			super.mira = 10;
			
		}else if(super.nomeArma.equalsIgnoreCase("Cinturao2")) {
			super.bonusPersonagem = 25;
			super.constituicao = 10;
			super.mira = 15;
		
		}else if(super.nomeArma.equalsIgnoreCase("Cinturao3")) {
			super.bonusPersonagem = 15;
			super.constituicao = 15;
			super.mira = 20;
			
		}else {
			System.out.println("Criaste uma arma inexistente??");
		}
	}
	
	public String toString() {
		String s = super.nomeArma + ": Basico " +super.bonusPersonagem+", Constituição "+ super.constituicao + ", Mira " + super.mira; 
		return s;
	}
}
