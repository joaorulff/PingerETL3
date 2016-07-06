package edu.stanford.slac.pinger.main;

import java.io.IOException;
import java.util.Date;

import org.json.JSONException;

import edu.stanford.slac.pinger.extractor.Starter;

public class Main {

	
	public static void main(String[] args) throws IOException, InterruptedException, JSONException{
		
		Starter.start(new Date());
	
	}
}

