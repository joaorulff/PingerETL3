package edu.stanford.slac.pinger.main;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONException;

import edu.stanford.slac.pinger.CSVHandler.TextReader;
import edu.stanford.slac.pinger.extractor.DownloadStarter;

public class Main {

	
	public static void main(String[] args) throws IOException, InterruptedException, JSONException{
		
		//DownloadStarter.start(Calendar.getInstance().getTime());
		TextReader tr = new TextReader(Calendar.getInstance().getTime());
		
	
	}
}

