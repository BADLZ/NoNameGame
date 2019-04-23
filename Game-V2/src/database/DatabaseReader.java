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
import Personagens.Inventory;
import Personagens.Personagens;

public class DatabaseReader {
	
public static Personagens getPersonagem(int playerId) {
		
		Document document = readDocument("PlayerBase.xml");
		
		NodeList allPlayers = document.getElementsByTagName("id");
		
		Personagens result = null;
		
		for (int i = 0; i < allPlayers.getLength(); i++) {
			
			Node databaseName = allPlayers.item(i);
			if (databaseName.getNodeType() == Node.ELEMENT_NODE && databaseName.getTextContent().equals(playerId + "")) {
				
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
				String nomeJogador = atributos[1];
				String classe = atributos[2];
				int nivel = Integer.parseInt(atributos[3]);
				long xp = Long.parseLong(atributos[4]);
				long gold = Long.parseLong(atributos[5]);
				int audacia = Integer.parseInt(atributos[6]);
				int armas = Integer.parseInt(atributos[7]);
				
				switch (classe) {
				case "Cacador":
					Cacador c = new Cacador(nomeJogador, playerId);
					result = (Personagens) c;
					break;
				case "Feiticeiro":
					Feiticeiro f = new Feiticeiro(nomeJogador, playerId);
					result = (Personagens) f;
					break;
				case "Gladiador":
					Gladiador g = new Gladiador(nomeJogador, playerId);
					result = (Personagens) g;
					break;
				default:
					System.out.println("Error");
					break;
				}
				result.powerPerLvl(nivel);
				result.setNivel(nivel);
				result.setCurrentXp(xp);
				result.setCurrentGold(gold);
				result.setAudacia(audacia);
				result.setTreinoArmas(armas);
				
				break;
			}
		}
		return result;
	}

	
	public static Personagens getPersonagem(String nome) {
		
		Document document = readDocument("PlayerBase.xml");
		
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
				int id = Integer.parseInt(atributos[0]);
				String nomeJogador = atributos[1];
				String classe = atributos[2];
				int nivel = Integer.parseInt(atributos[3]);
				long xp = Long.parseLong(atributos[4]);
				long gold = Long.parseLong(atributos[5]);
				int audacia = Integer.parseInt(atributos[6]);
				int armas = Integer.parseInt(atributos[7]);
				
				switch (classe) {
				case "Cacador":
					Cacador c = new Cacador(nomeJogador, id);
					result = (Personagens) c;
					break;
				case "Feiticeiro":
					Feiticeiro f = new Feiticeiro(nomeJogador, id);
					result = (Personagens) f;
					break;
				case "Gladiador":
					Gladiador g = new Gladiador(nomeJogador, id);
					result = (Personagens) g;
					break;
				default:
					System.out.println("Error");
					break;
				}
				result.powerPerLvl(nivel);
				result.setNivel(nivel);
				result.setCurrentXp(xp);
				result.setCurrentGold(gold);
				result.setAudacia(audacia);
				result.setTreinoArmas(armas);
				
				break;
			}
		}
		return result;
	}
	
	public static int login(String name, char[] password) {
		Document document = DatabaseReader.readDocument("AccountBase.xml");
		
		NodeList allPlayers = document.getElementsByTagName("name");
		
		for (int i = 0; i < allPlayers.getLength(); i++) {
			
			Node databaseName = allPlayers.item(i);
			if (databaseName.getNodeType() == Node.ELEMENT_NODE && databaseName.getTextContent().equals(name)) {
				
				NodeList lista = databaseName.getParentNode().getChildNodes();
				
				String storedPass = "";
				int id = -1;
				for (int j = 0; j < lista.getLength(); j++) {
					Node m = lista.item(j);
					if(m.getNodeType() == Node.ELEMENT_NODE && m.getNodeName().equalsIgnoreCase("pass")) {
						storedPass = m.getTextContent();
					}else if(m.getNodeType() == Node.ELEMENT_NODE && m.getNodeName().equalsIgnoreCase("id")) {
						id = Integer.parseInt(m.getTextContent());
					}
				}
				if(storedPass.equals(String.valueOf(password)))
					return id;
				else
					return -1;
			}
		}
		
		return -1;
	}
	
	public static void readPlayerInventory(Personagens p) {
		
		
	}
	
	protected static Document readDocument(String textFile) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			return builder.parse(textFile);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected static boolean existsAccount(String name) {
		Document document = DatabaseReader.readDocument("AccountBase.xml");
		
		NodeList allPlayers = document.getElementsByTagName("name");
		
		for (int i = 0; i < allPlayers.getLength(); i++) {
			
			Node databaseName = allPlayers.item(i);
			if (databaseName.getNodeType() == Node.ELEMENT_NODE && databaseName.getTextContent().equals(name)) {
				return true;
			}
		}
		
		return false;
	}
	
	protected static int getNumberAccounts() {
		Document document = readDocument("AccountBase.xml");
		NodeList allPlayers = document.getElementsByTagName("totalNum");
		
		for (int i = 0; i < allPlayers.getLength(); i++) {
			
			Node databaseName = allPlayers.item(i);
			if (databaseName.getNodeType() == Node.ELEMENT_NODE) {
				return Integer.parseInt(databaseName.getTextContent());
			}
		}
		return -1;
		
	}
	
}
