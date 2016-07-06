package edu.stanford.slac.pinger.extractor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import edu.stanford.slac.pinger.XML.XMLModelCreator;
import edu.stanford.slac.pinger.utils.LineSplitter;

public class MetricFileReader {
	
	
	public static void readFile(String metric, String packetSize, String granularity, String year, String month, String day, XMLModelCreator creator) throws IOException{
		
		String currentMetricFilePath = "metrics/"+metric+"-"+packetSize+"-by-"+granularity+"-"+year+"-"+month+"-"+day+".txt";
		File currentMetricFile = new File(currentMetricFilePath);
		FileReader fileReader = new FileReader(currentMetricFile);
		BufferedReader br = new BufferedReader(fileReader);
		String line = br.readLine();
		
		
		while((line = br.readLine()) != null){
			
			String [] arrayOfMetrics = LineSplitter.splitLine(line);
			for (int i = 0; i < 24; i++) {
				creator.insertMeasurement(arrayOfMetrics[0], arrayOfMetrics[1], i+"");
			}
			
			
		}	
		
	}

}
