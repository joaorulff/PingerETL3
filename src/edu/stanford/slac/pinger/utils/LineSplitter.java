package edu.stanford.slac.pinger.utils;

public class LineSplitter {

	
	public static String [][] splitLine(String [] lines){
		
		
		String [][] linesSplit = new String[16][];
		for (int i = 0; i < lines.length; i++) {
			
			String [] split = lines[i].split(" ");
			linesSplit[i] = split;
		}
		
		return linesSplit;
	}
	
	
}
