package designchallenge2;

import java.util.Calendar;

public class Event extends Occasion {
	
	private Calendar endDate;
	private Calendar endTime;
	
	
	public Event(String name, String startdate, String starttime, String enddate, String endtime) {
		setName(name);
		setStartDate(startdate);
		setStartTime(starttime);
		setEndDate(enddate);
		setEndTime(endtime);
		setStrColor("blue");
		setType("Event");
	}
	

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(String input) {
		this.endDate = setDate(input);
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(String input) {
		this.endTime = setTime(input);
	}

}
