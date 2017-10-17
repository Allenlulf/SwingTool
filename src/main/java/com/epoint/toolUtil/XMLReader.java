package com.epoint.toolUtil;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author JOECHAN XML
 */
public class XMLReader {
	private static XMLReader xmlReader = null;

	private XMLReader() {
	}

	public static XMLReader getInstance() {
		if (xmlReader == null) {
			synchronized (XMLReader.class) {
				xmlReader = new XMLReader();
			}
		}
		return xmlReader;
	}

	/**
	 * @param file
	 * @return
	 */
	private static Document getDocument(File file) {
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;
		Document document = null;
		try {
			factory = DocumentBuilderFactory
					.newInstance();
			factory.setValidating(false);
			builder = factory.newDocumentBuilder();
			document = builder.parse(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return document;
	}
	
	private static Document getDocument(byte [] bytes){
	    DocumentBuilderFactory factory = null;
        DocumentBuilder builder = null;
        Document document = null;
        try {
            factory = DocumentBuilderFactory
                    .newInstance();
            factory.setValidating(false);
            builder = factory.newDocumentBuilder();
            document = builder.parse(new ByteArrayInputStream(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
	}
	
	// 获得xml根节点
	public Element getRootElement(File file) throws Exception {
		Document doc = getDocument(file);
		return doc.getDocumentElement();
	}
	
	// 获取对应节点名称的所有节点
	public NodeList getAllElement(File file ,String tagName){
		Document doc = getDocument(file);
		NodeList nodeList = doc.getElementsByTagName(tagName);
		return nodeList;
	}
	
	
    public NodeList getAllElement(byte [] bytes ,String tagName){
        Document doc = getDocument(bytes);
        NodeList nodeList = doc.getElementsByTagName(tagName);
        return nodeList;
    }
    
	
	public Node getOnlyOneElement(File file,String tagName){
	    Node result = null;
	    Document doc = getDocument(file);
	    NodeList nodeList = doc.getElementsByTagName(tagName);
	    if(nodeList.getLength()==1){
	        result = doc.getElementsByTagName(tagName).item(0);
        }
        return result;
	}
	
	
	public Node getOnlyOneElement(byte[] content,String tagName){
        Node result = null;
        Document doc = getDocument(content);
        NodeList nodeList = doc.getElementsByTagName(tagName);
        if(nodeList.getLength()==1){
            result = doc.getElementsByTagName(tagName).item(0);
        }
        return result;
    }

	
	// 获取某个节点的所有属性
	public ArrayList<NamedNodeMap> getAllAttributesByTagName(File file ,String tagName){
		ArrayList<NamedNodeMap> list = new ArrayList<NamedNodeMap>();
		NodeList nodeList = getDocument(file).getElementsByTagName(tagName);
		if(nodeList.getLength()>0){
			for(int i = 0 ; i < nodeList.getLength() ; i++){
				list.add(nodeList.item(i).getAttributes());
			}
		}
		return list;
	}
	
	// 获取某个节点的某个属性的属性值
    // param(节点名，属性名)
	public String getAttributeValue(Node node,String attributeName){
		String value = "";
		if(node.hasAttributes()){
			Node temp = node.getAttributes().getNamedItem(attributeName);
			if(temp!=null){
				value = temp.getTextContent();
			}
		}
		return value;
	}

    // 获取某个节点的所有子节点
	public NodeList getChildNodelist(Node node){
		NodeList childNodeList = null;
		if(node!=null){
			childNodeList = node.getChildNodes();
			if(childNodeList != null && childNodeList.getLength()>0){
				for(int i = 0 ; i < childNodeList.getLength(); i++){
					if(childNodeList.item(i) instanceof Element){
					}else{
						node.removeChild(childNodeList.item(i));
					}
				}
			}
		}
		
		return childNodeList;
	}
	
	// 通过xpath获取所有节点
	public NodeList getAllElementByXPath(File file,String path){
	    NodeList nodes = null;
	    try {
	        Document doc = getDocument(file);
	        XPathFactory factory = XPathFactory.newInstance();
	        XPath xpath = factory.newXPath();
            XPathExpression expr = xpath.compile(path);
            Object result = expr.evaluate(doc, XPathConstants.NODESET);
            nodes = (NodeList) result;
        }
        catch (XPathExpressionException e) {
            e.printStackTrace();
        }    
	    return nodes;
	}
	
	
	// 通过xpath获取所有节点
    public NodeList getAllElementByXPath(byte[] content,String path){
        NodeList nodes = null;
        try {
            Document doc = getDocument(content);
            XPathFactory factory = XPathFactory.newInstance();
            XPath xpath = factory.newXPath();
            XPathExpression expr = xpath.compile(path);
            Object result = expr.evaluate(doc, XPathConstants.NODESET);
            nodes = (NodeList) result;
        }
        catch (XPathExpressionException e) {
            e.printStackTrace();
        }    
        return nodes;
    }
    
	
	// 通过document和xpath获取节点
	public NodeList getAllElementByXPath_Doc(Document doc,String path){
        NodeList nodes = null;
        try {
            //Document doc = getDocument(file);
            XPathFactory factory = XPathFactory.newInstance();
            XPath xpath = factory.newXPath();
            XPathExpression expr = xpath.compile(path);
            Object result = expr.evaluate(doc, XPathConstants.NODESET);
            nodes = (NodeList) result;
        }
        catch (XPathExpressionException e) {
            e.printStackTrace();
        }    
        return nodes;
    }
	
	// 通过xpath获取单独节点
    public Node getOnlyOneElementByXPath(File file,String path){
        Node node = null;
        try {
            Document doc = getDocument(file);
            XPathFactory factory = XPathFactory.newInstance();
            XPath xpath = factory.newXPath();
            XPathExpression expr = xpath.compile(path);
            Object result = expr.evaluate(doc, XPathConstants.NODE);
            node = (Node) result;
        }
        catch (XPathExpressionException e) {
            e.printStackTrace();
        }    
        return node;
    }
    
    public Node getOnlyOneElementByXPath(byte[] content,String path){
        Node node = null;
        try {
            Document doc = getDocument(content);
            XPathFactory factory = XPathFactory.newInstance();
            XPath xpath = factory.newXPath();
            XPathExpression expr = xpath.compile(path);
            Object result = expr.evaluate(doc, XPathConstants.NODE);
            node = (Node) result;
        }
        catch (XPathExpressionException e) {
            e.printStackTrace();
        }    
        return node;
    }
}
