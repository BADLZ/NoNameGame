package database;

import java.util.ArrayList;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Personagens.Personagens;

public class DatabaseWriter {
	
	public static boolean createNewPlayer(String name, String Class) {
		
		Document document = DatabaseReader.readDocument("PlayerBase.xml");
		
		
		try {
			
			Element root = document.getDocumentElement();

			Element newServer = document.createElement("player");

			Element nodeName = document.createElement("name");
			nodeName.appendChild(document.createTextNode(name));
			newServer.appendChild(nodeName);

			Element nodeClass = document.createElement("class");
			nodeClass.appendChild(document.createTextNode(Class));
			newServer.appendChild(nodeClass);
			
			Element nodeLvl = document.createElement("Level");
			nodeLvl.appendChild(document.createTextNode("1"));
			newServer.appendChild(nodeLvl);
			
			Element nodeXP = document.createElement("xp");
			nodeXP.appendChild(document.createTextNode("0"));
			newServer.appendChild(nodeXP);
			
			Element nodeGold = document.createElement("gold");
			nodeGold.appendChild(document.createTextNode("0"));
			newServer.appendChild(nodeGold);
			
			//TODO alteracoes (Pedro)
			Element nodeAudacia = document.createElement("audacia");
			nodeAudacia.appendChild(document.createTextNode("5"));
			newServer.appendChild(nodeAudacia);
			
			Element nodeArmas = document.createElement("armas");
			nodeArmas.appendChild(document.createTextNode("10"));
			newServer.appendChild(nodeArmas);
			
			Element nodeMoedasNegras = document.createElement("moedasNegras");
			nodeMoedasNegras.appendChild(document.createTextNode("0"));
			newServer.appendChild(nodeMoedasNegras);
			
			Element nodeFragmentos = document.createElement("fragmentos");
			nodeFragmentos.appendChild(document.createTextNode("0"));
			newServer.appendChild(nodeFragmentos);
			//ate aqui (Pedro)
			
			root.appendChild(newServer);

			DOMSource source = new DOMSource(document);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			StreamResult result = new StreamResult("PlayerBase.xml");
			transformer.transform(source, result);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean createAccout(String name, char[] password, String email) {
		
		if(DatabaseReader.existsAccount(name))
			return false;

		Document document = DatabaseReader.readDocument("AccountBase.xml");
		
		
		try {
			
			Element root = document.getDocumentElement();

			Element newServer = document.createElement("conta");
			
			Element nodeName = document.createElement("name");
			nodeName.appendChild(document.createTextNode(name));
			newServer.appendChild(nodeName);

			Element nodePass = document.createElement("pass");
			nodePass.appendChild(document.createTextNode(String.valueOf(password)));
			newServer.appendChild(nodePass);
			
			Element nodeEmail = document.createElement("email");
			nodeEmail.appendChild(document.createTextNode(email));
			newServer.appendChild(nodeEmail);

			root.appendChild(newServer);

			DOMSource source = new DOMSource(document);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			StreamResult result = new StreamResult("AccountBase.xml");
			transformer.transform(source, result);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	
	public static boolean storePlayer(Personagens p) {
		
		Document document = DatabaseReader.readDocument("PlayerBase.xml");
		
		try {
			NodeList allPlayers = document.getElementsByTagName("name");
			
			for (int i = 0; i < allPlayers.getLength(); i++) {
				
				Node databaseName = allPlayers.item(i);
				if (databaseName.getNodeType() == Node.ELEMENT_NODE && databaseName.getTextContent().equals(p.getName())) {
					
					
					NodeList lista = databaseName.getParentNode().getChildNodes();
					ArrayList<Node> nodes = new ArrayList<>();
					for (int j = 0; j < lista.getLength(); j++) {
						Node m = lista.item(j);
						if(m.getNodeType() == Node.ELEMENT_NODE) {
							nodes.add(m);
						}
					}
					
					nodes.get(2).setTextContent(p.getNivel() + "");
					nodes.get(3).setTextContent(p.getCurrentXp() + "");
					nodes.get(4).setTextContent(p.getCurrentGold() + "");
					//TODO alteracoes começam aqui (Pedro)
					//Basicamente, e preciso saber o numero exacto de
					//audacia e treinoArmas para a salaTreino.
					//ganhas moedas negras que sao forjadas para Fragmentos
					//a fazer missoes ou a comprar
					nodes.get(5).setTextContent(p.getAudacia()+ "");
					nodes.get(6).setTextContent(p.getTreinoArmas()+ "");
					nodes.get(7).setTextContent(p.getMoedasNegras() +"");
					nodes.get(8).setTextContent(p.getFragmentos() + "");
					//acabam aqui (Pedro)
					break;
				}
			}


			DOMSource source = new DOMSource(document);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			StreamResult result = new StreamResult("PlayerBase.xml");
			transformer.transform(source, result);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
