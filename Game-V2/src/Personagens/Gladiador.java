package Personagens;
import Personagens.Personagens;

public class Gladiador extends Personagens {
	
	
	String name;
	
	//-------------------------------
	public Gladiador(String name) {
		
		super.statusBase = 40;   
		super.inteligencia = 5;  
		super.destreza = 5;      
		super.forca = 12;        
		super.constituicao = 12; 
		super.mira = 6;          
		super.treinoArmas = 10;  
		super.audacia = 5;
		
		if (name == null || name.length() < 1) {
			throw new IllegalArgumentException("Nome inválido");
		}
		this.name = name;
	}
	
	public String toString() {
		String result = "Personagem: --Gladiador--\n" + super.toString();
		return result;
	}
	//-------------------------------
	
	public String getName() {		
		return name;
	}


	@Override
	public void powerPerLvl(int lvl) {
		statusBase = 40;
		inteligencia = 5;
		destreza = 5;
		forca = 12;
		constituicao = 12;
		mira = 6;
		treinoArmas = 10;
		audacia = 5;
		
		if (lvl > 1) {		
			for (int i = 0; i < lvl-1; i++) {
				statusBase += 20;
				inteligencia += 0;
				destreza += 0;
				forca += 6;
				constituicao += 11;
				mira += 3;
				treinoArmas += 0;
				audacia += 0;
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
