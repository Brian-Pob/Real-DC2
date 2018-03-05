package designchallenge2;
//model
import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public abstract class Occasion {
	protected Calendar startDate;
	protected Calendar endDate;
	protected String name;
	protected Color color;
	protected String strColor; 
	//protected Calendar startTime;
	protected String Type;
	
	/*
	public Calendar setTime(String input) {
		Calendar cal = null;
		DateFormat formatter = new SimpleDateFormat("HH:mm");
		try {
					Date d = (Date)formatter.parse(input);
					cal = Calendar.getInstance();
					cal.setTime(d);
					//time = cal;
					
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
		return cal;
		
	}
	
	public void setStartTime(String input){
		this.startTime = setTime(input);
	}
	*/
	
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void setColor();
	
	
	public Calendar setDate(String input) {
		Calendar cal = null;
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {
			
			Date d = (Date)formatter.parse(input);
			cal = Calendar.getInstance();
			cal.setTime(d);
			//date = cal;
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cal;
	}
	
	public abstract void setEndDate(String input);
	
	public abstract Calendar getEndDate();
	
	public void setStartDate(String input) {
		this.startDate = setDate(input);
	}
	
	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	public Calendar getStartDate() {
		return this.startDate;
	}
	
	/*
	public Calendar getStartTime() {
		return startTime;
	}
	*/
	public String getStrColor() {
		return this.strColor;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
	
}
