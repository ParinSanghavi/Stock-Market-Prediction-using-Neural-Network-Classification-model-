package Predictor;

import java.io.*;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
 
public class MLP
{
	
	static File trainingfile=Create_traintestdata.trainfile;
	static File testingfile=Create_traintestdata.testfile;
	
	static double pred;
	static Instance newInst;
	static String actual;
	static String predString;

	public static void main(String args[]) throws Exception
	{
		getpred_Data();
		getactual_Data();
	}
	
	public static String[] getpred_Data() throws Exception
	{
		DataSource trainsource=new DataSource("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\CLASSIFICATION_OUTPUT_training.arff");
		Instances traindataset=trainsource.getDataSet();
		int classindex=traindataset.numAttributes()-1;
	    traindataset.setClassIndex(classindex);
		
	    MultilayerPerceptron trainnb=new MultilayerPerceptron();
	    trainnb.buildClassifier(traindataset);
	    weka.core.SerializationHelper.write("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\CLASSIFICATION_OUTPUT_training.model",trainnb);
	    
	    MultilayerPerceptron testnb=(MultilayerPerceptron)weka.core.SerializationHelper.read("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\CLASSIFICATION_OUTPUT_training.model");
	    DataSource testsource=new DataSource("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\CLASSIFICATION_OUTPUT_testing.arff");
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
		DataSource trainsource=new DataSource("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\CLASSIFICATION_OUTPUT_training.arff");
		Instances traindataset=trainsource.getDataSet();
		int classindex=traindataset.numAttributes()-1;
	    traindataset.setClassIndex(classindex);
		
	    MultilayerPerceptron trainnb=new MultilayerPerceptron();
	    trainnb.buildClassifier(traindataset);
	    weka.core.SerializationHelper.write("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\CLASSIFICATION_OUTPUT_training.model",trainnb);
	    
	    MultilayerPerceptron testnb=(MultilayerPerceptron)weka.core.SerializationHelper.read("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\CLASSIFICATION_OUTPUT_training.model");
	    DataSource testsource=new DataSource("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\CLASSIFICATION_OUTPUT_testing.arff");
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
	
	public static  MultilayerPerceptron get_model() throws Exception
	{
		DataSource trainsource=new DataSource("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\CLASSIFICATION_OUTPUT_training.arff");
		Instances traindataset=trainsource.getDataSet();
		int classindex=traindataset.numAttributes()-1;
	    traindataset.setClassIndex(classindex);
		
		MultilayerPerceptron trainnb=new MultilayerPerceptron();
	    trainnb.buildClassifier(traindataset);
	    weka.core.SerializationHelper.write("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\CLASSIFICATION_OUTPUT_training.model",trainnb);
	    MultilayerPerceptron testnb=(MultilayerPerceptron)weka.core.SerializationHelper.read("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\CLASSIFICATION_OUTPUT_training.model");
	    
		return testnb;
	}	
}