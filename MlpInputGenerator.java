package Predictor;

import java.io.*;

public class MlpInputGenerator
{
	private static BufferedReader br;

	public static void main(String args[]) throws Exception
	{
		
		int length = N_bayes.get_len();
		
		String[] nb=N_bayes.getpred_Data();
		String[] actual=N_bayes.getactual_Data();
		String[] j48=J_48.getpred_Data();
		String[] m1=Adaboost_M1.getpred_Data();
		
		try
		{ 
			String outputFile = "C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\Final.csv";
		    FileWriter fw=new FileWriter(outputFile, true);
			BufferedWriter bw=new BufferedWriter(fw);
			br = new BufferedReader(new FileReader(outputFile));
			
			bw.write("NB_pred"+","+"J48_pred"+","+"AdaBoostM1_pred"+","+"Actual");
			bw.newLine();
			
			int count=0;
			while (br.readLine()!=null)
			{ 
				count++;
			}
			
			if(count!=length+1)
			{
				for(int i=0;i<length;i++)
				{
			    	bw.write(nb[i]+","+j48[i]+","+m1[i]+","+actual[i]);
			    	bw.newLine();
			    }
			}
			
			bw.close();
			fw.close();
			br.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
}
