package designchallenge2;
//model
//import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Task extends Occasion{
	
	public Task(String name, String startdate) {
		setName(name);
		setStartDate(startdate);
		setEndDate(startdate);
		setStrColor();
		this.isDone = false;
	}
	
	public Task(String name, String startdate, String done) {
		super();
		if(done.trim().equalsIgnoreCase("true")) {
			setIsDone(true);
		}
		else
			setIsDone(false);
	}

	@Override
	public void setStrColor() {
		this.strColor = "green";
		
	}

	@Override
	public void setEndDate(String input) {
		Calendar cal = convertDate(input);
		cal.add(Calendar.MINUTE, 30);
		this.endDate = cal;

	}
	
	public Calendar getEndDate() {
		return endDate;
	}

	@Override
	public boolean IsDone() {
		// TODO Auto-generated method stub
		return isDone;
	}
	
	

}
