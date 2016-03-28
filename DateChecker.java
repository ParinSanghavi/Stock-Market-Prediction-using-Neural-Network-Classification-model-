package Predictor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateChecker
{
	private static BufferedReader br;
	private static String[] cols;
	private static String[] dates;
	private static String userDate;
	
	public static String main(String args[]) throws IOException
	{
		try
		{	
			String OriginalCsv = "C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\DownloadedData\\"+args[0]+".csv";
			br = new BufferedReader(new FileReader(OriginalCsv));
			dates = new String[1000];
			cols = new String[20];
			
			String edit="", usable="";
			String line = br.readLine();
			int i=0;
			
			while (null != (line = br.readLine()))
			{
				cols = line.split(",");
				edit = cols[2].replace("\"", "");
				usable =edit.replace(" ","");
				dates[i] = usable;
				i++;
			}
			userDate = cases(dates,args[1]);
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userDate;
	}
	
	public static String cases(String dates[] , String userDate)
	{
		try
		{
			int length;
			Date date1, date2, date3;
			
            for(length = 0 ;length < dates.length ; length++)
            {
            	if(dates[length]==null)
            	{
            		break;
            	}
            }					
        	
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
			
			date1 = formatter.parse(dates[length-1]);
			Calendar cal = Calendar.getInstance();
            cal.setTime(date1);
            cal.add(Calendar.DATE, 1);
            date1 = cal.getTime();
            String actualDate = df.format(date1);
            dates[length] = actualDate;
   
            date1 = formatter.parse(userDate);
            date2 = formatter.parse(dates[0]);
            date3 = formatter.parse(dates[length]);
            
            if(date1.before(date2))
            {
            	return "DOP is before";
            }
            else if(date1.after(date3))
            {
            	return "MODEL CAN PREDICT ONLY TILL "+dates[length];
            }
            
            actualDate = df.format(date1);
            
            int index = 0, x =0 ;
            for( int i = 0; i < dates.length; i++)
            {
            	if(actualDate.equals(dates[i]))
            	{
            		x = 1;
            		index = i+1;
            		break;
            	}
            }
            if(x == 0)
            {
            	return "DOP was holiday";
            }
            if(x == 1 && index < 20)
            {
            	return "Provide atleast 60 data";
            }
            userDate = dates[index-2];
		}
		catch (Exception e)
    	{
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}   	
		return userDate;
	}
}
