package Predictor;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import java.io.File;
 
public class CsvArffConverter
{
	public static void Convert(String sourcepath,String destpath) throws Exception
	{
		// load CSV
		CSVLoader loader = new CSVLoader();
		loader.setSource(new File(sourcepath));
		Instances data = loader.getDataSet();
 
		// save ARFF
		ArffSaver saver = new ArffSaver();
		saver.setInstances(data);
		saver.setFile(new File(destpath));
		saver.writeBatch();
	}
	public static void main(String args[]) throws Exception
	{
		Convert(args[0],args[1]);
	}
}