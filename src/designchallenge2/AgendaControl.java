package designchallenge2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

//Control
public class AgendaControl{
	private AddTaskMenu taskMenu;
	private AddEventMenu eventMenu;
	private AgendaModel am;
	private AgendaView av;
	public void addOccasion(Occasion occasion) {
		am.addOccasion(occasion);
	}
	
	public void removeOccasion(Occasion occasion) {
		am.removeOccasion(occasion);
	}
	
	public void attachModel(AgendaModel am) {
		this.am = am;
	}

	public void attachView(AgendaView av) {
		this.av = av;
	}
	public class AddEventButtonListener implements ActionListener {
		Event event;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(!eventMenu.getEventNameInput().getText().isEmpty()) {
				//String eventDetails = eventMenu.getEventNameInput()+","
				event = new Event(eventMenu.getEventNameInput().getText(),				//event name
						
								  eventMenu.getCmbStartMonth().getSelectedItem()+"/" 	//event start date and time
								 +eventMenu.getCmbStartDay().getSelectedItem()+"/"
								 +eventMenu.getCmbStartYear().getSelectedItem()+" "
								 +eventMenu.getCmbStartTime().getSelectedItem(),
								 
								  eventMenu.getCmbEndMonth().getSelectedItem()+"/"		//event end date and time
								 +eventMenu.getCmbEndDay().getSelectedItem()+"/"
								 +eventMenu.getCmbEndYear().getSelectedItem()+" "
								 +eventMenu.getCmbEndTime().getSelectedItem());
				Calendar start = Calendar.getInstance();
				Calendar end = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
				String strStartDate =  eventMenu.getCmbStartMonth().getSelectedItem()+"/" 	//event start date and time
						 +eventMenu.getCmbStartDay().getSelectedItem()+"/"
						 +eventMenu.getCmbStartYear().getSelectedItem()+" "
						 +eventMenu.getCmbStartTime().getSelectedItem();
				String strEndDate = eventMenu.getCmbEndMonth().getSelectedItem()+"/"		//event end date and time
						 +eventMenu.getCmbEndDay().getSelectedItem()+"/"
						 +eventMenu.getCmbEndYear().getSelectedItem()+" "
						 +eventMenu.getCmbEndTime().getSelectedItem();
				try {
					start.setTime(sdf.parse(strStartDate));
					end.setTime(sdf.parse(strEndDate));
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(start.before(end))
					am.addOccasion(event);
				else {
					System.out.println("End Date must come after Start Date");
					JOptionPane.showMessageDialog(null, "End Date must come after Start Date");
				}
			}
			else {
				System.out.println("Input field cannot be empty");
				JOptionPane.showMessageDialog(null, "Input field cannot be empty");
			}
			
			
			//model.exportOccasion(event)
			//refreshAgenda()
		}
	}
	
	public class AddTaskButtonListener implements ActionListener {
		Task task;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(!taskMenu.getTextTaskName().getText().isEmpty()) {
				task = new Task(taskMenu.getTextTaskName().getText(),				//task name
						
								 taskMenu.getCmbMonth().getSelectedItem()+"/" 	//task start date and time
								+taskMenu.getCmbDay().getSelectedItem()+"/"
								+taskMenu.getCmbYear().getSelectedItem()+" "
								+taskMenu.getCmbTime().getSelectedItem());
				System.out.println(taskMenu.getCmbTime().getSelectedItem()+"DEBUG!!!");
//				System.out.println(task.get);
				am.addOccasion(task);
				
			}
			else {
				System.out.println("Input field cannot be empty");
				JOptionPane.showMessageDialog(null, "Input field cannot be empty");
			}
			//model.exportOccasion(task)
			//refreshAgenda
		}
		
	}

	public void attachTaskMenu(AddTaskMenu taskMenu) {
		this.taskMenu = taskMenu;
		this.taskMenu.getBtnAddTask().addActionListener(new AddTaskButtonListener());
	}

	public void attachEventMenu(AddEventMenu eventMenu) {
		this.eventMenu = eventMenu;
		this.eventMenu.getBtnAddEvent().addActionListener(new AddEventButtonListener());
	}

	public AgendaView getAv() {
		return av;
	}


	public AddTaskMenu getTaskMenu() {
		return taskMenu;
	}

	public AddEventMenu getEventMenu() {
		return eventMenu;
	}
	
	
	public ArrayList<Occasion> sort(ArrayList<Occasion> occasions){
		
		Collections.sort(occasions, new Comparator<Occasion>() {
			
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
		
		return occasions;
	}
	
	public ArrayList<Occasion> filterDate(String date, ArrayList<Occasion> occasions){
		ArrayList<Occasion> filteredOccasions = new ArrayList<Occasion>();
		String dateDetails[];
		String delimiter = " ";
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		String formatted;
		
		for(Occasion o : occasions) {
			formatted = formatter.format(o.getStartDate().getTime());
			dateDetails = formatted.split(delimiter);
			if(dateDetails[0].equals(date)) {
				filteredOccasions.add(o);
			}
		}
		return filteredOccasions;
	}

	public ArrayList<Occasion> filterType(String type, ArrayList<Occasion> occasions){
		ArrayList<Occasion> filteredOccasions = new ArrayList<Occasion>();
		
		switch(type) {
			case "all" : return occasions;
			
			case "event" :
				for(Occasion o : occasions) {
					if(o instanceof Event) {
						filteredOccasions.add(o);
					}
				}
				break;
				
			case "task" :
				for(Occasion o : occasions) {
					if(o instanceof Task) {
						filteredOccasions.add(o);
					}
				}
				break;
				
			default: 
		}
		
		
		return filteredOccasions;
	}
	
	public boolean isOverlapped(Occasion o1, Occasion o2) {
		//do stuff
		return false;
	}

	
}
