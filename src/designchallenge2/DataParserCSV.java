package designchallenge2;
//model
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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
//			e.printStackTrace();
			System.out.println("File not found. Creating file...");
			DataWriterCSV dw = new DataWriterCSV();
			return dataList;
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
		return dataList;
		
	}
	public ArrayList<Occasion> processData(){
		String[] eventDetails;
		String delimiter = "";
		String extension = "";
		ArrayList<Occasion> parsedData = new ArrayList<Occasion>();
		Occasion occasion = null;
		ArrayList<String> dataList = new ArrayList<String>(readData());
		
		int i = filename.lastIndexOf('.');
		if (i > 0) {
		    extension = filename.substring(i+1);
		}
		if(extension.equals("csv")) 
			delimiter = ",";
		
		for(String s: dataList) {
			eventDetails = s.split(delimiter);
			if(eventDetails[0].equals("Task")) {
				occasion = new Task(eventDetails[1], eventDetails[2], eventDetails[3]);
				parsedData.add(occasion);
			}
			
			else if(eventDetails[0].equals("Event")) {
				occasion = new Event(eventDetails[1], eventDetails[2], eventDetails[3], eventDetails[4]);
				parsedData.add(occasion);
			}

//			System.out.println("Data added to "+extension);
		}
		return parsedData;
	}
	
	
	
	protected String filename;
    
}
