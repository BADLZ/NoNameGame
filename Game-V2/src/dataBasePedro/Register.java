package dataBasePedro;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import legacyCode.LogSign;

public class Register {


	public static void main(String args[]) {
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
		
		Register m = new Register();
		
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
		
		String newGuyId = m.availableId(doc);
		//String newGuyId = "2";
		m.registPlayerBase(username, categoria, newGuyId);
		m.registAccounBase(username, newGuyId);
		m.registAcessoryBase(username, categoria, newGuyId);
		sc.close();
		
		//System.out.println(m.availableId(doc));
	}
	
	public String availableId(Document doc) {
		
		XPath xpath = XPathFactory.newInstance().newXPath();
		String expressao = "//player[last()]/@id";
		String ret = null;
		try {
			ret = (String) xpath.evaluate(expressao, doc,
						XPathConstants.STRING);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		int retorno = Integer.parseInt(ret)+1;

		return Integer.toString(retorno);
		
	
	}

	public boolean registPlayerBase(String name, String classe, String id) {
		
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse("newPlayerBase.xml");
			DOMSource source = new DOMSource(document);
			
			//DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			//DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			//document = dBuilder.parse("newPlayerBase.xml");			
			//document.getDocumentElement().normalize();	
			
			Element root = document.getDocumentElement();
			
			Element newPlayer = document.createElement("player");
			((Element) newPlayer).setAttribute("name", name);
			((Element) newPlayer).setAttribute("class", classe);
			((Element) newPlayer).setAttribute("id", id);
			//id
			Element nodeLvl = document.createElement("level");
			nodeLvl.appendChild(document.createTextNode("1"));
			newPlayer.appendChild(nodeLvl);
			
			Element nodeXp = document.createElement("xp");
			nodeXp.appendChild(document.createTextNode("0"));
			newPlayer.appendChild(nodeXp);
			
			Element nodeGold = document.createElement("gold");
			nodeGold.appendChild(document.createTextNode("0"));
			newPlayer.appendChild(nodeGold);
			
			Element nodeAudacia = document.createElement("audacia");
			nodeAudacia.appendChild(document.createTextNode("5"));
			newPlayer.appendChild(nodeAudacia);
			
			Element nodeArmas = document.createElement("treinoArmas");
			nodeArmas.appendChild(document.createTextNode("10"));
			newPlayer.appendChild(nodeArmas);
			
			Element nodeMoedas = document.createElement("moedas");
			nodeMoedas.appendChild(document.createTextNode("0"));
			newPlayer.appendChild(nodeMoedas);
			
			Element nodeFragmentos = document.createElement("fragmentos");
			nodeFragmentos.appendChild(document.createTextNode("0"));
			newPlayer.appendChild(nodeFragmentos);
			
			//Companheiro
			Element companheiro = document.createElement("companheiro");
			
			Element nodeTipo = document.createElement("tipo");
			nodeTipo.appendChild(document.createTextNode("0"));
			companheiro.appendChild(nodeTipo);
			
			
			Element nodeCons = document.createElement("constituicao");
			nodeCons.appendChild(document.createTextNode("0"));
			companheiro.appendChild(nodeCons);
			
			//basico
			Element basico = document.createElement("basico");
			
			Element nodeCF = document.createElement("cforca");
			nodeCF.appendChild(document.createTextNode("0"));
			basico.appendChild(nodeCF);
			
			Element nodeCD = document.createElement("cdestreza");
			nodeCD.appendChild(document.createTextNode("0"));
			basico.appendChild(nodeCD);
			
			Element nodeCI = document.createElement("cinteligencia");
			nodeCI.appendChild(document.createTextNode("0"));
			basico.appendChild(nodeCI);
			
			companheiro.appendChild(basico);
			
			newPlayer.appendChild(companheiro);
			
			root.appendChild(newPlayer);			
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			StreamResult result = new StreamResult("newPlayerBase.xml");
			transformer.transform(source, result);
			
			return true;
		} catch (Exception e) {}
		
		return false;
	}

	
	public boolean registAccounBase(String name, String id) {
		
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse("newAccountBase.xml");
			DOMSource source = new DOMSource(document);
			
			Element root = document.getDocumentElement();
			
			Element newPlayer = document.createElement("conta");
			((Element) newPlayer).setAttribute("name", name);
			((Element) newPlayer).setAttribute("id", id);
			//id
			Element nodePass = document.createElement("pass");
			nodePass.appendChild(document.createTextNode("1234"));
			newPlayer.appendChild(nodePass);
			
			Element nodeEmail = document.createElement("email");
			nodeEmail.appendChild(document.createTextNode("something"));
			newPlayer.appendChild(nodeEmail);
			
			root.appendChild(newPlayer);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			StreamResult result = new StreamResult("newAccountBase.xml");
			transformer.transform(source, result);
			return true;
		} catch (Exception e) {}
		
		return false;
	}
	
	public boolean registAcessoryBase(String name, String category, String id) {
		
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse("newAcessoryBase.xml");
			DOMSource source = new DOMSource(document);
			
			Element root = document.getDocumentElement();
			
			Element newPlayer = document.createElement("acessorio");
			((Element) newPlayer).setAttribute("name", name);
			((Element) newPlayer).setAttribute("id", id);
			((Element) newPlayer).setAttribute("class", category);
			
			Element nodeAmu = document.createElement("amuleto");
			nodeAmu.appendChild(document.createTextNode("0"));
			newPlayer.appendChild(nodeAmu);
			
			Element nodeAnel = document.createElement("anel");
			nodeAnel.appendChild(document.createTextNode("0"));
			newPlayer.appendChild(nodeAnel);
			
			Element nodeArma = document.createElement("arma");
			nodeArma.appendChild(document.createTextNode("0"));
			newPlayer.appendChild(nodeArma);
			
			Element nodeBra = document.createElement("bracelete");
			nodeBra.appendChild(document.createTextNode("0"));
			newPlayer.appendChild(nodeBra);
			
			Element nodeCalcas = document.createElement("calcas");
			nodeCalcas.appendChild(document.createTextNode("0"));
			newPlayer.appendChild(nodeCalcas);
			
			Element nodeColar = document.createElement("colar");
			nodeColar.appendChild(document.createTextNode("0"));
			newPlayer.appendChild(nodeColar);
			
			Element nodeComp = document.createElement("companheiro");
			nodeComp.appendChild(document.createTextNode("0"));
			newPlayer.appendChild(nodeComp);
			
			Element nodeIns = document.createElement("insignias");
			nodeIns.appendChild(document.createTextNode("0"));
			newPlayer.appendChild(nodeIns);
			
			Element nodeTronco = document.createElement("tronco");
			nodeTronco.appendChild(document.createTextNode("0"));
			newPlayer.appendChild(nodeTronco);

			
			root.appendChild(newPlayer);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			StreamResult result = new StreamResult("newAcessoryBase.xml");
			transformer.transform(source, result);
			
			return true;
		} catch (Exception e) {}
		
		
		
		return false;
	}
		
}
