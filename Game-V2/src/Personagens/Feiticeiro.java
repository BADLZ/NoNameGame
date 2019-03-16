package Personagens;

public class Feiticeiro extends Personagens {
	
	String name;
	
	//-------------------------------	
	public Feiticeiro(String name) {
		/*super.setStatusBase(40);     
		super.setInteligencia(15);   
		super.setDestreza(5);        
		super.setForca(5);           
		super.setConstituicao(5);    
		super.setMira(10);           
		super.setTreinoArmas(10);    
		super.setAudacia(5);  
		*/
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
		
		setStatusBase(20);
		setInteligencia(15);
		setDestreza(5);
		setForca(5);
		setConstituicao(5);
		setMira(10);
		setTreinoArmas(10);
		setAudacia(5);
		
		if (lvl > 1) {		
			for (int i = 0; i < lvl-1; i++) {
				setStatusBase(getStatusBase() + 20);
				setInteligencia(getInteligencia() + 12);
				setDestreza(getDestreza() + 0);
				setForca(getForca() + 0);
				setConstituicao(getConstituicao() + 2);
				setMira(getMira() + 6);
				setTreinoArmas(getTreinoArmas() + 0);
				setAudacia(getAudacia() + 0);
			}
		}
		
		System.out.println("Nivel "+getNivel());
		System.out.println("forcaBase "+getStatusBase());
		System.out.println("inteligencia "+getInteligencia());
		System.out.println("destreza "+getDestreza());
		System.out.println("forca "+getForca());
		System.out.println("constituicao "+getConstituicao());
		System.out.println("mira "+getMira());
		System.out.println("treinoArmas "+getTreinoArmas());
		System.out.println("Audacia "+getAudacia());
		
	}

}
