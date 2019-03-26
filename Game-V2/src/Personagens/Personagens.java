package Personagens;

import java.util.ArrayList;

import accessory.Accessory;
import accessory.Arma;

public abstract class Personagens {
	
	public abstract void powerPerLvl(int lvl);
	//numero maximo de acessorios que podem estar no inventario
	public static final int MAX_ITENS_INV = 30;
	
	protected int nivel, id;
	protected long currentXp = 0;
	protected long currentGold = 0;
	protected Inventory inv;
	private String name;
	
	protected int treinoArmas;
	protected int audacia;
	
	protected int moedasNegras;
	protected int fragmentos;
	
	public Personagens(String name, int id) {
		this.name = name;
		this.id = id;
		inv = new Inventory();
		powerPerLvl(1);
		setNivel(1);
	}
	
	//--------------------------novas cenas-----
	//statusBase = soma todos atributos
	protected int statusBase, inteligencia, destreza, forca, constituicao, mira;
	
	public Inventory getInventory() {
		return inv;
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

	public int getBaseInteligencia() {
		return inteligencia;
	}

	public int getBaseDestreza() {
		return destreza;
	}

	public int getBaseForca() {
		return forca;
	}

	public int getBaseConstituicao() {
		return constituicao;
	}

	public int getBaseMira() {
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
	
	public int getId() {
		return this.id;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		result.append("Nivel:          -" + getNivel() + "-\n");
		result.append("Current XP:     -" + getCurrentXp() + "-\n");
		result.append("Current Gold:   -" + getCurrentGold() + "-\n");
//		result.append("Status Base:    -" + getStatusBase() + "-\n");
		result.append("Inteligencia:   -" + getBaseInteligencia() + " + " + getBonusInteligencia() + " = " + getInteligencia() + "-\n");
		result.append("Destreza:       -" + getBaseDestreza() + " + " + getBonusDestreza() + " = " + getDestreza() + "-\n");
		result.append("Forca:          -" + getBaseForca() + " + " + getBonusForca() + " = " + getForca() + "-\n");
		result.append("Constituicao:   -" + getBaseConstituicao() + " + " + getBonusConstituicao() + " = " + getConstituicao() + "-\n");
		result.append("Mira:           -" + getBaseMira() + " + " + getBonusMira() + " = " + getMira() + "-\n");
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
	
	//---------------
	
	public void lvlUp() {
		nivel += 1;
		lvlUpStats();
	}
	protected abstract void lvlUpStats();
	//---------------
	
	
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
	
	
	public boolean updateXp(long xp) {
		boolean chegouAqui = false;
		
		setCurrentXp(getCurrentXp()+xp);

		while (getCurrentXp() >= xpForNextLvl(getNivel()+1)) {
			//resetar xp
			setCurrentXp(getCurrentXp()-xpForNextLvl(getNivel()+1));
			//aumentar lvl
			lvlUp();
			System.out.println("LEVEL UP!");
			
			chegouAqui = true;		
		}	
		return chegouAqui;
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
		for(Accessory item: inv.getEquipped()) {
			result += item.getConstituicao();
			result += constituicao*item.getPConstituicao();
		}
		return result;
	}
	
	public int getBonusMira() {
		int result = 0;
		for(Accessory item: inv.getEquipped()) {
			result += item.getMira();
			result += mira*item.getPMira();
		}
		return result;
	}
	
	public int getBonusForca() {
		int result = 0;
		if(this instanceof Gladiador) {
			for(Accessory item: inv.getEquipped()) {
				result += item.getBonusPersonagem();
				result += forca*item.getPBonusPersonagem();
			}
		}
		return result;
	}
	
	public int getBonusInteligencia() {
		int result = 0;
		if(this instanceof Feiticeiro) {
			for(Accessory item: inv.getEquipped()) {
				result += item.getBonusPersonagem();
				result += inteligencia*item.getPBonusPersonagem();
			}
		}
		return result;
	}
	
	public int getBonusDestreza() {
		int result = 0;
		if(this instanceof Cacador) {
			for(Accessory item: inv.getEquipped()) {
				result += item.getBonusPersonagem();
				result += destreza*item.getPBonusPersonagem();
			}
		}
		return result;
	}
	//-------------------------
	public int getConstituicao() {
		return getBaseConstituicao() + getBonusConstituicao();
	}
	
	public int getMira() {
		return getBaseMira() + getBonusMira();
	}
	
	public int getForca() {
		int result = getBaseForca() + getBonusForca();
		if(this instanceof Gladiador) {
			result *= danoArma();
		}
		return result;
	}
	
	public int getInteligencia() {
		int result =  getBaseInteligencia() + getBonusInteligencia();
		if(this instanceof Feiticeiro) {
			result *= danoArma();
		}
		return result;
	}
	
	public int getDestreza() {
		int result = getBaseDestreza() + getBonusDestreza();
		if(this instanceof Cacador) {
			result *= danoArma();
		}
		return result;
	}

	private int danoArma() {
		int result = 1;
		for(Accessory item: inv.getEquipped()) {
			if(item instanceof Arma) {
				Arma arma = (Arma) item;
				//assumindo que ele so tem 1 arma
				result = arma.getDano();
				break;
			}
		}
		
		//caso result der 0 ou menos o dano tem que ser no minimo 1, pois se tiver a 0 o atributo
		//caracteristico ficara a 0
		return result>0? result : 1;
	}
	
	

}
