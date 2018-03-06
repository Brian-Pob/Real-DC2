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
		//setStartTime(starttime);
		setEndDate(enddate);
		//setEndTime(endtime);
		setStrColor();
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
	
	/*
	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(String input) {
		this.endTime = setTime(input);
	}
	*/
}
