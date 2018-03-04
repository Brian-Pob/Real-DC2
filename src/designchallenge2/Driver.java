package designchallenge2;

import java.text.SimpleDateFormat;

public class Driver {

	public static void main(String[] args) {
		
		
        
		Event e = new Event("Party", "12/07/1997", "08:00", "12/07/1997", "12:30");
		Task t = new Task("Laundry", "3/5/2018", "7:30");
		
		SimpleDateFormat formatter=new SimpleDateFormat("HH:mm"); 
        String startTime = formatter.format(e.getStartTime().getTime());
        
        SimpleDateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy"); 
        //String startDate = dateformat.format(e.getStartDate().getTime());
		
		System.out.println(e.getName() + " Start Date: " + dateformat.format(e.getStartDate().getTime()) + " Start Time: " + startTime 
			+" End Date: " + dateformat.format(e.getEndDate().getTime()) + " End Time: " + formatter.format(e.getEndTime().getTime()));
		System.out.println(t.getName() + " Start Date: " + dateformat.format(t.getStartDate().getTime()) + " Start Time: " + formatter.format(t.getStartTime().getTime()));

	}

}
