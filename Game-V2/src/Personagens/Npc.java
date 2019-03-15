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
			throw new IllegalArgumentException("Nome NPC inválido");
		}
		this.name = name;
	}

	
	public void statusNpc(String name) {
		//FIRST FLOOR
		if (name.equalsIgnoreCase("bruxinha")) {
			setInteligencia(230);
			setConstituicao(150);
			setMira(250);
			setNivel(15);
			setStatusBase(0);
			setDestreza(0);
			setForca(0);
			setTreinoArmas(0);
			setAudacia(0);
			setAttBase("inteligencia");
		}
		else if (name.equalsIgnoreCase("PequenoGuerreiro")) {
			setInteligencia(0);
			setConstituicao(450);
			setMira(250);
			setNivel(40);
			setStatusBase(0);
			setDestreza(0); 
			setForca(550);
			setTreinoArmas(0);
			setAudacia(0);
			setAttBase("forca");
		}
		else if (name.equalsIgnoreCase("ArqueiroMorto")) {
			setInteligencia(0);
			setConstituicao(800);
			setMira(700);
			setNivel(70);
			setStatusBase(0);
			setDestreza(900); 
			setForca(0);
			setTreinoArmas(0);
			setAudacia(0);
			setAttBase("Destreza");
		}
		else if (name.equalsIgnoreCase("RoqueiroFantasma")) {
			setInteligencia(1250);
			setConstituicao(800);
			setMira(1100);
			setNivel(110);
			setStatusBase(0);
			setDestreza(0); 
			setForca(0);
			setTreinoArmas(0);
			setAudacia(0);
			setAttBase("inteligencia");
		}
		else if (name.equalsIgnoreCase("BailarinaMortifora")) {
			setInteligencia(0);
			setConstituicao(1500);
			setMira(900);
			setNivel(150);
			setStatusBase(0);
			setDestreza(1600); 
			setForca(0);
			setTreinoArmas(0);
			setAudacia(0);
			setAttBase("destreza");
		}
		//SECOND FLOOR
		else if (name.equalsIgnoreCase("PecadorEmEspera")) {
			setInteligencia(0);
			setConstituicao(250);
			setMira(200);
			setNivel(25);
			setStatusBase(0);
			setDestreza(300); 
			setForca(0);
			setTreinoArmas(0);
			setAudacia(0);
			setAttBase("destreza");
		}
		else if (name.equalsIgnoreCase("ChefeDaFila")) {
			setInteligencia(700);
			setConstituicao(300);
			setMira(600);
			setNivel(60);
			setStatusBase(0);
			setDestreza(0); 
			setForca(0);
			setTreinoArmas(0);
			setAudacia(0);
			setAttBase("inteligencia");
		}
		else if (name.equalsIgnoreCase("MestreCucumba")) {
			setInteligencia(0);
			setConstituicao(1000);
			setMira(400);
			setNivel(90);
			setStatusBase(0);
			setDestreza(0); 
			setForca(1100);
			setTreinoArmas(0);
			setAudacia(0);
			setAttBase("forca");
		}
		else if (name.equalsIgnoreCase("GuardiaoDoPortao")) {
			setInteligencia(0);
			setConstituicao(1500);
			setMira(650);
			setNivel(130);
			setStatusBase(0);
			setDestreza(0); 
			setForca(1700);
			setTreinoArmas(0);
			setAudacia(0);
			setAttBase("forca");
		}
		else if (name.equalsIgnoreCase("PortaoDemoniaco")) {
			setInteligencia(0);
			setConstituicao(2000);
			setMira(1500);
			setNivel(180);
			setStatusBase(0);
			setDestreza(2200); 
			setForca(0);
			setTreinoArmas(0);
			setAudacia(0);
			setAttBase("destreza");
		}
		else {
			System.out.println("NPC não encontrados");
		}
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
