package Personagens;

public class Cacador extends Personagens {
	
//	String name;
	//-------------------------------
	public Cacador(String name) {
		//o nome vai para a classe Personagens
		super(name);
		if (name == null || name.length() < 1) {
			throw new IllegalArgumentException("Nome inválido");
		}

		
	}
	
	public String toString() {
		String result = "Personagem: --Cacador--\n" + super.toString();
		return result;
	}
	//-------------------------------
	
	public String getName() {		
		return super.getName();
	}

	@Override
	public void powerPerLvl(int lvl) {		
		setStatusBase(20);
		setInteligencia(5);
		setDestreza(10);
		setForca(5);
		setConstituicao(10);
		setMira(10);
		
		
		if (lvl > 1) {		
			for (int i = 0; i < lvl-1; i++) {
				//falta atualizar os gets
				setStatusBase(getStatusBase() + 20);
				setInteligencia(getInteligencia() + 0);
				setDestreza(getDestreza() + 7);
				setForca(getForca() + 0);
				setConstituicao(getConstituicao() + 7);
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
		super.inteligencia += 0;
		super.destreza += 0;
		super.forca += 6;
		super.constituicao += 11;
		super.mira += 3;
		
	}

}
