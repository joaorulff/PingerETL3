package edu.stanford.slac.pinger.CSVHandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import edu.stanford.slac.pinger.general.Constants;

public class CSVWriter {
	
	
	private File resultCSV;
	private FileWriter writerCSV;
	private BufferedWriter bufferCSV;
	
	public CSVWriter(){
		
		
		try {
			
			this.resultCSV = new File(Constants.csvFolder+"/result.csv");
			this.writerCSV = new FileWriter(resultCSV);
			this.bufferCSV = new BufferedWriter(writerCSV);
			
		} catch (IOException e) {
			System.out.println("Exception while creating the CSV file");
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public void insertMetricCSV(String [][] metricMatrix){
		
		String line = metricMatrix[0][0]+","+metricMatrix[0][1];
		
	}

}
