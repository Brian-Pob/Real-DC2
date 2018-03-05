package designchallenge2;
//View
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
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
		eventNameInput = new JTextField();
		eventNameInput.setColumns(10);
		
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
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCmbLabel)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(cmbEndMonth, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cmbStartMonth, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(21)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(cmbEndDay, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cmbStartDay, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(17)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(cmbEndYear, 0, 0, Short.MAX_VALUE)
										.addComponent(cmbStartYear, 0, 26, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(cmbEndTime, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cmbStartTime, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
					.addContainerGap(14, Short.MAX_VALUE))
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
