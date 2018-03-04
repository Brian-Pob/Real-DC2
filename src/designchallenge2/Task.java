package designchallenge2;

import java.awt.Color;

public class Task extends Occasion{
	
	public Task(String name, String startdate, String starttime) {
		setName(name);
		setStartDate(startdate);
		setStartTime(starttime);
		setColor();
		setType("Task");
	}

	@Override
	public void setColor() {
		this.color = Color.GREEN;
		
	}

}
