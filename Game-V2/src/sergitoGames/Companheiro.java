package sergitoGames;

import java.util.Scanner;

import Personagens.Personagens;

public class Companheiro {
	
	//TODO tem que estar a lvl 50 
	//Não estou a incluir esta parte agora para conseguir testar
	public void choseCompanheiro(Personagens p) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Some fancy text");
		System.out.println("1 - forca 200 // Constituicao 90");
		System.out.println("2 - destreza 550 // Constituicao 55");
		System.out.println("3 - inteligencia 800 // Constituicao 30");
		System.out.print("Option (1/2/3) ---> ");
		int choice = sc.nextInt();
		while (choice < 1 || choice > 3) {
			System.out.print("Option (1/2/3) ---> ");
			choice = sc.nextInt();
		}
		
		switch (choice) {
		
		case 1:
			p.setCForca(200);
			p.setCDestreza(0);
			p.setCInteligencia(0);
			p.setCons(90);
			break;
		
		case 2:
			p.setCForca(0);
			p.setCDestreza(550);
			p.setCInteligencia(0);
			p.setCons(55);
			break;
		
		case 3:
			p.setCForca(0);
			p.setCDestreza(0);
			p.setCInteligencia(800);
			p.setCons(30);
			break;

		}	
		p.setTipo(choice);
		System.out.println();

	}



}
