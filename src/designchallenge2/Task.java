package designchallenge2;

import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Task extends Occasion{
	
	public Task(String name, String startdate) {
		setName(name);
		setStartDate(startdate);
		//setStartTime(starttime);
		setColor();
		setType("Task");
	}

	@Override
	public void setColor() {
		this.color = Color.GREEN;
		
	}

	@Override
	public void setEndDate(String input) {
		Calendar cal = setDate(input);
		cal.add(Calendar.MINUTE, 30);
		this.endDate = cal;

	}
	
	

}
