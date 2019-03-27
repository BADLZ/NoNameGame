package testesPedro;

import java.util.Scanner;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Personagens.Cacador;
import Personagens.Feiticeiro;
import Personagens.Gladiador;
import Personagens.Personagens;
import sergitoGames.Catacumbas;
import sergitoGames.Missoes;
import sergitoGames.SalaTreinos;
import Personagens.Npc;

public class Main {
	
	static int option;
	static int contador = 0;
	
	public static void main(String[] args) throws TransformerException {
		Document doc = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse("newPlayerBase.xml");			
			doc.getDocumentElement().normalize();			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		
		
		Main ma = new Main();
		Missoes m = new Missoes();
		Catacumbas c = new Catacumbas();
		//Feiticeiro badaxe = new Feiticeiro("di", 0);
		//Cacador badaxe = new Cacador("cacador");
		Gladiador badaxe = new Gladiador("Draven", 0);
		SalaTreinos s = new SalaTreinos();
		Npc npc = new Npc("PecadorEmEspera");
		
		Scanner sc = new Scanner(System.in);

		//Para termos os stats através do XML
		/*NodeList nomePlayers = doc.getElementsByTagName("name");		
		for (int i = 0; i < nomePlayers.getLength(); i++) {
			Node databaseName = nomePlayers.item(i);
			if (databaseName.getTextContent().equals(badaxe.getName())) {
				NodeList player = databaseName.getParentNode().getChildNodes();
				for (int j = 0; j < player.getLength(); j++) {*/
					//
					
		NodeList nomePlayers = doc.getElementsByTagName("player");
		for (int i = 0; i < nomePlayers.getLength(); i++) {
			Node databaseName = nomePlayers.item(i);
			NamedNodeMap attributes = databaseName.getAttributes();
			if(attributes.item(2).getNodeValue().equals(badaxe.getName())) {
				System.out.println("aqui");
				NodeList player = databaseName.getChildNodes();
				for (int j = 0; j < player.getLength(); j++) {
					Node no = player.item(j);
					if (no.getNodeName().equalsIgnoreCase("Level")) {
						badaxe.setNivel(Integer.parseInt(no.getTextContent()));
						System.out.println("Nivel Inicial "+badaxe.getNivel());
					}
					else if (no.getNodeName().equalsIgnoreCase("xp")) {
						badaxe.setCurrentXp(Long.parseLong(no.getTextContent()));
						System.out.println("Your XP "+badaxe.getCurrentXp());
					}
					else if (no.getNodeName().equalsIgnoreCase("gold")) {
						badaxe.setCurrentGold(Long.parseLong(no.getTextContent()));
						System.out.println("Your Gold "+badaxe.getCurrentGold());
					}
					else if (no.getNodeName().equalsIgnoreCase("audacia")) {
						badaxe.setAudacia(Integer.parseInt(no.getTextContent()));
						System.out.println("Audacia "+badaxe.getAudacia());
					}
					else if (no.getNodeName().equalsIgnoreCase("treinoArmas")) {
						badaxe.setTreinoArmas(Integer.parseInt(no.getTextContent()));
						System.out.println("Treino Armas "+badaxe.getTreinoArmas());
					}					
					else if (no.getNodeName().equalsIgnoreCase("moedasNegras")) {
						badaxe.setMoedasNegras(Integer.parseInt(no.getTextContent()));
						System.out.println("Moedas "+badaxe.getMoedasNegras());
					}
					else if (no.getNodeName().equalsIgnoreCase("fragmentos")) {
						badaxe.setFragmentos(Integer.parseInt(no.getTextContent()));
						System.out.println("Fragmentos "+badaxe.getFragmentos()+"\n");
					}
				}
			}
		}
		
		do {
			System.out.println("1 - Missions");
			System.out.println("2 - First Floor");
			System.out.println("3 - Second Floor");
			System.out.println("4 - Hyperbolic Time Chamber");;
			System.out.println("0 - Exit Game");
			System.out.print("Option --> ");
			option = sc.nextInt();
			System.out.println();
			
			
			switch (option) {
			
			case 1: 
				if (badaxe.getNivel() == 1) {
					m.firstMission(badaxe);
				}
				else {
					m.choseMission(badaxe, badaxe.getNivel());
				}	
				break;
				
			case 2:
				c.number1(badaxe);
				break;
				
			case 3:
				c.number2(badaxe);
				break;	
			
			case 4:
				s.escolherTreino(badaxe);
				break;

		}
			//gravar no XML 
			NodeList players = doc.getElementsByTagName("player");
			for (int i = 0; i < players.getLength(); i++) {
				Node playerInfo = players.item(i);
				NamedNodeMap attributes = playerInfo.getAttributes();
				if(attributes.item(2).getNodeValue().equals(badaxe.getName())) {

					NodeList info = playerInfo.getChildNodes();
					for (int j = 0; j < info.getLength(); j++) {
						Node lvl = info.item(j);							
						if (lvl.getNodeName().equalsIgnoreCase("Level")) {
							lvl.setTextContent(Integer.toString(badaxe.getNivel()));								
						}
						else if (lvl.getNodeName().equalsIgnoreCase("xp")) {
							lvl.setTextContent(Long.toString(badaxe.getCurrentXp()));
						}
						else if (lvl.getNodeName().equalsIgnoreCase("gold")) {
							lvl.setTextContent(Long.toString(badaxe.getCurrentGold()));
						}
						else if (lvl.getNodeName().equalsIgnoreCase("treinoArmas")) {
							lvl.setTextContent(Integer.toString(badaxe.getTreinoArmas()));
						}
						else if (lvl.getNodeName().equalsIgnoreCase("audacia")) {
							lvl.setTextContent(Integer.toString(badaxe.getAudacia()));
						}
						else if (lvl.getNodeName().equalsIgnoreCase("moedasNegras")) {
							lvl.setTextContent(Integer.toString(badaxe.getMoedasNegras()));
						}
						else if (lvl.getNodeName().equalsIgnoreCase("fragmentos")) {
							lvl.setTextContent(Integer.toString(badaxe.getFragmentos()));
						}
					}
				}
			}
			
			Transformer xformer = TransformerFactory.newInstance().newTransformer();
		    xformer.transform
		        (new DOMSource(doc), new StreamResult(("newPlayerBase.xml")));	

		} while (option!=0);
		System.out.println("@axe.bad");


	}	

}
