package parsers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XMLParser {

	final static String filePath = "src\\main\\resources\\cities.xml";

	 public static List<String> xmlParser() {
	 List<String> city = new ArrayList<String>();
	 try {
	 File xmlFile = new File(filePath);
	 DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	 DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
	 Document document = (Document) documentBuilder.parse(xmlFile);
	 document.getDocumentElement().normalize();
	 NodeList nodeList = document.getElementsByTagName(document.getDocumentElement().getChildNodes().item(1).getNodeName());
	 int length = nodeList.getLength();
	 Node[] copy = new Node[length];
	 for (int n = 0; n < length; ++n) {
	 city.add(nodeList.item(n).getChildNodes().item(0).getNodeValue());
	 }
	 }catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
			ex.printStackTrace();
		}
	 
	 return city;
	 }

	
	
}
