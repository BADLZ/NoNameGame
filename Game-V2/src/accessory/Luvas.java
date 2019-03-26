package accessory;

public class Luvas extends Accessory {

	public Luvas(String name) {
		super(name, "Luvas");

		initialize();
	}

	public Luvas(int tipo) {
		super("Luvas" + tipo, "Luvas");

		initialize();
	}

	private void initialize() {
		super.percentageEvolutionStats = 0.2;
		super.percentageEvolutionGold = 0.3;
		super.incrementEvolutionWeapon = 3;
		//base costs para evolucoes
		super.baseGoldCost = 300;
		super.baseTreinoArmasCost = 5;
		setAtributos();
		
	}
	
	private void setAtributos() {
		if(super.nomeArma.equalsIgnoreCase("Luvas1")) {
			super.bonusPersonagem = 15;
			super.constituicao = 40;
			super.mira = 15;
			
		}else if(super.nomeArma.equalsIgnoreCase("Luvas2")) {
			super.bonusPersonagem = 40;
			super.constituicao = 20;
			super.mira = 10;
		
		}else if(super.nomeArma.equalsIgnoreCase("Luvas3")) {
			super.bonusPersonagem = 30;
			super.constituicao = 10;
			super.mira = 30;
			
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
		if(o == null || !(o instanceof Luvas))
			return false;
		Luvas l = (Luvas) o;
		if(super.getName().equals(l.getName()) && super.getLevel() == l.getLevel() &&
				super.getType().equals(l.getType()))
			return true;
		return false;
	}
}
