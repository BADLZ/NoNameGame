package Personagens;

import java.util.ArrayList;

import accessory.Accessory;
import accessory.Arma;

public abstract class Personagens {
	
	public abstract void powerPerLvl(int lvl); 

	
	private int nivel;
	private long currentXp = 0;
	private long currentGold = 0;
	private String name;
	
	private int treinoArmas;
	private int audacia;
	
	private int moedasNegras;
	private int fragmentos;
	
	private ArrayList<Accessory> equipedItems;
	
	public Personagens(String name) {
		this.name = name;
		equipedItems = new ArrayList<>();
	}
	
	//--------------------------novas cenas-----
	//statusBase = soma todos atributos
	private int statusBase, inteligencia, destreza, forca, constituicao, mira;
	
	public boolean equipItem(Accessory item) {
		equipedItems.add(item);
		//TODO ha casos em que o jogador nao pode equipar itens
		return true;
	}
	
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
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		result.append("Nivel:          -" + getNivel() + "-\n");
		result.append("Current XP:     -" + getCurrentXp() + "-\n");
		result.append("Current Gold:   -" + getCurrentGold() + "-\n");
		result.append("Status Base:    -" + getStatusBase() + "-\n");
		result.append("Inteligencia:   -" + getInteligencia() + " + " + getBonusInteligencia() + "-\n");
		result.append("Destreza:       -" + getDestreza() + " + " + getBonusDestreza() + "-\n");
		result.append("Forca:          -" + getForca() + " + " + getBonusForca() + "-\n");
		result.append("Constituicao:   -" + getConstituicao() + " + " + getBonusConstituicao() + "-\n");
		result.append("Mira:           -" + getMira() + " + " + getBonusMira() + "-\n");
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
			
		}
		else if (p instanceof Feiticeiro) {
			p.setInteligencia(p.getInteligencia() + 12);
			p.setDestreza(p.getDestreza() + 0);
			p.setForca(p.getForca() + 0);
			p.setConstituicao(p.getConstituicao() + 2);
			p.setMira(p.getMira() + 6);
			
		}
		else { //caçador
			p.setInteligencia(p.getInteligencia() + 0);
			p.setDestreza(p.getDestreza() + 7);
			p.setForca(p.getForca() + 0);
			p.setConstituicao(p.getConstituicao() + 7);
			p.setMira(p.getMira() + 6);

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

	public int getMoedasNegras() {
		return moedasNegras;
	}

	public void setMoedasNegras(int moedasNegras) {
		this.moedasNegras = moedasNegras;
	}

	public int getFragmentos() {
		return fragmentos;
	}

	public void setFragmentos(int fragmentos) {
		this.fragmentos = fragmentos;
	}
	
	
	//-------------------------
	public int getBonusConstituicao() {
		int result = 0;
		for(Accessory item: equipedItems) {
			result += item.getConstituicao();
			result += constituicao*item.getPConstituicao();
		}
		return result;
	}
	
	public int getBonusMira() {
		int result = 0;
		for(Accessory item: equipedItems) {
			result += item.getMira();
			result += mira*item.getPMira();
		}
		return result;
	}
	
	public int getBonusForca() {
		int result = 0;
		if(this instanceof Gladiador) {
			for(Accessory item: equipedItems) {
				result += item.getBonusPersonagem();
				result += forca*item.getPBonusPersonagem();
			}
		}
		return result;
	}
	
	public int getBonusInteligencia() {
		int result = 0;
		if(this instanceof Feiticeiro) {
			for(Accessory item: equipedItems) {
				result += item.getBonusPersonagem();
				result += inteligencia*item.getPBonusPersonagem();
			}
		}
		return result;
	}
	
	public int getBonusDestreza() {
		int result = 0;
		if(this instanceof Cacador) {
			for(Accessory item: equipedItems) {
				result += item.getBonusPersonagem();
				result += destreza*item.getPBonusPersonagem();
			}
		}
		return result;
	}
	//-------------------------
	public int getTotalConstituicao() {
		return getConstituicao() + getBonusConstituicao();
	}
	
	public int getTotalMira() {
		return getMira() + getBonusMira();
	}
	
	public int getTotalForca() {
		int result = getForca() + getBonusForca();
		return result*danoArma();
	}
	
	public int getTotalInteligencia() {
		return getInteligencia() + getBonusInteligencia();
	}
	
	public int getTotalDestreza() {
		return getDestreza() + getBonusDestreza();
	}

	private int danoArma() {
		int result = 0;
		for(Accessory item: equipedItems) {
			if(item instanceof Arma) {
				Arma arma = (Arma) item;
				//assumindo que ele so tem 1 arma
				result = arma.getDano();
				break;
			}
		}
		
		return result;
	}
	
	

}
