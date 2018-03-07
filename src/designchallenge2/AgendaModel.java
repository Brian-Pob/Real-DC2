package designchallenge2;

import java.util.ArrayList;

public class AgendaModel {
	private DataParserCSV dp;
	private DataWriterCSV dw;
	private ArrayList<Occasion> occasionsList = new ArrayList<Occasion>();
	
	public void importOccasions(){
    
        
        try {
			dp = new DataParserCSV("List of Occasions.csv");
			//view.addAllEvents(dp.processData());
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
    
    public void exportOccasions(ArrayList<Occasion> occasions){

            dw = new DataWriterCSV(occasions);
    }
    
    public void addOccasion(Occasion occasion) {
    	occasionsList.add(occasion);
    	//update view
    }
    
    public void removeOccasion(Occasion occasion) {
    	occasionsList.remove(occasion);
    	//update view
    }
}
