package Predictor;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Date;
import java.util.Properties;
//import javax.swing.JComboBox;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;

public class DispWindow extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//private static JComboBox comboBox; 
	private String combo;
	private JDatePickerImpl datePicker;
	private JTextField textField;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try
				{
					DispWindow frame = new DispWindow();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public void delete()
	{
		//Delete existing files
		System.gc();
		File file = new File("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData");      
	    String[] myFiles;    
	    if(file.isDirectory())
	    {
	    	myFiles = file.list();
	        for (int i=0; i<myFiles.length; i++)
	        {
	        	File myFile = new File(file, myFiles[i]); 
	            myFile.delete();
	        }
	    }
	}

	public DispWindow() 
	{	
		
		//JFrame
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setTitle("PRS PREDICTOR");
        setMinimumSize(new java.awt.Dimension(1360, 718));
        setPreferredSize(new java.awt.Dimension(1360, 718));
        setResizable(false);
        setContentPane(contentPane);
        contentPane.setLayout(null);
		
        
        // Labels
        
        JLabel lblNewLabel = new JLabel();
        lblNewLabel.setBounds(475, 25, 600, 300);
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\src\\BullAndBear.jpg"));
        contentPane.add(lblNewLabel);

        JLabel lblNewLabe2 = new JLabel("Enter your Stock :");
        lblNewLabe2.setBounds(90, 400, 195, 28);
        lblNewLabe2.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
        contentPane.add(lblNewLabe2);
        
        JLabel lblNewLabe3 = new JLabel("Date of Prediction :");
        lblNewLabe3.setBounds(90, 475, 195, 28);
        lblNewLabe3.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 18));
        contentPane.add(lblNewLabe3);
        
        final JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\src\\upArrowGrey.png"));
        lblNewLabel_1.setBounds(977, 336, 108, 119);
        contentPane.add(lblNewLabel_1);
        
        final JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\src\\downArrowGrey.png"));
        lblNewLabel_2.setBounds(977, 480, 108, 119);
        contentPane.add(lblNewLabel_2);

        // Text Field
        
        textField = new JTextField();
        textField.setBounds(300, 400, 195, 32);
        textField.setFont(new Font("Segoe UI BLACK", Font.BOLD, 22));
        textField.setForeground(new java.awt.Color(0, 10, 19));
        textField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
        contentPane.add(textField);
        textField.setColumns(10);
           
        /*
        // Combo Box        
        comboBox = new JComboBox();
        comboBox.setBounds(300, 400, 195, 28);
        contentPane.add(comboBox);
        comboBox.setFont(new java.awt.Font("Segoe Script", 3, 14)); // NOI18N
        comboBox.setForeground(new java.awt.Color(0, 10, 19));
        comboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Stock", "IDEA", "KOTAK", "RELIANCE" , "TCS", "HCLTECH" , "NIITTECH", "GOLDTECH" , "INFY"}));
        comboBox.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
        contentPane.setLayout(null);
		*/	
        // Date Component
        
        UtilDateModel model = new UtilDateModel();
		model.setDate(2014, 12, 1);
		model.setSelected(true);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(300, 475, 195, 28);
        contentPane.add(datePicker);
        
        // Button
        
        JButton btnNewButton = new JButton("PREDICT");
        btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
        btnNewButton.setBounds(560, 434, 260, 35);
        btnNewButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNewButton.setContentAreaFilled(false);
        contentPane.add(btnNewButton);
        
        // Background label
        
        JLabel lblPredict = new JLabel();
        lblPredict.setBounds(0, 0, 1600, 1000);
        lblPredict.setIcon(new ImageIcon("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\src\\Grey.jpg"));
        contentPane.add(lblPredict);
        
        // Button Action Listener
        
        btnNewButton.addActionListener(new ActionListener()
        {
        	private String sourcepath;
			private String destinationpath1;
			private String destinationpath2;
			private String filename1;
			private String filename2;
			private String filename3;
			public String a[];
			
			public void actionPerformed(ActionEvent e)
        	{
        		try 
        		{
        			// Delete Existing Files
        			delete();
        			
        			// Set Default Labels
        			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\src\\upArrowGrey.png"));
        			lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\src\\downArrowGrey.png"));
    		        
        			// Check Stock Input        			
        	        combo = textField.getText().toUpperCase().toString();
        	        File f = new File("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\DownloadedData\\"+combo+".csv");
        	        if(!f.exists())
        	        {
        	        	JOptionPane.showMessageDialog(getComponent(0), "THE SPECIFIED FILE DOES NOT EXISTS.");
            			return;
        	        }
        	        /*
        	         a = new String[10];        	         
                    combo=comboBox.getSelectedItem().toString(); 
                    if(combo.equalsIgnoreCase("Select Stock"))
                    {
            			JOptionPane.showMessageDialog(getComponent(0), "Please Select a Stock");
            			return;
                    }
                    */
        	        
                    // Check Date Input
                    Date selectedDate = (Date) datePicker.getModel().getValue();
        			DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                    String userDate = df.format(selectedDate);
                    String output = df.format(selectedDate);
                    
                    
                    
                    // Check availability of Date
                    a = new String[10];
                    a[0] = combo;
        		    a[1] = userDate;
        		    userDate = DateChecker.main(a);
        		    if(userDate.equals("DOP was holiday"))
        		    {
        		    	JOptionPane.showMessageDialog(getComponent(0), "STOCK MARKET DID NOT FUNCTION ON THE SPECIFIED DAY. PREDICTION NOT POSSIBLE");
            			delete();
        		    	return;
        		    }
        		    if(userDate.equals("DOP is before"))
        		    {
        		    	JOptionPane.showMessageDialog(getComponent(0), "THE SPECIFIED DATE OF PREDICTION IS BEFORE THE DATES GIVEN IN THE TRAINING DATA. PREDICTION NOT POSSIBLE");
            			delete();
        		    	return;
        		    }
        		    /*if(userDate.equals("DOP is after"))
        		    {
        		    	JOptionPane.showMessageDialog(getComponent(0), "MODEL CAN PREDICT ONLY TILL " + userDate);
            			delete();
        		    	return;
        		    }*/
        		    if(userDate.substring(0, 5).equals("MODEL"))
        		    {
        		    	JOptionPane.showMessageDialog(getComponent(0), userDate);
            			delete();
        		    	return;
        		    }
        		    if(userDate.equals("Provide atleast 60 data"))
        		    {
        		    	JOptionPane.showMessageDialog(getComponent(0), "PROVIDE PREVIOUS 3 MONTH'S TRAINING DATA");
            			delete();
        		    	return;
        		    }                   
      		        
        		    JOptionPane.showMessageDialog(getComponent(0), "PREDICTING THE OPENING PRICE FOR "+combo+" STOCK FOR "+ output);					
        			
        		    
        		    // Generate required CSV file from downloaded file
        		    a[0] = combo;
        		    a[1] = userDate;
        		    String returnData[][]= new String[1000][2];
        		    returnData = CsvMaker.main(a);          		            		    
        		   
        			// DownloadedData.csv to GeneratedData.arff
        			filename1 = combo+"Modified.csv"; 
        			filename2 = "Modified.arff";  
        			filename3 = "";
        			sourcepath="C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\";
        			destinationpath1="C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\";
        			destinationpath2="";
        			a[0]= sourcepath+filename1;
        			a[1]=destinationpath1+filename2;
        			CsvArffConverter.main(a);
        			
        			
        			// GeneratedData.arff to Training.csv and Testing.csv
        			filename1 = "Modified.arff";
        			filename2 = combo + "Modifiedtrainingeg.csv";
        			filename3 = combo+"Modifiedtestingeg.csv";
        			sourcepath="C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\";
        			destinationpath1="C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\";
        			destinationpath2="C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\";
        			a[0]= sourcepath+filename1;
        			Create_traintestdata.train = destinationpath1+filename2;
        			Create_traintestdata.test = destinationpath2+filename3;
        			Create_traintestdata.main(a);
        			
        			// Training.csv to Training.arff 
        			filename1 = combo+"Modifiedtrainingeg.csv"; 
        			filename2 = combo+"Modifiedtrainingeg.arff";  
        			filename3 = "";
        			sourcepath="C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\";
        			destinationpath1="C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\";
        			destinationpath2="";
        			a[0]= sourcepath+filename1;
        			a[1]=destinationpath1+filename2;
        			CsvArffConverter.main(a);
        			
        			// Testing.csv to Testing.arff 
        			filename1 = combo+"Modifiedtestingeg.csv"; 
        			filename2 = combo+"Modifiedtestingeg.arff";  
        			filename3 = "";
        			sourcepath="C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\";
        			destinationpath1="C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\";
        			destinationpath2="";
        			a[0]= sourcepath+filename1;
        			a[1]=destinationpath1+filename2;
        			CsvArffConverter.main(a);
        			
        			// Create Sourcepath and filenames for N_bayes , J_48 and Adaboost
        			sourcepath = "C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\";
        			filename2 = combo + "Modifiedtrainingeg.arff";  
        			filename3 = combo + "Modifiedtestingeg.arff";
        			
        			// N_bayes
        			N_bayes.tr = sourcepath + filename2;
        			N_bayes.te = sourcepath + filename3;
        			N_bayes.main(a);
        		
        			// J_48
        			J_48.tr = sourcepath + filename2;
        			J_48.te = sourcepath + filename3;
        			J_48.main(new String[0]);
        			
        			// Adaboost_M1
        			Adaboost_M1.tr = sourcepath + filename2;
        			Adaboost_M1.te = sourcepath + filename3;
        			Adaboost_M1.main(new String[0]);
        			
        			// Generate Final.csv file for MLP
        			MlpInputGenerator.main(new String[0]);
        			
        			// Final.csv to Training.csv and Testing.csv 
        			sourcepath="C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\Final.csv";
        			destinationpath1="C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\CLASSIFICATION_OUTPUT_training.csv";
        			destinationpath2="C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\CLASSIFICATION_OUTPUT_testing.csv";
        			a[0]= sourcepath;
        			Create_traintestdata.train = destinationpath1;
        			Create_traintestdata.test = destinationpath2;
        			Create_traintestdata.main(a);
        			
        			// Training.csv to Training.arff
        			sourcepath="C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\CLASSIFICATION_OUTPUT_training.csv";
        			destinationpath1="C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\CLASSIFICATION_OUTPUT_training.arff";
        			a[0]= sourcepath;
        			a[1]=destinationpath1;
        			CsvArffConverter.main(a);
        			
        			// Testing.csv to Testing.arff
        			sourcepath="C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\CLASSIFICATION_OUTPUT_testing.csv";
        			destinationpath1="C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\GeneratedData\\CLASSIFICATION_OUTPUT_testing.arff";
        			a[0]= sourcepath;
        			a[1]=destinationpath1;
        			CsvArffConverter.main(a);
        			
        			// MLP
        			MLP.main(new String[0]);
        			
        			// Generate .arff for classifying an instance
        			Userip_classification_arff.main(returnData);
        		    
        			
        			// Classify an instance
        			a = Evaluated_clssificationtomlp_arff.main(new String[0]);
        			
        			
        			// Change the color of Arrow labels as per the output
        			if (a[0].equals("UP"))
        			{
        				lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\src\\green.png"));
        		        
        			}
        			else if(a[0].equals("DOWN"))
        			{
        				lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Parin\\Documents\\ParinAndroid\\StockPredictor\\src\\Red.png"));
        			}
        			else
        			{
        				throw new Exception("ERROR IN COMPUTATION");
        			}
        			
        			// Delete all the generated files
        			//delete();
        			JOptionPane.showMessageDialog(getComponent(0), "WE PREDICT THAT THE OPENING PRICE FOR THE "+combo+" STOCK FOR "+ output + " SHOULD GO "+ a[0]);					
        			System.out.print("Terminated successfully");
    			}         		
        		catch (Exception e1) 
        		{
        			JOptionPane.showMessageDialog(getComponent(0), "PLEASE DOWNLOAD AUTHENTIC "+combo+" FILE. (MISSING ATTRIBUTES IS NOT ALLOWED)");
					e1.printStackTrace();
					delete();
					System.out.print("Terminated by catching exception");
				}
    
        	}
        });            
	}
}

class DateLabelFormatter extends AbstractFormatter
{
	private static final long serialVersionUID = 1L;
	private String datePattern = "dd-MM-yy";
	private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
	
	@Override
	public Object stringToValue(String text) throws ParseException
	{
		return dateFormatter.parseObject(text);
	}
	@Override
	public String valueToString(Object value) throws ParseException
	{
		if (value != null)
		{
			Calendar cal = (Calendar) value;
			return dateFormatter.format(cal.getTime());
		}		
		return "";
	}
}