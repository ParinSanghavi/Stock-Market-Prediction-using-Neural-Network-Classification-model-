package Predictor;

import java.io.*; 
import weka.core.converters.*;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.unsupervised.instance.Resample;
import weka.core.*;

public class Create_traintestdata  
{	
	public static String train;
	public static String test;
	static File trainfile;
	static File testfile;
        	    
	public static void main(String[] args) throws Exception 
	{	
		trainfile=new File(train);
		testfile=new File(test);
    	DataSource mainsource=new DataSource(args[0]);
		Instances maketraintestdataset=mainsource.getDataSet();
		
		Resample trainsampler=new Resample();
		
		trainsampler.setInputFormat(maketraintestdataset);
		trainsampler.setNoReplacement(true);
		trainsampler.setInvertSelection(false);
		trainsampler.setSampleSizePercent(70.00);
		trainsampler.setRandomSeed(1);
		DataSource train=new DataSource(Resample.useFilter(maketraintestdataset, trainsampler));
		Instances traininst=train.getDataSet();
		
		CSVSaver csv=new CSVSaver();
		csv.setStructure(maketraintestdataset);
		csv.setInstances(traininst);
		csv.setFile(trainfile);
		csv.writeBatch();
		
        Resample testsampler=new Resample();
		
		testsampler.setInputFormat(maketraintestdataset);
		testsampler.setNoReplacement(true);
		testsampler.setInvertSelection(true);
		testsampler.setSampleSizePercent(70.00);
		testsampler.setRandomSeed(1);
		DataSource test=new DataSource(Resample.useFilter(maketraintestdataset, testsampler));
		Instances testinst=test.getDataSet();
		CSVSaver csv1=new CSVSaver();
		csv1.setStructure(maketraintestdataset);
		csv1.setInstances(testinst);
		csv1.setFile(testfile);
		csv1.writeBatch();
		
		int classindex=maketraintestdataset.numAttributes()-1;
		traininst.setClassIndex(classindex);
		testinst.setClassIndex(classindex);
    }   
}