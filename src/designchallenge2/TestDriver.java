package designchallenge2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;


public class TestDriver {

	public static void main(String[] args) {
		
		
        AgendaControl ac = new AgendaControl();
		Event e = new Event("Ball", "12/07/1997 08:00", "12/07/1997 12:30");
		Event e2 = new Event("Party", "12/07/1987 08:00", "12/07/1997 12:30");
		Task t = new Task("Laundry", "3/18/2018 7:30");
		Task t2 = new Task("poker", "3/18/2018 12:30");
		
		SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/yyyy HH:mm"); 
        //String startTime = formatter.format(e.getStartTime().getTime());
        
        //SimpleDateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy"); 
        //String startDate = dateformat.format(e.getStartDate().getTime());
		/*
		System.out.println(e.getName() + " Start Date: " + formatter.format(e.getStartDate().getTime())
			+" End Date: " + formatter.format(e.getEndDate().getTime()) );
		System.out.println(t.getName() + " Start Date: " + formatter.format(t.getStartDate().getTime()) +" End Date: " + formatter.format(t.getEndDate().getTime()));
		*/
		ArrayList<Occasion> A = new ArrayList<Occasion>();
		A.add(t);
		A.add(e);
		A.add(t2);
		A.add(e2);
		AgendaModel am = new AgendaModel(new AgendaView());
		//boolean num = ac.isOverlapped(t, t2);
		//System.out.println(num);
		A = am.filterDate("03/18/2018", A);
		/*
		Collections.sort(A, new Comparator<Occasion>() {
		
			public int compare(Occasion o1, Occasion o2) {
				int result = 0;
				if(o1.getStartDate().before(o2.getStartDate()))
					result = -1;
					else if(o1.getStartDate().equals(o2.getStartDate())) 
						result = 0;
						else if(o1.getStartDate().after(o2.getStartDate()) )
							result = 1;
					
				return result;
			}
		});
		*/
		
		//Collections.sort(A);
		//Collections.sort(A, new Occasion());
		/*
		DataWriterCSV w = new DataWriterCSV(A);
		
		DataParserCSV r = new DataParserCSV("List of Occasions.csv");
		ArrayList<Occasion> B = new ArrayList<Occasion>();
		B = r.processData();
		*/
		for(Occasion o : A) {
			System.out.println(o.getName() + " Start Date: " + formatter.format(o.getStartDate().getTime())
			+" End Date: " + formatter.format(o.getEndDate().getTime()) );
		}
		
		
		
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
