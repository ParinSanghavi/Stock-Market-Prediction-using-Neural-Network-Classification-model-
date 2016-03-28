package Predictor;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.meta.AdaBoostM1;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Userip_classification_arff
{
	static File trainingfile=Create_traintestdata.trainfile;
	static File testingfile=Create_traintestdata.testfile;
	
	static double pred;
	static Instance newInst;
	static String actual;
	static String predString;
	
	public static void main(String args[][]) throws Exception
	{	
		String outputFile = "C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\final_classify_arff.arff";
		FileWriter fw=new FileWriter(outputFile, true);
		BufferedWriter bw=new BufferedWriter(fw);
		
		final String OLD_FORMAT = "dd-MMM-yyyy";
		final String NEW_FORMAT = "dd-MMM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
		Date d;
		String newDateString;
		
		// Get Data
		d = sdf.parse(args[0][1]);
		sdf.applyPattern(NEW_FORMAT);
		newDateString = sdf.format(d);
		String date = newDateString;
		String open=args[1][1];
		String high=args[2][1];
		String low=args[3][1];
		String close=args[4][1];
		String traded=args[5][1];
		String result=args[6][1];			

		String attributeDate = "@attribute Date {";
		String dateCollector= "";
			

		d = sdf.parse(args[0][0]);
		sdf.applyPattern(NEW_FORMAT);
		dateCollector = sdf.format(d);
			
		int i=1;
		while(args[i][0] != null)
		{
			d = sdf.parse(args[i][0]);
			sdf.applyPattern(NEW_FORMAT);
			newDateString = sdf.format(d);
			dateCollector = dateCollector + "," + newDateString;
			i++;
		}
		
		attributeDate = attributeDate + dateCollector + "}";
			
		bw.write("@relation -weka.filters.unsupervised.instance.Resample-S1-Z70.0-no-replacement-V"); //ERROR
		bw.newLine();
		bw.newLine();
		bw.write(attributeDate);
		bw.newLine();
		bw.write("@attribute Open numeric");
		bw.newLine();
		bw.write("@attribute High numeric");
		bw.newLine();
		bw.write("@attribute Low numeric");
		bw.newLine();
		bw.write("@attribute Close numeric");
		bw.newLine();
		bw.write("@attribute Traded numeric");
		bw.newLine();
		bw.write("@attribute Result {UP,DOWN}");
		bw.newLine();
		bw.newLine();
		bw.write("@data");
		bw.newLine();
		bw.write(date+","+open+","+high+","+low+","+close+","+traded+","+result);
		bw.close();
	}
	
	public static String[] getpred_Datanb() throws Exception
	{
		DataSource testsource=new DataSource("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\final_classify_arff.arff");
		Instances testdataset=testsource.getDataSet();
		testdataset.setClassIndex(testdataset.numAttributes()-1);
		NaiveBayes nbmodel=N_bayes.get_model();
		String predicted_Data[]=new String[testdataset.numInstances()];
	 	
		for(int i=0;i<testdataset.numInstances();i++)
		{
		    // Get class double value for current instance
		    double actualClass=testdataset.instance(i).classValue();
		    // Get class string value using the class index using the class int's value
		    actual=testdataset.classAttribute().value((int) actualClass);
		    // Get instance object of curreent instance
		   	Instance newInst=testdataset.instance(i);
		   	// Call classifyindex() which returns the double value for the class
		   	pred=nbmodel.classifyInstance(newInst);
	    	// Use this value to get the string value of the predicted class
	    	predString=testdataset.classAttribute().value((int)pred); 	
		    predicted_Data[i]=predString; 
		}
		
		return(predicted_Data);
	}

	public static String[] getpred_Dataj48() throws Exception
 	{
		DataSource testsource=new DataSource("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\final_classify_arff.arff");
		Instances testdataset=testsource.getDataSet();
 	    testdataset.setClassIndex(testdataset.numAttributes()-1);
 	    J48 j48model=J_48.get_model();
 	    String predicted_Data[]=new String[testdataset.numInstances()];

 	    for(int i=0;i<testdataset.numInstances();i++)
 	    {
 	    	// Get class double value for current instance
 	    	double actualClass=testdataset.instance(i).classValue();
 	    	// Get class string value using the class index using the class int's value
 	    	actual=testdataset.classAttribute().value((int) actualClass);
 	    	// Get instance object of curreent instance
 	    	Instance newInst=testdataset.instance(i);
 	    	// Call classifyindex() which returns the double value for the class
 	    	pred=j48model.classifyInstance(newInst);
 	    	// Use this value to get the string value of the predicted class
 	    	predString=testdataset.classAttribute().value((int)pred); 
 	    	predicted_Data[i]=predString; 
 	    }
 	    
 	    return(predicted_Data);	 
 	}

	public static String[] getpred_Datam1() throws Exception
	{
		
		DataSource testsource=new DataSource("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\final_classify_arff.arff");
		Instances testdataset=testsource.getDataSet();
	    testdataset.setClassIndex(testdataset.numAttributes()-1);
	    AdaBoostM1 m1model=Adaboost_M1.get_model();
	    String predicted_Data[]=new String[testdataset.numInstances()];
	
	    for(int i=0;i<testdataset.numInstances();i++)
	    {
	    	// Get class double value for current instance
	    	double actualClass=testdataset.instance(i).classValue();
	    	// Get class string value using the class index using the class int's value
	    	actual=testdataset.classAttribute().value((int) actualClass);
	    	// Get instance object of curreent instance
	    	Instance newInst=testdataset.instance(i);
	    	// Call classifyindex() which returns the double value for the class
	    	pred=m1model.classifyInstance(newInst);
	    	// Use this value to get the string value of the predicted class
	    	predString=testdataset.classAttribute().value((int)pred); 	
	    	predicted_Data[i]=predString;
	    }
	    return(predicted_Data);
	 }
}	