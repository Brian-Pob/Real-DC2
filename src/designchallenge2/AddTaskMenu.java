package designchallenge2;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.util.Calendar;

public class AddTaskMenu extends JFrame {
	private JLabel lblTaskName;
	private JLabel lblTaskDate;
	private JTextField textTaskName;
	private JButton btnAddTask;
	private JComboBox cmbMonth;
	private JComboBox cmbDay;
	private JComboBox cmbYear;
	private JComboBox cmbTime;
	private JLabel lblMonthDayYear;
	public AddTaskMenu() {
		setVisible(true);
		setTitle("AddTaskMenu");
		setSize(new Dimension(500, 300));
		
		lblTaskName = new JLabel("Task Name:");
		
		lblTaskDate = new JLabel("Task Date & Time:");
		
		textTaskName = new JTextField();
		textTaskName.setColumns(10);
		
		btnAddTask = new JButton("AddTask");
		
		cmbMonth = new JComboBox();
		
		cmbDay = new JComboBox();
		
		cmbYear = new JComboBox();
		
		cmbTime = new JComboBox();
		
		Calendar start = Calendar.getInstance();
		start.set(Calendar.HOUR_OF_DAY, 0);
		start.set(Calendar.MINUTE, 0);
		Calendar end = Calendar.getInstance();
		end.set(Calendar.HOUR_OF_DAY, 23);
		end.set(Calendar.MINUTE, 59);
		String timeString = "";
		do {
			timeString = Integer.toString(start.getTime().getHours())+":"+Integer.toString(start.getTime().getMinutes());
			if(start.getTime().getHours() <= 9)
				timeString = "0"+timeString;
			if(start.getTime().getMinutes() <= 9)
				timeString = timeString+"0";
			
			cmbTime.addItem(timeString);
			start.add(Calendar.MINUTE, 30);
		}while(start.getTime().before(end.getTime()));
		
		lblMonthDayYear = new JLabel("Month          Day             Year            Time");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTaskName)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textTaskName, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnAddTask))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTaskDate)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMonthDayYear)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(cmbMonth, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(cmbDay, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(cmbYear, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cmbTime, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTaskName)
						.addComponent(textTaskName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddTask))
					.addGap(20)
					.addComponent(lblMonthDayYear)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTaskDate)
						.addComponent(cmbMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(120, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	public JTextField getTextTaskName() {
		return textTaskName;
	}
	public JButton getBtnAddTask() {
		return btnAddTask;
	}
	public JComboBox getCmbMonth() {
		return cmbMonth;
	}
	public JComboBox getCmbDay() {
		return cmbDay;
	}
	public JComboBox getCmbYear() {
		return cmbYear;
	}
	public JComboBox getCmbTime() {
		return cmbTime;
	}

}
