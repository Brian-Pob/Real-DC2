package designchallenge2;
import java.io.BufferedWriter;
//model
//import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataWriterCSV implements TemplateDataWriter{
	//random comment
	public DataWriterCSV(ArrayList<Occasion> o){
//    	File file;
//		file = new File("src/List of Occasions.csv");
		
        this.writeFile(o);
    }
	
	@Override
	public void writeFile(ArrayList<Occasion> occasions) { 
	        String result = convertToString(occasions);
	        try { 
				BufferedWriter bw = new BufferedWriter(new FileWriter("src/List of Occasions.csv"));
				bw.write(result);
				bw.close();
			} catch (IOException ex) {
				Logger.getLogger(DataWriterCSV.class.getName()).log(Level.SEVERE, null, ex);
			}  
	}
	
	public String convertToString(ArrayList<Occasion> occasions) {
		 String startdate;
	     SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
	     String result = "";
	     
	     for(Occasion o : occasions) {
	        String name = o.getName();
	        if(o instanceof Task){
	        	startdate = sdf.format(o.getStartDate().getTime());
				String info = "Task" +","+name+","+ startdate + "\n";
				result += info;
	        }
				
			else if(o instanceof Event) {
		        startdate = sdf.format(o.getStartDate().getTime());
		        String enddate = sdf.format(o.getEndDate().getTime());
				String info = "Event" +","+name+","+ startdate +","+ enddate+"\n";
				result += info;
			}
		
	     }
	     return result;
	}

}
