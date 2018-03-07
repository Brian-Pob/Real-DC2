package designchallenge2;

public interface Observer {
	
	public abstract void update(Occasion o);

	public void attach(AgendaModel am);

}
