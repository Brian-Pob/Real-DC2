package designchallenge2;
//View
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.util.Calendar;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.WindowConstants;
public class AddTaskMenu extends JFrame{
	
	private JTextField taskName;
	private JLabel     lblTaskName   ;
	private JLabel     lblTaskDT     ;
	private JComboBox  cmbTime       ;
	private JComboBox  cmbYear       ;
	private JComboBox  cmbDay        ;
	private JComboBox  cmbMonth      ;
	private JLabel     lblComboLabel ;
	private JButton    btnAddtask    ;
	
	//initComponents
	public AddTaskMenu() {
		                                                              
		lblTaskName   = new JLabel("Task Name");                                
		lblTaskDT     = new JLabel("Task Date & Time");                         
		cmbTime       = new JComboBox();                                        
		taskName = new JTextField();
		cmbYear       = new JComboBox();                                        
		taskName.setColumns(10);
		cmbDay        = new JComboBox();                                        
		cmbMonth      = new JComboBox();                                        
		setTitle("AddTaskMenu");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		lblComboLabel = new JLabel("MM           DD          YYYY       hh:mm");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		btnAddtask    = new JButton("AddTask");        
		
		Calendar start = Calendar.getInstance();
		start.set(Calendar.HOUR_OF_DAY, 0);
		start.set(Calendar.MINUTE, 0);
		Calendar end = Calendar.getInstance();
		end.set(Calendar.HOUR_OF_DAY, 23);
		end.set(Calendar.MINUTE, 30);
		String timeString = "";
		do {
			timeString = Integer.toString(start.getTime().getHours())+":"+Integer.toString(start.getTime().getMinutes());
			cmbTime.addItem(timeString);
			start.add(Calendar.MINUTE, 30);
		}while(start.getTime().before(end.getTime()));
		
		setSize(500, 300);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblTaskName)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(taskName, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTaskDT)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblComboLabel)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(cmbMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(cmbDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(cmbYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(cmbTime, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
							.addGap(10)))
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addComponent(btnAddtask)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTaskName)
						.addComponent(taskName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddtask))
					.addGap(12)
					.addComponent(lblComboLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTaskDT)
						.addComponent(cmbTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(158))
		);
		getContentPane().setLayout(groupLayout);
	}//end of init components
	
	public JTextField getTaskName() {
		return taskName;
	}
	public JComboBox getCmbTime() {
		return cmbTime;
	}
	public JComboBox getCmbYear() {
		return cmbYear;
	}
	public JComboBox getCmbDay() {
		return cmbDay;
	}
	public JComboBox getCmbMonth() {
		return cmbMonth;
	}
	public JButton getBtnAddtask() {
		return btnAddtask;
	}
}
