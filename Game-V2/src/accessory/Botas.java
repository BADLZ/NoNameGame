package accessory;

public class Botas extends Accessory {

	public Botas(String name) {
		super(name, "Botas");

		initialize();
	}

	public Botas(int tipo) {
		super("Botas" + tipo, "Botas");

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
		if(super.nomeArma.equalsIgnoreCase("Botas1")) {
			super.bonusPersonagem = 15;
			super.constituicao = 40;
			super.mira = 15;
			
		}else if(super.nomeArma.equalsIgnoreCase("Botas2")) {
			super.bonusPersonagem = 40;
			super.constituicao = 20;
			super.mira = 10;
		
		}else if(super.nomeArma.equalsIgnoreCase("Botas3")) {
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
		if(o == null || !(o instanceof Botas))
			return false;
		Botas b = (Botas) o;
		if(super.getName().equals(b.getName()) && super.getLevel() == b.getLevel() &&
				super.getType().equals(b.getType()))
			return true;
		return false;
	}
}
