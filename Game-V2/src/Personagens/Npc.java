package Personagens;

public class Npc extends Personagens {

	
	
	//para sabermos o atributo para o dano
	private String attBase;	

	
	public Npc(String name) {
		super(name, -1);
		
		if (name == null || name.length() < 1) {
			throw new IllegalArgumentException("Nome NPC inválido");
		}
	}

	
	public void statusNpc(String name) {
		//FIRST FLOOR
		if (name.equalsIgnoreCase("bruxinha")) {
			setAtributos(230, 150, 250, 15, 0, 0, 0, 0, 0, "inteligencia");
		}
		else if (name.equalsIgnoreCase("PequenoGuerreiro")) {
			setAtributos(0, 450, 250, 40, 0, 0, 550, 0, 0, "forca");
		}
		else if (name.equalsIgnoreCase("ArqueiroMorto")) {
			setAtributos(0, 800, 700, 70, 0, 900, 0, 0, 0, "destreza");
		}
		else if (name.equalsIgnoreCase("RoqueiroFantasma")) {
			setAtributos(1250, 800, 1100, 110, 0, 0, 0, 0, 0, "inteligencia");
		}
		else if (name.equalsIgnoreCase("BailarinaMortifora")) {
			setAtributos(0, 1500, 900, 150, 0, 1600, 0, 0, 0, "destreza");
		}
		//SECOND FLOOR
		else if (name.equalsIgnoreCase("PecadorEmEspera")) {
			setAtributos(0, 250, 200, 25, 0, 300, 0, 0, 0, "destreza");
		}
		else if (name.equalsIgnoreCase("ChefeDaFila")) {
			setAtributos(700, 300, 600, 60, 0, 0, 0, 0, 0, "inteligencia");
		}
		else if (name.equalsIgnoreCase("MestreCucumba")) {
			setAtributos(0, 1000, 400, 90, 0, 0, 1100, 0, 0, "forca");
		}
		else if (name.equalsIgnoreCase("GuardiaoDoPortao")) {
			setAtributos(0, 1500, 650, 130, 0, 0, 1700, 0, 0, "forca");
		}
		else if (name.equalsIgnoreCase("PortaoDemoniaco")) {
			setAtributos(0, 2000, 1500, 180, 0, 2200, 0, 0, 0, "destreza");
		}
		else {
			System.out.println("NPC não encontrados");
		}
	}
	private void setAtributos(int inteligencia, int constituicao, int mira, 
			int nivel ,int statusbase, int destreza, int forca, int treinoarmas,
			int audacia, String attBase) {
		setInteligencia(inteligencia);
		setConstituicao(constituicao);
		setMira(mira);
		setNivel(nivel);
		setStatusBase(statusbase);
		setDestreza(destreza); 
		setForca(forca);
		setTreinoArmas(treinoarmas);
		setAudacia(audacia);
		setAttBase(attBase);
	}
	
	public String getName() {
		
		return super.getName();
	}

	public String getAttBase() {
		return attBase;
	}
	
	public void setAttBase(String a) {
		this.attBase = a;
	}

	@Override
	public void powerPerLvl(int lvl) {
		// nothing happens here, because NPC dont get status depending on their level
		
	}


	@Override
	protected void lvlUpStats() {
		// nao precisa de aumentar os stats por set npc
		
	}


}
