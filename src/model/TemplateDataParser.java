package model;
//model
import java.util.ArrayList;

import shared.Occasion;

public interface TemplateDataParser {
	
	public ArrayList<String> readData();
	public ArrayList<Occasion> processData();

}
