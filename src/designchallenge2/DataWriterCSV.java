package designchallenge2;
//model
import java.io.File;

public class DataWriterCSV implements TemplateDataWriter{
	
	public DataWriterCSV(Occasion o){
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
