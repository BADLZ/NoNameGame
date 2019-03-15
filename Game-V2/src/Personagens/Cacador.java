package Personagens;

public class Cacador extends Personagens {
	
	String name;
	//-------------------------------
	public Cacador(String name) {
		super.statusBase = 40;   
		super.inteligencia = 5;  
		super.destreza = 10;     
		super.forca = 5;         
		super.constituicao = 10; 
		super.mira = 10;         
		super.treinoArmas = 10;  
		super.audacia = 5;
		
		if (name == null || name.length() < 1) {
			throw new IllegalArgumentException("Nome inválido");
		}
		this.name = name;
	}
	
	public String toString() {
		String result = "Personagem: --Cacador--\n" + super.toString();
		return result;
	}
	//-------------------------------
	
	public String getName() {		
		return name;
	}

	@Override
	public void powerPerLvl(int lvl) {		
		statusBase = 20;
		inteligencia = 5;
		destreza = 10;
		forca = 5;
		constituicao = 10;
		mira = 10;
		treinoArmas = 10;
		audacia = 5;
		
		if (lvl > 1) {		
			for (int i = 0; i < lvl-1; i++) {
				statusBase += 20;
				inteligencia += 0;
				destreza += 7;
				forca += 0;
				constituicao += 7;
				mira += 6;
				treinoArmas += 0;
			}
		}
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
