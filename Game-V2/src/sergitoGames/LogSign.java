package sergitoGames;


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



public class LogSign{

	private Document document;
	
	public LogSign() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			document = builder.parse("PlayerBase.xml");

		} catch (Exception e) {

		}
	}
	public String login(String name) {

		StringBuilder s = new StringBuilder();
		
		NodeList allPlayers = document.getElementsByTagName("name");

		for (int i = 0; i < allPlayers.getLength(); i++) {
			Node databaseName = allPlayers.item(i);
			if (databaseName.getNodeType() == Node.ELEMENT_NODE && databaseName.getTextContent().equals(name)) {
				NodeList lista = databaseName.getParentNode().getChildNodes();
				for (int j = 0; j < lista.getLength(); j++) {
					Node m = lista.item(j);
					if(m.getNodeType() == Node.ELEMENT_NODE) {
						s.append(m.getTextContent());
						
					}
				}
				return s.toString();
			}
		}
		return null;
	}

	public void CreateNewPlayer(String name, String Class) {
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
