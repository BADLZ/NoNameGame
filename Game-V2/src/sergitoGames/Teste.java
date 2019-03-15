package sergitoGames;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document doc = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse("PlayerBase.xml");			
			doc.getDocumentElement().normalize();			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		Teste t = new Teste();
		
		System.out.println(t.knowUser(doc, "BAD AXE"));
		System.out.println(t.tipoCategoria(doc, "BAD AXE"));
		System.out.println(t.nivelPlayer(doc, "BAD AXE"));
		System.out.println();
		System.out.println(t.knowUser(doc, "Sergito"));
		System.out.println(t.tipoCategoria(doc, "Sergito"));
		System.out.println(t.nivelPlayer(doc, "Sergito"));
		System.out.println();
		System.out.println(t.knowUser(doc, "Soldadinho"));
		System.out.println(t.tipoCategoria(doc, "Soldadinho"));
		System.out.println(t.nivelPlayer(doc, "Soldadinho"));		
	}
	
	//Working
	public boolean knowUser(Document doc, String p) {
		NodeList players = doc.getElementsByTagName("player");
		for (int i = 0; i < players.getLength(); i++) {
			Element name = (Element) players.item(i);				
			NodeList getName = name.getElementsByTagName("name");		
			for (int j = 0; j < getName.getLength(); j++) {
				if (getName.item(j).getTextContent().equals(p)) {
					return true;
				}
			}			
		}
		return false;
	}
	
	//Working
	public String tipoCategoria(Document doc, String p) {
		
		NodeList players = doc.getElementsByTagName("player");
		for (int i = 0; i < players.getLength(); i++) {
			Element el = (Element) players.item(i);
			NodeList name = el.getElementsByTagName("name");
			
			for (int j = 0; j < name.getLength(); j++) {
				if (name.item(j).getTextContent().equals(p)) {
					NodeList classe = el.getElementsByTagName("class");
					return classe.item(j).getTextContent();
				}
			}
		}		
		return null;
	}
	
	//Working
	public String nivelPlayer(Document doc, String p) {
		
		NodeList players = doc.getElementsByTagName("player");
		for (int i = 0; i < players.getLength(); i++) {
			Element el = (Element) players.item(i);
			NodeList name = el.getElementsByTagName("name");
			
			for (int j = 0; j < name.getLength(); j++) {
				if (name.item(j).getTextContent().equals(p)) {
					NodeList nivel = el.getElementsByTagName("Level");
					return nivel.item(j).getTextContent();
				}
			}
		}		
		return null;
	}

}
