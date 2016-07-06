package edu.stanford.slac.pinger.extractor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import edu.stanford.slac.pinger.XML.XMLModelCreator;

public class Starter {
	
	
	
	public static String [] metrics = {"throughput"
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
	
	
	public static String [] packet_size ={"100"
										 //,"1000"
										};
	
	
	
	
	public static void start(Date date) throws IOException, InterruptedException, JSONException{
				
		FileDownloader.deleteMetricFiles();		
		
		for (String metric : metrics) {
			
			for (String size : packet_size) {
				
				FileDownloader.download(metric, size, "node", "2016", "06", "28");
				
			}	
		}
		
		
	}
}
