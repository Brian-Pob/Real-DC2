package designchallenge2;

import java.util.ArrayList;

public interface Observer {
	
	public abstract void updateView(ArrayList<Occasion> occasions);

	public void attachModel(AgendaModel am);

}
