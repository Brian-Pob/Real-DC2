package model;
//model
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import shared.Event;
import shared.Occasion;
import shared.Task;


public class DataParserCSV implements TemplateDataParser{
	
	
    public DataParserCSV(String filename) {
    	this.filename = ("src/"+filename);
    }
	
	public ArrayList<String> readData() {
		ArrayList<String> dataList = new ArrayList<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));
			String line  = "";
			while((line = br.readLine())!= null) {
				dataList.add(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			DataWriterCSV dw = new DataWriterCSV();
			return dataList;
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}finally {
			try {
				br.close();
			}catch(IOException e) {
			}
		}
		return dataList;
		
	}
	public ArrayList<Occasion> processData(){
		String[] eventDetails;
		String delimiter = "";
		String extension = "";
		ArrayList<Occasion> parsedData = new ArrayList<Occasion>();
		Occasion event = null;
		ArrayList<String> dataList = new ArrayList<String>(readData());
		String isDone;
		int i = filename.lastIndexOf('.');
		if (i > 0) {
		    extension = filename.substring(i+1);
		}
		if(extension.equals("csv")) 
			delimiter = ",";
		
		for(String s: dataList) {
			eventDetails = s.split(delimiter);
			if(eventDetails[0].equals("Task")) {
				if(eventDetails[3].trim().equalsIgnoreCase("true")) {
					isDone = "true";
				}
				else
					isDone = "false";
				event = new Task(eventDetails[1], eventDetails[2],isDone);
				parsedData.add(event);
			}
			
			else if(eventDetails[0].equals("Event")) {
				if(eventDetails[4].trim().equalsIgnoreCase("true")) {
					isDone = "true";
				}
				else
					isDone = "false";
				event = new Event(eventDetails[1], eventDetails[2], eventDetails[3]/*, isDone*/);
				parsedData.add(event);
			}
		}
		return parsedData;
	}
	
	
	
	protected String filename;
    
}
