package Personagens;

public class Feiticeiro extends Personagens {
	
	String name;
	
	//-------------------------------	
	public Feiticeiro(String name) {
		super.statusBase = 40;     
		super.inteligencia = 15;   
		super.destreza = 5;        
		super.forca = 5;           
		super.constituicao = 5;    
		super.mira = 10;           
		super.treinoArmas = 10;    
		super.audacia = 5;  
		
		if (name == null || name.length() < 1) {
			throw new IllegalArgumentException("Nome inválido");
		}
		this.name = name;
	}

	public String toString() {
		String result = "Personagem: --Feiticeiro--\n" + super.toString();
		return result;
	}
	//-------------------------------
	
	public String getName() {		
		return name;
	}
	
	@Override
	public void powerPerLvl(int lvl) {
		
		statusBase = 20;
		inteligencia = 15;
		destreza = 5;
		forca = 5;
		constituicao = 5;
		mira = 10;
		treinoArmas = 10;
		audacia = 5;
		
		if (lvl > 1) {		
			for (int i = 0; i < lvl-1; i++) {
				statusBase += 20;
				inteligencia += 12;
				destreza += 0;
				forca += 0;
				constituicao += 2;
				mira += 6;
				treinoArmas += 0;
				audacia += 0;
			}
		}
		//Se das um nivel o nivel da personagem tem de mudar
		setNivel(lvl);
		
		System.out.println("Nivel "+lvl);
		System.out.println("forcaBase "+statusBase);
		System.out.println("inteligencia "+inteligencia);
		System.out.println("destreza "+destreza);
		System.out.println("forca "+forca);
		System.out.println("constituicao "+constituicao);
		System.out.println("mira "+mira);
		System.out.println("treinoArmas "+treinoArmas);
		System.out.println("Audacia "+audacia);
		
	}

}
