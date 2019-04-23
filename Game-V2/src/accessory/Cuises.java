package accessory;

public class Cuises extends Accessory {

	public Cuises(String name) {
		super(name, "Cuises");

		initialize();
	}

	public Cuises(int tipo) {
		super("Cuises" + tipo, "Cuises");

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
		if(super.nomeArma.equalsIgnoreCase("Cuises1")) {
			super.bonusPersonagem = 10;
			super.constituicao = 30;
			super.mira = 10;
			
		}else if(super.nomeArma.equalsIgnoreCase("Cuises2")) {
			super.bonusPersonagem = 25;
			super.constituicao = 10;
			super.mira = 15;
		
		}else if(super.nomeArma.equalsIgnoreCase("Cuises3")) {
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
	
	@Override
	public boolean equals(Object o) {
		if(o == this)
			return true;
		if(o == null || !(o instanceof Cuises))
			return false;
		Cuises c = (Cuises) o;
		if(super.getName().equals(c.getName()) && super.getLevel() == c.getLevel() &&
				super.getType().equals(c.getType()))
			return true;
		return false;
	}
}
