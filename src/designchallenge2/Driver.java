package designchallenge2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Driver {

	public static void main(String[] args) {
		
		
        
		Event e = new Event("Party", "12/07/1997 08:00", "12/07/1997 12:30");
		Task t = new Task("Laundry", "3/5/2018 7:30");
		
		SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/yyyy HH:mm"); 
        //String startTime = formatter.format(e.getStartTime().getTime());
        
        //SimpleDateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy"); 
        //String startDate = dateformat.format(e.getStartDate().getTime());
		
		System.out.println(e.getName() + " Start Date: " + formatter.format(e.getStartDate().getTime())
			+" End Date: " + formatter.format(e.getEndDate().getTime()) );
		System.out.println(t.getName() + " Start Date: " + formatter.format(t.getStartDate().getTime()) +" End Date: " + formatter.format(t.getEndDate().getTime()));
		
		
		//testing
		/*
		 String myTime = "12/31/2017 23:30";
		 SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		 Date d;
		try {
			d = df.parse(myTime);
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			cal.add(Calendar.MINUTE, 30);
			String newTime = df.format(cal.getTime());
			
			System.out.println(newTime);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 */

	}

}
