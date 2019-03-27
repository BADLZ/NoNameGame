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
import sergitoGames.Pvp;
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
		Feiticeiro feit = new Feiticeiro("@axe.bad", 1);
		Cacador teste = new Cacador("EuEraOViolador", 2);
		Gladiador badaxe = new Gladiador("Draven", 0);
		SalaTreinos s = new SalaTreinos();
		Npc npc = new Npc("PecadorEmEspera");
		Pvp pv = new Pvp();
		
		Scanner sc = new Scanner(System.in);	
		
		ma.readPlayer(doc, badaxe);
		ma.readPlayer(doc, teste);
		ma.readPlayer(doc, feit);
		
		do {
			System.out.println("1 - Missions");
			System.out.println("2 - First Floor");
			System.out.println("3 - Second Floor");
			System.out.println("4 - Hyperbolic Time Chamber");
			System.out.println("5 - PVP");
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
				
			case 5:
				pv.battlePVP(badaxe, feit);
				break;

		}
			
			ma.writePlayer(doc, badaxe);
			
			Transformer xformer = TransformerFactory.newInstance().newTransformer();
		    xformer.transform
		        (new DOMSource(doc), new StreamResult(("newPlayerBase.xml")));	

		} while (option!=0);
		System.out.println("@axe.bad");

	}	
	
	
	public void readPlayer(Document doc, Personagens p) {
		
		System.out.println("Stats de "+p.getName()+"\n");
		
		NodeList nomePlayers = doc.getElementsByTagName("player");
		for (int i = 0; i < nomePlayers.getLength(); i++) {
			Node databaseName = nomePlayers.item(i);
			NamedNodeMap attributes = databaseName.getAttributes();
			if(attributes.item(2).getNodeValue().equals(p.getName())) {
				NodeList player = databaseName.getChildNodes();
				for (int j = 0; j < player.getLength(); j++) {
					Node no = player.item(j);
					if (no.getNodeName().equalsIgnoreCase("Level")) {
						p.setNivel(Integer.parseInt(no.getTextContent()));
						System.out.println("Nivel Inicial "+p.getNivel());
					}
					else if (no.getNodeName().equalsIgnoreCase("xp")) {
						p.setCurrentXp(Long.parseLong(no.getTextContent()));
						System.out.println("Your XP "+p.getCurrentXp());
					}
					else if (no.getNodeName().equalsIgnoreCase("gold")) {
						p.setCurrentGold(Long.parseLong(no.getTextContent()));
						System.out.println("Your Gold "+p.getCurrentGold());
					}
					else if (no.getNodeName().equalsIgnoreCase("audacia")) {
						p.setAudacia(Integer.parseInt(no.getTextContent()));
						System.out.println("Audacia "+p.getAudacia());
					}
					else if (no.getNodeName().equalsIgnoreCase("treinoArmas")) {
						p.setTreinoArmas(Integer.parseInt(no.getTextContent()));
						System.out.println("Treino Armas "+p.getTreinoArmas());
					}					
					else if (no.getNodeName().equalsIgnoreCase("moedasNegras")) {
						p.setMoedasNegras(Integer.parseInt(no.getTextContent()));
						System.out.println("Moedas "+p.getMoedasNegras());
					}
					else if (no.getNodeName().equalsIgnoreCase("fragmentos")) {
						p.setFragmentos(Integer.parseInt(no.getTextContent()));
						System.out.println("Fragmentos "+p.getFragmentos()+"\n");
					}
				}
			}
		}
	}
	
	public void writePlayer(Document doc, Personagens p) {
		NodeList players = doc.getElementsByTagName("player");
		for (int i = 0; i < players.getLength(); i++) {
			Node playerInfo = players.item(i);
			NamedNodeMap attributes = playerInfo.getAttributes();
			if(attributes.item(2).getNodeValue().equals(p.getName())) {

				NodeList info = playerInfo.getChildNodes();
				for (int j = 0; j < info.getLength(); j++) {
					Node lvl = info.item(j);							
					if (lvl.getNodeName().equalsIgnoreCase("Level")) {
						lvl.setTextContent(Integer.toString(p.getNivel()));								
					}
					else if (lvl.getNodeName().equalsIgnoreCase("xp")) {
						lvl.setTextContent(Long.toString(p.getCurrentXp()));
					}
					else if (lvl.getNodeName().equalsIgnoreCase("gold")) {
						lvl.setTextContent(Long.toString(p.getCurrentGold()));
					}
					else if (lvl.getNodeName().equalsIgnoreCase("treinoArmas")) {
						lvl.setTextContent(Integer.toString(p.getTreinoArmas()));
					}
					else if (lvl.getNodeName().equalsIgnoreCase("audacia")) {
						lvl.setTextContent(Integer.toString(p.getAudacia()));
					}
					else if (lvl.getNodeName().equalsIgnoreCase("moedasNegras")) {
						lvl.setTextContent(Integer.toString(p.getMoedasNegras()));
					}
					else if (lvl.getNodeName().equalsIgnoreCase("fragmentos")) {
						lvl.setTextContent(Integer.toString(p.getFragmentos()));
					}
				}
			}
		}
	}

}
