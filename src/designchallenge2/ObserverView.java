package designchallenge2;

import java.util.ArrayList;

public class ObserverView implements Observer{
	
	private AgendaView av;
	private AgendaModel am;
	
	public ObserverView(AgendaView av) {
		this.av = av;
	}
	
	@Override
	public void update(ArrayList<Occasion> occasions) {
		// TODO Auto-generated method stub
		av.updateView(occasions);
		
	}

	@Override
	public void attach(AgendaModel am) {
		// TODO Auto-generated method stub
		this.am = am;
	}

}
