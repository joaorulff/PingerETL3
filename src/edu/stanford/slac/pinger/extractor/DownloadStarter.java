package edu.stanford.slac.pinger.extractor;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.json.JSONException;
import org.json.JSONObject;

import edu.stanford.slac.pinger.XML.XMLModelCreator;

public class DownloadStarter {
	
	
	
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
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		
		String year = String.valueOf(dateFormat.format(calendar.getTime())).substring(0,4);
		String month = String.valueOf(dateFormat.format(calendar.getTime())).substring(5,7);
		String day = String.valueOf(dateFormat.format(calendar.getTime())).substring(8,10);
		
		//System.out.println(year+"-"+month+"-"+day);
		
		for (String metric : metrics) {
			
			for (String size : packet_size) {
				
				FileDownloader.download(metric, size, "node", year, month, day);
				
			}	
		}
	}
}
