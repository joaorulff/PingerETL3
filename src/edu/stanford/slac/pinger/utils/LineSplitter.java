package edu.stanford.slac.pinger.utils;

public class LineSplitter {

	
	public static String [] splitLine(String line){
		
		String [] arrayOfMetrics = line.split(" ", 28);
		return arrayOfMetrics;
	}
	
	
}
