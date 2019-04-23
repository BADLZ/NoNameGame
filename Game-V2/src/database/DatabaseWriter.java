package database;

import java.util.ArrayList;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Personagens.Personagens;
import accessory.Accessory;
import accessory.Arma;

public class DatabaseWriter {

	public static boolean createNewPlayer(String name, String Class, int id) {

		Document document = DatabaseReader.readDocument("PlayerBase.xml");

		System.out.println(name + " " + Class + " " + id);
		try {

			Element root = document.getDocumentElement();

			Element newServer = document.createElement("player");

			Element nodeId = document.createElement("id");
			nodeId.appendChild(document.createTextNode("" +id));
			newServer.appendChild(nodeId);
			
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

			Element nodeAudacia = document.createElement("audacia");
			nodeAudacia.appendChild(document.createTextNode("5"));
			newServer.appendChild(nodeAudacia);

			Element nodeArmas = document.createElement("treinoArmas");
			nodeArmas.appendChild(document.createTextNode("10"));
			newServer.appendChild(nodeArmas);

			Element nodeMoedasNegras = document.createElement("moedasNegras");
			nodeMoedasNegras.appendChild(document.createTextNode("0"));
			newServer.appendChild(nodeMoedasNegras);

			Element nodeFragmentos = document.createElement("fragmentos");
			nodeFragmentos.appendChild(document.createTextNode("0"));
			newServer.appendChild(nodeFragmentos);
			
			root.appendChild(newServer);
			storeInfo(document, "PlayerBase.xml");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
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

			Element nodeId = document.createElement("id");
			nodeId.appendChild(document.createTextNode("" + (DatabaseReader.getNumberAccounts() + 1)));
			newServer.appendChild(nodeId);
			
			Element nodeEmail = document.createElement("email");
			nodeEmail.appendChild(document.createTextNode(email));
			newServer.appendChild(nodeEmail);

			root.appendChild(newServer);

			storeInfo(document, "AccountBase.xml");

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void storeInv(Personagens p) {
		Document document = DatabaseReader.readDocument("ItemBase.xml");
		
		try {
			NodeList allPlayers = document.getElementsByTagName("playerid");
			boolean hadInv = false;
			for (int i = 0; i < allPlayers.getLength(); i++) {
				Node playerNode = allPlayers.item(i);
				if (playerNode.getNodeType() == Node.ELEMENT_NODE && playerNode.getTextContent().equals(String.valueOf(p.getId()))) {
					hadInv = true;
					playerNode = playerNode.getParentNode();
					
					
					NodeList playerNodes = playerNode.getChildNodes();
					
					Node equippedNode = null;
					Node invNode = null;
					for(int j = 0; j < playerNodes.getLength(); j++) {
						Node n = playerNodes.item(j);
						if(n.getNodeType() == Node.ELEMENT_NODE) {
							if(n.getNodeName().equalsIgnoreCase("inv"))
								invNode = n;
							else if(n.getNodeName().equalsIgnoreCase("equipped"))
								equippedNode = n;
						}
					}
					Node parent = playerNode;
					
					if(equippedNode != null)
						parent.removeChild(equippedNode);
					if(invNode != null)
						parent.removeChild(invNode);
					
					Node inventoryNode = getInvNode("inv", p.getInventory().getInv(), document);
					parent.appendChild(inventoryNode);
					
					Node equipNode = getInvNode("equipped", p.getInventory().getEquipped(), document);
					parent.appendChild(equipNode);
					
//					for(int j = playerNodes.getLength() - 1; j >= 0; j--) {
//						playerNode.removeChild(playerNodes.item(j));
//					}
					
				}
			}
			if(!hadInv) {
				//cria novo inv
				Element root = document.getDocumentElement();
				Element playerNode = document.createElement("player");
				Element playerId = document.createElement("playerid");
				playerId.setTextContent(String.valueOf(p.getId()));
				Node invNode = getInvNode("inv", p.getInventory().getInv(), document);
				Node equippedNode = getInvNode("equipped", p.getInventory().getEquipped(), document);
				
				playerNode.appendChild(playerId);
				playerNode.appendChild(invNode);
				playerNode.appendChild(equippedNode);
				
				root.appendChild(playerNode);
				
			}
			
			
			storeInfo(document, "ItemBase.xml");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected static Node getInvNode(String nodeName, ArrayList<Accessory> inventory, Document document) {
		Element invNode = document.createElement(nodeName);
		for(Accessory item: inventory) {
			Node itemNode = getAccessoryNode(item, document);
			invNode.appendChild(itemNode);
		}
		return invNode;
	}

	
	protected static Node getAccessoryNode(Accessory item, Document document) {
		Element e = document.createElement("item");
		Element name = document.createElement("name");
		Element type = document.createElement("type");
		Element lvl = document.createElement("lvl");
		
		name.setTextContent(item.getName());
		type.setTextContent(item.getType());
		lvl.setTextContent("" + item.getLevel());
		
		e.appendChild(name);
		e.appendChild(type);
		e.appendChild(lvl);
		
		if(item instanceof Arma) {
			Element damage = document.createElement("damage");
			Arma a = (Arma) item;
			damage.setTextContent("" + a.getDamage());
			e.appendChild(damage);
		}
		
		return e;
	}


	public static boolean storePlayer(Personagens p) {
		//falta meter para id
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

					nodes.get(3).setTextContent(p.getNivel() + "");
					nodes.get(4).setTextContent(p.getCurrentXp() + "");
					nodes.get(5).setTextContent(p.getCurrentGold() + "");
					//TODO alteracoes começam aqui (Pedro)
					//Basicamente, e preciso saber o numero exacto de
					//audacia e treinoArmas para a salaTreino.
					//ganhas moedas negras que sao forjadas para Fragmentos
					//a fazer missoes ou a comprar
					nodes.get(6).setTextContent(p.getAudacia()+ "");
					nodes.get(7).setTextContent(p.getTreinoArmas()+ "");
					nodes.get(8).setTextContent(p.getMoedasNegras() +"");
					nodes.get(9).setTextContent(p.getFragmentos() + "");
					//acabam aqui (Pedro)
					break;
				}
			}

			
			storeInfo(document, "PlayerBase.xml");
			
			return true;
		} 
		//		catch (IndexOutOfBoundsException e) {
		//			//tenho que fazer algo quando na database do jogador faltam parametros
		//			deletePlayer(p.getName());
		//			createNewPlayer(p.getName(), "Cacador");
		//			storePlayer(p);
		//			return true;
		//		} 
		catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}
	
	protected static boolean storeInventory(Personagens p, ArrayList<Accessory> inv, ArrayList<Accessory> equipedInv, Document document) {
		//ainda tenho que fazer
		return false;
	}

	public static boolean deletePlayer(String name) {
		Document document = DatabaseReader.readDocument("PlayerBase.xml");

		NodeList allPlayers = document.getElementsByTagName("name");

		for (int i = 0; i < allPlayers.getLength(); i++) {

			Node databaseName = allPlayers.item(i);
			if (databaseName.getNodeType() == Node.ELEMENT_NODE && databaseName.getTextContent().equals(name)) {
				
				Node player = databaseName.getParentNode();
				player.getParentNode().removeChild(player);

				try {
					storeInfo(document, "PlayerBase.xml");
				} catch (TransformerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
		}

		return false;

	}

	protected static void storeInfo(Document document, String txtFile) throws TransformerException {

		DOMSource source = new DOMSource(document);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		
		transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		StreamResult result = new StreamResult(txtFile);
		transformer.transform(source, result);
		

	}


}
