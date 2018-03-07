package designchallenge2;

import java.util.ArrayList;

//model
public interface TemplateDataWriter {

	public void writeFile(ArrayList<Occasion> o );
	public String convertToString(ArrayList<Occasion> o );
	
}
