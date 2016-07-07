package edu.stanford.slac.pinger.extractor;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;


public class FileDownloader {
	
	public static final String downloadPath = "downloaded";
	
	public static void download(String metric, String packetSize, String granularity, String year, String month, String day) throws IOException, InterruptedException{		
		
		
		FTPClient ftpClient = new FTPClient();
		
		try{
			
			boolean success = false;
			
			do{
				
				ftpClient.connect("ftp.slac.stanford.edu");
				ftpClient.login("anonymous", "anonymous@domain.com");
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				ftpClient.enterLocalPassiveMode();
				FileOutputStream fos = new FileOutputStream(downloadPath+"/"+metric+".tar");
				success = ftpClient.retrieveFile("/users/cottrell/"+metric+"-"+packetSize+"-by-"+granularity+".tar", fos);
				fos.close();
				ftpClient.logout();
				ftpClient.disconnect();
				
			}while(!success);
			
			extractDailyFile(metric, packetSize, granularity, year, month, day);
			
		}catch(IOException ex){	
			System.out.println("Fail to download the "+metric+" file from the FTP");
		}
	}
	
		
	public static void extractDailyFile(String metric, String packetSize, String granularity, String year, String month, String day) throws IOException, InterruptedException{
		
		
		Process p;
		p = Runtime.getRuntime().exec("tar -xf "+downloadPath+"/"+metric+".tar -C metrics");
		p.waitFor();
		p = Runtime.getRuntime().exec("cp metrics/"+metric+"/"+metric+"-"+packetSize+"-by-"+granularity+"-"+year+"-"+month+"-"+day+".txt.gz metrics/");
	    p.waitFor();
		p = Runtime.getRuntime().exec("rm -rf metrics/"+metric);
		p.waitFor();
		p = Runtime.getRuntime().exec("rm "+downloadPath+"/"+metric+".tar");
		p.waitFor();
		p = Runtime.getRuntime().exec("gunzip metrics/"+metric+"-"+packetSize+"-by-"+granularity+"-"+year+"-"+month+"-"+day+".txt.gz");
		p.waitFor();
		
		p.destroy();

		
	}
	
	public static void deleteMetricFiles() throws IOException{
		
		Process p;
		p = Runtime.getRuntime().exec("rm -f metrics/*");
		p.destroy();
	}
}
