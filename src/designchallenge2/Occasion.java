package designchallenge2;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public abstract class Occasion{
	protected Calendar startDate;
	protected Calendar endDate;
	protected String name;
//	protected Color color;
	protected String strColor; 
	protected Boolean isDone;
	//protected Calendar startTime;
	
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
	
	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public abstract void setStrColor();
	
	
	public Calendar convertDate(String input) {
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
		this.startDate = convertDate(input);
	}
	
	public String getName() {
		return name;
	}

//	public Color getColor() {
//		return color;
//	}

	public Calendar getStartDate() {
		return this.startDate;
	}
	

	public String getStrColor() {
		return this.strColor;
	}
	
	public boolean isBetween(Calendar date, Occasion otherOccasion) {
		return ((date.compareTo(otherOccasion.getStartDate()) >= 0) && (date.compareTo(otherOccasion.getEndDate())<=0));
	}
	
	public boolean isOverlap(Occasion otherOccasion) {
		return (this.isBetween(this.getStartDate(), otherOccasion) || this.isBetween(this.getEndDate(), otherOccasion));
	}
	
	
}
