package Personagens;

public abstract class Personagens {
	
	public abstract void powerPerLvl(int lvl); 

	
	private int nivel;
	private long currentXp = 0;
	private long currentGold = 0;
	
	//--------------------------novas cenas-----
	private int statusBase, inteligencia, destreza, forca, constituicao, mira, treinoArmas, audacia;
	

	
	public int getStatusBase() {
		return statusBase;
	}

	public void setStatusBase(int statusBase) {
		this.statusBase = statusBase;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public void setConstituicao(int constituicao) {
		this.constituicao = constituicao;
	}

	public void setMira(int mira) {
		this.mira = mira;
	}

	public void setTreinoArmas(int treinoArmas) {
		this.treinoArmas = treinoArmas;
	}

	public void setAudacia(int audacia) {
		this.audacia = audacia;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public int getDestreza() {
		return destreza;
	}

	public int getForca() {
		return forca;
	}

	public int getConstituicao() {
		return constituicao;
	}

	public int getMira() {
		return mira;
	}

	public int getTreinoArmas() {
		return treinoArmas;
	}

	public int getAudacia() {
		return audacia;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		result.append("Nivel:          -" + getNivel() + "-\n");
		result.append("Current XP:     -" + getCurrentXp() + "-\n");
		result.append("Current Gold:   -" + getCurrentGold() + "-\n");
		result.append("Status Base:    -" + getStatusBase() + "-\n");
		result.append("Inteligencia:   -" + getInteligencia() + "-\n");
		result.append("Destreza:       -" + getDestreza() + "-\n");
		result.append("Forca:          -" + getForca() + "-\n");
		result.append("Constituicao:   -" + getConstituicao() + "-\n");
		result.append("Mira:           -" + getMira() + "-\n");
		result.append("Treino Armas:   -" + getTreinoArmas() + "-\n");
		result.append("Audacia:        -" + getAudacia() + "-");
		
		return result.toString();
	}
	//--------------------------------------------------------
	
	public long getCurrentXp() {
		return currentXp;
	}
	public void setCurrentXp(long a) {
		currentXp = a;
	}

	public long getCurrentGold() {
		return currentGold;
	}
	public void setCurrentGold(long a) {
		currentGold = a;
	}

	public int getNivel() {
		return nivel;
	}
	
	public void setNivel(int a) {
		nivel = a;
	}
	
	public void lvlUp(Personagens p) {
		p.setNivel(p.getNivel()+1);
		p.setStatusBase(getStatusBase() + 20);
		if (p instanceof Gladiador) {
			p.setInteligencia(p.getInteligencia() + 0);
			p.setDestreza(p.getDestreza() + 0);
			p.setForca(p.getForca() + 6);
			p.setConstituicao(p.getConstituicao() + 11);
			p.setMira(p.getMira() + 3);
			p.setTreinoArmas(p.getTreinoArmas() + 0);
			p.setAudacia(p.getAudacia() + 0);
		}
		else if (p instanceof Feiticeiro) {
			p.setInteligencia(p.getInteligencia() + 12);
			p.setDestreza(p.getDestreza() + 0);
			p.setForca(p.getForca() + 0);
			p.setConstituicao(p.getConstituicao() + 2);
			p.setMira(p.getMira() + 6);
			p.setTreinoArmas(p.getTreinoArmas() + 0);
			p.setAudacia(p.getAudacia() + 0);
		}
		else { //caçador
			p.setInteligencia(p.getInteligencia() + 0);
			p.setDestreza(p.getDestreza() + 7);
			p.setForca(p.getForca() + 0);
			p.setConstituicao(p.getConstituicao() + 7);
			p.setMira(p.getMira() + 6);
			p.setTreinoArmas(p.getTreinoArmas() + 0);
		}
	}
	
	
	public static long xpForNextLvl(int lvl) {
		long xpNeeded;
		
		if (lvl < 51) {
			xpNeeded = (long) (2*lvl*100+(0.2*(lvl*100)*((lvl-1)*100)));
			//xpNeeded = xpNeeded/100;
		}
		else if (lvl < 101) {
			xpNeeded = (long) (2*lvl*100+(0.45*(lvl*100)*((lvl-1)*100)));
			//xpNeeded = xpNeeded/50;
		}
		else if (lvl < 151) {
			xpNeeded = (long) (2*lvl*100+(1.7*(lvl*100)*((lvl-1)*100)));
		}
		else {
			xpNeeded = (long) (2*lvl*100+(4*(lvl*100)*((lvl-1)*100)));
		}

		return xpNeeded/100;		
	}
	
	
	public static boolean updateXp(Personagens p, long xp) {
		boolean chegouAqui = false;
		
		p.setCurrentXp(p.getCurrentXp()+xp);

		while (p.getCurrentXp() >= xpForNextLvl(p.getNivel()+1)) {
			//resetar xp
			p.setCurrentXp(p.getCurrentXp()-xpForNextLvl(p.getNivel()+1));
			//aumentar lvl
			p.lvlUp(p);
			System.out.println("LEVEL UP!");
			
			chegouAqui = true;
			//p.setNivel(p.getNivel()+1);			
		}	
		
		if (chegouAqui == true) {
			chegouAqui = false;
			return true;
		}
		else {
			return false;
		}
	}

}
