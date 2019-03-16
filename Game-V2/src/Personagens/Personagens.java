package Personagens;

public abstract class Personagens {
	
	public abstract void powerPerLvl(int lvl); 

	
	private int nivel;
	private long currentXp = 0;
	private long currentGold = 0;
	
	//--------------------------novas cenas-----
	public int statusBase, inteligencia, destreza, forca, constituicao, mira, treinoArmas, audacia;
	

	
	public int getStatusBase() {
		return statusBase;
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
		result.append("Current XP:     -" + currentXp + "-\n");
		result.append("Current Gold:   -" + currentGold + "-\n");
		result.append("Status Base:    -"+ statusBase + "-\n");
		result.append("Inteligencia:   -" + inteligencia + "-\n");
		result.append("Destreza:       -" + destreza + "-\n");
		result.append("Forca:          -" + forca + "-\n");
		result.append("Constituicao:   -" + constituicao + "-\n");
		result.append("Mira:           -" + mira + "-\n");
		result.append("Treino Armas:   -" + treinoArmas + "-\n");
		result.append("Audacia:        -" + audacia + "-");
		
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
	
	public void lvlUp() {
		setNivel(getNivel()+1);
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
			p.lvlUp();
			System.out.println("LEVEL UP!");
			
			chegouAqui = true;
			//p.setNivel(p.getNivel()+1);			
		}	
		
		//codigo serguinte podia ser trocado por 1 linha:
		//return chegouAqui;
		
		if (chegouAqui == true) {
			//why put false????
			chegouAqui = false;
			return true;
		}
		else {
			return false;
		}
	}

}
