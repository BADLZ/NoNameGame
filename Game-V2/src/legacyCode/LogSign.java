package legacyCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

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


public class LogSign {

	private Document document;

	public static void main(String args[]) {
		LogSign m = new LogSign();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Username: ");
		String username = sc.nextLine();
		
		System.out.print("Categoria: ");
		String categoria = sc.nextLine();
		while (!categoria.equalsIgnoreCase("Gladiador") 
				&& !categoria.equalsIgnoreCase("Feiticeiro")
				&& !categoria.equalsIgnoreCase("Cacador")) {
			System.out.print("Categoria Inválida! ");
			categoria = sc.nextLine();
		}
		
		//m.login("Sergito");
		m.CreateNewPlayer(username, categoria);
		sc.close();
	}

	public NodeList login(String name) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			document = builder.parse("PlayerBase.xml");

		} catch (Exception e) {

		}

		NodeList allPlayers = document.getElementsByTagName("name");

		for (int i = 0; i < allPlayers.getLength(); i++) {
			Node databaseName = allPlayers.item(i);
			if (databaseName.getNodeType() == Node.ELEMENT_NODE && databaseName.getTextContent().equals(name)) {
				NodeList lista = databaseName.getParentNode().getChildNodes();
				for (int j = 0; j < lista.getLength(); j++) {
					Node m = lista.item(j);
					if (m.getNodeName().equalsIgnoreCase("class")) {
						System.out.println("Welcome back " + m.getTextContent() + ": " + name);
						return lista;
					}
				}
			}
		}
		return null;
	}

	public void CreateNewPlayer(String name, String Class) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse("PlayerBase.xml");
			
			Element root = document.getDocumentElement();

			Element newServer = document.createElement("player");

			Element nodeName = document.createElement("name");
			nodeName.appendChild(document.createTextNode(name));
			newServer.appendChild(nodeName);

			Element nodeClass = document.createElement("class");
			nodeClass.appendChild(document.createTextNode(Class));
			newServer.appendChild(nodeClass);
			
			Element nodeLvl = document.createElement("level");
			nodeLvl.appendChild(document.createTextNode("1"));
			newServer.appendChild(nodeLvl);
			
			Element nodeXp = document.createElement("xp");
			nodeXp.appendChild(document.createTextNode("0"));
			newServer.appendChild(nodeXp);
			
			Element nodeGold = document.createElement("Gold");
			nodeGold.appendChild(document.createTextNode("0"));
			newServer.appendChild(nodeGold);
			
			/*Element nodeStatus = document.createElement("statusBase");
			nodeStatus.appendChild(document.createTextNode("40"));
			newServer.appendChild(nodeStatus);
			
			Element nodeInt = document.createElement("inteligencia");
			if (Class.equalsIgnoreCase("feiticeiro")) {
				nodeInt.appendChild(document.createTextNode("15"));
			}
			else if (Class.equalsIgnoreCase("Gladiador")) {
				nodeInt.appendChild(document.createTextNode("5"));
			}
			else {
				nodeInt.appendChild(document.createTextNode("5"));
			}		
			newServer.appendChild(nodeInt);
			
			Element nodeDestreza = document.createElement("destreza");
			if (Class.equalsIgnoreCase("feiticeiro")) {
				nodeDestreza.appendChild(document.createTextNode("5"));
			}
			else if (Class.equalsIgnoreCase("Gladiador")) {
				nodeDestreza.appendChild(document.createTextNode("5"));
			}
			else {
				nodeDestreza.appendChild(document.createTextNode("10"));
			}
			newServer.appendChild(nodeDestreza);
			
			Element nodeForca = document.createElement("forca");
			if (Class.equalsIgnoreCase("feiticeiro")) {
				nodeForca.appendChild(document.createTextNode("5"));
			}
			else if (Class.equalsIgnoreCase("Gladiador")) {
				nodeForca.appendChild(document.createTextNode("12"));
			}
			else {
				nodeForca.appendChild(document.createTextNode("5"));
			}
			newServer.appendChild(nodeForca);
			
			Element nodeCons = document.createElement("constituicao");
			if (Class.equalsIgnoreCase("feiticeiro")) {
				nodeCons.appendChild(document.createTextNode("5"));
			}
			else if (Class.equalsIgnoreCase("Gladiador")) {
				nodeCons.appendChild(document.createTextNode("12"));
			}
			else {
				nodeCons.appendChild(document.createTextNode("10"));
			}
			newServer.appendChild(nodeCons);
			
			Element nodeMira = document.createElement("mira");
			if (Class.equalsIgnoreCase("feiticeiro")) {
				nodeMira.appendChild(document.createTextNode("10"));
			}
			else if (Class.equalsIgnoreCase("Gladiador")) {
				nodeMira.appendChild(document.createTextNode("6"));
			}
			else {
				nodeMira.appendChild(document.createTextNode("10"));
			}
			newServer.appendChild(nodeMira);
			*/
			Element nodeArmas = document.createElement("treinoArmas");
			if (Class.equalsIgnoreCase("feiticeiro")) {
				nodeArmas.appendChild(document.createTextNode("10"));
			}
			else if (Class.equalsIgnoreCase("Gladiador")) {
				nodeArmas.appendChild(document.createTextNode("10"));
			}
			else {
				nodeArmas.appendChild(document.createTextNode("10"));
			}
			newServer.appendChild(nodeArmas);
			
			Element nodeAud = document.createElement("audacia");
			if (Class.equalsIgnoreCase("feiticeiro")) {
				nodeAud.appendChild(document.createTextNode("5"));
			}
			else if (Class.equalsIgnoreCase("Gladiador")) {
				nodeAud.appendChild(document.createTextNode("5"));
			}
			else {
				nodeAud.appendChild(document.createTextNode("5"));
			}
			newServer.appendChild(nodeAud);

			root.appendChild(newServer);

			DOMSource source = new DOMSource(document);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			StreamResult result = new StreamResult("PlayerBase.xml");
			transformer.transform(source, result);
		} catch (Exception e) {

		}
	}
}
