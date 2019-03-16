package Personagens;

public class Npc extends Personagens {

	
	
	private int statusBase;
	private int inteligencia;
	private int destreza;
	private int forca;
	private int constituicao;
	private int mira;
	private int treinoArmas;
	private int audacia;
	private int nivel;
	
	//para sabermos o atributo para o dano
	private String attBase;	
	String name;
	
	public Npc(String name) {
		if (name == null || name.length() < 1) {
			throw new IllegalArgumentException("Nome NPC inv醠ido");
		}
		this.name = name;
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
		
		return name;
	}

	public int getStatusBase() {
		return statusBase;
	}


	public void setStatusBase(int statusBase) {
		this.statusBase = statusBase;
	}


	public int getInteligencia() {
		return inteligencia;
	}


	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}


	public int getDestreza() {
		return destreza;
	}


	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}


	public int getForca() {
		return forca;
	}


	public void setForca(int forca) {
		this.forca = forca;
	}


	public int getConstituicao() {
		return constituicao;
	}


	public void setConstituicao(int constituicao) {
		this.constituicao = constituicao;
	}


	public int getMira() {
		return mira;
	}


	public void setMira(int mira) {
		this.mira = mira;
	}


	public int getTreinoArmas() {
		return treinoArmas;
	}


	public void setTreinoArmas(int treinoArmas) {
		this.treinoArmas = treinoArmas;
	}


	public int getAudacia() {
		return audacia;
	}


	public void setAudacia(int audacia) {
		this.audacia = audacia;
	}


	public int getNivel() {
		return nivel;
	}


	public void setNivel(int nivel) {
		this.nivel = nivel;
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


}
