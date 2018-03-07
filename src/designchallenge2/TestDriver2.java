package designchallenge2;

public class TestDriver2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AgendaControl ac = new AgendaControl();
		AgendaView av = new AgendaView();
		AgendaModel am = new AgendaModel(av);
		av.attachModel(am);
		
		
		AddTaskMenu atm = new AddTaskMenu();
		AddEventMenu aem = new AddEventMenu();
		aem.setVisible(true);
		ac.attachModel(am);
		ac.attachView(av);
		ac.attachTaskMenu(atm);
		System.out.println("Attaching add event view");
		ac.attachEventMenu(aem);
		
		av.attachControl(ac);
	}

}
