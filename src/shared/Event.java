package shared;
//model
//import java.awt.Color;
import java.util.Calendar;

public class Event extends Occasion {
	
	private Calendar endDate;
	//private Calendar endTime;
	
	
	public Event(String name, String startdate, String enddate) {
		setName(name);
		setStartDate(startdate);
		setEndDate(enddate);
		setStrColor();
		getIsDone();
	}
	
	/*
	public Event(String name, String startdate, String enddate, String done) {
		this(name, startdate,enddate);
		if(done.trim().equalsIgnoreCase("true")) {
			setIsDone(true);
		}
		else
			setIsDone(false);
	}
	*/
	@Override
	public void setStrColor() {
		this.strColor = "blue";
		
	}
	
	
	public Calendar getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String input) {
		this.endDate = convertDate(input);
	}

	@Override
	public boolean getIsDone() {
		Calendar curr = Calendar.getInstance();
		 
	    if(this.endDate.before(curr)) {
	      setIsDone(true);
	      return true;
	    }
	    setIsDone(false);
	    return false;
	    
	 
	}
	
	/*
	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(String input) {
		this.endTime = setTime(input);
	}
	*/
}
