package database;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Personagens.Cacador;
import Personagens.Feiticeiro;
import Personagens.Gladiador;
import Personagens.Personagens;

public class DatabaseReader {
	
	public static Personagens getPersonagem(String nome) {
		
		Document document = readDocument();
		
		NodeList allPlayers = document.getElementsByTagName("name");
		
		Personagens result = null;
		
		for (int i = 0; i < allPlayers.getLength(); i++) {
			
			Node databaseName = allPlayers.item(i);
			if (databaseName.getNodeType() == Node.ELEMENT_NODE && databaseName.getTextContent().equals(nome)) {
				
				StringBuilder s = new StringBuilder();
				
				NodeList lista = databaseName.getParentNode().getChildNodes();
				
				for (int j = 0; j < lista.getLength(); j++) {
					Node m = lista.item(j);
					if(m.getNodeType() == Node.ELEMENT_NODE) {
						s.append(m.getTextContent() + "\n");
					}
				}
				
				//id
				//classe
				//nivel
				//xp
				//gold
				
				String[] atributos = s.toString().split("\n");
				String nomeJogador = atributos[0];
				String classe = atributos[1];
				int nivel = Integer.parseInt(atributos[2]);
				long xp = Long.parseLong(atributos[3]);
				long gold = Long.parseLong(atributos[4]);
				
				switch (classe) {
				case "Cacador":
					Cacador c = new Cacador(nomeJogador);
					c.powerPerLvl(nivel);
					result = (Personagens) c;
					break;
				case "Feiticeiro":
					Feiticeiro f = new Feiticeiro(nomeJogador);
					f.powerPerLvl(nivel);
					result = (Personagens) f;
					break;
				case "Gladiador":
					Gladiador g = new Gladiador(nomeJogador);
					g.powerPerLvl(nivel);
					result = (Personagens) g;
					break;
				default:
					System.out.println("Error");
					break;
				}
				
				result.setNivel(nivel);
				result.setCurrentXp(xp);
				result.setCurrentGold(gold);
				
				break;
			}
		}
		return result;
	}
	
	public static Document readDocument() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			return builder.parse("PlayerBase.xml");

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
