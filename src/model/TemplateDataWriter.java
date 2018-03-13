package model;

import java.util.ArrayList;

import shared.Occasion;

//model
public interface TemplateDataWriter {

	public void writeFile(ArrayList<Occasion> o );
	public String convertToString(ArrayList<Occasion> o );
	
}
