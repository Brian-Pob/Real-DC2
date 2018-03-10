package designchallenge2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AgendaModel {
	private DataParserCSV dp;
	private DataWriterCSV dw;
	private AgendaView av;
	
	public AgendaModel(AgendaView av) {
		this.av = av;
		this.importOccasions();
	}
	
	public ArrayList<Occasion> importOccasions(){
		ArrayList<Occasion> occasions = null;
        try {
			dp = new DataParserCSV("List of Occasions.csv");
			//AgendaView.addAllEvents(dp.processData());
			//av.updateView(dp.processData());
			occasions= dp.processData();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return occasions;
        
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
    
	public ArrayList<Occasion> sort(ArrayList<Occasion> occasions){
		
		Collections.sort(occasions, new Comparator<Occasion>() {
			
			public int compare(Occasion o1, Occasion o2) {
				int result = 0;
				if(o1.getStartDate().before(o2.getStartDate()))
					result = -1;
					else if(o1.getStartDate().equals(o2.getStartDate())) 
						result = 0;
						else if(o1.getStartDate().after(o2.getStartDate()) )
							result = 1;
					
				return result;
			}
		});
		
		return occasions;
	}
	
	public ArrayList<Occasion> filterDate(String date, ArrayList<Occasion> occasions){
		ArrayList<Occasion> filteredOccasions = new ArrayList<Occasion>();
		String dateDetails[];
		String delimiter = " ";
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		String formatted;
		
		for(Occasion o : occasions) {
			formatted = formatter.format(o.getStartDate().getTime());
			dateDetails = formatted.split(delimiter);
			if(dateDetails[0].equals(date)) {
				filteredOccasions.add(o);
			}
		}
		return filteredOccasions;
	}

	public ArrayList<Occasion> filterType(String type, ArrayList<Occasion> occasions){
		ArrayList<Occasion> filteredOccasions = new ArrayList<Occasion>();
		
		switch(type) {
			case "all" : return occasions;
			case "event" :
				for(Occasion o : occasions) {
					if(o instanceof Event) {
						filteredOccasions.add(o);
					}
				}
				break;
			case "task" :
				for(Occasion o : occasions) {
					if(o instanceof Task) {
						filteredOccasions.add(o);
					}
				}
				break;
			default: 
		}
		return filteredOccasions;
	}
	
	public void updateViews(String date, String type){
		ArrayList<Occasion> occasions = this.importOccasions();
		occasions = this.sort(occasions);
		occasions = this.filterDate(date, occasions);
		occasions = this.filterType(type, occasions);
		av.updateView(occasions);
	}
}
