package Predictor;

import java.io.*;
import weka.classifiers.meta.AdaBoostM1;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Adaboost_M1 
{
	static String tr;
	static String te;
	
	static File trainingfile;	
	static File testingfile;
	
	static double pred;
	static Instance newInst;
	static String actual;
	static String predString;

	public static void main(String args[]) throws Exception
	{
		trainingfile = new File(tr);
		testingfile=new File(te);
		getpred_Data();		
	}
	
	public static String[] getpred_Data() throws Exception
	{
		DataSource trainsource=new DataSource(trainingfile.getAbsolutePath());
		Instances traindataset=trainsource.getDataSet();
		int classindex=traindataset.numAttributes()-1;
	    traindataset.setClassIndex(classindex);
		
	    AdaBoostM1 trainm1=new AdaBoostM1();
	    trainm1.buildClassifier(traindataset);
	    weka.core.SerializationHelper.write("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\Adaboost_M1_training.model",trainm1);
	    AdaBoostM1 testm1=(AdaBoostM1)weka.core.SerializationHelper.read("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\Adaboost_M1_training.model");
	    
	    DataSource testsource=new DataSource(testingfile.getAbsolutePath());
	    Instances testdataset=testsource.getDataSet();
	    testdataset.setClassIndex(testdataset.numAttributes()-1);
	    String predicted_Data[]=new String[testdataset.numInstances()];
	    
	    for(int i=0;i<testdataset.numInstances();i++)
	    {
	    	// Get class double value for current instance
	    	double actualClass=testdataset.instance(i).classValue();
	    	// Get class string value using the class index using the class int's value
	    	actual=testdataset.classAttribute().value((int) actualClass);
	    	// Get instance object of curreent instance
	    	Instance newInst=testdataset.instance(i);
	    	// Call classifyindex(Str) which returns the double value for the class
	    	pred=testm1.classifyInstance(newInst);
	    	//use this value to get the string value of the predicted class
	    	predString=testdataset.classAttribute().value((int)pred); 	
	    	predicted_Data[i]=predString; 
	    }
	    return(predicted_Data);
	}
	
	public static  AdaBoostM1 get_model() throws Exception
	{
		DataSource trainsource=new DataSource(trainingfile.getAbsolutePath());
		Instances traindataset=trainsource.getDataSet();
		int classindex=traindataset.numAttributes()-1;
	    traindataset.setClassIndex(classindex);
		
	    AdaBoostM1 trainm1=new AdaBoostM1();
	    trainm1.buildClassifier(traindataset);
	    weka.core.SerializationHelper.write("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\Adaboost_M1_training.model",trainm1);
	    AdaBoostM1 testm1=(AdaBoostM1)weka.core.SerializationHelper.read("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\Adaboost_M1_training.model");
	    
	    return testm1;
	}
}



