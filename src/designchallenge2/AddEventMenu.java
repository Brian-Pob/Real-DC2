package designchallenge2;
//View

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AddEventMenu extends JFrame{
	private JTextField eventNameInput;
	
	
	private JButton btnAddEvent = new JButton("Add Event");
	private JLabel startLabel = new JLabel("Start Date & Time");
	private JComboBox cmbStartMonth = new JComboBox();
	private JComboBox cmbStartDay = new JComboBox();
	private JComboBox cmbStartTime = new JComboBox();
	private JComboBox cmbEndTime = new JComboBox();
	private JLabel endLabel = new JLabel("End Date & Time");
	private JComboBox cmbEndDay = new JComboBox();
	private JComboBox cmbEndMonth = new JComboBox();
	private JComboBox cmbEndYear = new JComboBox();	
	private JComboBox cmbStartYear = new JComboBox();	
	private JLabel lblEventName = new JLabel("Event Name");
	private JLabel lblCmbLabel = new JLabel("MM           DD          YYYY       hh:mm");
	
	public AddEventMenu() {
		setTitle("Add Event Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Calendar start = Calendar.getInstance();
		start.set(Calendar.HOUR_OF_DAY, 0);
		start.set(Calendar.MINUTE, 0);
		Calendar end = Calendar.getInstance();
		end.set(Calendar.HOUR_OF_DAY, 23);
		end.set(Calendar.MINUTE, 59);
		String timeString = "";
		GregorianCalendar gCal = new GregorianCalendar();
		System.out.println("Add Event View Added");

		int yearBound = gCal.get(GregorianCalendar.YEAR);
		for(int i = yearBound-100; i <= yearBound+100; i++) {
			cmbStartYear.addItem(i);
			cmbEndYear.addItem(i);
		}
		cmbStartYear.setSelectedIndex(100);
		cmbEndYear.setSelectedIndex(100);

		
		int monthBound = gCal.get(GregorianCalendar.MONTH);
		for(int i = 1; i<=12; i++) {
			cmbStartMonth.addItem(i);
			cmbEndMonth.addItem(i);
		}
		cmbStartMonth.setSelectedIndex(monthBound);
		cmbEndMonth.setSelectedIndex(monthBound);

		int dayBound = gCal.get(GregorianCalendar.DATE);
		for(int i = 1; i <= 31; i++) {
			cmbStartDay.addItem(i);
			cmbEndDay.addItem(i);
		}
		cmbStartDay.setSelectedIndex(dayBound-1);
		cmbEndDay.setSelectedIndex(dayBound-1);

		do {
			timeString = Integer.toString(start.get(Calendar.HOUR_OF_DAY))+":"+Integer.toString(start.get(Calendar.MINUTE));
//			if(start.get(Calendar.HOUR_OF_DAY) <= 9)
//				timeString = "0"+timeString;
			if(start.get(Calendar.MINUTE) <= 9)
				timeString = timeString+"0";
			
			cmbStartTime.addItem(timeString);
			cmbEndTime.addItem(timeString);
			start.add(Calendar.MINUTE, 30);
		}while(start.getTime().before(end.getTime()));
		
		int hourBound = gCal.get(GregorianCalendar.HOUR_OF_DAY);
		int minuteBound = gCal.get(GregorianCalendar.MINUTE);
		//System.out.println(minuteBound);
		if(minuteBound <= 30)
			minuteBound = 30;
		else if(minuteBound > 30) {
			minuteBound = 0;
			hourBound++;
			if(hourBound == 24) {
				hourBound = 0;
				cmbStartDay.setSelectedItem(cmbStartDay.getSelectedIndex()+2);
			}
		}
		String curTime = hourBound+":"+minuteBound;
		if(minuteBound == 0)
			curTime = curTime+"0";
		cmbStartTime.setSelectedItem(curTime);
		
		if(minuteBound == 30) {
			minuteBound = 0;
			hourBound++;
			if(hourBound == 24) {
				hourBound = 0;
				cmbEndDay.setSelectedItem(cmbEndDay.getSelectedIndex()+2);
			}
		}else if(minuteBound == 0) {
			minuteBound = 30;
			if(hourBound == 0) {
				cmbEndDay.setSelectedItem(cmbEndDay.getSelectedIndex()+2);
			}
		}
		curTime = hourBound+":"+minuteBound;
		if(minuteBound == 0)
			curTime = curTime+"0";
		cmbEndTime.setSelectedItem(curTime);
		
		eventNameInput = new JTextField();
		eventNameInput.setColumns(10);
		setSize(new Dimension(500, 300));
		
		setResizable(false);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblEventName)
							.addGap(18)
							.addComponent(eventNameInput, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAddEvent))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(startLabel)
								.addComponent(endLabel))
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCmbLabel)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(cmbEndMonth, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cmbStartMonth, 0, 39, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(cmbEndDay, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cmbStartDay, 0, 35, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(cmbStartYear, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cmbEndYear, 0, 34, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(cmbEndTime, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cmbStartTime, 0, 46, Short.MAX_VALUE))))))
					.addContainerGap(68, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEventName)
						.addComponent(eventNameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddEvent))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCmbLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(startLabel)
						.addComponent(cmbStartMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbStartDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbStartYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbStartTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(endLabel)
						.addComponent(cmbEndDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbEndMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbEndYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbEndTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(123))
		);
		getContentPane().setLayout(groupLayout);
		JFrame jf = new JFrame();
	}
	
	public JTextField getEventNameInput() {
		return eventNameInput;
	}
	public void setEventNameInput(JTextField eventNameInput) {
		this.eventNameInput = eventNameInput;
	}
	public JComboBox getCmbStartMonth() {
		return  cmbStartMonth;
	}
	public JButton getBtnAddEvent() {
		return btnAddEvent;
	}

	public void setBtnAddEvent(JButton btnAddEvent) {
		this.btnAddEvent = btnAddEvent;
	}

	public JComboBox getCmbStartDay() {
		return cmbStartDay;
	}

	public JComboBox getCmbStartTime() {
		return cmbStartTime;
	}

	public JComboBox getCmbEndTime() {
		return cmbEndTime;
	}

	public JComboBox getCmbEndDay() {
		return cmbEndDay;
	}

	public JComboBox getCmbEndMonth() {
		return cmbEndMonth;
	}

	public JComboBox getCmbEndYear() {
		return cmbEndYear;
	}

	public JComboBox getCmbStartYear() {
		return cmbStartYear;
	}
}
