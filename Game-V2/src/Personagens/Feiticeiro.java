package Personagens;

public class Feiticeiro extends Personagens {
	
	
	//-------------------------------	
	public Feiticeiro(String name, int id) {
		/*super.setStatusBase(40);     
		super.setInteligencia(15);   
		super.setDestreza(5);        
		super.setForca(5);           
		super.setConstituicao(5);    
		super.setMira(10);           
		super.setTreinoArmas(10);    
		super.setAudacia(5);  
		*/
		
		//o nome vai para a classe Personagens
		super(name, id);
		
		if (name == null || name.length() < 1) {
			throw new IllegalArgumentException("Nome inv�lido");
		}
	}

	public String toString() {
		String result = "Personagem: --Feiticeiro--\n" + super.toString();
		return result;
	}
	//-------------------------------
	
	public String getName() {		
		return super.getName();
	}
	
	@Override
	public void powerPerLvl(int lvl) {
		
		setStatusBase(20);
		setInteligencia(15);
		setDestreza(5);
		setForca(5);
		setConstituicao(5);
		setMira(10);
		
		
		if (lvl > 1) {		
			for (int i = 0; i < lvl-1; i++) {
				setStatusBase(getStatusBase() + 20);
				setInteligencia(getInteligencia() + 12);
				setDestreza(getDestreza() + 0);
				setForca(getForca() + 0);
				setConstituicao(getConstituicao() + 2);
				setMira(getMira() + 6);
				
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
		super.inteligencia += 12;
		super.destreza += 0;
		super.forca += 0;
		super.constituicao += 2;
		super.mira += 6;
	}

}
