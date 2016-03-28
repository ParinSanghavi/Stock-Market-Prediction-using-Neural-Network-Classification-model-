package Predictor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AutomatedDownloader
{
	private static FileOutputStream fos;

	public static void main(String args[]) throws IOException, ParseException
	{
		String combo = "Reliance";
		String userDate = "02-12-2014";
		
		//String combo = args[0];
		//String userDate = args[1];
		
		Date date1, date2, date3;
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Calendar cal = Calendar.getInstance();		
		
        date1 = formatter.parse(userDate);

        cal.setTime(date1);
        cal.add(Calendar.DATE, -1);
        date2 = cal.getTime();
        String endDate = df.format(date2);
        
        cal.setTime(date1);
        cal.add(Calendar.DATE, - 360);
        date3 = cal.getTime();
        String startDate = df.format(date3);        
        
        String url ="http://www.nseindia.com/content/equities/scripvol/datafiles/"+startDate+"-TO-"+endDate+combo+"ALLN.csv";
        String fileName = "C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\DownloadedData\\"+combo+".csv";
        System.out.println(url);
        		        
		URL website = new URL(url);
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		fos = new FileOutputStream(fileName);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		System.out.print("done");
	}
}