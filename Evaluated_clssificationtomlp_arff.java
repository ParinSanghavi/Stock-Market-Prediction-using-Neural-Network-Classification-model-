package Predictor;

import java.io.*;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Evaluated_clssificationtomlp_arff
{
	
	static File trainingfile=Create_traintestdata.trainfile;
	static File testingfile=Create_traintestdata.testfile;
	
	static double pred;
	static Instance newInst;
	static String actual;
	static String predString;
	
	public static String[] main(String args[]) throws Exception
	{	
		String outputFile = "C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\final_mlp_arff.arff";
		
		FileWriter fw=new FileWriter(outputFile, true);
		BufferedWriter bw=new BufferedWriter(fw);
		
	    String pred_j48[]=Userip_classification_arff.getpred_Dataj48();
	    String pred_nb[]=Userip_classification_arff.getpred_Datanb();

	    String pred_m1[]=Userip_classification_arff.getpred_Datam1();
	    
	    String actual="UP"; // Set default Value as UP
	    	
	    bw.write("@relation CLASSIFFICATION_OUTPUT-weka.filters.unsupervised.instance.Resample-S1-Z70.0");
	    bw.newLine();
	    bw.newLine();
	    bw.write("@attribute pred_nb {UP,DOWN}");
	    bw.newLine();
	    bw.write("@attribute pred_J48 {UP,DOWN}");
	    bw.newLine();
	    bw.write("@attribute pred_AdaBoostM1 {UP,DOWN}");
	    bw.newLine();
	    bw.write("@attribute actual {UP,DOWN}");
	    bw.newLine();
	    bw.newLine();
	    bw.write("@data");
	    bw.newLine();
	    bw.write(pred_nb[0]+","+pred_j48[0]+","+pred_m1[0]+","+actual);
	    bw.close();
	    	
	    return getpred_DataMLP();
	}

	public static String[] getpred_DataMLP() throws Exception
	{
		MultilayerPerceptron mlpmodel=MLP.get_model();
		DataSource testsource=new DataSource("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\final_mlp_arff.arff");
		Instances testdataset=testsource.getDataSet();
	    testdataset.setClassIndex(testdataset.numAttributes()-1);
	    String predicted_Data[]=new String[testdataset.numInstances()];
 	 
	    for(int i=0;i<testdataset.numInstances();i++)
	    {
	    	double actualClass=testdataset.instance(i).classValue();
	    	actual=testdataset.classAttribute().value((int) actualClass);
	    	Instance newInst=testdataset.instance(i);
	    	pred=mlpmodel.classifyInstance(newInst);
	    	predString=testdataset.classAttribute().value((int)pred); 	
	    	predicted_Data[i]=predString; 	    	
	    }
	    
	    return(predicted_Data);
	}
}
