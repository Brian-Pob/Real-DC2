package designchallenge2;
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
		IsDone();
	}
	
	public Event(String name, String startdate, String enddate, boolean done) {
		super();
		setIsDone(done);
	}
	
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
	public boolean IsDone() {
		Calendar curr = Calendar.getInstance();
		 
	    if(this.endDate.after(curr)) {
	      setIsDone(true);
	      return true;
	    }
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
