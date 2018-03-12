package designchallenge2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

public class AgendaModel {
	private DataParserCSV dp;
	private DataWriterCSV dw;
	private AgendaView av;
	//private List<ObserverView> observerViews;
	
	public AgendaModel(/*AgendaView av*/) {
//		this.av = av;
//		av.attachModel(this);
		GregorianCalendar gCal = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		//this.updateViews(sdf.format(gCal.getTime()), "all");
	}
	
	public /*void*/ ArrayList<Occasion> importOccasions(){
    
        ArrayList<Occasion> occasions = null;
        try {
			dp = new DataParserCSV("List of Occasions.csv");
			//AgendaView.addAllEvents(dp.processData());
			occasions = dp.processData();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return occasions;
        
    }
    
    public void exportOccasions(ArrayList<Occasion> occasions) {
        dw = new DataWriterCSV(occasions);
        importOccasions();
    }
    
    public void addOccasion(Occasion occasion) {
    	ArrayList<Occasion> occasionsList = new ArrayList<Occasion>(dp.processData());
    	occasionsList.add(occasion);
    	exportOccasions(occasionsList);
    	
    	//update view
    }
    
    public void removeOccasion(Occasion occasion) {
    	ArrayList<Occasion> occasionsList = new ArrayList<Occasion>(dp.processData());
    	for(int i = 0; i < occasionsList.size();i++) {
    		if(occasionsList.get(i).getStartDate().equals(occasion.getStartDate())) {
    			occasionsList.remove(occasionsList.get(i));
    			System.out.println("OCCASION REMOVED.");
    		}
    	}
    	exportOccasions(occasionsList);
    	
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
			System.out.println(dateDetails[0]+" == "+date);
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
        occasions = this.filterType(type, occasions); 
        occasions = this.filterDate(date, occasions); 
        av.countUpdate();
        av.updateView(occasions); 
      } 
    
    
    public boolean doesOverlap(Occasion occasion) {
    	ArrayList<Occasion>occasions = this.importOccasions();
    	for(Occasion o : occasions) {
    		if(o.isOverlap(occasion)){
    			return true;
    		}
    	}
    	return false;
    }
    
    public void attachView(AgendaView av) {
    	this.av = av;
    }
    
}
