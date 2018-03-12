package designchallenge2;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class TestDriver2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GregorianCalendar gCal = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//dont change the order
		AgendaModel am = new AgendaModel();
		AgendaView av = new AgendaView(am);
		AgendaControl ac = new AgendaControl();
		ac.attachModel(am);
		ac.attachView(av);
		am.updateViews(sdf.format(gCal.getTime()), "all"); //makes default
		//av.attachModel(am);
		am.attachView(av);
//until here
		
		AddTaskMenu atm = new AddTaskMenu();
		AddEventMenu aem = new AddEventMenu();
		aem.setVisible(true);
		//ac.attachModel(am);
		ac.attachView(av);
		ac.attachTaskMenu(atm);
		System.out.println("Attaching add event view");
		ac.attachEventMenu(aem);
		
		av.attachControl(ac);
		ac.startInstructions();
	}

}
