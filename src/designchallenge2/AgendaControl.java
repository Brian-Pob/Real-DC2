package designchallenge2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//Control
public class AgendaControl {
	private AddTaskMenu taskMenu;
	private AddEventMenu eventMenu;
	private ArrayList<Occasion> occasionsList = new ArrayList<Occasion>();
	private AgendaModel am;
	
	public void addOccasion(Occasion occasion) {
		occasionsList.add(occasion);
	}
	
	public void removeOccasion(Occasion occasion) {
		occasionsList.remove(occasion);
	}
	
	public void attachModel(AgendaModel am) {
		this.am = am;
	}
	public class AddEventButtonListener implements ActionListener {
		Event event;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(!eventMenu.getEventNameInput().getText().equals("")) {
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
			}
			occasionsList.add(event);
			//model.exportOccasion(event)
			//refreshAgenda()
		}
	}
	
	public class AddTaskButtonListener implements ActionListener {
		Task task;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(!taskMenu.getTextTaskName().getText().equals("")) {
				task = new Task(taskMenu.getTextTaskName().getText(),				//task name
						
								 taskMenu.getCmbMonth().getSelectedItem()+"/" 	//task start date and time
								+taskMenu.getCmbDay().getSelectedItem()+"/"
								+taskMenu.getCmbYear().getSelectedItem()+" "
								+taskMenu.getCmbTime().getSelectedItem());
			}
			occasionsList.add(task);
			//model.exportOccasion(task)
			//refreshAgenda
		}
		
	}

	public AddTaskMenu getTaskMenu() {
		return taskMenu;
	}

	public AddEventMenu getEventMenu() {
		return eventMenu;
	}

	public ArrayList<Occasion> getOccasionsList() {
		return occasionsList;
	}
}
