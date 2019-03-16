package sergitoGames;

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
			
			Element nodeLvl = document.createElement("Level");
			nodeLvl.appendChild(document.createTextNode("1"));
			newServer.appendChild(nodeLvl);

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
