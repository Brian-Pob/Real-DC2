package designchallenge2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;

public class AgendaView extends JFrame{
	public AgendaView() {
	}
	private AgendaModel am;
	private AgendaControl ac;
	
	public void updateView(ArrayList<Occasion> occasionsList) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		
		for(int i = 0; i < 100; i++){
			System.out.println(); //acts like a clear screen. only temporary
		}
		for(Occasion o: occasionsList) {
			if(o instanceof Task) {
				Task t = (Task)o;
				System.out.println("TASK | "+t.getName()+" | "+t.getStrColor()+" | "+sdf.format(t.getEndDate().getTime()));
			}else if(o instanceof Event) {
				Event e = (Event)o;
				System.out.println("EVENT | "+e.getName()+" | "+e.getStrColor()+" | "
									+sdf.format(e.getStartDate().getTime())+" | "+sdf.format(e.getEndDate().getTime()));
			}
		}
	}
	
	public void attachModel(AgendaModel am) {
		this.am = am;
	}
	public void attachControl(AgendaControl ac) {
		this.ac = ac;
	}
}
