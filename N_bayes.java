package Predictor;

import java.io.*;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class N_bayes 
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
		getactual_Data();
	}
	
	public static String[] getpred_Data() throws Exception
	{
		DataSource trainsource=new DataSource(trainingfile.getAbsolutePath());
		Instances traindataset=trainsource.getDataSet();
		int classindex=traindataset.numAttributes()-1;
	    traindataset.setClassIndex(classindex);
		
	    NaiveBayes trainnb=new NaiveBayes();
	    trainnb.buildClassifier(traindataset);
	    weka.core.SerializationHelper.write("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\N_bayes_training.model",trainnb);
	    NaiveBayes testnb=(NaiveBayes)weka.core.SerializationHelper.read("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\N_bayes_training.model");
	    
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
	    	// Call classifyindex() which returns the double value for the class
	    	pred=testnb.classifyInstance(newInst);
	    	// Use this value to get the string value of the predicted class
	    	predString=testdataset.classAttribute().value((int)pred); 	
	    	predicted_Data[i]=predString; 
	    }
	    
	    return(predicted_Data);
	}
	
	public static String[] getactual_Data() throws Exception
	{
		DataSource trainsource=new DataSource(trainingfile.getAbsolutePath());
		Instances traindataset=trainsource.getDataSet();
		int classindex=traindataset.numAttributes()-1;
	    traindataset.setClassIndex(classindex);
		
	    NaiveBayes trainnb=new NaiveBayes();
	    trainnb.buildClassifier(traindataset);
	    weka.core.SerializationHelper.write("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\N_bayes_training.model",trainnb);
	    NaiveBayes testnb=(NaiveBayes)weka.core.SerializationHelper.read("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\N_bayes_training.model");
	    
	    DataSource testsource=new DataSource(testingfile.getAbsolutePath());
	    Instances testdataset=testsource.getDataSet();
	    testdataset.setClassIndex(testdataset.numAttributes()-1);
	    String actual_Data[]=new String[testdataset.numInstances()];
	    
	    for(int i=0;i<testdataset.numInstances();i++)
	    {
	    	// Get class double value for current instance
	    	double actualClass=testdataset.instance(i).classValue();
	    	// Get class string value using the class index using the class int's value
	    	actual=testdataset.classAttribute().value((int) actualClass);
	    	// Get instance object of curreent instance
	    	Instance newInst=testdataset.instance(i);
	    	// Call classifyindex() which returns the double value for the class
	    	pred=testnb.classifyInstance(newInst);
	    	// Use this value to get the string value of the predicted class
	    	predString=testdataset.classAttribute().value((int)pred); 	
	    	actual_Data[i]=actual;
	    }
	    
	    return(actual_Data);
	}
	
	public static int get_len() throws Exception
	{
		DataSource testsource=new DataSource(testingfile.getAbsolutePath());
	    Instances  testdataset=testsource.getDataSet();
	    return (testdataset.numInstances());
	}
	
	public static  NaiveBayes get_model() throws Exception
	{	
		DataSource trainsource=new DataSource("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\Modified.arff"); // Parin
		Instances traindataset=trainsource.getDataSet();
		int classindex=traindataset.numAttributes()-1;
		traindataset.setClassIndex(classindex);
		
	    NaiveBayes trainnb=new NaiveBayes();
	    trainnb.buildClassifier(traindataset);
	    weka.core.SerializationHelper.write("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\N_bayes_training.model",trainnb);
	    NaiveBayes testnb=(NaiveBayes)weka.core.SerializationHelper.read("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\N_bayes_training.model");
		
		return testnb;
	}
}



