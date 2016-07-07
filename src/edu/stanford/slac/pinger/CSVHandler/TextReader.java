package edu.stanford.slac.pinger.CSVHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import edu.stanford.slac.pinger.general.Constants;
import edu.stanford.slac.pinger.utils.LineSplitter;

public class TextReader {
	
	private File [] metricTxtFiles = new File [16];
	private FileReader [] fileReaders = new FileReader[16];
	private BufferedReader [] bufferedReaders = new BufferedReader[16];
	
	private CSVWriter writer;
	
	private String [] metrics = {"throughput"
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
	
	public TextReader(Date today){
		
		this.writer = new CSVWriter();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		
		String year = String.valueOf(dateFormat.format(calendar.getTime())).substring(0,4);
		String month = String.valueOf(dateFormat.format(calendar.getTime())).substring(5,7);
		String day = String.valueOf(dateFormat.format(calendar.getTime())).substring(8,10);
		
		try {
			
			for (int i = 0; i < 16; i++) {
				
				String pathname = Constants.metricsFileFolder+"/"+metrics[i]+"-100-by-node-"+year+"-"+month+"-"+day+".txt";
				metricTxtFiles[i] = new File(pathname);
				fileReaders[i] = new FileReader(metricTxtFiles[i]);
				bufferedReaders[i] = new BufferedReader(fileReaders[i]);
				
			}
			
		} catch (Exception e) {
			System.out.println("Error while creating File Readers");
		}
		
		
	}
	
	public void mergeFiles(){
		
		//Discard the first line of each file
		for (int i = 0; i < 16; i++) {
			try {
				bufferedReaders[i].readLine();
			} catch (Exception e) {
				System.out.println("Error while reding the first line of "+metrics[i]+" file" );
			}
		}
		
		try {
			String [] currentLines = new String [16];
			for (int i = 0; i < 16; i++) {
				
				if((currentLines[i] = bufferedReaders[i].readLine()) != null){
					
					if(i == 15){
						String [][] splitArray = LineSplitter.splitLine(currentLines);
						this.writer.insertMetricCSV(splitArray);
						i = 0;
					}
				}
			}		
		} catch (IOException e) {

			e.printStackTrace();
		}
	}	
}

