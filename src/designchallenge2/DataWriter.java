package designchallenge2;

import java.io.File;

public class DataWriter implements TemplateDataWriter{
	
	public DataWriter(Occasion o){
    	File file;
		file = new File("src/List of Ocassions.csv");
		
        if(file.exists())
            this.appendToFile(o);
        else
            this.writeFile(o);
    }
	
	@Override
	public void writeFile(Occasion o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void appendToFile(Occasion o) {
		// TODO Auto-generated method stub
		
	}

}
