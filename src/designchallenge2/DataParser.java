package designchallenge2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DataParser{
	
	
    public DataParser(String filename) {
    	this.filename = ("src/"+filename);
    	readData();
    }
	
	public void readData() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));
			String line  = "";
			while((line = br.readLine())!= null) {
				dataList.add(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
			}catch(IOException e) {
				System.out.println("Error with br.close()");
				e.printStackTrace();
			}
		}
		
	}
	public ArrayList<Occasion> processData(){
		String[] eventDetails;
		String delimiter = "";
		String extension = "";
		Occasion event = null;
		
		int i = filename.lastIndexOf('.');
		if (i > 0) {
		    extension = filename.substring(i+1);
		}
		if(extension.equals("csv")) 
			delimiter = ",";

		for(String s: dataList) {
			eventDetails = s.split(delimiter);
			if(extension.equals("csv")) {
				//event = new Occasion(eventDetails[0], eventDetails[1], eventDetails[2].trim());
				parsedData.add(event);
			}	

//			System.out.println("Data added to "+extension);
		}
		return parsedData;
	}
	
	
	protected List<String> dataList = new ArrayList<String>();
	//protected List<Occasion> eventList = new ArrayList<Occasion>();
	protected String filename;
    protected ArrayList<Occasion> parsedData = new ArrayList<Occasion>();
}
