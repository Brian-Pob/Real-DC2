package designchallenge2;

import java.awt.Color;
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
		setColor();
		setType("Event");
	}
	
	@Override
	public void setColor() {
		this.color = Color.BLUE;
		
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(String input) {
		this.endDate = setDate(input);
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
