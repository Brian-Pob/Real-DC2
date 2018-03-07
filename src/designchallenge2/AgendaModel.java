package designchallenge2;

import java.util.ArrayList;

public class AgendaModel {
	private DataParserCSV dp;
	private DataWriterCSV dw;
	private AgendaView av;
	
	public AgendaModel(AgendaView av) {
		this.av = av;
		importOccasions();
	}
	
	public void importOccasions(){
    
        
        try {
			dp = new DataParserCSV("List of Occasions.csv");
			//AgendaView.addAllEvents(dp.processData());
			av.updateView(dp.processData());
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
    
    public void exportOccasions(ArrayList<Occasion> occasions) {
        dw = new DataWriterCSV(occasions);
    }
    
    public void addOccasion(Occasion occasion) {
    	ArrayList<Occasion> occasionsList = new ArrayList<Occasion>(dp.processData());
    	occasionsList.add(occasion);
    	exportOccasions(occasionsList);
    	importOccasions();
    	//update view
    }
    
    public void removeOccasion(Occasion occasion) {
    	ArrayList<Occasion> occasionsList = new ArrayList<Occasion>(dp.processData());
    	occasionsList.remove(occasion);
    	exportOccasions(occasionsList);
    	importOccasions();
    	//update view
    }
}
