package Personagens;
import Personagens.Personagens;

public class Gladiador extends Personagens {
	
	
	//-------------------------------
	public Gladiador(String name) {
		/*
		super.setStatusBase(40);   
		super.setInteligencia(5);  
		super.setDestreza(5);      
		super.setForca(12);        
		super.setConstituicao(12); 
		super.setMira(6);          
		super.setTreinoArmas(10);  
		super.setAudacia(5);*/
		
		//o nome vai para a classe Personagens
		super(name);
		
		if (name == null || name.length() < 1) {
			throw new IllegalArgumentException("Nome inválido");
		}
	}
	
	public String toString() {
		String result = "Personagem: --Gladiador--\n" + super.toString();
		return result;
	}
	//-------------------------------
	
	public String getName() {		
		return super.getName();
	}


	@Override
	public void powerPerLvl(int lvl) {
		setStatusBase(40);
		setInteligencia(5);
		setDestreza(5);
		setForca(12);
		setConstituicao(12);
		setMira(6);
		
		
		if (lvl > 1) {		
			for (int i = 0; i < lvl-1; i++) {
				setStatusBase(getStatusBase() + 20);
				setInteligencia(getInteligencia() + 0);
				setDestreza(getDestreza() + 0);
				setForca(getForca() + 6);
				setConstituicao(getConstituicao() + 11);
				setMira(getMira() + 3);
				
			}
		}
//		System.out.println("Nivel "+getNivel());
//		System.out.println("forcaBase "+getStatusBase());
//		System.out.println("inteligencia "+getInteligencia());
//		System.out.println("destreza "+getDestreza());
//		System.out.println("forca "+getForca());
//		System.out.println("constituicao "+getConstituicao());
//		System.out.println("mira "+getMira());
//		System.out.println("treinoArmas "+getTreinoArmas());
//		System.out.println("Audacia "+getAudacia());
	}

	@Override
	protected void lvlUpStats() {
		super.inteligencia += 0;
		super.destreza += 7;
		super.forca += 0;
		super.constituicao += 7;
		super.mira += 6;
	}

	



	
	
}
