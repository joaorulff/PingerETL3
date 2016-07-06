package edu.stanford.slac.pinger.XML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import edu.stanford.slac.pinger.general.Constants;

public class XMLModelCreator {
	
	
	private Document pingerXML;
	private Element root;
	private File fileToWrite = new File(Constants.xmlFolder+"/pinger.xml");
	
	
	public XMLModelCreator(){
		
		try {
			
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			this.pingerXML = builder.newDocument();
			createXMLRoot();
			
			
			
		} catch (Exception e) {
			System.out.println("Error while creating the XML doc");
		}
		
	}
	
	
	public void createXMLRoot(){
		
		Element root = this.pingerXML.createElement("pinger");
		this.pingerXML.appendChild(root);
		this.root = root;
		
	}
	
	public void addTheMetrics(){
		
	}
	
	public void saveToDisk(){
		try {
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource documentSource = new DOMSource(this.pingerXML);
			StreamResult result = new StreamResult(fileToWrite);
			transformer.transform(documentSource, result);
			
			
			
		} catch (Exception e) {
			System.out.println("Error while writing the XML to disk");
		}
	}
	
	
	public void insertMeasurement(String sourceNode, String destinationNode, String timeID){

		Element pairMeasurement = this.pingerXML.createElement("pair");
		
		Attr source = this.pingerXML.createAttribute("source");
		source.setValue(sourceNode);
		pairMeasurement.setAttribute("source", sourceNode);
		
		Attr destination = this.pingerXML.createAttribute("destination");
		destination.setValue(destinationNode);
		pairMeasurement.setAttribute("destination", destinationNode);
		
		Attr timeHour = this.pingerXML.createAttribute("time");
		timeHour.setValue(timeID);
		pairMeasurement.setAttribute("time", timeID);
		
		
		String [] metrics = {"throughput"
				  ,"packet_loss"
				  ,"average_rtt"
				  ,"MOS"
				  ,"alpha"
				  ,"conditional_loss_probability"
				  ,"duplicate_packets"
				  ,"ipdv"
				  ,"unreachability"
				  ,"zero_packet_loss_frequency"
				  ,"minimum_rtt"
				  ,"iqr"
				  ,"maximum_rtt"
				  ,"minimum_packet_loss"
				  ,"out_of_order_packets"
				  ,"unpredictability"
				  };
		
		for (int i = 0; i < metrics.length; i++) {
			
			Element currentMetricToAdd = this.pingerXML.createElement(metrics[i]);
			currentMetricToAdd.setNodeValue("REALVALUE");
			pairMeasurement.appendChild(currentMetricToAdd);
			
		}
		
		
		this.root.appendChild(pairMeasurement);
		
	}

}
