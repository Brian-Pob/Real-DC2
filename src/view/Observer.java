package view;

import java.util.ArrayList;

import model.AgendaModel;
import shared.Occasion;

public interface Observer {
	
	public abstract void updateView(ArrayList<Occasion> occasions);

	public void attachModel(AgendaModel am);

}
