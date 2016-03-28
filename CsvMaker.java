package Predictor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class CsvMaker
{
	private static BufferedReader br;
	private static String[] cols;
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
	private static FileWriter fileWriter;

	public static String[][] main(String args[]) throws IOException
	{
		String returnData[][] = new String[1000][2];
		
		String OriginalCsv = "C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\DownloadedData\\"+args[0]+".csv";
    	String ModifiedCsv = "C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\Modified1.csv";
		
    	String line="";
    	String errorChecker=""; // Checks the frequently errors induced in files and removes them
		cols = new String[20];
		
		fileWriter = new FileWriter(ModifiedCsv);
		br = new BufferedReader(new FileReader(OriginalCsv));
		
		String userDate = "\""+args[1]+"\"";
		String waste = "";
	    int i = 0;
	    
	    
	    line = br.readLine();
	    while (null != (line = br.readLine()))
		{	
				cols = line.split(",");

		    	if(errorChecker.equals(cols[2]))
				{
					continue;
				}
				errorChecker = cols[2];
				
				if(cols[2].equals(userDate))
				{
					waste = cols[2].replace("\"", "");
					returnData[i][0] = waste.replace(" ", "");
					break; 
				}
				else
				{
					waste = cols[2].replace("\"", "");
					returnData[i][0] = waste.replace(" ", "");
					i++;
				}
		}
	    br.close();
		fileWriter.flush();
		fileWriter.close();
		
		fileWriter = new FileWriter(ModifiedCsv);
		br = new BufferedReader(new FileReader(OriginalCsv));
	    
		errorChecker = ""; 
		
	    while (null != (line = br.readLine()))
		{
	    		
				cols = line.split(",");
				if(errorChecker.equals(cols[2]))
				{
					continue;
				}
				errorChecker = cols[2];
				if(cols[2].equals(userDate))
				{
					waste = cols[2].replace("\"", "");
					returnData[0][1] = waste.replace(" ", "");
					waste = cols[4].replace("\"", "");
					returnData[1][1] = waste.replace(" ", "");
					waste = cols[5].replace("\"", "");
					returnData[2][1] = waste.replace(" ", "");
					waste = cols[6].replace("\"", "");
					returnData[3][1] = waste.replace(" ", "");
					waste = cols[8].replace("\"", "");
					returnData[4][1] = waste.replace(" ", "");
					waste = cols[10].replace("\"", "");
					returnData[5][1] = waste.replace(" ", "");
					returnData[6][1] = "UP";   // Needs to be predicted. So, store default "UP" 
					fileWriter.append(cols[2]);
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(cols[4]);
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(cols[5]);
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(cols[6]);
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(cols[8]);
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(cols[10]);
					fileWriter.append(NEW_LINE_SEPARATOR);
				    break; 
				}
				else
				{ 
					fileWriter.append(cols[2]);
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(cols[4]);
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(cols[5]);
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(cols[6]);
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(cols[8]);
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(cols[10]);
					fileWriter.append(NEW_LINE_SEPARATOR);
					line = "";
				}
		}

		br.close();
		fileWriter.flush();
		fileWriter.close();
		
		OriginalCsv = "C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\Modified1.csv";
		ModifiedCsv = "C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\Modified2.csv";
		fileWriter = new FileWriter(ModifiedCsv);
		br = new BufferedReader(new FileReader(OriginalCsv));
		
		int c= br.read();
	    while(c!=-1)
	    {
	        if(!(((char)c=='"')||((char)c==' ')))
	        {
	        	line = (char)c+ "";
	        	fileWriter.append(line);
	        	line = "";
	        }
	        c=br.read();
	    }
		fileWriter.flush();
		fileWriter.close();
		br.close();
		
		OriginalCsv = "C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\Modified2.csv";
    	ModifiedCsv = "C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\"+args[0]+"Modified.csv";
		
    	
    	line="";
		double open = 0, close = 0;
		cols = new String[20];
		
		fileWriter = new FileWriter(ModifiedCsv);
		br = new BufferedReader(new FileReader(OriginalCsv));
		fileWriter.append("Date,Open,High,Low,Close,TradedQuantity,Result");
		fileWriter.append(NEW_LINE_SEPARATOR);
		line = br.readLine();
		int first = 0 ;
		while (null != (line = br.readLine()))
		{		
				
				cols = line.split(",");
				if(!(first == 0))
				{
					open = Double.parseDouble(cols[1]);				
					if( open >= close )
					{
						fileWriter.append("UP");
					}
					else
					{
						fileWriter.append("DOWN");
					}
					fileWriter.append(NEW_LINE_SEPARATOR);
				}
				
				fileWriter.append(cols[0]);
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(cols[1]);
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(cols[2]);
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(cols[3]);
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(cols[4]);
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(cols[5]);
				fileWriter.append(COMMA_DELIMITER);
				line = "";
				close = Double.parseDouble(cols[4]);
				first = 1;
		}
		fileWriter.append("UP"); // Needs to be predicted. So, store default "UP" 
		fileWriter.flush();
		fileWriter.close();
		br.close();
		return returnData;
    }
}