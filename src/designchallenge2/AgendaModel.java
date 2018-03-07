package designchallenge2;

import java.util.ArrayList;

public class AgendaModel {
	private DataParserCSV dp;
	private DataWriterCSV dw;
	
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

}
