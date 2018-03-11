package designchallenge2;

import java.util.ArrayList;

public interface Observer {
	
	public abstract void update(ArrayList<Occasion> occasions);

	public void attach(AgendaModel am);

}
